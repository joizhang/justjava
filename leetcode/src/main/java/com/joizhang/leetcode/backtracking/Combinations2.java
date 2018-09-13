package com.joizhang.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 77. Combinations
 *
 * @author joizhang
 */
public class Combinations2 {

    private List<List<Integer>> res;

    public List<List<Integer>> combine(int n, int k) {
        res = new ArrayList<>();
        if (n <= 0 || k <= 0) {
            return res;
        }
        generateCombinations(n, k, 1, new ArrayList<>());
        return res;
    }

    private void generateCombinations(int n, int k, int start, List<Integer> p) {
        if (p.size() == k) {
            res.add(new ArrayList<>(p));
            return;
        }
        // 还有 k - p.size() 个空位， 所以 [i...n] 中至少要有 k - p.size() 个元素
        // i 最多为 n - (k - p.size()) + 1
        for (int i = start; i <= n - (k - p.size()) + 1; i++) {
            p.add(i);
            generateCombinations(n, k, i + 1, p);
            p.remove(p.size() - 1);
        }
    }

}
