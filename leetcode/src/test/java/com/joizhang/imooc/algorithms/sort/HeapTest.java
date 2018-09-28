package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class HeapTest {

    @Test
    public void sort() {
        Integer[] integers = Sorts.generateRandomArray(1000, 0, 100);
        Heap.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }
}