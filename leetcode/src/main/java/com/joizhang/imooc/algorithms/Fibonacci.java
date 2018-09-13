package com.joizhang.imooc.algorithms;

import java.util.Arrays;

/**
 * @author joizhang
 */
class Fibonacci {

    private int[] memo;

    Fibonacci(int n) {
        this.memo = new int[n + 1];
        Arrays.fill(this.memo, -1);
    }

    /**
     * 记忆搜索 - 自上向下的解决问题
     */
    int fib(int n) {
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (memo[n] == -1) {
            memo[n] = fib(n - 1) + fib(n - 2);
        }
        return memo[n];
    }

    /**
     * <p>动态规划 - 自下向上的解决问题
     * <p>将原问题拆解成若干子问题，同时保存子问题的答案，使得每个字问题只求解一次，
     * 最终获得原问题的答案
     */
    int fib2(int n) {
        memo[0] = 0;
        memo[1] = 1;
        for (int i = 2; i <= n; i++) {
            memo[i] = memo[i - 1] + memo[i - 2];
        }
        return memo[n];
    }

}
