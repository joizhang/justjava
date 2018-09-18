package com.joizhang.imooc.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class InsertionTest {

    @Test
    public void sortGenerateRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(10, 0, 100);
        Insertion.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

    @Test
    public void sortMoreGenerateRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(10000, 100, 100000);
        Insertion.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

}