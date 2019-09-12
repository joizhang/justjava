package com.joizhang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 39. Combination Sum
 * @author joizhang
 */
class CombinationSum {

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(candidates);
        backtrack(candidates, target, res, 0, new ArrayList<Integer>());
        return res;
    }

    private void backtrack(int[] candidates, int target, List<List<Integer>> res, int i, ArrayList<Integer> tmpList) {
        if (target < 0) {
            return;
        }
        if (target == 0) {
            res.add(new ArrayList<>(tmpList));
            return;
        }
        for (int start = i; start < candidates.length; start++) {
            if (target < candidates[start]) {
                break;
            }
            tmpList.add(candidates[start]);
            backtrack(candidates, target - candidates[start], res, start, tmpList);
            tmpList.remove(tmpList.size() - 1);
        }
    }

}
