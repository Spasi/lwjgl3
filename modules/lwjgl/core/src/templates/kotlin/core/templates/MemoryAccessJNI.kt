/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package core.templates

import org.lwjgl.generator.*

val MemoryAccessJNI = "MemoryAccessJNI".nativeClass(Module.CORE) {
    nativeImport(
        "<stdlib.h>",
        "<stdint.h>"
    )

    access = Access.INTERNAL
    Code(
        nativeCall = "${t}return (jint)sizeof(void *);"
    )..int(
        "getPointerSize",
        void()
    )

    val primitives = arrayOf(
        Triple(int8_t, "Byte", "a byte value"),
        Triple(int16_t, "Short", "a short value"),
        Triple(int32_t, "Int", "an int value"),
        Triple(int64_t, "Long", "a long value"),

        Triple(float, "Float", "a float value"),
        Triple(double, "Double", "a double value"),

        Triple(uintptr_t, "Address", "a pointer address")
    )

    nativeDirective(
        """#ifdef LWJGL_WINDOWS
    static void* __aligned_alloc(size_t alignment, size_t size) {
        return _aligned_malloc(size, alignment);
    }
    #define __aligned_free _aligned_free
#else
    #if defined(__USE_ISOC11)
        #define __aligned_alloc aligned_alloc
    #else
        static void* __aligned_alloc(size_t alignment, size_t size) {
            void *p;
            return posix_memalign(&p, alignment, size) ? NULL : p;
        }
    #endif
    #define __aligned_free free
#endif

// -----------

${primitives
            .asSequence()
            .map {
                val (type, name) = it
                "static inline ${type.name} get$name(void *ptr) { return *(${type.name} *)ptr; }"
            }
            .joinToString("\n")}

// -----------

${primitives
            .asSequence()
            .map {
                val (type, name) = it
                "static inline void put$name(void *ptr, ${type.name} value) { *(${type.name} *)ptr = value; }"
            }
            .joinToString("\n")}

// -----------""")

    arrayOf(
        "malloc" to "void * (*) (size_t)",
        "calloc" to "void * (*) (size_t, size_t)",
        "realloc" to "void * (*) (void *, size_t)",
        "free" to "void (*) (void *)"
    ).forEach { (name, signature) ->
        macro..Address..signature.handle(
            name,
            void()
        )
    }

    Code(
        nativeCall = "${t}return (jlong)(uintptr_t)&__aligned_alloc;"
    )..macro..Address.."void * (*) (size_t, size_t)".handle(
        "aligned_alloc",
        void()
    )

    Code(
        nativeCall = "${t}return (jlong)(uintptr_t)&__aligned_free;"
    )..macro..Address.."void (*) (void *)".handle(
        "aligned_free",
        void()
    )

    for ((type, name, msg) in primitives)
        type(
            "get$name",

            opaque_p("ptr")
        )

    for ((type, name, msg) in primitives)
        void(
            "put$name",

            opaque_p("ptr"),
            type("value")
        )
}