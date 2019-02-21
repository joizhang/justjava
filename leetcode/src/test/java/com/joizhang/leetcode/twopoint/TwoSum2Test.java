package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import static org.junit.Assert.*;

public class TwoSum2Test {

    @Test
    public void twoSum() {
        assertArrayEquals(new int[]{1,2}, new TwoSum2().twoSum(new int[]{2,7,11,15}, 9));
    }
}