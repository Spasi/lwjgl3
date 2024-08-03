/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.system.ffm;

import java.lang.constant.*;
import java.lang.foreign.*;
import java.lang.reflect.*;
import java.nio.charset.*;

import static java.lang.constant.ConstantDescs.*;

final class ConstantDescs {

    static final ClassDesc
        CD_AddressLayout            = AddressLayout.class.describeConstable().orElseThrow(),
        CD_byteArray                = byte[].class.describeConstable().orElseThrow(),
        CD_Charset                  = Charset.class.describeConstable().orElseThrow(),
        CD_IllegalArgumentException = IllegalArgumentException.class.describeConstable().orElseThrow(),
        CD_MemoryLayout             = MemoryLayout.class.describeConstable().orElseThrow(),
        CD_MemorySegment            = MemorySegment.class.describeConstable().orElseThrow(),
        CD_Method                   = Method.class.describeConstable().orElseThrow(),
        CD_ObjectArray              = Object[].class.describeConstable().orElseThrow(),
        CD_SegmentAllocator         = SegmentAllocator.class.describeConstable().orElseThrow(),
        CD_StackAllocator           = StackAllocator.class.describeConstable().orElseThrow(),
        CD_StackArena               = StackArena.class.describeConstable().orElseThrow(),
        CD_StandardCharsets         = StandardCharsets.class.describeConstable().orElseThrow(),
        CD_TraceConsumer            = TraceConsumer.class.describeConstable().orElseThrow(),
        CD_ValueLayout              = ValueLayout.class.describeConstable().orElseThrow(),
        CD_ValueLayout$OfByte       = ValueLayout.OfByte.class.describeConstable().orElseThrow(),
        CD_ValueLayout$OfShort      = ValueLayout.OfShort.class.describeConstable().orElseThrow(),
        CD_ValueLayout$OfInt        = ValueLayout.OfInt.class.describeConstable().orElseThrow(),
        CD_ValueLayout$OfLong       = ValueLayout.OfLong.class.describeConstable().orElseThrow();

    static final MethodTypeDesc
        MTD_Charset_forName                             = MethodTypeDesc.of(CD_Charset, CD_String),
        MTD_IllegalArgumentException_new                = MethodTypeDesc.of(CD_void, CD_String),
        MTD_MemorySegment_asSlice                       = MethodTypeDesc.of(CD_MemorySegment, CD_long, CD_long),
        MTD_MemorySegment_equals                        = MethodTypeDesc.of(CD_boolean, CD_Object),
        MTD_MemorySegment_get$OfByte                    = MethodTypeDesc.of(CD_byte, CD_ValueLayout$OfByte, CD_long),
        MTD_MemorySegment_get$OfShort                   = MethodTypeDesc.of(CD_short, CD_ValueLayout$OfShort, CD_long),
        MTD_MemorySegment_get$OfInt                     = MethodTypeDesc.of(CD_int, CD_ValueLayout$OfInt, CD_long),
        MTD_MemorySegment_get$OfLong                    = MethodTypeDesc.of(CD_long, CD_ValueLayout$OfLong, CD_long),
        MTD_MemorySegment_get$Address                   = MethodTypeDesc.of(CD_MemorySegment, CD_AddressLayout, CD_long),
        MTD_MemorySegment_getString                     = MethodTypeDesc.of(CD_String, CD_long, CD_Charset),
        MTD_MemorySegment_toArray$OfByte                = MethodTypeDesc.of(CD_byteArray, CD_ValueLayout$OfByte),
        MTD_SegmentAllocator_allocate_long              = MethodTypeDesc.of(CD_MemorySegment, CD_long),
        MTD_SegmentAllocator_allocate_MemoryLayout_long = MethodTypeDesc.of(CD_MemorySegment, CD_MemoryLayout, CD_long),
        MTD_SegmentAllocator_allocateFrom               = MethodTypeDesc.of(CD_MemorySegment, CD_String, CD_Charset),
        MTD_String_new$byteArray_Charset                = MethodTypeDesc.of(CD_void, CD_byteArray, CD_Charset),
        MTD_StackAllocator_push                         = MethodTypeDesc.of(CD_StackAllocator),
        MTD_StackAllocator_pop                          = MethodTypeDesc.of(CD_StackAllocator),
        MTD_StackArena_stackPush                        = MethodTypeDesc.of(CD_StackArena),
        MTD_Throwable_addSuppressed                     = MethodTypeDesc.of(CD_void, CD_Throwable),
        MTD_TraceConsumer_accept                        = MethodTypeDesc.of(CD_void, CD_Method, CD_Object, CD_ObjectArray);

    static final MethodTypeDesc
        MTD_Boolean_valueOf = MethodTypeDesc.of(CD_Boolean, CD_boolean),
        MTD_Byte_valueOf    = MethodTypeDesc.of(CD_Byte, CD_byte),
        MTD_Short_valueOf   = MethodTypeDesc.of(CD_Short, CD_short),
        MTD_Integer_valueOf = MethodTypeDesc.of(CD_Integer, CD_int),
        MTD_Long_valueOf    = MethodTypeDesc.of(CD_Long, CD_long),
        MTD_Float_valueOf   = MethodTypeDesc.of(CD_Float, CD_float),
        MTD_Double_valueOf  = MethodTypeDesc.of(CD_Double, CD_double);

    private ConstantDescs() {
    }

}
