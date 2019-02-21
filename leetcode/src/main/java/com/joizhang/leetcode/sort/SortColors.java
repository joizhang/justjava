package com.joizhang.leetcode.sort;

/**
 * 75. Sort Colors
 *
 * @author joizhang
 */
class SortColors {

    public void sortColors(int[] nums) {
        int[] countArr = new int[3];
        for (int num : nums) {
            countArr[num]++;
        }
        int index = 0;
        for (int i = 0; i < countArr.length; i++) {
            for (int j = 0; j < countArr[i]; j++) {
                nums[index++] = i;
            }
        }
    }

    public void sortColors2(int[] nums) {
        // nums[0...zero] = 0
        int zero = -1;
        // nums[two...n] = 2
        int two = nums.length;
        int i = 0;
        while (i < two) {
            if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                swap(nums, i, --two);
            } else {
                swap(nums, i, ++zero);
                i++;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }

}
