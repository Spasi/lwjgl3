/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.vulkan;

import org.jspecify.annotations.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

import org.lwjgl.system.windows.*;

/**
 * <pre>{@code
 * struct VkImportFenceWin32HandleInfoKHR {
 *     VkStructureType sType;
 *     void const * pNext;
 *     VkFence fence;
 *     VkFenceImportFlags flags;
 *     VkExternalFenceHandleTypeFlagBits handleType;
 *     HANDLE handle;
 *     LPCWSTR name;
 * }}</pre>
 */
public class VkImportFenceWin32HandleInfoKHR extends Struct<VkImportFenceWin32HandleInfoKHR> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        STYPE,
        PNEXT,
        FENCE,
        FLAGS,
        HANDLETYPE,
        HANDLE,
        NAME;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __member(8),
            __member(4),
            __member(4),
            __member(POINTER_SIZE),
            __member(POINTER_SIZE)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        STYPE = layout.offsetof(0);
        PNEXT = layout.offsetof(1);
        FENCE = layout.offsetof(2);
        FLAGS = layout.offsetof(3);
        HANDLETYPE = layout.offsetof(4);
        HANDLE = layout.offsetof(5);
        NAME = layout.offsetof(6);
    }

    protected VkImportFenceWin32HandleInfoKHR(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected VkImportFenceWin32HandleInfoKHR create(long address, @Nullable ByteBuffer container) {
        return new VkImportFenceWin32HandleInfoKHR(address, container);
    }

    /**
     * Creates a {@code VkImportFenceWin32HandleInfoKHR} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public VkImportFenceWin32HandleInfoKHR(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code sType} field. */
    @NativeType("VkStructureType")
    public int sType() { return nsType(address()); }
    /** @return the value of the {@code pNext} field. */
    @NativeType("void const *")
    public long pNext() { return npNext(address()); }
    /** @return the value of the {@code fence} field. */
    @NativeType("VkFence")
    public long fence() { return nfence(address()); }
    /** @return the value of the {@code flags} field. */
    @NativeType("VkFenceImportFlags")
    public int flags() { return nflags(address()); }
    /** @return the value of the {@code handleType} field. */
    @NativeType("VkExternalFenceHandleTypeFlagBits")
    public int handleType() { return nhandleType(address()); }
    /** @return the value of the {@code handle} field. */
    @NativeType("HANDLE")
    public long handle() { return nhandle(address()); }
    /** @return a {@link ByteBuffer} view of the null-terminated string pointed to by the {@code name} field. */
    @NativeType("LPCWSTR")
    public ByteBuffer name() { return nname(address()); }
    /** @return the null-terminated string pointed to by the {@code name} field. */
    @NativeType("LPCWSTR")
    public String nameString() { return nnameString(address()); }

    /** Sets the specified value to the {@code sType} field. */
    public VkImportFenceWin32HandleInfoKHR sType(@NativeType("VkStructureType") int value) { nsType(address(), value); return this; }
    /** Sets the {@link KHRExternalFenceWin32#VK_STRUCTURE_TYPE_IMPORT_FENCE_WIN32_HANDLE_INFO_KHR STRUCTURE_TYPE_IMPORT_FENCE_WIN32_HANDLE_INFO_KHR} value to the {@code sType} field. */
    public VkImportFenceWin32HandleInfoKHR sType$Default() { return sType(KHRExternalFenceWin32.VK_STRUCTURE_TYPE_IMPORT_FENCE_WIN32_HANDLE_INFO_KHR); }
    /** Sets the specified value to the {@code pNext} field. */
    public VkImportFenceWin32HandleInfoKHR pNext(@NativeType("void const *") long value) { npNext(address(), value); return this; }
    /** Sets the specified value to the {@code fence} field. */
    public VkImportFenceWin32HandleInfoKHR fence(@NativeType("VkFence") long value) { nfence(address(), value); return this; }
    /** Sets the specified value to the {@code flags} field. */
    public VkImportFenceWin32HandleInfoKHR flags(@NativeType("VkFenceImportFlags") int value) { nflags(address(), value); return this; }
    /** Sets the specified value to the {@code handleType} field. */
    public VkImportFenceWin32HandleInfoKHR handleType(@NativeType("VkExternalFenceHandleTypeFlagBits") int value) { nhandleType(address(), value); return this; }
    /** Sets the specified value to the {@code handle} field. */
    public VkImportFenceWin32HandleInfoKHR handle(@NativeType("HANDLE") long value) { nhandle(address(), value); return this; }
    /** Sets the address of the specified encoded string to the {@code name} field. */
    public VkImportFenceWin32HandleInfoKHR name(@NativeType("LPCWSTR") ByteBuffer value) { nname(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public VkImportFenceWin32HandleInfoKHR set(
        int sType,
        long pNext,
        long fence,
        int flags,
        int handleType,
        long handle,
        ByteBuffer name
    ) {
        sType(sType);
        pNext(pNext);
        fence(fence);
        flags(flags);
        handleType(handleType);
        handle(handle);
        name(name);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public VkImportFenceWin32HandleInfoKHR set(VkImportFenceWin32HandleInfoKHR src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code VkImportFenceWin32HandleInfoKHR} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static VkImportFenceWin32HandleInfoKHR malloc() {
        return new VkImportFenceWin32HandleInfoKHR(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code VkImportFenceWin32HandleInfoKHR} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static VkImportFenceWin32HandleInfoKHR calloc() {
        return new VkImportFenceWin32HandleInfoKHR(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code VkImportFenceWin32HandleInfoKHR} instance allocated with {@link BufferUtils}. */
    public static VkImportFenceWin32HandleInfoKHR create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new VkImportFenceWin32HandleInfoKHR(memAddress(container), container);
    }

    /** Returns a new {@code VkImportFenceWin32HandleInfoKHR} instance for the specified memory address. */
    public static VkImportFenceWin32HandleInfoKHR create(long address) {
        return new VkImportFenceWin32HandleInfoKHR(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable VkImportFenceWin32HandleInfoKHR createSafe(long address) {
        return address == NULL ? null : new VkImportFenceWin32HandleInfoKHR(address, null);
    }

    /**
     * Returns a new {@link VkImportFenceWin32HandleInfoKHR.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkImportFenceWin32HandleInfoKHR.Buffer malloc(int capacity) {
        return new Buffer(nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link VkImportFenceWin32HandleInfoKHR.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkImportFenceWin32HandleInfoKHR.Buffer calloc(int capacity) {
        return new Buffer(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkImportFenceWin32HandleInfoKHR.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static VkImportFenceWin32HandleInfoKHR.Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return new Buffer(memAddress(container), container, -1, 0, capacity, capacity);
    }

    /**
     * Create a {@link VkImportFenceWin32HandleInfoKHR.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static VkImportFenceWin32HandleInfoKHR.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static VkImportFenceWin32HandleInfoKHR.@Nullable Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    // -----------------------------------

    /** Deprecated for removal in 3.4.0. Use {@link #malloc(MemoryStack)} instead. */
    @Deprecated public static VkImportFenceWin32HandleInfoKHR mallocStack() { return malloc(stackGet()); }
    /** Deprecated for removal in 3.4.0. Use {@link #calloc(MemoryStack)} instead. */
    @Deprecated public static VkImportFenceWin32HandleInfoKHR callocStack() { return calloc(stackGet()); }
    /** Deprecated for removal in 3.4.0. Use {@link #malloc(MemoryStack)} instead. */
    @Deprecated public static VkImportFenceWin32HandleInfoKHR mallocStack(MemoryStack stack) { return malloc(stack); }
    /** Deprecated for removal in 3.4.0. Use {@link #calloc(MemoryStack)} instead. */
    @Deprecated public static VkImportFenceWin32HandleInfoKHR callocStack(MemoryStack stack) { return calloc(stack); }
    /** Deprecated for removal in 3.4.0. Use {@link #malloc(int, MemoryStack)} instead. */
    @Deprecated public static VkImportFenceWin32HandleInfoKHR.Buffer mallocStack(int capacity) { return malloc(capacity, stackGet()); }
    /** Deprecated for removal in 3.4.0. Use {@link #calloc(int, MemoryStack)} instead. */
    @Deprecated public static VkImportFenceWin32HandleInfoKHR.Buffer callocStack(int capacity) { return calloc(capacity, stackGet()); }
    /** Deprecated for removal in 3.4.0. Use {@link #malloc(int, MemoryStack)} instead. */
    @Deprecated public static VkImportFenceWin32HandleInfoKHR.Buffer mallocStack(int capacity, MemoryStack stack) { return malloc(capacity, stack); }
    /** Deprecated for removal in 3.4.0. Use {@link #calloc(int, MemoryStack)} instead. */
    @Deprecated public static VkImportFenceWin32HandleInfoKHR.Buffer callocStack(int capacity, MemoryStack stack) { return calloc(capacity, stack); }

    /**
     * Returns a new {@code VkImportFenceWin32HandleInfoKHR} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static VkImportFenceWin32HandleInfoKHR malloc(MemoryStack stack) {
        return new VkImportFenceWin32HandleInfoKHR(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code VkImportFenceWin32HandleInfoKHR} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static VkImportFenceWin32HandleInfoKHR calloc(MemoryStack stack) {
        return new VkImportFenceWin32HandleInfoKHR(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    /**
     * Returns a new {@link VkImportFenceWin32HandleInfoKHR.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkImportFenceWin32HandleInfoKHR.Buffer malloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkImportFenceWin32HandleInfoKHR.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkImportFenceWin32HandleInfoKHR.Buffer calloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #sType}. */
    public static int nsType(long struct) { return memGetInt(struct + VkImportFenceWin32HandleInfoKHR.STYPE); }
    /** Unsafe version of {@link #pNext}. */
    public static long npNext(long struct) { return memGetAddress(struct + VkImportFenceWin32HandleInfoKHR.PNEXT); }
    /** Unsafe version of {@link #fence}. */
    public static long nfence(long struct) { return memGetLong(struct + VkImportFenceWin32HandleInfoKHR.FENCE); }
    /** Unsafe version of {@link #flags}. */
    public static int nflags(long struct) { return memGetInt(struct + VkImportFenceWin32HandleInfoKHR.FLAGS); }
    /** Unsafe version of {@link #handleType}. */
    public static int nhandleType(long struct) { return memGetInt(struct + VkImportFenceWin32HandleInfoKHR.HANDLETYPE); }
    /** Unsafe version of {@link #handle}. */
    public static long nhandle(long struct) { return memGetAddress(struct + VkImportFenceWin32HandleInfoKHR.HANDLE); }
    /** Unsafe version of {@link #name}. */
    public static ByteBuffer nname(long struct) { return memByteBufferNT2(memGetAddress(struct + VkImportFenceWin32HandleInfoKHR.NAME)); }
    /** Unsafe version of {@link #nameString}. */
    public static String nnameString(long struct) { return memUTF16(memGetAddress(struct + VkImportFenceWin32HandleInfoKHR.NAME)); }

    /** Unsafe version of {@link #sType(int) sType}. */
    public static void nsType(long struct, int value) { memPutInt(struct + VkImportFenceWin32HandleInfoKHR.STYPE, value); }
    /** Unsafe version of {@link #pNext(long) pNext}. */
    public static void npNext(long struct, long value) { memPutAddress(struct + VkImportFenceWin32HandleInfoKHR.PNEXT, value); }
    /** Unsafe version of {@link #fence(long) fence}. */
    public static void nfence(long struct, long value) { memPutLong(struct + VkImportFenceWin32HandleInfoKHR.FENCE, value); }
    /** Unsafe version of {@link #flags(int) flags}. */
    public static void nflags(long struct, int value) { memPutInt(struct + VkImportFenceWin32HandleInfoKHR.FLAGS, value); }
    /** Unsafe version of {@link #handleType(int) handleType}. */
    public static void nhandleType(long struct, int value) { memPutInt(struct + VkImportFenceWin32HandleInfoKHR.HANDLETYPE, value); }
    /** Unsafe version of {@link #handle(long) handle}. */
    public static void nhandle(long struct, long value) { memPutAddress(struct + VkImportFenceWin32HandleInfoKHR.HANDLE, check(value)); }
    /** Unsafe version of {@link #name(ByteBuffer) name}. */
    public static void nname(long struct, ByteBuffer value) {
        if (CHECKS) { checkNT2(value); }
        memPutAddress(struct + VkImportFenceWin32HandleInfoKHR.NAME, memAddress(value));
    }

    /**
     * Validates pointer members that should not be {@code NULL}.
     *
     * @param struct the struct to validate
     */
    public static void validate(long struct) {
        check(memGetAddress(struct + VkImportFenceWin32HandleInfoKHR.HANDLE));
        check(memGetAddress(struct + VkImportFenceWin32HandleInfoKHR.NAME));
    }

    // -----------------------------------

    /** An array of {@link VkImportFenceWin32HandleInfoKHR} structs. */
    public static class Buffer extends StructBuffer<VkImportFenceWin32HandleInfoKHR, Buffer> implements NativeResource {

        private static final VkImportFenceWin32HandleInfoKHR ELEMENT_FACTORY = VkImportFenceWin32HandleInfoKHR.create(-1L);

        /**
         * Creates a new {@code VkImportFenceWin32HandleInfoKHR.Buffer} instance backed by the specified container.
         *
         * <p>Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link VkImportFenceWin32HandleInfoKHR#SIZEOF}, and its mark will be undefined.</p>
         *
         * <p>The created buffer instance holds a strong reference to the container object.</p>
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected Buffer create(long address, @Nullable ByteBuffer container, int mark, int position, int limit, int capacity) {
            return new Buffer(address, container, mark, position, limit, capacity);
        }

        @Override
        protected VkImportFenceWin32HandleInfoKHR getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@code sType} field. */
        @NativeType("VkStructureType")
        public int sType() { return VkImportFenceWin32HandleInfoKHR.nsType(address()); }
        /** @return the value of the {@code pNext} field. */
        @NativeType("void const *")
        public long pNext() { return VkImportFenceWin32HandleInfoKHR.npNext(address()); }
        /** @return the value of the {@code fence} field. */
        @NativeType("VkFence")
        public long fence() { return VkImportFenceWin32HandleInfoKHR.nfence(address()); }
        /** @return the value of the {@code flags} field. */
        @NativeType("VkFenceImportFlags")
        public int flags() { return VkImportFenceWin32HandleInfoKHR.nflags(address()); }
        /** @return the value of the {@code handleType} field. */
        @NativeType("VkExternalFenceHandleTypeFlagBits")
        public int handleType() { return VkImportFenceWin32HandleInfoKHR.nhandleType(address()); }
        /** @return the value of the {@code handle} field. */
        @NativeType("HANDLE")
        public long handle() { return VkImportFenceWin32HandleInfoKHR.nhandle(address()); }
        /** @return a {@link ByteBuffer} view of the null-terminated string pointed to by the {@code name} field. */
        @NativeType("LPCWSTR")
        public ByteBuffer name() { return VkImportFenceWin32HandleInfoKHR.nname(address()); }
        /** @return the null-terminated string pointed to by the {@code name} field. */
        @NativeType("LPCWSTR")
        public String nameString() { return VkImportFenceWin32HandleInfoKHR.nnameString(address()); }

        /** Sets the specified value to the {@code sType} field. */
        public VkImportFenceWin32HandleInfoKHR.Buffer sType(@NativeType("VkStructureType") int value) { VkImportFenceWin32HandleInfoKHR.nsType(address(), value); return this; }
        /** Sets the {@link KHRExternalFenceWin32#VK_STRUCTURE_TYPE_IMPORT_FENCE_WIN32_HANDLE_INFO_KHR STRUCTURE_TYPE_IMPORT_FENCE_WIN32_HANDLE_INFO_KHR} value to the {@code sType} field. */
        public VkImportFenceWin32HandleInfoKHR.Buffer sType$Default() { return sType(KHRExternalFenceWin32.VK_STRUCTURE_TYPE_IMPORT_FENCE_WIN32_HANDLE_INFO_KHR); }
        /** Sets the specified value to the {@code pNext} field. */
        public VkImportFenceWin32HandleInfoKHR.Buffer pNext(@NativeType("void const *") long value) { VkImportFenceWin32HandleInfoKHR.npNext(address(), value); return this; }
        /** Sets the specified value to the {@code fence} field. */
        public VkImportFenceWin32HandleInfoKHR.Buffer fence(@NativeType("VkFence") long value) { VkImportFenceWin32HandleInfoKHR.nfence(address(), value); return this; }
        /** Sets the specified value to the {@code flags} field. */
        public VkImportFenceWin32HandleInfoKHR.Buffer flags(@NativeType("VkFenceImportFlags") int value) { VkImportFenceWin32HandleInfoKHR.nflags(address(), value); return this; }
        /** Sets the specified value to the {@code handleType} field. */
        public VkImportFenceWin32HandleInfoKHR.Buffer handleType(@NativeType("VkExternalFenceHandleTypeFlagBits") int value) { VkImportFenceWin32HandleInfoKHR.nhandleType(address(), value); return this; }
        /** Sets the specified value to the {@code handle} field. */
        public VkImportFenceWin32HandleInfoKHR.Buffer handle(@NativeType("HANDLE") long value) { VkImportFenceWin32HandleInfoKHR.nhandle(address(), value); return this; }
        /** Sets the address of the specified encoded string to the {@code name} field. */
        public VkImportFenceWin32HandleInfoKHR.Buffer name(@NativeType("LPCWSTR") ByteBuffer value) { VkImportFenceWin32HandleInfoKHR.nname(address(), value); return this; }

    }

}