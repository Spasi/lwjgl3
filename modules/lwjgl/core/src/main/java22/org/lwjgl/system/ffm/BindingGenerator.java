/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.system.ffm;

import org.lwjgl.system.*;

import java.lang.classfile.*;
import java.lang.constant.*;
import java.lang.foreign.*;
import java.lang.invoke.*;
import java.lang.reflect.*;
import java.nio.charset.*;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;

import static java.lang.constant.ConstantDescs.*;
import static java.lang.invoke.MethodHandles.*;
import static java.lang.invoke.MethodType.*;
import static org.lwjgl.system.APIUtil.*;
import static org.lwjgl.system.Checks.*;

/**
 * Generates LWJGL bindings from an interface, optionally annotated with {@code FFM*} annotations.
 *
 * <p>The objective is to allow users to create their own LWJGL-style bindings, dynamically at run-time, without sacrificing performance.</p>
 *
 * <p>Several modern Java technologies are being utilized to achieve this:</p>
 * <ul>
 *     <li>Dynamic Class-File Constants (JEP 309, JDK 11, a.k.a. Condy): Used to lazily initialize bindings, without precompiling a private nested class per function.</li>
 *     <li>Hidden Classes (JEP 371, JDK 15): Used to generate classes with minimal metadata and no interaction with ClassLoaders.</li>
 *     <li>Class data support for hidden classes (JDK-8256214, JDK 16): Used for constant pool patching, to boostrap Condy values.</li>
 *     <li>Class-File API (JEP 457, JDK 22, preview): Used to generate bytecode at runtime, without 3rd-party dependencies.</li>
 *     <li>Foreign Function & Memory API (JEP 442, JDK 22): Used for native interoperation without JNI.</li>
 * </ul>
 *
 * <p>The {@link #generate} method is designed to be relatively cheap. The instance returned is lightweight and its methods are never materialized, unless
 * actually used by the application. More specifically:</p>
 * <ul>
 *    <li>A minimal class is generated that implements the input interface.</li>
 *    <li>There is no state in the generated class, only methods.</li>
 *    <li>All methods are simple, with minimal bytecode. A method handle is retrieved using Condy and arguments are passed directly to {@link MethodHandle#invokeExact}.</li>
 *    <li>There is no overhead from the Condy {@code ldc} instruction. It is executed only once, if and when the method is called.</li>
 *    <li>
 *        Execution of relatively expensive binding code is deferred to the Condy bootstrap. This includes:
 *        <ul>
 *            <li>lookup of {@code FFM*} annotations and associated logic</li>
 *            <li>function address lookup and creation of FFM method handles</li>
 *            <li>further bytecode generation and wrapping of FFM method handles if necessary</li>
 *        </ul>
 *    </li>
 *    <li>
 *        Hidden class data is used:
 *        <ul>
 *            <li>to pass reflected {@link Method} instances to the Condy bootstrap</li>
 *            <li>to pass FFM {@link MethodHandle}/{@link MemorySegment} instances to generated wrapper methods</li>
 *        </ul>
 *    </li>
 * </ul>
 *
 * <p>When stored in {@code static final} fields, performance of the generated bindings is equivalent to direct FFM calls. The JVM can inline through
 * everything, for the following reasons:</p>
 * <ul>
 *     <li>The binding instance is constant.</li>
 *     <li>There is a single implementation of the binding interface.</li>
 *     <li>The {@link MethodHandle} instances created via Condy are also treated as constants by the JVM.</li>
 * </ul>
 *
 * <p>The generator DSL supports the specification of 3 virtual parameters, which must be present in a strict order before other parameters:</p>
 * <ul>
 *     <li>
 *         A {@link MemorySegment} parameter in methods annotated with {@link FFMFunctionAddress}.
 *
 *         <p>It must be specified before any other virtual or normal parameter.</p>
 *     </li>
 *     <li>
 *         A {@link SegmentAllocator} or {@link StackAllocator} parameter. This parameter will be used to allocate storage for struct values passed or returned
 *         by-value and also for temporary storage needed internally by the method call (e.g. for {@link FFMReturn} buffers).
 *
 *         <p>If the parameter is of type {@link StackAllocator}, a stack frame will be pushed & popped inside the method call when temporary storage is
 *         needed.</p>
 *
 *         <p>It must be specified after the {@link FFMFunctionAddress} parameter, if one exists, and before any other virtual or normal parameter.</p>
 *     </li>
 *     <li>
 *         A {@link MemorySegment} parameter annotated with {@link FFMCaptureCallState}.
 *
 *         <p>It must be specified after other virtual parameters and before any normal parameter.</p>
 *     </li>
 * </ul>
 */
