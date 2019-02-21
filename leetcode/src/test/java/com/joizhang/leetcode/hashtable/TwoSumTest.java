package com.joizhang.leetcode.hashtable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

public class TwoSumTest {

    @Test
    public void twoSum() {
        assertArrayEquals(new int[]{0, 1}, new TwoSum().twoSum(new int[]{2, 7, 11, 15}, 9));
        assertArrayEquals(new int[]{1, 2}, new TwoSum().twoSum(new int[]{3, 2, 4}, 6));
    }
}