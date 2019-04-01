package com.joizhang.leetcode.dp;

/**
 * 70. Climbing Stairs
 *
 * @author joizhang
 */
class ClimbingStairs {

    /**
     * DP
     */
    public int climbStairs(int n) {
        int[] memo = new int[n + 1];
        memo[0] = 1;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

    /**
     * 更直观的解法
     */
    public int climbStairs2(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        return climbStairs2(n - 1) + climbStairs2(n - 2);
    }

}
