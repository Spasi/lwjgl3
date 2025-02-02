/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.util.ktx;

import org.jspecify.annotations.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.system.*;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * <pre>{@code
 * struct ktxTexture1 {
 *     class_id classId;
 *     {@link ktxTexture_vtbl struct ktxTexture_vtbl} * vtbl;
 *     struct ktxTexture_vvtbl * vvtbl;
 *     struct ktxTexture_protected * _protected;
 *     ktx_bool_t isArray;
 *     ktx_bool_t isCubemap;
 *     ktx_bool_t isCompressed;
 *     ktx_bool_t generateMipmaps;
 *     ktx_uint32_t baseWidth;
 *     ktx_uint32_t baseHeight;
 *     ktx_uint32_t baseDepth;
 *     ktx_uint32_t numDimensions;
 *     ktx_uint32_t numLevels;
 *     ktx_uint32_t numLayers;
 *     ktx_uint32_t numFaces;
 *     {@link ktxOrientation struct ktxOrientation} orientation;
 *     ktxHashList kvDataHead;
 *     ktx_uint32_t kvDataLen;
 *     ktx_uint8_t * kvData;
 *     ktx_size_t dataSize;
 *     ktx_uint8_t * pData;
 *     ktx_uint32_t glFormat;
 *     ktx_uint32_t glInternalformat;
 *     ktx_uint32_t glBaseInternalformat;
 *     ktx_uint32_t glType;
 *     struct ktxTexture1_private * _private;
 * }}</pre>
 */
