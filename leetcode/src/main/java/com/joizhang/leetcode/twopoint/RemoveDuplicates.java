package com.joizhang.leetcode.twopoint;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * @author joizhang
 */
class RemoveDuplicates {

    public int removeDuplicates(int[] nums) {
        if (nums.length <= 1) {
            return nums.length;
        }
        int slow = 0;
        int fast = 1;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != nums[fast - 1]) {
                nums[++slow] = nums[fast];
            }
        }
        return slow + 1;
    }

}
