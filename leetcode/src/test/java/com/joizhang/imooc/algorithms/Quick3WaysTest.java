package com.joizhang.imooc.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class Quick3WaysTest {

    @Test
    public void sort() {
        Integer[] integers = Sorts.generateRandomArray(1000, 0, 100);
        Quick3Ways.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }
}