package com.joizhang.imooc.algorithms;

import org.junit.Test;

import static org.junit.Assert.*;

public class MergeBUTest {

    @Test
    public void sort() {
        Integer[] integers = Sorts.generateRandomArray(17, 0, 100);
        MergeBU.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }

}