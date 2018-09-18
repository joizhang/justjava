package com.joizhang.imooc.algorithms;

import org.junit.Test;

public class SortCompareTest {

    @Test
    public void compareWithRandomArray() {
        SortCompare.compareWithRandomArray(50000, Sorts.SortType.SELECTION,
                Sorts.SortType.INSERTION,
                Sorts.SortType.SHELL,
                Sorts.SortType.MERGE);
    }

    @Test
    public void compareWithNearlyOrderedArray() {
        SortCompare.compareWithNearlyOrderedArray(10000, Sorts.SortType.SELECTION,
                Sorts.SortType.INSERTION,
                Sorts.SortType.SHELL,
                Sorts.SortType.MERGE);
    }

}