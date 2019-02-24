package com.joizhang.leetcode.set;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class IntersectionOfTwoArrays2Test {

    @Test
    public void intersect() {
        assertArrayEquals(new int[]{}, new IntersectionOfTwoArrays2().intersect(new int[]{}, new int[]{1}));
        assertArrayEquals(new int[]{2, 2}, new IntersectionOfTwoArrays2().intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        assertArrayEquals(new int[]{9, 4}, new IntersectionOfTwoArrays2().intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

}