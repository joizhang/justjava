package com.joizhang.leetcode.hashtable;

import java.util.HashMap;
import java.util.Map;

/**
 * 454. 4Sum II
 *
 * @author joizhang
 */
class FourSum2 {

    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int res = 0;
        Map<Integer, Integer> record = new HashMap<>();
        for (int c : C) {
            for (int d : D) {
                record.put(c + d, record.getOrDefault(c + d, 0) + 1);
            }
        }
        for (int a : A) {
            for (int b : B) {
                if (record.containsKey(0 - a - b)) {
                    res += record.get(0 - a - b);
                }
            }
        }
        return res;
    }

}
