package com.joizhang.leetcode.twopoint;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

public class RemoveElementTest {

    @Test
    public void removeElement() {
        int[] nums = new int[]{3, 2, 2, 3};
        assertEquals(2, new RemoveElement().removeElement(nums, 3));
        assertArrayEquals(new int[]{2, 2, 2, 3}, nums);

        nums = new int[]{0,1,2,2,3,0,4,2};
        assertEquals(5, new RemoveElement().removeElement(nums, 2));
        assertArrayEquals(new int[]{0,1,3,0,4,0,4,2}, nums);
    }
}