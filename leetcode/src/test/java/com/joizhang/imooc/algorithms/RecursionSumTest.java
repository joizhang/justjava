package com.joizhang.imooc.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RecursionSumTest {

    @Test
    public void testSum() {
        RecursionSum recursionSum = new RecursionSum();
        assertEquals(recursionSum.recSum(5), recursionSum.tailRecSum(5, 0));
    }

}