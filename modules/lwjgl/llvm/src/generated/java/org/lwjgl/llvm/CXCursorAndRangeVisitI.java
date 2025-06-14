/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.llvm;

import org.lwjgl.system.*;
import org.lwjgl.system.libffi.*;

import static org.lwjgl.system.APIUtil.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.libffi.LibFFI.*;

/** Callback function: {@link #invoke (* anonymous)} */
@FunctionalInterface
@NativeType("enum CXVisitorResult (*) (void *, CXCursor, CXSourceRange)")
public interface CXCursorAndRangeVisitI extends CallbackI {

    FFICIF CIF = apiCreateCIF(
        ffi_type_uint32,
        ffi_type_pointer, apiCreateStruct(ffi_type_uint32, ffi_type_sint32, apiCreateArray(ffi_type_pointer, 3)), apiCreateStruct(apiCreateArray(ffi_type_pointer, 2), ffi_type_uint32, ffi_type_uint32)
    );

    @Override
    default FFICIF getCallInterface() { return CIF; }

    @Override
    default void callback(long ret, long args) {
        int __result = invoke(
            memGetAddress(memGetAddress(args)),
            CXCursor.create(memGetAddress(args + POINTER_SIZE)),
            CXSourceRange.create(memGetAddress(args + 2 * POINTER_SIZE))
        );
        apiClosureRet(ret, __result);
    }

    /** {@code enum CXVisitorResult (*) (void * context, CXCursor cursor, CXSourceRange range)} */
    @NativeType("enum CXVisitorResult") int invoke(@NativeType("void *") long context, CXCursor cursor, CXSourceRange range);

}