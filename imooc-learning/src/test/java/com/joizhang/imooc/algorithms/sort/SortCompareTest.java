package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

public class SortCompareTest {

    private static final String[] algos = new String[]{"Selection", "Insertion", "Shell", "Merge", "Quick"};

    @Test
    public void compareWithRandomArray() {
        SortCompare.compareWithRandomArray(50000, algos);
    }

    @Test
    public void compareWithNearlyOrderedArray() {
        SortCompare.compareWithNearlyOrderedArray(100000, algos);
    }

}