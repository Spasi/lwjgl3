/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.openvr;

import org.jspecify.annotations.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.system.*;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct InputBindingInfo_t {
 *     char rchDevicePathName[128];
 *     char rchInputPathName[128];
 *     char rchModeName[128];
 *     char rchSlotName[128];
 *     char rchInputSourceType[32];
 * }</code></pre>
 */
@NativeType("struct InputBindingInfo_t")
public class InputBindingInfo extends Struct<InputBindingInfo> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        RCHDEVICEPATHNAME,
        RCHINPUTPATHNAME,
        RCHMODENAME,
        RCHSLOTNAME,
        RCHINPUTSOURCETYPE;

    static {
        Layout layout = __struct(
            __array(1, 128),
            __array(1, 128),
            __array(1, 128),
            __array(1, 128),
            __array(1, 32)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        RCHDEVICEPATHNAME = layout.offsetof(0);
        RCHINPUTPATHNAME = layout.offsetof(1);
        RCHMODENAME = layout.offsetof(2);
        RCHSLOTNAME = layout.offsetof(3);
        RCHINPUTSOURCETYPE = layout.offsetof(4);
    }

    protected InputBindingInfo(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected InputBindingInfo create(long address, @Nullable ByteBuffer container) {
        return new InputBindingInfo(address, container);
    }

    /**
     * Creates a {@code InputBindingInfo} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public InputBindingInfo(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return a {@link ByteBuffer} view of the {@code rchDevicePathName} field. */
    @NativeType("char[128]")
    public ByteBuffer rchDevicePathName() { return nrchDevicePathName(address()); }
    /** @return the null-terminated string stored in the {@code rchDevicePathName} field. */
    @NativeType("char[128]")
    public String rchDevicePathNameString() { return nrchDevicePathNameString(address()); }
    /** @return a {@link ByteBuffer} view of the {@code rchInputPathName} field. */
    @NativeType("char[128]")
    public ByteBuffer rchInputPathName() { return nrchInputPathName(address()); }
    /** @return the null-terminated string stored in the {@code rchInputPathName} field. */
    @NativeType("char[128]")
    public String rchInputPathNameString() { return nrchInputPathNameString(address()); }
    /** @return a {@link ByteBuffer} view of the {@code rchModeName} field. */
    @NativeType("char[128]")
    public ByteBuffer rchModeName() { return nrchModeName(address()); }
    /** @return the null-terminated string stored in the {@code rchModeName} field. */
    @NativeType("char[128]")
    public String rchModeNameString() { return nrchModeNameString(address()); }
    /** @return a {@link ByteBuffer} view of the {@code rchSlotName} field. */
    @NativeType("char[128]")
    public ByteBuffer rchSlotName() { return nrchSlotName(address()); }
    /** @return the null-terminated string stored in the {@code rchSlotName} field. */
    @NativeType("char[128]")
    public String rchSlotNameString() { return nrchSlotNameString(address()); }
    /** @return a {@link ByteBuffer} view of the {@code rchInputSourceType} field. */
    @NativeType("char[32]")
    public ByteBuffer rchInputSourceType() { return nrchInputSourceType(address()); }
    /** @return the null-terminated string stored in the {@code rchInputSourceType} field. */
    @NativeType("char[32]")
    public String rchInputSourceTypeString() { return nrchInputSourceTypeString(address()); }

    // -----------------------------------

    /** Returns a new {@code InputBindingInfo} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static InputBindingInfo malloc() {
        return new InputBindingInfo(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code InputBindingInfo} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static InputBindingInfo calloc() {
        return new InputBindingInfo(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code InputBindingInfo} instance allocated with {@link BufferUtils}. */
    public static InputBindingInfo create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new InputBindingInfo(memAddress(container), container);
    }

    /** Returns a new {@code InputBindingInfo} instance for the specified memory address. */
    public static InputBindingInfo create(long address) {
        return new InputBindingInfo(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable InputBindingInfo createSafe(long address) {
        return address == NULL ? null : new InputBindingInfo(address, null);
    }

    /**
     * Returns a new {@link InputBindingInfo.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static InputBindingInfo.Buffer malloc(int capacity) {
        return new Buffer(nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link InputBindingInfo.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static InputBindingInfo.Buffer calloc(int capacity) {
        return new Buffer(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link InputBindingInfo.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static InputBindingInfo.Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return new Buffer(memAddress(container), container, -1, 0, capacity, capacity);
    }

    /**
     * Create a {@link InputBindingInfo.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static InputBindingInfo.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static InputBindingInfo.@Nullable Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    // -----------------------------------

    /** Deprecated for removal in 3.4.0. Use {@link #malloc(MemoryStack)} instead. */
    @Deprecated public static InputBindingInfo mallocStack() { return malloc(stackGet()); }
    /** Deprecated for removal in 3.4.0. Use {@link #calloc(MemoryStack)} instead. */
    @Deprecated public static InputBindingInfo callocStack() { return calloc(stackGet()); }
    /** Deprecated for removal in 3.4.0. Use {@link #malloc(MemoryStack)} instead. */
    @Deprecated public static InputBindingInfo mallocStack(MemoryStack stack) { return malloc(stack); }
    /** Deprecated for removal in 3.4.0. Use {@link #calloc(MemoryStack)} instead. */
    @Deprecated public static InputBindingInfo callocStack(MemoryStack stack) { return calloc(stack); }
    /** Deprecated for removal in 3.4.0. Use {@link #malloc(int, MemoryStack)} instead. */
    @Deprecated public static InputBindingInfo.Buffer mallocStack(int capacity) { return malloc(capacity, stackGet()); }
    /** Deprecated for removal in 3.4.0. Use {@link #calloc(int, MemoryStack)} instead. */
    @Deprecated public static InputBindingInfo.Buffer callocStack(int capacity) { return calloc(capacity, stackGet()); }
    /** Deprecated for removal in 3.4.0. Use {@link #malloc(int, MemoryStack)} instead. */
    @Deprecated public static InputBindingInfo.Buffer mallocStack(int capacity, MemoryStack stack) { return malloc(capacity, stack); }
    /** Deprecated for removal in 3.4.0. Use {@link #calloc(int, MemoryStack)} instead. */
    @Deprecated public static InputBindingInfo.Buffer callocStack(int capacity, MemoryStack stack) { return calloc(capacity, stack); }

    /**
     * Returns a new {@code InputBindingInfo} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static InputBindingInfo malloc(MemoryStack stack) {
        return new InputBindingInfo(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code InputBindingInfo} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static InputBindingInfo calloc(MemoryStack stack) {
        return new InputBindingInfo(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    /**
     * Returns a new {@link InputBindingInfo.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static InputBindingInfo.Buffer malloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link InputBindingInfo.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static InputBindingInfo.Buffer calloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #rchDevicePathName}. */
    public static ByteBuffer nrchDevicePathName(long struct) { return memByteBuffer(struct + InputBindingInfo.RCHDEVICEPATHNAME, 128); }
    /** Unsafe version of {@link #rchDevicePathNameString}. */
    public static String nrchDevicePathNameString(long struct) { return memASCII(struct + InputBindingInfo.RCHDEVICEPATHNAME); }
    /** Unsafe version of {@link #rchInputPathName}. */
    public static ByteBuffer nrchInputPathName(long struct) { return memByteBuffer(struct + InputBindingInfo.RCHINPUTPATHNAME, 128); }
    /** Unsafe version of {@link #rchInputPathNameString}. */
    public static String nrchInputPathNameString(long struct) { return memASCII(struct + InputBindingInfo.RCHINPUTPATHNAME); }
    /** Unsafe version of {@link #rchModeName}. */
    public static ByteBuffer nrchModeName(long struct) { return memByteBuffer(struct + InputBindingInfo.RCHMODENAME, 128); }
    /** Unsafe version of {@link #rchModeNameString}. */
    public static String nrchModeNameString(long struct) { return memASCII(struct + InputBindingInfo.RCHMODENAME); }
    /** Unsafe version of {@link #rchSlotName}. */
    public static ByteBuffer nrchSlotName(long struct) { return memByteBuffer(struct + InputBindingInfo.RCHSLOTNAME, 128); }
    /** Unsafe version of {@link #rchSlotNameString}. */
    public static String nrchSlotNameString(long struct) { return memASCII(struct + InputBindingInfo.RCHSLOTNAME); }
    /** Unsafe version of {@link #rchInputSourceType}. */
    public static ByteBuffer nrchInputSourceType(long struct) { return memByteBuffer(struct + InputBindingInfo.RCHINPUTSOURCETYPE, 32); }
    /** Unsafe version of {@link #rchInputSourceTypeString}. */
    public static String nrchInputSourceTypeString(long struct) { return memASCII(struct + InputBindingInfo.RCHINPUTSOURCETYPE); }

    // -----------------------------------

    /** An array of {@link InputBindingInfo} structs. */
    public static class Buffer extends StructBuffer<InputBindingInfo, Buffer> implements NativeResource {

        private static final InputBindingInfo ELEMENT_FACTORY = InputBindingInfo.create(-1L);

        /**
         * Creates a new {@code InputBindingInfo.Buffer} instance backed by the specified container.
         *
         * <p>Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link InputBindingInfo#SIZEOF}, and its mark will be undefined.</p>
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
        protected InputBindingInfo getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return a {@link ByteBuffer} view of the {@code rchDevicePathName} field. */
        @NativeType("char[128]")
        public ByteBuffer rchDevicePathName() { return InputBindingInfo.nrchDevicePathName(address()); }
        /** @return the null-terminated string stored in the {@code rchDevicePathName} field. */
        @NativeType("char[128]")
        public String rchDevicePathNameString() { return InputBindingInfo.nrchDevicePathNameString(address()); }
        /** @return a {@link ByteBuffer} view of the {@code rchInputPathName} field. */
        @NativeType("char[128]")
        public ByteBuffer rchInputPathName() { return InputBindingInfo.nrchInputPathName(address()); }
        /** @return the null-terminated string stored in the {@code rchInputPathName} field. */
        @NativeType("char[128]")
        public String rchInputPathNameString() { return InputBindingInfo.nrchInputPathNameString(address()); }
        /** @return a {@link ByteBuffer} view of the {@code rchModeName} field. */
        @NativeType("char[128]")
        public ByteBuffer rchModeName() { return InputBindingInfo.nrchModeName(address()); }
        /** @return the null-terminated string stored in the {@code rchModeName} field. */
        @NativeType("char[128]")
        public String rchModeNameString() { return InputBindingInfo.nrchModeNameString(address()); }
        /** @return a {@link ByteBuffer} view of the {@code rchSlotName} field. */
        @NativeType("char[128]")
        public ByteBuffer rchSlotName() { return InputBindingInfo.nrchSlotName(address()); }
        /** @return the null-terminated string stored in the {@code rchSlotName} field. */
        @NativeType("char[128]")
        public String rchSlotNameString() { return InputBindingInfo.nrchSlotNameString(address()); }
        /** @return a {@link ByteBuffer} view of the {@code rchInputSourceType} field. */
        @NativeType("char[32]")
        public ByteBuffer rchInputSourceType() { return InputBindingInfo.nrchInputSourceType(address()); }
        /** @return the null-terminated string stored in the {@code rchInputSourceType} field. */
        @NativeType("char[32]")
        public String rchInputSourceTypeString() { return InputBindingInfo.nrchInputSourceTypeString(address()); }

    }

}