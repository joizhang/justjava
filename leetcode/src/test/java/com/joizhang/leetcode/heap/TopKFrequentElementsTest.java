package com.joizhang.leetcode.heap;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;

public class TopKFrequentElementsTest {

    @Test
    public void topKFrequent() {
        int[] arr = {4, 1, -1, 2, -1, 2, 3};
        List<Integer> integers = new TopKFrequentElements().topKFrequent(arr, 2);
        Integer[] a = new Integer[integers.size()];
        integers.toArray(a);
        assertArrayEquals(new Integer[]{-1, 2}, a);
    }

}