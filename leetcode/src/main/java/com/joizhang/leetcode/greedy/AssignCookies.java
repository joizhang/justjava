package com.joizhang.leetcode.greedy;

import java.util.Arrays;

/**
 * 455. Assign Cookies
 *
 * @author joizhang
 */
class AssignCookies {

    /**
     * @param g children greed factors
     * @param s cookies size
     */
    public int findContentChildren(int[] g, int[] s) {
        // sort g desc
        Integer[] g1 = new Integer[g.length];
        for (int i = 0; i < g.length; i++) {
            g1[i] = g[i];
        }
        Arrays.sort(g1, (a, b) -> b - a);
        // sort s desc
        Integer[] s1 = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            s1[i] = s[i];
        }
        Arrays.sort(s1, (a, b) -> b - a);

        int si = 0;
        int gi = 0;
        int res = 0;
        while (gi < g1.length && si < s1.length) {
            if (s1[si] >= g1[gi]) {
                res++;
                si++;
                gi++;
            } else {
                gi++;
            }
        }
        return res;
    }

}
