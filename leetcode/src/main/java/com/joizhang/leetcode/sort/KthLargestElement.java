package com.joizhang.leetcode.sort;

/**
 * @author joizhang
 */
public class KthLargestElement {

    public int findKthLargest(int[] nums, int k) {
        int lo = 0;
        int hi = nums.length - 1;
        int p = -1;
        while (lo <= hi && p + 1 != k) {
            p = partition(nums, lo, hi);
            if (p + 1 < k) {
                lo = p + 1;
            } else {
                hi = p - 1;
            }
        }
        return nums[p];
    }

    /**
     * 返回 j 使得 a[lo...j-1] > a[j] > a[j+1...hi]
     */
    private int partition(int[] nums, int lo, int hi) {
        int v = nums[lo];
        int i = lo + 1;
        int j = hi;
        while (true) {
            while (i <= hi && nums[i] > v) {
                i++;
            }
            while (j >= lo + 1 && v > nums[j]) {
                j--;
            }
            if (i > j) {
                break;
            }
            swap(nums, i, j);
            i++;
            j--;
        }
        swap(nums, lo, j);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