public class ktxTexture1 extends Struct<ktxTexture1> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        CLASSID,
        VTBL,
        VVTBL,
        _PROTECTED,
        ISARRAY,
        ISCUBEMAP,
        ISCOMPRESSED,
        GENERATEMIPMAPS,
        BASEWIDTH,
        BASEHEIGHT,
        BASEDEPTH,
        NUMDIMENSIONS,
        NUMLEVELS,
        NUMLAYERS,
        NUMFACES,
        ORIENTATION,
        KVDATAHEAD,
        KVDATALEN,
        KVDATA,
        DATASIZE,
        PDATA,
        GLFORMAT,
        GLINTERNALFORMAT,
        GLBASEINTERNALFORMAT,
        GLTYPE,
        _PRIVATE;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __member(POINTER_SIZE),
            __member(POINTER_SIZE),
            __member(1),
            __member(1),
            __member(1),
            __member(1),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(ktxOrientation.SIZEOF, ktxOrientation.ALIGNOF),
            __member(POINTER_SIZE),
            __member(4),
            __member(POINTER_SIZE),
            __member(POINTER_SIZE),
            __member(POINTER_SIZE),
            __member(4),
            __member(4),
            __member(4),
            __member(4),
            __member(POINTER_SIZE)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        CLASSID = layout.offsetof(0);
        VTBL = layout.offsetof(1);
        VVTBL = layout.offsetof(2);
        _PROTECTED = layout.offsetof(3);
        ISARRAY = layout.offsetof(4);
        ISCUBEMAP = layout.offsetof(5);
        ISCOMPRESSED = layout.offsetof(6);
        GENERATEMIPMAPS = layout.offsetof(7);
        BASEWIDTH = layout.offsetof(8);
        BASEHEIGHT = layout.offsetof(9);
        BASEDEPTH = layout.offsetof(10);
        NUMDIMENSIONS = layout.offsetof(11);
        NUMLEVELS = layout.offsetof(12);
        NUMLAYERS = layout.offsetof(13);
        NUMFACES = layout.offsetof(14);
        ORIENTATION = layout.offsetof(15);
        KVDATAHEAD = layout.offsetof(16);
        KVDATALEN = layout.offsetof(17);
        KVDATA = layout.offsetof(18);
        DATASIZE = layout.offsetof(19);
        PDATA = layout.offsetof(20);
        GLFORMAT = layout.offsetof(21);
        GLINTERNALFORMAT = layout.offsetof(22);
        GLBASEINTERNALFORMAT = layout.offsetof(23);
        GLTYPE = layout.offsetof(24);
        _PRIVATE = layout.offsetof(25);
    }

    protected ktxTexture1(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected ktxTexture1 create(long address, @Nullable ByteBuffer container) {
        return new ktxTexture1(address, container);
    }

    /**
     * Creates a {@code ktxTexture1} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public ktxTexture1(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code classId} field. */
    @NativeType("class_id")
    public int classId() { return nclassId(address()); }
    /** @return a {@link ktxTexture_vtbl} view of the struct pointed to by the {@code vtbl} field. */
    @NativeType("struct ktxTexture_vtbl *")
    public ktxTexture_vtbl vtbl() { return nvtbl(address()); }
    /** @return the value of the {@code vvtbl} field. */
    @NativeType("struct ktxTexture_vvtbl *")
    public long vvtbl() { return nvvtbl(address()); }
    /** @return a {@link PointerBuffer} view of the data pointed to by the {@code _protected} field. */
    @NativeType("struct ktxTexture_protected *")
    public PointerBuffer _protected(int capacity) { return n_protected(address(), capacity); }
    /** @return the value of the {@code isArray} field. */
    @NativeType("ktx_bool_t")
    public boolean isArray() { return nisArray(address()); }
    /** @return the value of the {@code isCubemap} field. */
    @NativeType("ktx_bool_t")
    public boolean isCubemap() { return nisCubemap(address()); }
    /** @return the value of the {@code isCompressed} field. */
    @NativeType("ktx_bool_t")
    public boolean isCompressed() { return nisCompressed(address()); }
    /** @return the value of the {@code generateMipmaps} field. */
    @NativeType("ktx_bool_t")
    public boolean generateMipmaps() { return ngenerateMipmaps(address()); }
    /** @return the value of the {@code baseWidth} field. */
    @NativeType("ktx_uint32_t")
    public int baseWidth() { return nbaseWidth(address()); }
    /** @return the value of the {@code baseHeight} field. */
    @NativeType("ktx_uint32_t")
    public int baseHeight() { return nbaseHeight(address()); }
    /** @return the value of the {@code baseDepth} field. */
    @NativeType("ktx_uint32_t")
    public int baseDepth() { return nbaseDepth(address()); }
    /** @return the value of the {@code numDimensions} field. */
    @NativeType("ktx_uint32_t")
    public int numDimensions() { return nnumDimensions(address()); }
    /** @return the value of the {@code numLevels} field. */
    @NativeType("ktx_uint32_t")
    public int numLevels() { return nnumLevels(address()); }
    /** @return the value of the {@code numLayers} field. */
    @NativeType("ktx_uint32_t")
    public int numLayers() { return nnumLayers(address()); }
    /** @return the value of the {@code numFaces} field. */
    @NativeType("ktx_uint32_t")
    public int numFaces() { return nnumFaces(address()); }
    /** @return a {@link ktxOrientation} view of the {@code orientation} field. */
    @NativeType("struct ktxOrientation")
    public ktxOrientation orientation() { return norientation(address()); }
    /** @return the value of the {@code kvDataHead} field. */
    @NativeType("ktxHashList")
    public long kvDataHead() { return nkvDataHead(address()); }
    /** @return the value of the {@code kvDataLen} field. */
    @NativeType("ktx_uint32_t")
    public int kvDataLen() { return nkvDataLen(address()); }
    /** @return a {@link ByteBuffer} view of the data pointed to by the {@code kvData} field. */
    @NativeType("ktx_uint8_t *")
    public @Nullable ByteBuffer kvData() { return nkvData(address()); }
    /** @return the value of the {@code dataSize} field. */
    @NativeType("ktx_size_t")
    public long dataSize() { return ndataSize(address()); }
    /** @return a {@link ByteBuffer} view of the data pointed to by the {@code pData} field. */
    @NativeType("ktx_uint8_t *")
    public ByteBuffer pData() { return npData(address()); }
    /** @return the value of the {@code glFormat} field. */
    @NativeType("ktx_uint32_t")
    public int glFormat() { return nglFormat(address()); }
    /** @return the value of the {@code glInternalformat} field. */
    @NativeType("ktx_uint32_t")
    public int glInternalformat() { return nglInternalformat(address()); }
    /** @return the value of the {@code glBaseInternalformat} field. */
    @NativeType("ktx_uint32_t")
    public int glBaseInternalformat() { return nglBaseInternalformat(address()); }
    /** @return the value of the {@code glType} field. */
    @NativeType("ktx_uint32_t")
    public int glType() { return nglType(address()); }

    // -----------------------------------

    /** Returns a new {@code ktxTexture1} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static ktxTexture1 malloc() {
        return new ktxTexture1(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code ktxTexture1} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static ktxTexture1 calloc() {
        return new ktxTexture1(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code ktxTexture1} instance allocated with {@link BufferUtils}. */
    public static ktxTexture1 create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new ktxTexture1(memAddress(container), container);
    }

    /** Returns a new {@code ktxTexture1} instance for the specified memory address. */
    public static ktxTexture1 create(long address) {
        return new ktxTexture1(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable ktxTexture1 createSafe(long address) {
        return address == NULL ? null : new ktxTexture1(address, null);
    }

    /**
     * Returns a new {@link ktxTexture1.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static ktxTexture1.Buffer malloc(int capacity) {
        return new Buffer(nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link ktxTexture1.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static ktxTexture1.Buffer calloc(int capacity) {
        return new Buffer(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link ktxTexture1.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static ktxTexture1.Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return new Buffer(memAddress(container), container, -1, 0, capacity, capacity);
    }

    /**
     * Create a {@link ktxTexture1.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static ktxTexture1.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static ktxTexture1.@Nullable Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    /**
     * Returns a new {@code ktxTexture1} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static ktxTexture1 malloc(MemoryStack stack) {
        return new ktxTexture1(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code ktxTexture1} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static ktxTexture1 calloc(MemoryStack stack) {
        return new ktxTexture1(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    /**
     * Returns a new {@link ktxTexture1.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static ktxTexture1.Buffer malloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link ktxTexture1.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static ktxTexture1.Buffer calloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #classId}. */
    public static int nclassId(long struct) { return memGetInt(struct + ktxTexture1.CLASSID); }
    /** Unsafe version of {@link #vtbl}. */
    public static ktxTexture_vtbl nvtbl(long struct) { return ktxTexture_vtbl.create(memGetAddress(struct + ktxTexture1.VTBL)); }
    /** Unsafe version of {@link #vvtbl}. */
    public static long nvvtbl(long struct) { return memGetAddress(struct + ktxTexture1.VVTBL); }
    /** Unsafe version of {@link #_protected(int) _protected}. */
    public static PointerBuffer n_protected(long struct, int capacity) { return memPointerBuffer(memGetAddress(struct + ktxTexture1._PROTECTED), capacity); }
    /** Unsafe version of {@link #isArray}. */
    public static boolean nisArray(long struct) { return memGetByte(struct + ktxTexture1.ISARRAY) != 0; }
    /** Unsafe version of {@link #isCubemap}. */
    public static boolean nisCubemap(long struct) { return memGetByte(struct + ktxTexture1.ISCUBEMAP) != 0; }
    /** Unsafe version of {@link #isCompressed}. */
    public static boolean nisCompressed(long struct) { return memGetByte(struct + ktxTexture1.ISCOMPRESSED) != 0; }
    /** Unsafe version of {@link #generateMipmaps}. */
    public static boolean ngenerateMipmaps(long struct) { return memGetByte(struct + ktxTexture1.GENERATEMIPMAPS) != 0; }
    /** Unsafe version of {@link #baseWidth}. */
    public static int nbaseWidth(long struct) { return memGetInt(struct + ktxTexture1.BASEWIDTH); }
    /** Unsafe version of {@link #baseHeight}. */
    public static int nbaseHeight(long struct) { return memGetInt(struct + ktxTexture1.BASEHEIGHT); }
    /** Unsafe version of {@link #baseDepth}. */
    public static int nbaseDepth(long struct) { return memGetInt(struct + ktxTexture1.BASEDEPTH); }
    /** Unsafe version of {@link #numDimensions}. */
    public static int nnumDimensions(long struct) { return memGetInt(struct + ktxTexture1.NUMDIMENSIONS); }
    /** Unsafe version of {@link #numLevels}. */
    public static int nnumLevels(long struct) { return memGetInt(struct + ktxTexture1.NUMLEVELS); }
    /** Unsafe version of {@link #numLayers}. */
    public static int nnumLayers(long struct) { return memGetInt(struct + ktxTexture1.NUMLAYERS); }
    /** Unsafe version of {@link #numFaces}. */
    public static int nnumFaces(long struct) { return memGetInt(struct + ktxTexture1.NUMFACES); }
    /** Unsafe version of {@link #orientation}. */
    public static ktxOrientation norientation(long struct) { return ktxOrientation.create(struct + ktxTexture1.ORIENTATION); }
    /** Unsafe version of {@link #kvDataHead}. */
    public static long nkvDataHead(long struct) { return memGetAddress(struct + ktxTexture1.KVDATAHEAD); }
    /** Unsafe version of {@link #kvDataLen}. */
    public static int nkvDataLen(long struct) { return memGetInt(struct + ktxTexture1.KVDATALEN); }
    /** Unsafe version of {@link #kvData() kvData}. */
    public static @Nullable ByteBuffer nkvData(long struct) { return memByteBufferSafe(memGetAddress(struct + ktxTexture1.KVDATA), nkvDataLen(struct)); }
    /** Unsafe version of {@link #dataSize}. */
    public static long ndataSize(long struct) { return memGetAddress(struct + ktxTexture1.DATASIZE); }
    /** Unsafe version of {@link #pData() pData}. */
    public static ByteBuffer npData(long struct) { return memByteBuffer(memGetAddress(struct + ktxTexture1.PDATA), (int)ndataSize(struct)); }
    /** Unsafe version of {@link #glFormat}. */
    public static int nglFormat(long struct) { return memGetInt(struct + ktxTexture1.GLFORMAT); }
    /** Unsafe version of {@link #glInternalformat}. */
    public static int nglInternalformat(long struct) { return memGetInt(struct + ktxTexture1.GLINTERNALFORMAT); }
    /** Unsafe version of {@link #glBaseInternalformat}. */
    public static int nglBaseInternalformat(long struct) { return memGetInt(struct + ktxTexture1.GLBASEINTERNALFORMAT); }
    /** Unsafe version of {@link #glType}. */
    public static int nglType(long struct) { return memGetInt(struct + ktxTexture1.GLTYPE); }
    public static PointerBuffer n_private(long struct, int capacity) { return memPointerBuffer(memGetAddress(struct + ktxTexture1._PRIVATE), capacity); }

    // -----------------------------------

    /** An array of {@link ktxTexture1} structs. */
    public static class Buffer extends StructBuffer<ktxTexture1, Buffer> implements NativeResource {

        private static final ktxTexture1 ELEMENT_FACTORY = ktxTexture1.create(-1L);

        /**
         * Creates a new {@code ktxTexture1.Buffer} instance backed by the specified container.
         *
         * <p>Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link ktxTexture1#SIZEOF}, and its mark will be undefined.</p>
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
        protected ktxTexture1 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@code classId} field. */
        @NativeType("class_id")
        public int classId() { return ktxTexture1.nclassId(address()); }
        /** @return a {@link ktxTexture_vtbl} view of the struct pointed to by the {@code vtbl} field. */
        @NativeType("struct ktxTexture_vtbl *")
        public ktxTexture_vtbl vtbl() { return ktxTexture1.nvtbl(address()); }
        /** @return the value of the {@code vvtbl} field. */
        @NativeType("struct ktxTexture_vvtbl *")
        public long vvtbl() { return ktxTexture1.nvvtbl(address()); }
        /** @return a {@link PointerBuffer} view of the data pointed to by the {@code _protected} field. */
        @NativeType("struct ktxTexture_protected *")
        public PointerBuffer _protected(int capacity) { return ktxTexture1.n_protected(address(), capacity); }
        /** @return the value of the {@code isArray} field. */
        @NativeType("ktx_bool_t")
        public boolean isArray() { return ktxTexture1.nisArray(address()); }
        /** @return the value of the {@code isCubemap} field. */
        @NativeType("ktx_bool_t")
        public boolean isCubemap() { return ktxTexture1.nisCubemap(address()); }
        /** @return the value of the {@code isCompressed} field. */
        @NativeType("ktx_bool_t")
        public boolean isCompressed() { return ktxTexture1.nisCompressed(address()); }
        /** @return the value of the {@code generateMipmaps} field. */
        @NativeType("ktx_bool_t")
        public boolean generateMipmaps() { return ktxTexture1.ngenerateMipmaps(address()); }
        /** @return the value of the {@code baseWidth} field. */
        @NativeType("ktx_uint32_t")
        public int baseWidth() { return ktxTexture1.nbaseWidth(address()); }
        /** @return the value of the {@code baseHeight} field. */
        @NativeType("ktx_uint32_t")
        public int baseHeight() { return ktxTexture1.nbaseHeight(address()); }
        /** @return the value of the {@code baseDepth} field. */
        @NativeType("ktx_uint32_t")
        public int baseDepth() { return ktxTexture1.nbaseDepth(address()); }
        /** @return the value of the {@code numDimensions} field. */
        @NativeType("ktx_uint32_t")
        public int numDimensions() { return ktxTexture1.nnumDimensions(address()); }
        /** @return the value of the {@code numLevels} field. */
        @NativeType("ktx_uint32_t")
        public int numLevels() { return ktxTexture1.nnumLevels(address()); }
        /** @return the value of the {@code numLayers} field. */
        @NativeType("ktx_uint32_t")
        public int numLayers() { return ktxTexture1.nnumLayers(address()); }
        /** @return the value of the {@code numFaces} field. */
        @NativeType("ktx_uint32_t")
        public int numFaces() { return ktxTexture1.nnumFaces(address()); }
        /** @return a {@link ktxOrientation} view of the {@code orientation} field. */
        @NativeType("struct ktxOrientation")
        public ktxOrientation orientation() { return ktxTexture1.norientation(address()); }
        /** @return the value of the {@code kvDataHead} field. */
        @NativeType("ktxHashList")
        public long kvDataHead() { return ktxTexture1.nkvDataHead(address()); }
        /** @return the value of the {@code kvDataLen} field. */
        @NativeType("ktx_uint32_t")
        public int kvDataLen() { return ktxTexture1.nkvDataLen(address()); }
        /** @return a {@link ByteBuffer} view of the data pointed to by the {@code kvData} field. */
        @NativeType("ktx_uint8_t *")
        public @Nullable ByteBuffer kvData() { return ktxTexture1.nkvData(address()); }
        /** @return the value of the {@code dataSize} field. */
        @NativeType("ktx_size_t")
        public long dataSize() { return ktxTexture1.ndataSize(address()); }
        /** @return a {@link ByteBuffer} view of the data pointed to by the {@code pData} field. */
        @NativeType("ktx_uint8_t *")
        public ByteBuffer pData() { return ktxTexture1.npData(address()); }
        /** @return the value of the {@code glFormat} field. */
        @NativeType("ktx_uint32_t")
        public int glFormat() { return ktxTexture1.nglFormat(address()); }
        /** @return the value of the {@code glInternalformat} field. */
        @NativeType("ktx_uint32_t")
        public int glInternalformat() { return ktxTexture1.nglInternalformat(address()); }
        /** @return the value of the {@code glBaseInternalformat} field. */
        @NativeType("ktx_uint32_t")
        public int glBaseInternalformat() { return ktxTexture1.nglBaseInternalformat(address()); }
        /** @return the value of the {@code glType} field. */
        @NativeType("ktx_uint32_t")
        public int glType() { return ktxTexture1.nglType(address()); }

    }

}