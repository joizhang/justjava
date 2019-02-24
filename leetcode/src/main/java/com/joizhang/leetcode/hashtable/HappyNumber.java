package com.joizhang.leetcode.hashtable;

import java.util.HashSet;
import java.util.Set;

/**
 * 202. Happy Number
 *
 * @author joizhang
 */
class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while (set.add(n)) {
            int squareSum = 0;
            while (n > 0) {
                int remain = n % 10;
                squareSum += remain * remain;
                n /= 10;
            }
            if (squareSum == 1) {
                return true;
            } else {
                n = squareSum;
            }
        }
        return false;
    }

}
