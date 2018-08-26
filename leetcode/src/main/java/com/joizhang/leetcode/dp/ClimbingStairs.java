package com.joizhang.leetcode.dp;

/**
 * 70. Climbing Stairs
 *
 * @author joizhang
 */
class ClimbingStairs {

    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

}
