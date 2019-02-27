package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class PartitionListTest {

    @Test
    public void partition() {
        assertEquals(new ListNode(new int[]{1, 2, 2, 4, 3, 5}), new PartitionList().partition(new ListNode(new int[]{1, 4, 3, 2, 5, 2}), 3));
        assertEquals(new ListNode(new int[]{1, 2, 3}), new PartitionList().partition(new ListNode(new int[]{3, 1, 2}), 3));
    }
}