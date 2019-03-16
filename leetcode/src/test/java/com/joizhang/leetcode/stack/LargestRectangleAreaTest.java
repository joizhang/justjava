package com.joizhang.leetcode.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class LargestRectangleAreaTest {

    @Test
    public void largestRectangleArea() {
        assertEquals(10, new LargestRectangleArea().largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}