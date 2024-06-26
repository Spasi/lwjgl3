/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.system.ffm;

import java.lang.classfile.*;
import java.lang.constant.*;
import java.lang.foreign.*;

import static org.lwjgl.system.ffm.BindingGenerator.*;

public enum SizeCarrier {

    BYTE(ValueLayout.JAVA_BYTE, "JAVA_BYTE", CD_ValueLayout$OfByte, MTD_MemorySegment_get$OfByte),
    SHORT(ValueLayout.JAVA_SHORT, "JAVA_SHORT", CD_ValueLayout$OfShort, MTD_MemorySegment_get$OfShort),
    INT(ValueLayout.JAVA_INT, "JAVA_INT", CD_ValueLayout$OfInt, MTD_MemorySegment_get$OfInt),
    LONG(ValueLayout.JAVA_LONG, "JAVA_LONG", CD_ValueLayout$OfLong, MTD_MemorySegment_get$OfLong),
    SIZE_T(ValueLayout.ADDRESS, "ADDRESS", CD_AddressLayout, MTD_MemorySegment_get$Address);

    private static final SizeCarrier[] values = values();

    public final ValueLayout layout;

    final String         name;
    final ClassDesc      type;
    final MethodTypeDesc getter;

    private SizeCarrier(ValueLayout layout, String name, ClassDesc type, MethodTypeDesc getter) {
        this.layout = layout;
        this.name = name;
        this.type = type;
        this.getter = getter;
    }

    CodeBuilder allocateSingle(CodeBuilder cb) {
        return cb
            .getstatic(CD_ValueLayout, name, type)
            .lconst_1()
            .invokeinterface(CD_SegmentAllocator, "allocate", MTD_SegmentAllocator_allocate_MemoryLayout_long);
    }

    static SizeCarrier get(Class<?> carrier) {
        for (var value : values) {
            if (value.layout.carrier() == carrier) {
                return value;
            }
        }
        throw new IllegalArgumentException("Unsupported carrier type: " + carrier);
    }

}