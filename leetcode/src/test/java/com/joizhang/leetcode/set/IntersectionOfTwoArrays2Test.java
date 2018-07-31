package com.joizhang.leetcode.set;

import org.junit.Test;

public class IntersectionOfTwoArrays2Test {

    @Test
    public void intersect() {
        IntersectionOfTwoArrays2 intersection = new IntersectionOfTwoArrays2();
        int[] nums1 = {};
        int[] nums2 = {1};
        int[] res = intersection.intersect(nums1, nums2);
        for (int num : res) {
            System.out.print(num + " ");
        }
    }

}