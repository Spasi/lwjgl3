/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.jmh;

import org.lwjgl.system.*;
import org.lwjgl.system.ffm.*;
import org.openjdk.jmh.annotations.*;

import java.lang.foreign.*;
import java.lang.invoke.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.JNI.*;

@State(Scope.Benchmark)
public class FFMOverheadTest {

    static {
        Library.initialize();
    }

    private static final SymbolLookup LOADER = SymbolLookup.libraryLookup("lwjgl", Arena.global());

    private static final MemorySegment FUNCTION_NOOP        = LOADER.find("org_lwjgl_system_noop").orElseThrow();
    private static final MemorySegment FUNCTION_NOOP_PARAMS = LOADER.find("org_lwjgl_system_noop_params").orElseThrow();

    private static final MethodHandle NOOP = Linker.nativeLinker()
        .downcallHandle(FunctionDescriptor.ofVoid())
        .bindTo(FUNCTION_NOOP);

    private static final MethodHandle NOOP_PARAMS = Linker.nativeLinker()
        .downcallHandle(FunctionDescriptor.ofVoid(ValueLayout.ADDRESS, ValueLayout.ADDRESS, ValueLayout.JAVA_INT))
        .bindTo(FUNCTION_NOOP_PARAMS);

    private interface FFMBindings {
        @FFMName("org_lwjgl_system_noop")
        void noop();

        @FFMCritical
        @FFMName("org_lwjgl_system_noop")
        void noop_crit();

        @FFMName("org_lwjgl_system_noop_params")
        void noop_params(@FFMNullable MemorySegment param0, @FFMNullable MemorySegment param1, int param2);

        @FFMName("org_lwjgl_system_noop_params")
        void noop_params_checked(MemorySegment param0, MemorySegment param1, int param2);

        @FFMCritical
        @FFMName("org_lwjgl_system_noop_params")
        void noop_params_crit(@FFMNullable MemorySegment param0, @FFMNullable MemorySegment param1, int param2);

        @FFMCritical
        @FFMName("org_lwjgl_system_noop_params")
        void noop_params_crit_checked(MemorySegment param0, MemorySegment param1, int param2);
    }

    private static final FFMBindings BINDINGS = BindingGenerator.generate(MethodHandles.lookup(), FFMBindings.class, LOADER);

    private MemorySegment param0 = MemorySegment.ofAddress(8L);
    private MemorySegment param1 = MemorySegment.ofAddress(16L);
    private int           param2 = 32;

    @Benchmark
    public void jni_noop() {
        invokeV(FUNCTION_NOOP.address());
    }

    @Benchmark
    public void jni_noop_params() {
        invokePPV(param0.address(), param1.address(), param2, FUNCTION_NOOP.address());
    }

    @Benchmark
    public void jni_noop_params_checked() {
        if (CHECKS) {
            if (MemorySegment.NULL.equals(param0)) {
                throw new IllegalArgumentException("MemorySegment argument <param0> cannot be NULL");
            }
            if (MemorySegment.NULL.equals(param1)) {
                throw new IllegalArgumentException("MemorySegment argument <param1> cannot be NULL");
            }
        }
        invokePPV(param0.address(), param1.address(), param2, FUNCTION_NOOP.address());
    }

    @Benchmark
    public void ffm_noop() {
        try {
            NOOP.invokeExact();
        } catch (Throwable e) {
            throw new AssertionError(e);
        }
    }

    @Benchmark
    public void ffm_noop_params() {
        try {
            NOOP_PARAMS.invokeExact(param0, param1, param2);
        } catch (Throwable e) {
            throw new AssertionError(e);
        }
    }

    @Benchmark
    public void ffm_noop_params_checked() {
        if (CHECKS) {
            if (MemorySegment.NULL.equals(param0)) {
                throw new IllegalArgumentException("MemorySegment argument <param0> cannot be NULL");
            }
            if (MemorySegment.NULL.equals(param1)) {
                throw new IllegalArgumentException("MemorySegment argument <param1> cannot be NULL");
            }
        }
        try {
            NOOP_PARAMS.invokeExact(param0, param1, param2);
        } catch (Throwable e) {
            throw new AssertionError(e);
        }
    }

    @Benchmark
    public void gen_noop() {
        BINDINGS.noop();
    }

    @Benchmark
    public void gen_noop_crit() {
        BINDINGS.noop_crit();
    }

    @Benchmark
    public void gen_noop_params() {
        BINDINGS.noop_params(param0, param1, param2);
    }

    @Benchmark
    public void gen_noop_params_checked() {
        BINDINGS.noop_params_checked(param0, param1, param2);
    }

    @Benchmark
    public void gen_noop_params_crit() {
        BINDINGS.noop_params_crit(param0, param1, param2);
    }

    @Benchmark
    public void gen_noop_params_crit_checked() {
        BINDINGS.noop_params_crit_checked(param0, param1, param2);
    }

}