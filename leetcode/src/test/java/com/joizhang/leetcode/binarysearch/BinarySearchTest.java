package com.joizhang.leetcode.binarysearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearchTest {

    @Test
    public void search() {
        assertEquals(0, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, -1));
        assertEquals(1, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 0));
        assertEquals(2, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 3));
        assertEquals(3, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 5));
        assertEquals(4, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(5, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 12));
        assertEquals(-1, new BinarySearch().search(new int[]{-1, 0, 3, 5, 9, 12}, 4));
    }

    @Test
    public void search2() {
        assertEquals(0, new BinarySearch().search2(new int[]{-1, 0, 3, 5, 9, 12}, -1));
        assertEquals(1, new BinarySearch().search2(new int[]{-1, 0, 3, 5, 9, 12}, 0));
        assertEquals(2, new BinarySearch().search2(new int[]{-1, 0, 3, 5, 9, 12}, 3));
        assertEquals(3, new BinarySearch().search2(new int[]{-1, 0, 3, 5, 9, 12}, 5));
        assertEquals(4, new BinarySearch().search2(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(5, new BinarySearch().search2(new int[]{-1, 0, 3, 5, 9, 12}, 12));
        assertEquals(-1, new BinarySearch().search2(new int[]{-1, 0, 3, 5, 9, 12}, 4));
    }
}