public final class BindingGenerator {

    public static final AddressLayout C_POINTER = ValueLayout.ADDRESS
        .withTargetLayout(MemoryLayout.sequenceLayout(Long.MAX_VALUE, ValueLayout.JAVA_BYTE));

    private static final DirectMethodHandleDesc BSM_BOOTSTRAP = ofConstantBootstrap(
        BindingGenerator.class.describeConstable().orElseThrow(),
        "bootstrap",
        CD_MethodHandle,
        CD_int
    );

    private static final int METHOD_FLAGS_PUBLIC        = AccessFlags.ofMethod(AccessFlag.PUBLIC).flagsMask();
    private static final int METHOD_FLAGS_PUBLIC_STATIC = AccessFlags.ofMethod(AccessFlag.PUBLIC, AccessFlag.STATIC).flagsMask();

    static final ClassDesc
        CD_AddressLayout            = AddressLayout.class.describeConstable().orElseThrow(),
        CD_byteArray                = byte[].class.describeConstable().orElseThrow(),
        CD_Charset                  = Charset.class.describeConstable().orElseThrow(),
        CD_IllegalArgumentException = IllegalArgumentException.class.describeConstable().orElseThrow(),
        CD_MemoryLayout             = MemoryLayout.class.describeConstable().orElseThrow(),
        CD_MemorySegment            = MemorySegment.class.describeConstable().orElseThrow(),
        CD_SegmentAllocator         = SegmentAllocator.class.describeConstable().orElseThrow(),
        CD_StackAllocator           = StackAllocator.class.describeConstable().orElseThrow(),
        CD_StackArena               = StackArena.class.describeConstable().orElseThrow(),
        CD_StandardCharsets         = StandardCharsets.class.describeConstable().orElseThrow(),
        CD_ValueLayout              = ValueLayout.class.describeConstable().orElseThrow(),
        CD_ValueLayout$OfByte       = ValueLayout.OfByte.class.describeConstable().orElseThrow(),
        CD_ValueLayout$OfShort      = ValueLayout.OfShort.class.describeConstable().orElseThrow(),
        CD_ValueLayout$OfInt        = ValueLayout.OfInt.class.describeConstable().orElseThrow(),
        CD_ValueLayout$OfLong       = ValueLayout.OfLong.class.describeConstable().orElseThrow();

