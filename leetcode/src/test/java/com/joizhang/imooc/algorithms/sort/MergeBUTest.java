package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class MergeBUTest {

    @Test
    public void sort() {
        Integer[] integers = Sorts.generateRandomArray(17, 0, 100);
        MergeBU.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

}