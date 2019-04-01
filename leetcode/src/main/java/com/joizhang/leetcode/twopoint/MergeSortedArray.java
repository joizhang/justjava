package com.joizhang.leetcode.twopoint;

/**
 * 88. Merge Sorted ArrayList
 *
 * @author joizhang
 */
class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int index = m + n - 1;
        while (i >= 0 || j >= 0) {
            if (i < 0) {
                nums1[index] = nums2[j];
                j--;
            } else if (j < 0) {
                nums1[index] = nums1[i];
                i--;
            } else if (nums1[i] >= nums2[j]) {
                nums1[index] = nums1[i];
                i--;
            } else {
                nums1[index] = nums2[j];
                j--;
            }
            index--;
        }
    }

}
