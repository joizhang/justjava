package com.joizhang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 47. Permutations II
 *
 * @author joizhang
 */
class Permutations2 {

    private List<List<Integer>> res;

    public List<List<Integer>> permuteUnique(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        generatePermuteUnique(nums, 0);
        return res;
    }

    private void generatePermuteUnique(int[] nums, int index) {
        if (index == nums.length) {
            List<Integer> temp = new ArrayList<>();
            for (int num : nums) {
                temp.add(num);
            }
            res.add(temp);
        }
        Set<Integer> appeared = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (appeared.add(nums[i])) {
                swap(nums, index, i);
                generatePermuteUnique(nums, index + 1);
                swap(nums, index, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int save = nums[i];
        nums[i] = nums[j];
        nums[j] = save;
    }

}
