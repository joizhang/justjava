package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import static org.junit.Assert.*;

public class MoveZeroesTest {

    @Test
    public void moveZeroes() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

    @Test
    public void moveZeroes2() {
        int[] nums = new int[]{0, 1, 0, 3, 12};
        new MoveZeroes().moveZeroes2(nums);
        assertArrayEquals(new int[]{1, 3, 12, 0, 0}, nums);
    }

}