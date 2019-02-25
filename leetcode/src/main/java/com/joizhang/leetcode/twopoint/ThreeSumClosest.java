package com.joizhang.leetcode.twopoint;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 *
 * @author joizhang
 */
class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = 0;
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int minus = sum - target;
                if (minus == 0) {
                    return sum;
                }
                if (Math.abs(minus) < closest) {
                    closest = Math.abs(minus);
                    res = sum;
                }
                if (sum < target) {
                    j++;
                }
                if (sum > target) {
                    k--;
                }
            }
        }
        return res;
    }

}
