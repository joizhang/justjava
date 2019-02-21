package com.joizhang.leetcode.sort;

import org.junit.Test;

import static org.junit.Assert.*;

public class SortColorsTest {

    @Test
    public void sortColors() {
        int[] nums = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors(nums);
        assertArrayEquals(new int[]{0,0,1,1,2,2}, nums);
    }

    @Test
    public void sortColors2() {
        int[] nums = new int[]{2,0,2,1,1,0};
        new SortColors().sortColors2(nums);
        assertArrayEquals(new int[]{0,0,1,1,2,2}, nums);
    }

}