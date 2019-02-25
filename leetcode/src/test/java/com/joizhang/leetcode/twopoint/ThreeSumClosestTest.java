package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import static org.junit.Assert.*;

public class ThreeSumClosestTest {

    @Test
    public void threeSumClosest() {
        assertEquals(2, new ThreeSumClosest().threeSumClosest(new int[]{-1, 2, 1, -4}, 1));
        assertEquals(3, new ThreeSumClosest().threeSumClosest(new int[]{0, 1, 2}, 3));
        assertEquals(-1, new ThreeSumClosest().threeSumClosest(new int[]{4, -1, -4, 4}, -1));
    }
}