    static final MethodTypeDesc
        MTD_Charset_forName                             = MethodTypeDesc.of(CD_Charset, CD_String),
        MTD_IllegalArgumentException_new                = MethodTypeDesc.of(CD_void, CD_String),
        MTD_MemorySegment_asSlice                       = MethodTypeDesc.of(CD_MemorySegment, CD_long, CD_long),
        MTD_MemorySegment_equals                        = MethodTypeDesc.of(CD_boolean, CD_Object),
        MTD_MemorySegment_get$OfByte                    = MethodTypeDesc.of(CD_byte, CD_ValueLayout$OfByte, CD_long),
        MTD_MemorySegment_get$OfShort                   = MethodTypeDesc.of(CD_short, CD_ValueLayout$OfShort, CD_long),
        MTD_MemorySegment_get$OfInt                     = MethodTypeDesc.of(CD_int, CD_ValueLayout$OfInt, CD_long),
        MTD_MemorySegment_get$OfLong                    = MethodTypeDesc.of(CD_long, CD_ValueLayout$OfLong, CD_long),
        MTD_MemorySegment_get$Address                   = MethodTypeDesc.of(CD_MemorySegment, CD_AddressLayout, CD_long),
        MTD_MemorySegment_getString                     = MethodTypeDesc.of(CD_String, CD_long, CD_Charset),
        MTD_MemorySegment_toArray$OfByte                = MethodTypeDesc.of(CD_byteArray, CD_ValueLayout$OfByte),
        MTD_SegmentAllocator_allocate_long              = MethodTypeDesc.of(CD_MemorySegment, CD_long),
        MTD_SegmentAllocator_allocate_MemoryLayout_long = MethodTypeDesc.of(CD_MemorySegment, CD_MemoryLayout, CD_long),
        MTD_SegmentAllocator_allocateFrom               = MethodTypeDesc.of(CD_MemorySegment, CD_String, CD_Charset),
        MTD_String_new$byteArray_Charset                = MethodTypeDesc.of(CD_void, CD_byteArray, CD_Charset),
        MTD_StackAllocator_push                         = MethodTypeDesc.of(CD_StackAllocator),
        MTD_StackAllocator_pop                          = MethodTypeDesc.of(CD_StackAllocator),
        MTD_StackArena_stackPush                        = MethodTypeDesc.of(CD_StackArena),
        MTD_Throwable_addSuppressed                     = MethodTypeDesc.of(CD_void, CD_Throwable);

    private static final Set<String> STANDARD_CHARSETS = Arrays.stream(StandardCharsets.class.getDeclaredFields())
        .map(Field::getName)
        .collect(Collectors.toUnmodifiableSet());

    private BindingGenerator() {
    }

    public static <T> T generate(Lookup lookup, Class<T> bindingInterface) {
        return generate(lookup, bindingInterface, null);
    }

    @SuppressWarnings("unchecked")
    public static <T> T generate(Lookup lookup, Class<T> bindingInterface, SymbolLookup loader) {
        try {
            return ((Class<T>)generateImplementation(lookup, bindingInterface, loader).lookupClass())
                .getDeclaredConstructor()
                .newInstance();
        } catch (Throwable t) {
            // This method is almost always called as a static field initializer,
            // which is awkward and can often lead to swallowed exceptions.
            if (DEBUG) {
                // Worst-case: there's double output
                //  Best-case: the user is able to figure what went wrong
                t.printStackTrace(DEBUG_STREAM);
            }
            throw new RuntimeException(t);
        }
    }

    private static Lookup generateImplementation(Lookup lookup, Class<?> functionsClass, SymbolLookup loader) throws IllegalAccessException {
        var methods = functionsClass.getMethods();

        // Slot 0: loader
        // Slot 1+: reflected Method instances
        var classData = new ArrayList<>(1 + methods.length);
        classData.add(loader);
        classData.addAll(Arrays.asList(methods));

        var bytecode = ClassFile.of().build(getClassDesc(functionsClass), classBuilder -> {
            startHiddenClass(classBuilder)
                .withInterfaceSymbols(functionsClass.describeConstable().orElseThrow());

            var constantPool = classBuilder.constantPool();
            for (int m = 0; m < methods.length; m++) {
                var method = methods[m];

                var condy = DynamicConstantDesc.ofNamed(
                    BSM_BOOTSTRAP,
                    method.getName(),
                    CD_MethodHandle,
                    constantPool.intEntry(m + 1).constantValue());

                var methodTypeDesc = getMethodTypeDesc(method);

                classBuilder
                    .withMethod(method.getName(), methodTypeDesc, METHOD_FLAGS_PUBLIC, mb -> mb
                        .withCode(cb -> {
                            // Do the Condy lookup
                            cb.ldc(condy);
                            // Pass arguments unmodified
                            for (int p = 0; p < methodTypeDesc.parameterCount(); p++) {
                                cb.loadInstruction(TypeKind.from(methodTypeDesc.parameterType(p)), p + 1);
                            }
                            // Invoke the generated method handle
                            cb
                                .invokevirtual(CD_MethodHandle, "invokeExact", methodTypeDesc)
                                // Return result if non-void, also unmodified
                                .returnInstruction(TypeKind.from(methodTypeDesc.returnType()));
                        })
                    );
            }
        });

        return lookup.defineHiddenClassWithClassData(bytecode, classData, false);
    }

