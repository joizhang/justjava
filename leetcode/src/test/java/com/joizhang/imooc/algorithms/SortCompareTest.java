package com.joizhang.imooc.algorithms;

import org.junit.Test;

public class SortCompareTest {

    @Test
    public void compareWithRandomArray() {
        SortCompare.compareWithRandomArray(10000, "Selection", "Insertion", "Shell");
    }

    @Test
    public void compareWithNearlyOrderedArray() {
        SortCompare.compareWithNearlyOrderedArray(10000, "Selection", "Insertion", "Shell");
    }

}