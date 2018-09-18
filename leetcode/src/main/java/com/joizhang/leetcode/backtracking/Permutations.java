package com.joizhang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 46. Permutations
 *
 * @author joizhang
 */
class Permutations {

    private List<List<Integer>> res;

    private boolean[] used;

    public List<List<Integer>> permute(int[] nums) {
        res = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        used = new boolean[nums.length];
        Arrays.fill(used, false);
        generatePermutations(nums, 0, new ArrayList<>());
        return res;
    }

    /**
     * p 中保存了一个有index个元素的排列。
     * 向这个排列的末尾添加第 index + 1 个元素，获得一个有 index + 1 个元素的排列
     */
    private void generatePermutations(int[] nums, int index, List<Integer> p) {
        if (index == nums.length) {
            res.add(new ArrayList<>(p));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                p.add(nums[i]);
                used[i] = true;
                generatePermutations(nums, index + 1, p);
                p.remove(p.size() - 1);
                used[i] = false;
            }
        }
    }

}