    // The Condy boostrap method, called the first time the above LDC bytecode is executed.
    @SuppressWarnings("unused")
    public static MethodHandle bootstrap(Lookup lookup, String name, Class<?> bootstrapClass, int index) {
        var debugGenerator = Configuration.DEBUG_GENERATOR.get(false);
        if (debugGenerator) {
            apiLog("BOOTSTRAPPING #" + index + ": " + name);
        }
        try {
            var loader = classDataAt(lookup, DEFAULT_NAME, SymbolLookup.class, 0);
            var method = classDataAt(lookup, DEFAULT_NAME, Method.class, index);

            var parameters = method.getParameters();

            // The target handle
            var nativeHandle = new NativeHandle(method, parameters);
            if (debugGenerator) {
                nativeHandle.printDebug(method, parameters);
            }

            var virtualParameterCount = nativeHandle.getVirtualParameterCount();

            var wrapperFlags = getWrapperFlags(method, parameters, virtualParameterCount);
            if (wrapperFlags != 0) {
                // Wrap the FFM method handle call in a generated method with the same signature as the bootstrapped method.
                // This is required when the native function is not compatible with the bootstrapped method and transformations must be applied.
                if (debugGenerator) {
                    apiLog("\t-> generating wrapper method");
                }

                var bytecode = ClassFile.of().build(getClassDescWrapper(method), classBuilder -> {
                    startHiddenClass(classBuilder);

                    var methodTypeDesc = getMethodTypeDesc(method);

                    classBuilder
                        .withMethod(method.getName(), methodTypeDesc, METHOD_FLAGS_PUBLIC_STATIC, methodBuilder -> methodBuilder
                            .withCode(cb -> {
                                if (CHECKS) {
                                    // Generate checks
                                    for (var p = virtualParameterCount; p < methodTypeDesc.parameterCount(); p++) {
                                        var parameter = parameters[p];
                                        if (!methodTypeDesc.parameterType(p).isPrimitive() && parameter.getAnnotation(FFMNullable.class) == null) {
                                            if (parameter.getType() == MemorySegment.class) {
                                                var slot = cb.parameterSlot(p);
                                                cb
                                                    .getstatic(CD_MemorySegment, "NULL", CD_MemorySegment)
                                                    .aload(slot)
                                                    .invokeinterface(CD_MemorySegment, "equals", MTD_MemorySegment_equals)
                                                    .ifThen(thenHandler -> thenHandler
                                                        .new_(CD_IllegalArgumentException)
                                                        .dup()
                                                        .ldc(thenHandler.constantPool().stringEntry(getExceptionTextNULL(parameter)).constantValue())
                                                        .invokespecial(CD_IllegalArgumentException, INIT_NAME, MTD_IllegalArgumentException_new)
                                                        .athrow()
                                                    );
                                            }
                                            // String will throw in allocateFrom
                                            // TODO: add more types
                                        }
                                    }
                                }

                                var allocatorSlot = (wrapperFlags & 1) != 0 ? nativeHandle.getStackSlot(cb) : -1;
                                buildMethodBody(cb, methodTypeDesc, nativeHandle, allocatorSlot, bcb -> {
                                    ReturnTransform returnTransform = null;

                                    var returnAnnotation = method.getAnnotation(FFMReturn.class);
                                    if (returnAnnotation != null) {
                                        returnTransform = ReturnTransform.create(
                                            bcb,
                                            methodTypeDesc, method, parameters,
                                            returnAnnotation,
                                            allocatorSlot
                                        );
                                    }

                                    // LDC the target handle
                                    nativeHandle.build(bcb);
                                    // Pass arguments, transform if necessary
                                    var firstNativeParameterIndex = nativeHandle.getFirstNativeParameterIndex();
                                    for (int p = 0; p < methodTypeDesc.parameterCount(); p++) {
                                        var parameter = parameters[p];

                                        if (SegmentAllocator.class.isAssignableFrom(parameter.getType())) {
                                            // TODO: unless there is a struct value returned or passed by-value
                                            continue;
                                        }

                                        if (returnTransform != null) {
                                            returnTransform.loadParameters(bcb, virtualParameterCount, p);
                                        }

                                        var slot = bcb.parameterSlot(p);
                                        if (parameter.getType() == String.class) {
                                            if (parameter.getAnnotation(FFMNullable.class) != null) {
                                                bcb
                                                    .aload(slot)
                                                    .ifThenElse(
                                                        Opcode.IFNULL,
                                                        thenHandler -> thenHandler.getstatic(CD_MemorySegment, "NULL", CD_MemorySegment),
                                                        elseHandler -> buildAllocateFrom(elseHandler, allocatorSlot, slot, parameter)
                                                    );
                                            } else {
                                                buildAllocateFrom(bcb, allocatorSlot, slot, parameter);
                                            }
                                        } else if (parameter.getType() == boolean.class && parameter.getAnnotation(FFMBooleanInt.class) != null) {
                                            bcb.iload(p); // TODO: test
                                        } else {
                                            bcb.loadInstruction(TypeKind.from(methodTypeDesc.parameterType(p)), p);
                                        }
                                    }
                                    if (returnTransform != null) {
                                        returnTransform.loadParametersTail(bcb, virtualParameterCount, methodTypeDesc.parameterCount());
                                    }

                                    // Invoke the FFM method handle
                                    var booleanInt = method.getAnnotation(FFMBooleanInt.class);
                                    bcb.invokevirtual(CD_MethodHandle, "invokeExact", nativeHandle.ffm.type().describeConstable().orElseThrow());
                                    if (method.getReturnType() != void.class) {
                                        // Return result if non-void, transform if necessary
                                        if (returnTransform != null) {
                                            returnTransform.buildResult(bcb, methodTypeDesc, method);
                                        } else if (method.getReturnType() == String.class) {
                                            // Native function returns null-terminated string
                                            bcb.lconst_0();
                                            buildCharsetInstance(bcb, getCharset(method));
                                            bcb.invokeinterface(CD_MemorySegment, "getString", MTD_MemorySegment_getString);
                                        } else if (booleanInt != null) {
                                            if (!booleanInt.binary()) {
                                                bcb.ifThenElse(Opcode.IFEQ, CodeBuilder::iconst_0, CodeBuilder::iconst_1);
                                            }
                                        }
                                    }
                                });
                            })
                        );
                });

                if (debugGenerator) {
                    printModel(ClassFile.of().parse(bytecode).methods().getLast());
                }

                // Store the target handle as class data in the hidden class.
                try {
                    var wrapperLookup = lookup.defineHiddenClassWithClassData(bytecode, nativeHandle.getClassData(loader), true);
                    return wrapperLookup.findStatic(
                        wrapperLookup.lookupClass(),
                        method.getName(),
                        methodType(method.getReturnType(), method.getParameterTypes())
                    );
                } catch (Throwable t) {
                    printModel(ClassFile.of().parse(bytecode));
                    throw t;
                }
            }

            // No wrapper needed
            return nativeHandle.getSimpleHandle(loader);
        } catch (Throwable t) {
            throw new RuntimeException(t);
        }
    }

