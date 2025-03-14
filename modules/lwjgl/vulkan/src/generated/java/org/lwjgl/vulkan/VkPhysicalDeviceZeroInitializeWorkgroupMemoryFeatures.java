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

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * <pre>{@code
 * struct VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures {
 *     VkStructureType sType;
 *     void * pNext;
 *     VkBool32 shaderZeroInitializeWorkgroupMemory;
 * }}</pre>
 */
public class VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures extends Struct<VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        STYPE,
        PNEXT,
        SHADERZEROINITIALIZEWORKGROUPMEMORY;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __member(4)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        STYPE = layout.offsetof(0);
        PNEXT = layout.offsetof(1);
        SHADERZEROINITIALIZEWORKGROUPMEMORY = layout.offsetof(2);
    }

    protected VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures create(long address, @Nullable ByteBuffer container) {
        return new VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(address, container);
    }

    /**
     * Creates a {@code VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code sType} field. */
    @NativeType("VkStructureType")
    public int sType() { return nsType(address()); }
    /** @return the value of the {@code pNext} field. */
    @NativeType("void *")
    public long pNext() { return npNext(address()); }
    /** @return the value of the {@code shaderZeroInitializeWorkgroupMemory} field. */
    @NativeType("VkBool32")
    public boolean shaderZeroInitializeWorkgroupMemory() { return nshaderZeroInitializeWorkgroupMemory(address()) != 0; }

    /** Sets the specified value to the {@code sType} field. */
    public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures sType(@NativeType("VkStructureType") int value) { nsType(address(), value); return this; }
    /** Sets the {@link VK13#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_ZERO_INITIALIZE_WORKGROUP_MEMORY_FEATURES STRUCTURE_TYPE_PHYSICAL_DEVICE_ZERO_INITIALIZE_WORKGROUP_MEMORY_FEATURES} value to the {@code sType} field. */
    public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures sType$Default() { return sType(VK13.VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_ZERO_INITIALIZE_WORKGROUP_MEMORY_FEATURES); }
    /** Sets the specified value to the {@code pNext} field. */
    public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures pNext(@NativeType("void *") long value) { npNext(address(), value); return this; }
    /** Sets the specified value to the {@code shaderZeroInitializeWorkgroupMemory} field. */
    public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures shaderZeroInitializeWorkgroupMemory(@NativeType("VkBool32") boolean value) { nshaderZeroInitializeWorkgroupMemory(address(), value ? 1 : 0); return this; }

    /** Initializes this struct with the specified values. */
    public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures set(
        int sType,
        long pNext,
        boolean shaderZeroInitializeWorkgroupMemory
    ) {
        sType(sType);
        pNext(pNext);
        shaderZeroInitializeWorkgroupMemory(shaderZeroInitializeWorkgroupMemory);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures set(VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures malloc() {
        return new VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures calloc() {
        return new VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} instance allocated with {@link BufferUtils}. */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(memAddress(container), container);
    }

    /** Returns a new {@code VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} instance for the specified memory address. */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures create(long address) {
        return new VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures createSafe(long address) {
        return address == NULL ? null : new VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(address, null);
    }

    /**
     * Returns a new {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer malloc(int capacity) {
        return new Buffer(nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer calloc(int capacity) {
        return new Buffer(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return new Buffer(memAddress(container), container, -1, 0, capacity, capacity);
    }

    /**
     * Create a {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.@Nullable Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    /**
     * Returns a new {@code VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures malloc(MemoryStack stack) {
        return new VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures calloc(MemoryStack stack) {
        return new VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    /**
     * Returns a new {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer malloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer calloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #sType}. */
    public static int nsType(long struct) { return memGetInt(struct + VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.STYPE); }
    /** Unsafe version of {@link #pNext}. */
    public static long npNext(long struct) { return memGetAddress(struct + VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.PNEXT); }
    /** Unsafe version of {@link #shaderZeroInitializeWorkgroupMemory}. */
    public static int nshaderZeroInitializeWorkgroupMemory(long struct) { return memGetInt(struct + VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.SHADERZEROINITIALIZEWORKGROUPMEMORY); }

    /** Unsafe version of {@link #sType(int) sType}. */
    public static void nsType(long struct, int value) { memPutInt(struct + VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.STYPE, value); }
    /** Unsafe version of {@link #pNext(long) pNext}. */
    public static void npNext(long struct, long value) { memPutAddress(struct + VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.PNEXT, value); }
    /** Unsafe version of {@link #shaderZeroInitializeWorkgroupMemory(boolean) shaderZeroInitializeWorkgroupMemory}. */
    public static void nshaderZeroInitializeWorkgroupMemory(long struct, int value) { memPutInt(struct + VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.SHADERZEROINITIALIZEWORKGROUPMEMORY, value); }

    // -----------------------------------

    /** An array of {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures} structs. */
    public static class Buffer extends StructBuffer<VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures, Buffer> implements NativeResource {

        private static final VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures ELEMENT_FACTORY = VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.create(-1L);

        /**
         * Creates a new {@code VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer} instance backed by the specified container.
         *
         * <p>Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures#SIZEOF}, and its mark will be undefined.</p>
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
        protected VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@code sType} field. */
        @NativeType("VkStructureType")
        public int sType() { return VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.nsType(address()); }
        /** @return the value of the {@code pNext} field. */
        @NativeType("void *")
        public long pNext() { return VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.npNext(address()); }
        /** @return the value of the {@code shaderZeroInitializeWorkgroupMemory} field. */
        @NativeType("VkBool32")
        public boolean shaderZeroInitializeWorkgroupMemory() { return VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.nshaderZeroInitializeWorkgroupMemory(address()) != 0; }

        /** Sets the specified value to the {@code sType} field. */
        public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer sType(@NativeType("VkStructureType") int value) { VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.nsType(address(), value); return this; }
        /** Sets the {@link VK13#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_ZERO_INITIALIZE_WORKGROUP_MEMORY_FEATURES STRUCTURE_TYPE_PHYSICAL_DEVICE_ZERO_INITIALIZE_WORKGROUP_MEMORY_FEATURES} value to the {@code sType} field. */
        public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer sType$Default() { return sType(VK13.VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_ZERO_INITIALIZE_WORKGROUP_MEMORY_FEATURES); }
        /** Sets the specified value to the {@code pNext} field. */
        public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer pNext(@NativeType("void *") long value) { VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.npNext(address(), value); return this; }
        /** Sets the specified value to the {@code shaderZeroInitializeWorkgroupMemory} field. */
        public VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.Buffer shaderZeroInitializeWorkgroupMemory(@NativeType("VkBool32") boolean value) { VkPhysicalDeviceZeroInitializeWorkgroupMemoryFeatures.nshaderZeroInitializeWorkgroupMemory(address(), value ? 1 : 0); return this; }

    }

}