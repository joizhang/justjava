package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class ThreeSumTest {

    @Test
    public void threeSum() {
//        List<List<Integer>> res = new ThreeSum().threeSum(new int[]{-1, 0, 1, 2, -1, -4});
//        for (int i = 0; i < res.size(); i++) {
//            System.out.println(res.get(i));
//        }

        List<List<Integer>> res = new ThreeSum().threeSum(new int[]{-2,0,0,2,2});
        for (List<Integer> re : res) {
            System.out.println(re);
        }
    }
}