    private static ClassBuilder startHiddenClass(ClassBuilder classBuilder) {
        return classBuilder
            .withVersion(ClassFile.latestMajorVersion(), ClassFile.latestMinorVersion())
            .withFlags(AccessFlag.PUBLIC, AccessFlag.FINAL)
            .withSuperclass(CD_Object)
            // private <init>() { super(); }
            .withMethod(INIT_NAME, MTD_void, METHOD_FLAGS_PUBLIC, mb -> mb
                .withCode(cb -> cb
                    .aload(0)
                    .invokespecial(CD_Object, INIT_NAME, MTD_void, false)
                    .return_()));
    }

    private static int getWrapperFlags(Method method, Parameter[] parameters, int virtualParameterCount) {
        // TODO: sort/tokenize these flags
        // 1: needs stack
        // 2: needs conversion from/to boolean
        // 4: needs check
        var wrapperFlags = 0;
        if (method.getReturnType() == String.class || method.getAnnotation(FFMReturn.class) != null) {
            wrapperFlags |= 1;
        } else if (method.getReturnType() == boolean.class) {
            if (method.getAnnotation(FFMBooleanInt.class) != null) {
                wrapperFlags |= 2;
            }
        }

        for (int i = virtualParameterCount; i < parameters.length; i++) {
            var parameter = parameters[i];
            var type      = parameter.getType();
            if (type == MemorySegment.class) {
                if (CHECKS && parameter.getAnnotation(FFMNullable.class) == null) {
                    wrapperFlags |= 4; // requires null check
                }
            } else if (type == String.class) {
                wrapperFlags |= 1;
            } else if (type == boolean.class) {
                if (parameter.getAnnotation(FFMBooleanInt.class) != null) {
                    wrapperFlags |= 2;
                }
            }
        }
        return wrapperFlags;
    }

