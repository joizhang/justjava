package com.joizhang.leetcode.set;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntersectionOfTwoArraysTest {

    @Test
    public void intersection() {
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        assertArrayEquals(new int[]{2}, new IntersectionOfTwoArrays().intersection(nums1, nums2));
    }
}