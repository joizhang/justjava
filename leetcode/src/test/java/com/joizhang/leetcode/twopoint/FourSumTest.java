package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class FourSumTest {

    @Test
    public void fourSum() {
        List<List<Integer>> res = new FourSum().fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0);
        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}