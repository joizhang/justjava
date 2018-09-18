package com.joizhang.imooc.algorithms.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class ShellTest {

    @Test
    public void sortGenerateRandomArray() {
        Integer[] integers = Sorts.generateRandomArray(10, 0, 100);
        Shell.sort(integers);
        Sorts.show(integers);
        assertTrue(Sorts.isSorted(integers));
    }
}