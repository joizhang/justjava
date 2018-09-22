package com.joizhang.imooc.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class QuickTest {

    @Test
    public void sortRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(100, 0, 100);
        Quick.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

    @Test
    public void sortRandomLessArray() {
        Integer[] integers = Sorts.generateRandomArray(1000000, 0, 10);
        Quick.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

    @Test
    public void sortNearlyOrderedArray() {
        Integer[] integers = Sorts.generateNearlyOrderedArray(10000, 10);
        Quick.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }
}