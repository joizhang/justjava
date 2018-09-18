package com.joizhang.leetcode.dp;

import java.util.List;

/**
 * 120. Triangle
 *
 * @author joizhang
 */
class Triangle {

    public int minimumTotal(List<List<Integer>> triangle) {
        int[] memo = new int[triangle.size() + 1];
        for (int i = triangle.size() - 1; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                memo[j] = Math.min(memo[j], memo[j + 1]) + triangle.get(i).get(j);
            }
        }
        return memo[0];
    }

}
