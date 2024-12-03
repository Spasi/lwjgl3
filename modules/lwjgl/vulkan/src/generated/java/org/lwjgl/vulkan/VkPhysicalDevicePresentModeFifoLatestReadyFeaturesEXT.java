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
 * Structure describing support for VK_PRESENT_MODE_FIFO_LATEST_READY_EXT.
 * 
 * <h5>Description</h5>
 * 
 * <p>If the {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} structure is included in the {@code pNext} chain of the {@link VkPhysicalDeviceFeatures2} structure passed to {@link VK11#vkGetPhysicalDeviceFeatures2 GetPhysicalDeviceFeatures2}, it is filled in to indicate whether each corresponding feature is supported. {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} <b>can</b> also be used in the {@code pNext} chain of {@link VkDeviceCreateInfo} to selectively enable these features.</p>
 * 
 * <h5>Valid Usage (Implicit)</h5>
 * 
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link EXTPresentModeFifoLatestReady#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_MODE_FIFO_LATEST_READY_FEATURES_EXT STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_MODE_FIFO_LATEST_READY_FEATURES_EXT}</li>
 * </ul>
 * 
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT {
 *     VkStructureType {@link #sType};
 *     void * {@link #pNext};
 *     VkBool32 {@link #presentModeFifoLatestReady};
 * }</code></pre>
 */
public class VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT extends Struct<VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        STYPE,
        PNEXT,
        PRESENTMODEFIFOLATESTREADY;

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
        PRESENTMODEFIFOLATESTREADY = layout.offsetof(2);
    }

    protected VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT create(long address, @Nullable ByteBuffer container) {
        return new VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(address, container);
    }

    /**
     * Creates a {@code VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** a {@code VkStructureType} value identifying this structure. */
    @NativeType("VkStructureType")
    public int sType() { return nsType(address()); }
    /** {@code NULL} or a pointer to a structure extending this structure. */
    @NativeType("void *")
    public long pNext() { return npNext(address()); }
    /** specifies whether the implementation supports the {@link EXTPresentModeFifoLatestReady#VK_PRESENT_MODE_FIFO_LATEST_READY_EXT PRESENT_MODE_FIFO_LATEST_READY_EXT} present mode. */
    @NativeType("VkBool32")
    public boolean presentModeFifoLatestReady() { return npresentModeFifoLatestReady(address()) != 0; }

    /** Sets the specified value to the {@link #sType} field. */
    public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT sType(@NativeType("VkStructureType") int value) { nsType(address(), value); return this; }
    /** Sets the {@link EXTPresentModeFifoLatestReady#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_MODE_FIFO_LATEST_READY_FEATURES_EXT STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_MODE_FIFO_LATEST_READY_FEATURES_EXT} value to the {@link #sType} field. */
    public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT sType$Default() { return sType(EXTPresentModeFifoLatestReady.VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_MODE_FIFO_LATEST_READY_FEATURES_EXT); }
    /** Sets the specified value to the {@link #pNext} field. */
    public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT pNext(@NativeType("void *") long value) { npNext(address(), value); return this; }
    /** Sets the specified value to the {@link #presentModeFifoLatestReady} field. */
    public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT presentModeFifoLatestReady(@NativeType("VkBool32") boolean value) { npresentModeFifoLatestReady(address(), value ? 1 : 0); return this; }

    /** Initializes this struct with the specified values. */
    public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT set(
        int sType,
        long pNext,
        boolean presentModeFifoLatestReady
    ) {
        sType(sType);
        pNext(pNext);
        presentModeFifoLatestReady(presentModeFifoLatestReady);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT set(VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT malloc() {
        return new VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT calloc() {
        return new VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} instance allocated with {@link BufferUtils}. */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(memAddress(container), container);
    }

    /** Returns a new {@code VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} instance for the specified memory address. */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT create(long address) {
        return new VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT createSafe(long address) {
        return address == NULL ? null : new VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(address, null);
    }

    /**
     * Returns a new {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer malloc(int capacity) {
        return new Buffer(nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer calloc(int capacity) {
        return new Buffer(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return new Buffer(memAddress(container), container, -1, 0, capacity, capacity);
    }

    /**
     * Create a {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.@Nullable Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    /**
     * Returns a new {@code VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT malloc(MemoryStack stack) {
        return new VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT calloc(MemoryStack stack) {
        return new VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    /**
     * Returns a new {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer malloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer calloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #sType}. */
    public static int nsType(long struct) { return memGetInt(struct + VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.STYPE); }
    /** Unsafe version of {@link #pNext}. */
    public static long npNext(long struct) { return memGetAddress(struct + VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.PNEXT); }
    /** Unsafe version of {@link #presentModeFifoLatestReady}. */
    public static int npresentModeFifoLatestReady(long struct) { return memGetInt(struct + VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.PRESENTMODEFIFOLATESTREADY); }

    /** Unsafe version of {@link #sType(int) sType}. */
    public static void nsType(long struct, int value) { memPutInt(struct + VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.STYPE, value); }
    /** Unsafe version of {@link #pNext(long) pNext}. */
    public static void npNext(long struct, long value) { memPutAddress(struct + VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.PNEXT, value); }
    /** Unsafe version of {@link #presentModeFifoLatestReady(boolean) presentModeFifoLatestReady}. */
    public static void npresentModeFifoLatestReady(long struct, int value) { memPutInt(struct + VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.PRESENTMODEFIFOLATESTREADY, value); }

    // -----------------------------------

    /** An array of {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT} structs. */
    public static class Buffer extends StructBuffer<VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT, Buffer> implements NativeResource {

        private static final VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT ELEMENT_FACTORY = VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.create(-1L);

        /**
         * Creates a new {@code VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer} instance backed by the specified container.
         *
         * <p>Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT#SIZEOF}, and its mark will be undefined.</p>
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
        protected VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT#sType} field. */
        @NativeType("VkStructureType")
        public int sType() { return VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.nsType(address()); }
        /** @return the value of the {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT#pNext} field. */
        @NativeType("void *")
        public long pNext() { return VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.npNext(address()); }
        /** @return the value of the {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT#presentModeFifoLatestReady} field. */
        @NativeType("VkBool32")
        public boolean presentModeFifoLatestReady() { return VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.npresentModeFifoLatestReady(address()) != 0; }

        /** Sets the specified value to the {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT#sType} field. */
        public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer sType(@NativeType("VkStructureType") int value) { VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.nsType(address(), value); return this; }
        /** Sets the {@link EXTPresentModeFifoLatestReady#VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_MODE_FIFO_LATEST_READY_FEATURES_EXT STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_MODE_FIFO_LATEST_READY_FEATURES_EXT} value to the {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT#sType} field. */
        public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer sType$Default() { return sType(EXTPresentModeFifoLatestReady.VK_STRUCTURE_TYPE_PHYSICAL_DEVICE_PRESENT_MODE_FIFO_LATEST_READY_FEATURES_EXT); }
        /** Sets the specified value to the {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT#pNext} field. */
        public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer pNext(@NativeType("void *") long value) { VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.npNext(address(), value); return this; }
        /** Sets the specified value to the {@link VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT#presentModeFifoLatestReady} field. */
        public VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.Buffer presentModeFifoLatestReady(@NativeType("VkBool32") boolean value) { VkPhysicalDevicePresentModeFifoLatestReadyFeaturesEXT.npresentModeFifoLatestReady(address(), value ? 1 : 0); return this; }

    }

}