    private static void buildMethodBody(CodeBuilder cb, MethodTypeDesc methodTypeDesc, NativeHandle nativeHandle, int allocatorSlot, Consumer<CodeBuilder> bodyHandler) {
        var returnTK = TypeKind.from(methodTypeDesc.returnType());
        if (allocatorSlot != -1 && (nativeHandle.allocatorClass == null || StackAllocator.class.isAssignableFrom(nativeHandle.allocatorClass))) {
            buildStackBody(cb, returnTK, nativeHandle, allocatorSlot, bodyHandler);
        } else {
            bodyHandler.accept(cb);
        }
        cb.returnInstruction(returnTK);
    }

    private static void buildStackBody(CodeBuilder cb, TypeKind returnTK, NativeHandle nativeHandle, int stackSlot, Consumer<CodeBuilder> arenaTryHandler) {
        var returnSlot = returnTK == TypeKind.VoidType ? -1 : cb.allocateLocal(returnTK);

        if (nativeHandle.allocatorClass == null || !StackAllocator.class.isAssignableFrom(nativeHandle.allocatorClass)) {
            // try (var stack = stackPush()) {
            cb
                .invokestatic(CD_StackArena, "stackPush", MTD_StackArena_stackPush)
                .astore(stackSlot);
        } else {
            // stack.push();
            cb
                .aload(cb.parameterSlot(nativeHandle.hasFunctionAddress ? 1 : 0))
                .invokeinterface(CD_StackAllocator, "push", MTD_StackAllocator_push)
                .pop();
        }
        cb.trying(
                tryingHandler -> {
                    arenaTryHandler.accept(tryingHandler);
                    if (returnTK != TypeKind.VoidType) {
                        tryingHandler.storeInstruction(returnTK, returnSlot);
                    }
                },
                catchesHandler -> catchesHandler.catchingAll(bcb0 -> bcb0
                    .astore(stackSlot + 1)
                    .trying(
                        finallyTryHandler -> finallyTryHandler
                            // finally, pop the stack
                            .aload(stackSlot)
                            .invokeinterface(CD_StackAllocator, "pop", MTD_StackAllocator_pop)
                            .pop(),
                        suppressedCatchesHandler -> suppressedCatchesHandler.catchingAll(bcb1 -> bcb1
                            // exception in pop, add to suppressed list
                            .astore(stackSlot + 2)
                            .aload(stackSlot + 1)
                            .aload(stackSlot + 2)
                            .invokevirtual(CD_Throwable, "addSuppressed", MTD_Throwable_addSuppressed))
                    )
                    // rethrow original exception
                    .aload(stackSlot + 1)
                    .throwInstruction()
                )
            )
            // finally, pop the stack
            .aload(stackSlot)
            .invokeinterface(CD_StackAllocator, "pop", MTD_StackAllocator_pop)
            .pop();
        if (returnTK != TypeKind.VoidType) {
            cb.loadInstruction(returnTK, returnSlot);
        }
    }

