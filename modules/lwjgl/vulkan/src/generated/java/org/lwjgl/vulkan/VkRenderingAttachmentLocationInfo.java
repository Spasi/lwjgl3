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
 * Structure specifying attachment locations.
 * 
 * <h5>Description</h5>
 * 
 * <p>This structure allows applications to remap the locations of color attachments to different fragment shader output locations.</p>
 * 
 * <p>Each element of {@code pColorAttachmentLocations} set to {@link VK10#VK_ATTACHMENT_UNUSED ATTACHMENT_UNUSED} will be inaccessible to this pipeline as a color attachment; no location will map to it. Each element of {@code pColorAttachmentLocations} set to any other value will map the specified location value to the color attachment specified in the render pass at the corresponding index in the {@code pColorAttachmentLocations} array. Any writes to a fragment output location that is not mapped to an attachment <b>must</b> be discarded.</p>
 * 
 * <p>If {@code pColorAttachmentLocations} is {@code NULL}, it is equivalent to setting each element to its index within the array.</p>
 * 
 * <p>This structure <b>can</b> be included in the {@code pNext} chain of a {@link VkGraphicsPipelineCreateInfo} structure to set this state for a pipeline. If this structure is not included in the {@code pNext} chain of {@link VkGraphicsPipelineCreateInfo}, it is equivalent to specifying this structure with the following properties:</p>
 * 
 * <ul>
 * <li>{@code colorAttachmentCount} set to {@link VkPipelineRenderingCreateInfo}{@code ::colorAttachmentCount}.</li>
 * <li>{@code pColorAttachmentLocations} set to {@code NULL}.</li>
 * </ul>
 * 
 * <p>This structure <b>can</b> be included in the {@code pNext} chain of a {@link VkCommandBufferInheritanceInfo} structure to specify inherited state from the primary command buffer. If {@link VkCommandBufferInheritanceInfo}::renderPass is not {@link VK10#VK_NULL_HANDLE NULL_HANDLE}, or {@link VK10#VK_COMMAND_BUFFER_USAGE_RENDER_PASS_CONTINUE_BIT COMMAND_BUFFER_USAGE_RENDER_PASS_CONTINUE_BIT} is not specified in {@link VkCommandBufferBeginInfo}::flags, members of this structure are ignored. If this structure is not included in the {@code pNext} chain of {@link VkCommandBufferInheritanceInfo}, it is equivalent to specifying this structure with the following properties:</p>
 * 
 * <ul>
 * <li>{@code colorAttachmentCount} set to {@link VkCommandBufferInheritanceRenderingInfo}{@code ::colorAttachmentCount}.</li>
 * <li>{@code pColorAttachmentLocations} set to {@code NULL}.</li>
 * </ul>
 * 
 * <h5>Valid Usage</h5>
 * 
 * <ul>
 * <li>If the <a href="https://registry.khronos.org/vulkan/specs/latest/html/vkspec.html#features-dynamicRenderingLocalRead">{@code dynamicRenderingLocalRead}</a> feature is not enabled, and {@code pColorAttachmentLocations} is not {@code NULL}, each element <b>must</b> be the value of its index within the array</li>
 * <li>Elements of {@code pColorAttachmentLocations} that are not {@link VK10#VK_ATTACHMENT_UNUSED ATTACHMENT_UNUSED} <b>must</b> each be unique</li>
 * <li>{@code colorAttachmentCount} <b>must</b> be less than or equal to <a href="https://registry.khronos.org/vulkan/specs/latest/html/vkspec.html#limits-maxColorAttachments">{@code maxColorAttachments}</a></li>
 * <li>Each element of {@code pColorAttachmentLocations} <b>must</b> be less than <a href="https://registry.khronos.org/vulkan/specs/latest/html/vkspec.html#limits-maxColorAttachments">{@code maxColorAttachments}</a></li>
 * </ul>
 * 
 * <h5>Valid Usage (Implicit)</h5>
 * 
 * <ul>
 * <li>{@code sType} <b>must</b> be {@link VK14#VK_STRUCTURE_TYPE_RENDERING_ATTACHMENT_LOCATION_INFO STRUCTURE_TYPE_RENDERING_ATTACHMENT_LOCATION_INFO}</li>
 * </ul>
 * 
 * <h5>See Also</h5>
 * 
 * <p>{@link VK14#vkCmdSetRenderingAttachmentLocations CmdSetRenderingAttachmentLocations}, {@link KHRDynamicRenderingLocalRead#vkCmdSetRenderingAttachmentLocationsKHR CmdSetRenderingAttachmentLocationsKHR}</p>
 * 
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct VkRenderingAttachmentLocationInfo {
 *     VkStructureType {@link #sType};
 *     void const * {@link #pNext};
 *     uint32_t {@link #colorAttachmentCount};
 *     uint32_t const * {@link #pColorAttachmentLocations};
 * }</code></pre>
 */
public class VkRenderingAttachmentLocationInfo extends Struct<VkRenderingAttachmentLocationInfo> implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        STYPE,
        PNEXT,
        COLORATTACHMENTCOUNT,
        PCOLORATTACHMENTLOCATIONS;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __member(4),
            __member(POINTER_SIZE)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        STYPE = layout.offsetof(0);
        PNEXT = layout.offsetof(1);
        COLORATTACHMENTCOUNT = layout.offsetof(2);
        PCOLORATTACHMENTLOCATIONS = layout.offsetof(3);
    }

    protected VkRenderingAttachmentLocationInfo(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected VkRenderingAttachmentLocationInfo create(long address, @Nullable ByteBuffer container) {
        return new VkRenderingAttachmentLocationInfo(address, container);
    }

    /**
     * Creates a {@code VkRenderingAttachmentLocationInfo} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public VkRenderingAttachmentLocationInfo(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** a {@code VkStructureType} value identifying this structure. */
    @NativeType("VkStructureType")
    public int sType() { return nsType(address()); }
    /** {@code NULL} or a pointer to a structure extending this structure. */
    @NativeType("void const *")
    public long pNext() { return npNext(address()); }
    /** the number of elements in {@code pColorAttachmentLocations}. */
    @NativeType("uint32_t")
    public int colorAttachmentCount() { return ncolorAttachmentCount(address()); }
    /** a pointer to an array of {@code colorAttachmentCount} {@code uint32_t} values defining remapped locations for color attachments. */
    @NativeType("uint32_t const *")
    public @Nullable IntBuffer pColorAttachmentLocations() { return npColorAttachmentLocations(address()); }

    /** Sets the specified value to the {@link #sType} field. */
    public VkRenderingAttachmentLocationInfo sType(@NativeType("VkStructureType") int value) { nsType(address(), value); return this; }
    /** Sets the {@link VK14#VK_STRUCTURE_TYPE_RENDERING_ATTACHMENT_LOCATION_INFO STRUCTURE_TYPE_RENDERING_ATTACHMENT_LOCATION_INFO} value to the {@link #sType} field. */
    public VkRenderingAttachmentLocationInfo sType$Default() { return sType(VK14.VK_STRUCTURE_TYPE_RENDERING_ATTACHMENT_LOCATION_INFO); }
    /** Sets the specified value to the {@link #pNext} field. */
    public VkRenderingAttachmentLocationInfo pNext(@NativeType("void const *") long value) { npNext(address(), value); return this; }
    /** Sets the specified value to the {@link #colorAttachmentCount} field. */
    public VkRenderingAttachmentLocationInfo colorAttachmentCount(@NativeType("uint32_t") int value) { ncolorAttachmentCount(address(), value); return this; }
    /** Sets the address of the specified {@link IntBuffer} to the {@link #pColorAttachmentLocations} field. */
    public VkRenderingAttachmentLocationInfo pColorAttachmentLocations(@Nullable @NativeType("uint32_t const *") IntBuffer value) { npColorAttachmentLocations(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public VkRenderingAttachmentLocationInfo set(
        int sType,
        long pNext,
        int colorAttachmentCount,
        @Nullable IntBuffer pColorAttachmentLocations
    ) {
        sType(sType);
        pNext(pNext);
        colorAttachmentCount(colorAttachmentCount);
        pColorAttachmentLocations(pColorAttachmentLocations);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public VkRenderingAttachmentLocationInfo set(VkRenderingAttachmentLocationInfo src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code VkRenderingAttachmentLocationInfo} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static VkRenderingAttachmentLocationInfo malloc() {
        return new VkRenderingAttachmentLocationInfo(nmemAllocChecked(SIZEOF), null);
    }

    /** Returns a new {@code VkRenderingAttachmentLocationInfo} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static VkRenderingAttachmentLocationInfo calloc() {
        return new VkRenderingAttachmentLocationInfo(nmemCallocChecked(1, SIZEOF), null);
    }

    /** Returns a new {@code VkRenderingAttachmentLocationInfo} instance allocated with {@link BufferUtils}. */
    public static VkRenderingAttachmentLocationInfo create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return new VkRenderingAttachmentLocationInfo(memAddress(container), container);
    }

    /** Returns a new {@code VkRenderingAttachmentLocationInfo} instance for the specified memory address. */
    public static VkRenderingAttachmentLocationInfo create(long address) {
        return new VkRenderingAttachmentLocationInfo(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable VkRenderingAttachmentLocationInfo createSafe(long address) {
        return address == NULL ? null : new VkRenderingAttachmentLocationInfo(address, null);
    }

    /**
     * Returns a new {@link VkRenderingAttachmentLocationInfo.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkRenderingAttachmentLocationInfo.Buffer malloc(int capacity) {
        return new Buffer(nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link VkRenderingAttachmentLocationInfo.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static VkRenderingAttachmentLocationInfo.Buffer calloc(int capacity) {
        return new Buffer(nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkRenderingAttachmentLocationInfo.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static VkRenderingAttachmentLocationInfo.Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return new Buffer(memAddress(container), container, -1, 0, capacity, capacity);
    }

    /**
     * Create a {@link VkRenderingAttachmentLocationInfo.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static VkRenderingAttachmentLocationInfo.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static VkRenderingAttachmentLocationInfo.@Nullable Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    /**
     * Returns a new {@code VkRenderingAttachmentLocationInfo} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static VkRenderingAttachmentLocationInfo malloc(MemoryStack stack) {
        return new VkRenderingAttachmentLocationInfo(stack.nmalloc(ALIGNOF, SIZEOF), null);
    }

    /**
     * Returns a new {@code VkRenderingAttachmentLocationInfo} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static VkRenderingAttachmentLocationInfo calloc(MemoryStack stack) {
        return new VkRenderingAttachmentLocationInfo(stack.ncalloc(ALIGNOF, 1, SIZEOF), null);
    }

    /**
     * Returns a new {@link VkRenderingAttachmentLocationInfo.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkRenderingAttachmentLocationInfo.Buffer malloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link VkRenderingAttachmentLocationInfo.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static VkRenderingAttachmentLocationInfo.Buffer calloc(int capacity, MemoryStack stack) {
        return new Buffer(stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #sType}. */
    public static int nsType(long struct) { return memGetInt(struct + VkRenderingAttachmentLocationInfo.STYPE); }
    /** Unsafe version of {@link #pNext}. */
    public static long npNext(long struct) { return memGetAddress(struct + VkRenderingAttachmentLocationInfo.PNEXT); }
    /** Unsafe version of {@link #colorAttachmentCount}. */
    public static int ncolorAttachmentCount(long struct) { return memGetInt(struct + VkRenderingAttachmentLocationInfo.COLORATTACHMENTCOUNT); }
    /** Unsafe version of {@link #pColorAttachmentLocations() pColorAttachmentLocations}. */
    public static @Nullable IntBuffer npColorAttachmentLocations(long struct) { return memIntBufferSafe(memGetAddress(struct + VkRenderingAttachmentLocationInfo.PCOLORATTACHMENTLOCATIONS), ncolorAttachmentCount(struct)); }

    /** Unsafe version of {@link #sType(int) sType}. */
    public static void nsType(long struct, int value) { memPutInt(struct + VkRenderingAttachmentLocationInfo.STYPE, value); }
    /** Unsafe version of {@link #pNext(long) pNext}. */
    public static void npNext(long struct, long value) { memPutAddress(struct + VkRenderingAttachmentLocationInfo.PNEXT, value); }
    /** Sets the specified value to the {@code colorAttachmentCount} field of the specified {@code struct}. */
    public static void ncolorAttachmentCount(long struct, int value) { memPutInt(struct + VkRenderingAttachmentLocationInfo.COLORATTACHMENTCOUNT, value); }
    /** Unsafe version of {@link #pColorAttachmentLocations(IntBuffer) pColorAttachmentLocations}. */
    public static void npColorAttachmentLocations(long struct, @Nullable IntBuffer value) { memPutAddress(struct + VkRenderingAttachmentLocationInfo.PCOLORATTACHMENTLOCATIONS, memAddressSafe(value)); if (value != null) { ncolorAttachmentCount(struct, value.remaining()); } }

    // -----------------------------------

    /** An array of {@link VkRenderingAttachmentLocationInfo} structs. */
    public static class Buffer extends StructBuffer<VkRenderingAttachmentLocationInfo, Buffer> implements NativeResource {

        private static final VkRenderingAttachmentLocationInfo ELEMENT_FACTORY = VkRenderingAttachmentLocationInfo.create(-1L);

        /**
         * Creates a new {@code VkRenderingAttachmentLocationInfo.Buffer} instance backed by the specified container.
         *
         * <p>Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link VkRenderingAttachmentLocationInfo#SIZEOF}, and its mark will be undefined.</p>
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
        protected VkRenderingAttachmentLocationInfo getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@link VkRenderingAttachmentLocationInfo#sType} field. */
        @NativeType("VkStructureType")
        public int sType() { return VkRenderingAttachmentLocationInfo.nsType(address()); }
        /** @return the value of the {@link VkRenderingAttachmentLocationInfo#pNext} field. */
        @NativeType("void const *")
        public long pNext() { return VkRenderingAttachmentLocationInfo.npNext(address()); }
        /** @return the value of the {@link VkRenderingAttachmentLocationInfo#colorAttachmentCount} field. */
        @NativeType("uint32_t")
        public int colorAttachmentCount() { return VkRenderingAttachmentLocationInfo.ncolorAttachmentCount(address()); }
        /** @return a {@link IntBuffer} view of the data pointed to by the {@link VkRenderingAttachmentLocationInfo#pColorAttachmentLocations} field. */
        @NativeType("uint32_t const *")
        public @Nullable IntBuffer pColorAttachmentLocations() { return VkRenderingAttachmentLocationInfo.npColorAttachmentLocations(address()); }

        /** Sets the specified value to the {@link VkRenderingAttachmentLocationInfo#sType} field. */
        public VkRenderingAttachmentLocationInfo.Buffer sType(@NativeType("VkStructureType") int value) { VkRenderingAttachmentLocationInfo.nsType(address(), value); return this; }
        /** Sets the {@link VK14#VK_STRUCTURE_TYPE_RENDERING_ATTACHMENT_LOCATION_INFO STRUCTURE_TYPE_RENDERING_ATTACHMENT_LOCATION_INFO} value to the {@link VkRenderingAttachmentLocationInfo#sType} field. */
        public VkRenderingAttachmentLocationInfo.Buffer sType$Default() { return sType(VK14.VK_STRUCTURE_TYPE_RENDERING_ATTACHMENT_LOCATION_INFO); }
        /** Sets the specified value to the {@link VkRenderingAttachmentLocationInfo#pNext} field. */
        public VkRenderingAttachmentLocationInfo.Buffer pNext(@NativeType("void const *") long value) { VkRenderingAttachmentLocationInfo.npNext(address(), value); return this; }
        /** Sets the specified value to the {@link VkRenderingAttachmentLocationInfo#colorAttachmentCount} field. */
        public VkRenderingAttachmentLocationInfo.Buffer colorAttachmentCount(@NativeType("uint32_t") int value) { VkRenderingAttachmentLocationInfo.ncolorAttachmentCount(address(), value); return this; }
        /** Sets the address of the specified {@link IntBuffer} to the {@link VkRenderingAttachmentLocationInfo#pColorAttachmentLocations} field. */
        public VkRenderingAttachmentLocationInfo.Buffer pColorAttachmentLocations(@Nullable @NativeType("uint32_t const *") IntBuffer value) { VkRenderingAttachmentLocationInfo.npColorAttachmentLocations(address(), value); return this; }

    }

}