package com.joizhang.leetcode.dp;

import java.util.Arrays;

/**
 * 509. Fibonacci Number
 *
 * @author joizhang
 */
class Fibonacci {

    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        int[] memo = new int[N + 1];
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i < N + 1; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[N];
    }

    public int fib2(int N) {
        int[] memo = new int[N + 1];
        Arrays.fill(memo, -1);
        if (N == 0) {
            return 0;
        }

        if (N == 1) {
            return 1;
        }

        if (memo[N] == -1) {
            memo[N] = fib2(N - 1) + fib2(N - 2);
        }
        return memo[N];
    }

}
