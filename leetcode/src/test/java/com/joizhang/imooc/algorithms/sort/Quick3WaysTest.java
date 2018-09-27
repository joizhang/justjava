package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class Quick3WaysTest {

    @Test
    public void sort() {
        Integer[] integers = Sorts.generateRandomArray(1000, 0, 100);
        Quick3Ways.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }
}