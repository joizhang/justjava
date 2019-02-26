package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicatesFromSortedListTest {

    @Test
    public void deleteDuplicates() {
        assertEquals(new ListNode(new int[]{1, 2}), new RemoveDuplicatesFromSortedList().deleteDuplicates(new ListNode(new int[]{1, 1, 2})));
        assertEquals(new ListNode(new int[]{1, 2, 3}), new RemoveDuplicatesFromSortedList().deleteDuplicates(new ListNode(new int[]{1, 1, 2, 3, 3})));
        assertEquals(new ListNode(new int[]{1}), new RemoveDuplicatesFromSortedList().deleteDuplicates(new ListNode(new int[]{1, 1, 1})));
    }
}