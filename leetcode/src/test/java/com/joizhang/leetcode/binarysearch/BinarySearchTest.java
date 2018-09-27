package com.joizhang.leetcode.binarysearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void search() {
        assertEquals(4, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
        assertEquals(-1, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 13));
    }
}