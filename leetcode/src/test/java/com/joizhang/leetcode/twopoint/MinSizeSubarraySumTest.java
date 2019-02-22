package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import static org.junit.Assert.*;

public class MinSizeSubarraySumTest {

    @Test
    public void minSubArrayLen() {
        assertEquals(2, new MinSizeSubarraySum().minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}