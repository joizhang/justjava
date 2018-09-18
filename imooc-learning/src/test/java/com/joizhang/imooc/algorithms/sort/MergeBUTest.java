package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeBUTest {

    @Test
    public void sortGenerateRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(90, 0, 100);
        MergeBU.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

}