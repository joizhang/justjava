package com.joizhang.leetcode.segmenttree;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumArrayTest {

    @Test
    public void sumRange() {
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray numArray = new NumArray(nums);
        assertEquals(1, numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));
    }
}