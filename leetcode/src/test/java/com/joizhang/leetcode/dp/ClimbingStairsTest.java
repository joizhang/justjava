package com.joizhang.leetcode.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class ClimbingStairsTest {

    @Test
    public void climbStairs() {
        assertEquals(2, new ClimbingStairs().climbStairs(2));
        assertEquals(3, new ClimbingStairs().climbStairs(3));
    }

}