    static void buildCharsetInstance(CodeBuilder cb, FFMCharset.Type type) {
        cb.getstatic(CD_StandardCharsets, type.charset, CD_Charset);
        /*if (STANDARD_CHARSETS.contains(charsetName)) {
            cb.getstatic(CD_StandardCharsets, charsetName, CD_Charset);
        } else {
            cb
                .ldc(cb.constantPool().stringEntry(charsetName).constantValue())
                .invokestatic(CD_Charset, "forName", MTD_Charset_forName);
        }*/
    }

    static void buildCharsetShift(CodeBuilder bcb, FFMCharset.Type type, TypeKind kind) {
        if (type.byteSize == 1) {
            return;
        }

        switch (type.byteSize) {
            case 2:
                bcb.iconst_1();
                break;
            case 4:
                bcb.iconst_2();
                break;
            default:
                throw new AssertionError();
        }

        if (kind != TypeKind.LongType) {
            bcb.ishl();
        } else {
            bcb.lshl();
        }
    }

    private static void buildAllocateFrom(CodeBuilder cb, int allocatorSlot, int slot, Parameter parameter) {
        cb
            .aload(allocatorSlot)
            .aload(slot);
        buildCharsetInstance(cb, getCharset(parameter));
        cb.invokeinterface(CD_SegmentAllocator, "allocateFrom", MTD_SegmentAllocator_allocateFrom);
    }

    private static ClassDesc getClassDesc(Class<?> functionsClass) {
        return ClassDesc.of(functionsClass.getPackageName(), functionsClass.getSimpleName() + "Impl");
    }

    private static ClassDesc getClassDescWrapper(Method method) {
        var declaringClass = method.getDeclaringClass();
        return ClassDesc.of(
            declaringClass.getPackageName(),
            declaringClass.getSimpleName() + "$" + method.getName() // TODO: do we need to handle multiple overloads?
        );
    }

    private static ClassDesc getClassDescNative(Class<?> type) {
        Class<?> nativeType;
        if (type == String.class) {
            nativeType = MemorySegment.class;
        } else {
            nativeType = type;
        }
        return nativeType.describeConstable().orElseThrow();
    }

    private static MethodTypeDesc getMethodTypeDesc(Method method) {
        return MethodTypeDesc.of(
            method.getReturnType().describeConstable().orElseThrow(),
            getParameterDescs(method)
        );
    }

    private static ClassDesc[] getParameterDescs(Method method) {
        var parameterTypes = method.getParameterTypes();
        var parameterDescs = new ClassDesc[parameterTypes.length];
        for (int p = 0; p < parameterTypes.length; p++) {
            parameterDescs[p] = parameterTypes[p].describeConstable().orElseThrow();
        }
        return parameterDescs;
    }

