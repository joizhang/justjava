package com.joizhang.imooc.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeTest {

    @Test
    public void sort() {
        Integer[] integers = Sorts.generateRandomArray(100, 0, 100);
        Merge.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }
}