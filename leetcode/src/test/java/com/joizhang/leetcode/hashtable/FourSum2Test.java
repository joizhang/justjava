package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import static org.junit.Assert.*;

public class FourSum2Test {

    @Test
    public void fourSumCount() {
        assertEquals(2,
                new FourSum2().fourSumCount(
                        new int[]{1, 2}, new int[]{-2, -1},
                        new int[]{-1, 2}, new int[]{0, 2}));
    }
}