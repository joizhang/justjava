package com.joizhang.leetcode.sort;

import com.joizhang.leetcode.sort.KthLargestElement;
import org.junit.Test;

import static org.junit.Assert.*;

public class KthLargestElementTest {

    @Test
    public void findKthLargest() {
        assertEquals(5, new KthLargestElement().findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        assertEquals(4, new KthLargestElement().findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
        assertEquals(1, new KthLargestElement().findKthLargest(new int[]{2,1}, 2));
    }
}