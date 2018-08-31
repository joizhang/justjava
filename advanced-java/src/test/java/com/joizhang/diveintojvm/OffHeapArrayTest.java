package com.joizhang.diveintojvm;

import org.junit.Test;

import static org.junit.Assert.*;

public class OffHeapArrayTest {

    @Test
    public void testOffHeapArray() throws NoSuchFieldException, IllegalAccessException {
        long SUPER_SIZE = (long) Integer.MAX_VALUE * 2;
        OffHeapArray array = new OffHeapArray(SUPER_SIZE);

        int sum = 0;
        for (int i = 0; i < 100; i++) {
            array.set((long) Integer.MAX_VALUE + i, (byte) 3);
            sum += array.get((long) Integer.MAX_VALUE + i);
        }

        assertEquals(SUPER_SIZE, array.size());
        assertEquals(300, sum);

        array.freeMemory();
    }

}