    private static ClassDesc[] getParameterDescsNative(Method method, ReturnTransform returnTransform) {
        var parameterTypes = method.getParameterTypes();
        var parameterDescs = new ClassDesc[parameterTypes.length];
        for (int p = 0; p < parameterTypes.length; p++) {
            parameterDescs[p] = getClassDescNative(parameterTypes[p]);
        }
        return parameterDescs;
    }


    private static String getExceptionTextNULL(Parameter parameter) {
        return parameter.getType().getSimpleName() + " argument <" + parameter.getName() + "> cannot be NULL";
    }


    static FFMCharset.Type getCharset(Method method) {
        var annotation = method.getAnnotation(FFMCharset.class);
        if (annotation == null) {
            annotation = method.getDeclaringClass().getAnnotation(FFMCharset.class);
        }
        return annotation != null ? annotation.value() : FFMCharset.DEFAULT;
    }

    private static FFMCharset.Type getCharset(Parameter parameter) {
        var annotation = parameter.getAnnotation(FFMCharset.class);
        if (annotation == null) {
            annotation = parameter.getDeclaringExecutable().getDeclaringClass().getAnnotation(FFMCharset.class);
        }
        return annotation != null ? annotation.value() : FFMCharset.DEFAULT;
    }

    private static void printModel(CompoundElement<?> model) {
        DEBUG_STREAM.println(model);
        printModel(model, 0);
    }
    private static void printModel(CompoundElement<?> model, int depth) {
        var indent = "\t".repeat(depth);
        var bci    = 0;
        for (var el : model) {
            if (el instanceof Instruction i) {
                DEBUG_STREAM.println(indent + bci + ": " + i);
                bci += i.sizeInBytes();
            } else {
                DEBUG_STREAM.println(indent + " ".repeat(Integer.toString(bci).length()) + "* " + el);
            }
            if (el instanceof CompoundElement<?> ce) {
                printModel(ce, depth + 1);
            }
        }
    }

    // Experimental wrapper generation using the MethodHandle API.
    // It works, but is awkward (reverse order, broadcasting the StackArena to each parameter that needs it) and verbose.
    // It results in stack frames 5+ levels deep.
    // It is probably not as efficient as the bytecode generation approach above.
    /*private static MethodHandle generateMethodHandleAPI(Method method, MethodHandle nativeHandle) throws Exception {
        // T nativeCall(...);
        // T innerCall2(..., Arena stack, argN, ...) {
        //     return nativeCall(..., stack.allocateFrom(argN), ...);
        // }
        var handle = collectArguments(
            nativeHandle,
            2,
            lookup().findStatic(BindingGenerator.class, "allocateFrom", methodType(MemorySegment.class, Arena.class, String.class))
        );
        // T innerCall1(Arena stack, ...) {
        //     return innerCell2(..., stack, argN, ...);
        // }
        handle = permuteArguments(
            handle,
            methodType(MemorySegment.class, Arena.class, int.class, int.class, String.class, MemorySegment.class, MemorySegment.class),
            1, 2, 0, 3, 4, 5
        );
        // T innerCall0(Arena stack, ...) {
        //     try {
        //         return innerCall1(stack, ...);
        //     } finally {
        //         cleanup(throwable, result, stack); // stack.close() is called here
        //     }
        // }
        handle = tryFinally(
            handle,
            foldArguments(
                permuteArguments(
                    identity(method.getReturnType()),
                    methodType(method.getReturnType(), Throwable.class, method.getReturnType(), Arena.class),
                    1
                ),
                2,
                publicLookup().findVirtual(Arena.class, "close", methodType(void.class))
            )

        );
        // T wrappedCall(...) {
        //     var stack = stackPush();
        //     return innerCall0(stack, ...);
        // }
        handle = foldArguments(
            handle,
            0,
            publicLookup().findStatic(Arena.class, "ofConfined", methodType(Arena.class))
        );

        return handle;
    }*/
}