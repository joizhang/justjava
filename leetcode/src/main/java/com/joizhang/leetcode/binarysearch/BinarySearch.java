package com.joizhang.leetcode.binarysearch;

/**
 * 704. Binary Search
 *
 * @author joizhang
 */
class BinarySearch {

    public int search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }

    /**
     * 在[lo...hi]的范围里寻找target
     */
    private int binarySearch(int[] nums, int target, int lo, int hi) {
        if (lo > hi) {
            return -1;
        }
        int mid = lo + (hi - lo) / 2;
        if (target < nums[mid]) {
            return binarySearch(nums, target, lo, mid - 1);
        } else if (target > nums[mid]) {
            return binarySearch(nums, target, mid + 1, hi);
        } else {
            return mid;
        }
    }

}
