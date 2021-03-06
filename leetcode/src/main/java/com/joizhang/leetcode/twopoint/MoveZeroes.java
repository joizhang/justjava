package com.joizhang.leetcode.twopoint;

/**
 * 283. Move Zeroes
 *
 * @author joizhang
 */
class MoveZeroes {

    public void moveZeroes(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (fast < nums.length) {
            if (nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        while (slow < nums.length) {
            nums[slow] = 0;
            slow++;
        }
    }

    public void moveZeroes2(int[] nums) {
        int slow = 0;
        int fast = 0;
        for (; fast < nums.length; fast++) {
            if (nums[fast] != 0) {
                int temp = nums[slow];
                nums[slow++] = nums[fast];
                nums[fast] = temp;
            }
        }
    }

}
