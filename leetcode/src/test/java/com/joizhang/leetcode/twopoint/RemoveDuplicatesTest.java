package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesTest {

    @Test
    public void removeDuplicates() {
        int[] nums = new int[]{1, 1, 2};
        assertEquals(2, new RemoveDuplicates().removeDuplicates(nums));
        assertArrayEquals(new int[]{1, 2, 2}, nums);

        nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        assertEquals(5, new RemoveDuplicates().removeDuplicates(nums));
        assertArrayEquals(new int[]{0, 1, 2, 3, 4, 2, 2, 3, 3, 4}, nums);

        nums = new int[]{1, 1};
        assertEquals(1, new RemoveDuplicates().removeDuplicates(nums));
        assertArrayEquals(new int[]{1, 1}, nums);
    }
}