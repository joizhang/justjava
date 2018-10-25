package com.joizhang.imooc.algorithms;

/**
 * 尾递归
 *
 * @author joizhang
 */
class RecursionSum {

    /**
     * recSum(5)
     * 5 + recSum(4)
     * 5 + (4 + recSum(3))
     * 5 + (4 + (3 + recSum(2)))
     * 5 + (4 + (3 + (2 + recSum(1))))
     * 5 + (4 + (3 + (2 + 1)))
     */
    public int recSum(int x) {
        if (x == 0) {
            return x;
        } else {
            return x + recSum(x - 1);
        }
    }

    /**
     * tailRecSum(5, 0)
     * tailRecSum(4, 5)
     * tailRecSum(3, 9)
     * tailRecSum(2, 12)
     * tailRecSum(1, 14)
     * tailRecSum(0, 15)
     */
    public int tailRecSum(int x, int sum) {
        if (x == 0) {
            return sum;
        } else {
            return tailRecSum(x - 1, sum + x);
        }
    }

}
