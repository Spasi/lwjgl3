/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.nuklear;

import org.jspecify.annotations.*;

import java.nio.*;

import org.lwjgl.system.*;

import static org.lwjgl.system.Checks.*;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * <pre>{@code
 * struct nk_config_stack_vec2 {
 *     int head;
 *     {@link NkConfigStackVec2Element struct nk_config_stack_vec2_element} elements[16];
 * }}</pre>
 */
@NativeType("struct nk_config_stack_vec2")
class NkConfigStackVec2 extends Struct<NkConfigStackVec2> {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        HEAD,
        ELEMENTS;

    static {
        Layout layout = __struct(
            __member(4),
            __array(NkConfigStackVec2Element.SIZEOF, NkConfigStackVec2Element.ALIGNOF, 16)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        HEAD = layout.offsetof(0);
        ELEMENTS = layout.offsetof(1);
    }

    protected NkConfigStackVec2(long address, @Nullable ByteBuffer container) {
        super(address, container);
    }

    @Override
    protected NkConfigStackVec2 create(long address, @Nullable ByteBuffer container) {
        return new NkConfigStackVec2(address, container);
    }

    /**
     * Creates a {@code NkConfigStackVec2} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    NkConfigStackVec2(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code head} field. */
    public int head() { return nhead(address()); }
    /** @return a {@link NkConfigStackVec2Element}.Buffer view of the {@code elements} field. */
    @NativeType("struct nk_config_stack_vec2_element[16]")
    public NkConfigStackVec2Element.Buffer elements() { return nelements(address()); }
    /** @return a {@link NkConfigStackVec2Element} view of the struct at the specified index of the {@code elements} field. */
    @NativeType("struct nk_config_stack_vec2_element")
    public NkConfigStackVec2Element elements(int index) { return nelements(address(), index); }

    // -----------------------------------

    /** Returns a new {@code NkConfigStackVec2} instance for the specified memory address. */
    public static NkConfigStackVec2 create(long address) {
        return new NkConfigStackVec2(address, null);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static @Nullable NkConfigStackVec2 createSafe(long address) {
        return address == NULL ? null : new NkConfigStackVec2(address, null);
    }

    /**
     * Create a {@link NkConfigStackVec2.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static NkConfigStackVec2.Buffer create(long address, int capacity) {
        return new Buffer(address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    public static NkConfigStackVec2.@Nullable Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : new Buffer(address, capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #head}. */
    public static int nhead(long struct) { return memGetInt(struct + NkConfigStackVec2.HEAD); }
    /** Unsafe version of {@link #elements}. */
    public static NkConfigStackVec2Element.Buffer nelements(long struct) { return NkConfigStackVec2Element.create(struct + NkConfigStackVec2.ELEMENTS, 16); }
    /** Unsafe version of {@link #elements(int) elements}. */
    public static NkConfigStackVec2Element nelements(long struct, int index) {
        return NkConfigStackVec2Element.create(struct + NkConfigStackVec2.ELEMENTS + check(index, 16) * NkConfigStackVec2Element.SIZEOF);
    }

    // -----------------------------------

    /** An array of {@link NkConfigStackVec2} structs. */
    public static class Buffer extends StructBuffer<NkConfigStackVec2, Buffer> {

        private static final NkConfigStackVec2 ELEMENT_FACTORY = NkConfigStackVec2.create(-1L);

        /**
         * Creates a new {@code NkConfigStackVec2.Buffer} instance backed by the specified container.
         *
         * <p>Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link NkConfigStackVec2#SIZEOF}, and its mark will be undefined.</p>
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
        protected NkConfigStackVec2 getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@code head} field. */
        public int head() { return NkConfigStackVec2.nhead(address()); }
        /** @return a {@link NkConfigStackVec2Element}.Buffer view of the {@code elements} field. */
        @NativeType("struct nk_config_stack_vec2_element[16]")
        public NkConfigStackVec2Element.Buffer elements() { return NkConfigStackVec2.nelements(address()); }
        /** @return a {@link NkConfigStackVec2Element} view of the struct at the specified index of the {@code elements} field. */
        @NativeType("struct nk_config_stack_vec2_element")
        public NkConfigStackVec2Element elements(int index) { return NkConfigStackVec2.nelements(address(), index); }

    }

}