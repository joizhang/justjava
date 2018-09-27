package com.joizhang.leetcode.set;

import org.junit.Test;

public class IntersectionOfTwoArraysTest {

    @Test
    public void intersection() {
        IntersectionOfTwoArrays intersection = new IntersectionOfTwoArrays();
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] res = intersection.intersection(nums1, nums2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }
}