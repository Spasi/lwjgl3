/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 */
package org.lwjgl.system;

import org.lwjgl.*;
import org.lwjgl.system.jni.*;
import org.testng.*;
import org.testng.annotations.*;

import java.nio.*;
import java.util.*;

import static org.lwjgl.system.MemoryUtil.*;
import static org.testng.Assert.*;

@Test
public class BufferTest {

    public void testCustomBufferIOOBE() {
        ByteBuffer    pb = memAlloc(16);
        PointerBuffer pp = memAllocPointer(16);

        expectThrows(IndexOutOfBoundsException.class, () -> pb.get(-1));
        expectThrows(IndexOutOfBoundsException.class, () -> pp.get(-1));
        pb.get(0);
        pp.get(0);
        pb.get(15);
        pp.get(15);
        expectThrows(IndexOutOfBoundsException.class, () -> pb.get(16));
        expectThrows(IndexOutOfBoundsException.class, () -> pp.get(16));

        pb.limit(10);
        pp.limit(10);
        pb.get(9);
        pp.get(9);
        expectThrows(IndexOutOfBoundsException.class, () -> pb.get(10));
        expectThrows(IndexOutOfBoundsException.class, () -> pp.get(10));

        pb.position(10);
        pp.position(10);

        memFree(pp);
        memFree(pb);
    }

    public void testLargeBufferNIO() {
        // ByteBuffer.allocateDirect supports up to Integer.MAX_VALUE bytes
        expectThrows(IllegalArgumentException.class, () -> BufferUtils.createShortBuffer(0x3FFFFFFF + 1));
    }

    public void testLargeBuffer() {
        try {
            ShortBuffer buffer = memCallocShort(0x3FFFFFFF + 1);

            buffer.put(buffer.limit() - 1, (short)0xBEEF);
            assertEquals(buffer.get(buffer.limit() - 1), (short)0xBEEF);

            memFree(buffer);
        } catch (OutOfMemoryError e) {
            throw new SkipException("Large buffer allocation failed."); // 32-bit JVM
        }
    }

    public void testPointerBuffer() {
        PointerBuffer buffer = memCallocPointer(8);
        long[]        array  = new long[buffer.capacity()];

        // Relative bulk

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i);
        }
        buffer.flip();
        buffer.get(array);
        assertEquals(buffer.remaining(), 0);
        buffer.flip();
        for (long l : array) {
            assertEquals(l, buffer.get());
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        buffer.flip();
        buffer.put(array);
        assertEquals(buffer.remaining(), 0);
        buffer.flip();
        for (long l : array) {
            assertEquals(buffer.get(), l);
        }

        // Absolute bulk

        buffer.clear();

        Arrays.fill(array, NULL);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i, i);
        }
        buffer.get(2, array, 2, 4);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.limit(), buffer.capacity());

        assertEquals(array[0], NULL);
        assertEquals(array[1], NULL);
        assertEquals(array[2], 2L);
        assertEquals(array[3], 3L);
        assertEquals(array[4], 4L);
        assertEquals(array[5], 5L);
        assertEquals(array[6], NULL);
        assertEquals(array[7], NULL);

        memSet(buffer, 0);
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        buffer.put(2, array, 2, 4);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.limit(), buffer.capacity());

        assertEquals(buffer.get(0), NULL);
        assertEquals(buffer.get(1), NULL);
        assertEquals(buffer.get(2), 6L);
        assertEquals(buffer.get(3), 5L);
        assertEquals(buffer.get(4), 4L);
        assertEquals(buffer.get(5), 3L);
        assertEquals(buffer.get(6), NULL);
        assertEquals(buffer.get(7), NULL);

        memFree(buffer);
    }

    public void testCLongBuffer() {
        CLongBuffer buffer = memCallocCLong(8);
        long[]      array  = new long[buffer.capacity()];

        // Relative bulk

        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i);
        }
        buffer.flip();
        buffer.get(array);
        assertEquals(buffer.remaining(), 0);
        buffer.flip();
        for (long l : array) {
            assertEquals(l, buffer.get());
        }

        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        buffer.flip();
        buffer.put(array);
        assertEquals(buffer.remaining(), 0);
        buffer.flip();
        for (long l : array) {
            assertEquals(buffer.get(), l);
        }

        // Absolute bulk

        buffer.clear();

        Arrays.fill(array, NULL);
        for (int i = 0; i < buffer.capacity(); i++) {
            buffer.put(i, i);
        }
        buffer.get(2, array, 2, 4);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.limit(), buffer.capacity());

        assertEquals(array[0], NULL);
        assertEquals(array[1], NULL);
        assertEquals(array[2], 2L);
        assertEquals(array[3], 3L);
        assertEquals(array[4], 4L);
        assertEquals(array[5], 5L);
        assertEquals(array[6], NULL);
        assertEquals(array[7], NULL);

        memSet(buffer, 0);
        for (int i = 0; i < array.length; i++) {
            array[i] = array.length - i;
        }
        buffer.put(2, array, 2, 4);
        assertEquals(buffer.position(), 0);
        assertEquals(buffer.limit(), buffer.capacity());

        assertEquals(buffer.get(0), NULL);
        assertEquals(buffer.get(1), NULL);
        assertEquals(buffer.get(2), 6L);
        assertEquals(buffer.get(3), 5L);
        assertEquals(buffer.get(4), 4L);
        assertEquals(buffer.get(5), 3L);
        assertEquals(buffer.get(6), NULL);
        assertEquals(buffer.get(7), NULL);

        memFree(buffer);
    }

    private static long fillBuffer(JNINativeMethod.Buffer buffer) {
        long sum = 0;
        for (int i = 0; i < buffer.remaining(); i++) {
            buffer.get(i).fnPtr(i + 1);
            sum += (i + 1);
        }
        return sum;
    }

    public void testStructBufferIterable() {
        JNINativeMethod.Buffer buffer = JNINativeMethod.malloc(10);

        long expected = fillBuffer(buffer);
        long actual   = 0;
        for (JNINativeMethod struct : buffer) {
            actual += struct.fnPtr();
        }

        assertEquals(actual, expected);

        buffer.free();
    }

    public void testStructBufferStream() {
        JNINativeMethod.Buffer buffer = JNINativeMethod.malloc(10);

        long expected = fillBuffer(buffer);
        long actual = buffer
            .stream()
            .mapToLong(JNINativeMethod::fnPtr)
            .sum();

        assertEquals(actual, expected);

        buffer.free();
    }

    public void testStructBufferParallelStream() {
        JNINativeMethod.Buffer buffer = JNINativeMethod.malloc(10 * 1024);

        long expected = fillBuffer(buffer);
        long actual = buffer
            .parallelStream()
            .mapToLong(JNINativeMethod::fnPtr)
            .sum();

        assertEquals(actual, expected);

        buffer.free();
    }

}
