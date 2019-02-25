package com.joizhang.leetcode.twopoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * @author joizhang
 */
class FourSum {

    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        return findNSum(nums, target, 4, 0);
    }

    private List<List<Integer>> findNSum(int[] nums, int target, int n, int index) {
        List<List<Integer>> res = new ArrayList<>();
        if (index >= nums.length) {
            return res;
        }
        if (n == 2) {
            int i = index;
            int j = nums.length - 1;
            while (i < j) {
                if (nums[i] + nums[j] == target) {
                    res.add(Arrays.asList(nums[i], nums[j]));
                    while (i < j && nums[i] == nums[i + 1]) {
                        i++;
                    }
                    while (i < j && nums[j] == nums[j - 1]) {
                        j--;
                    }
                    i++;
                    j--;
                } else if (nums[i] + nums[j] < target) {
                    i++;
                } else {
                    j--;
                }
            }
        } else {
            for (int i = index; i < nums.length - n + 1; i++) {
                List<List<Integer>> temp = findNSum(nums, target - nums[i], n - 1, i+1);
                if (!temp.isEmpty()) {
                    for (List<Integer> arr : temp) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.addAll(arr);
                        res.add(list);
                    }
                }
                while (i < nums.length - 1 && nums[i] == nums[i+1]) {
                    i++;
                }
            }
        }
        return res;
    }

}
