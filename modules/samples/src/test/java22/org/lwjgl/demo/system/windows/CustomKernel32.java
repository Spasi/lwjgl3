/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.demo.system.windows;

import org.lwjgl.system.*;
import org.lwjgl.system.ffm.*;
import org.lwjgl.system.windows.*;

import java.lang.foreign.*;
import java.lang.invoke.*;
import java.nio.charset.*;
import java.util.*;

import static org.lwjgl.system.ffm.FFMCharset.Type.*;
import static org.lwjgl.system.ffm.StackArena.*;
import static org.testng.Assert.*;

public class CustomKernel32 {

    @FFMCharset(UTF16)
    public interface MyKernel32Bindings {
        @FFMName("GetModuleHandleW")
        @FFMSignature("HMODULE GetModuleHandle(LPCWSTR lpModuleName)")
        MemorySegment GetModuleHandle(@FFMCaptureCallState("GetLastError") MemorySegment pLastError, @FFMNullable String lpModuleName);

        // ----------------------------

        @FFMName("GetModuleFileNameW")
        @FFMSignature("DWORD GetModuleFileNameW(HMODULE hModule, LPTSTR lpFileName, DWORD nSize)")
        int GetModuleFileName(@FFMCaptureCallState("GetLastError") MemorySegment pLastError, MemorySegment hModule, MemorySegment lpFileName, @FFMReturn.Size int nSize);

        @FFMName("GetModuleFileNameW") @FFMReturn(1)
        @FFMSignature("DWORD GetModuleFileNameW(HMODULE hModule, LPTSTR lpFileName, DWORD nSize)")
        String GetModuleFileName(@FFMCaptureCallState("GetLastError") MemorySegment pLastError, MemorySegment hModule, @FFMReturn.Size int nSize);

        @FFMName("GetModuleFileNameW") @FFMReturn(1)
        @FFMSignature("DWORD GetModuleFileNameW(HMODULE hModule, LPTSTR lpFileName, DWORD nSize)")
        String GetModuleFileName(SegmentAllocator allocator, @FFMCaptureCallState("GetLastError") MemorySegment pLastError, MemorySegment hModule, @FFMReturn.Size int nSize);

        @FFMName("GetModuleFileNameW") @FFMReturn(1)
        @FFMSignature("DWORD GetModuleFileNameW(HMODULE hModule, LPTSTR lpFileName, DWORD nSize)")
        String GetModuleFileName(StackAllocator<?> allocator, @FFMCaptureCallState("GetLastError") MemorySegment pLastError, MemorySegment hModule, @FFMReturn.Size int nSize);

        // ----------------------------

        @FFMName("LoadLibraryW")
        @FFMSignature("HMODULE LoadLibrary(LPCTSTR lpLibFileName)")
        MemorySegment LoadLibrary(@FFMCaptureCallState("GetLastError") MemorySegment pLastError, String lpLibFileName);

        @FFMSignature("FARPROC GetProcAddress(HMODULE hModule, LPCSTR lpProcName)")
        MemorySegment GetProcAddress(@FFMCaptureCallState("GetLastError") MemorySegment pLastError, MemorySegment hModule, @FFMCharset(ISO_8859_1) String lpProcName);

        @FFMBooleanInt(binary = true)
        @FFMSignature("BOOL FreeLibrary(HMODULE hLibModule)")
        boolean FreeLibrary(@FFMCaptureCallState("GetLastError") MemorySegment pLastError, MemorySegment hLibModule);
    }

    static {
        //Configuration.DISABLE_CHECKS.set(true);
        Configuration.DEBUG_GENERATOR.set(true);
    }

    private static final SymbolLookup       LOADER   = SymbolLookup.libraryLookup(Objects.requireNonNull(Kernel32.getLibrary().getPath()), Arena.global());
    private static final MyKernel32Bindings KERNEL32 = BindingGenerator.generate(MethodHandles.lookup(), MyKernel32Bindings.class, LOADER);

    public static void main(String[] ignored) {
        try (var stack = stackPush()) {
            var LastError = stack.allocate(Linker.Option.captureStateLayout());

            var process = KERNEL32.GetModuleHandle(LastError, null);
            check(LastError);

            assertEquals(
                process.address(),
                WinBase.GetModuleHandle((String)null)
            );

            var moduleFileNameRef = WinBase.GetModuleFileName(process.address(), 512);

            // Case A: External buffer
            try (var frame = stack.push()) {
                var lpFileName = frame.allocate(512 * 2);

                var length = KERNEL32.GetModuleFileName(LastError, process, lpFileName, 512);
                assertEquals(
                    new String(lpFileName.asSlice(0L, length * 2).toArray(ValueLayout.JAVA_BYTE), StandardCharsets.UTF_16LE),
                    moduleFileNameRef
                );
                check(LastError);
            }

            // Case B: Internal buffer, thread-local stack lookup, push/pop
            var pointer = stack.getPointer();
            {
                assertEquals(
                    KERNEL32.GetModuleFileName(LastError, process, 512),
                    moduleFileNameRef
                );
                check(LastError);
                assertEquals(stack.getPointer(), pointer);
            }

            // Case C: Internal buffer, explicit stack (no lookup), push/pop
            {
                assertEquals(
                    KERNEL32.GetModuleFileName(stack, LastError, process, 512),
                    moduleFileNameRef
                );
                check(LastError);
                assertEquals(stack.getPointer(), pointer);
            }

            // Case D: Internal buffer, explicit allocator, no push/pop
            try (var frame = stack.push()) {
                assertEquals(
                    KERNEL32.GetModuleFileName((SegmentAllocator)frame, LastError, process, 512),
                    moduleFileNameRef
                );
                check(LastError);
                assertEquals(frame.getPointer(), (pointer & -ValueLayout.ADDRESS.byteAlignment()) - (512 * 2));
            }
            assertEquals(stack.getPointer(), pointer);

            var kernel32    = KERNEL32.LoadLibrary(LastError, "kernel32.dll");
            var kernel32Ref = WinBase.LoadLibrary("kernel32.dll");
            check(LastError);
            assertEquals(
                kernel32.address(),
                kernel32Ref
            );

            assertEquals(
                KERNEL32.GetProcAddress(LastError, kernel32, "VirtualAlloc").address(),
                WinBase.GetProcAddress(kernel32Ref, "VirtualAlloc")
            );
            check(LastError);

            assertEquals(
                KERNEL32.FreeLibrary(LastError, kernel32),
                WinBase.FreeLibrary(kernel32Ref)
            );
            check(LastError);
        }
    }

    private static final VarHandle GET_LAST_ERROR = Linker.Option.captureStateLayout()
        .varHandle(MemoryLayout.PathElement.groupElement("GetLastError"))
        .withInvokeExactBehavior();

    private static void check(MemorySegment LastError) {
        var error = (int)GET_LAST_ERROR.get(LastError, 0L);
        if (error != 0) {
            throw new IllegalStateException("Operation failed with error code: " + error);
        }
    }

}