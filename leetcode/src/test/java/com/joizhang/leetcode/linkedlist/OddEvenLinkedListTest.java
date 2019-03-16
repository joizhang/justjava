package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class OddEvenLinkedListTest {

    @Test
    public void oddEvenList() {
        assertEquals(new ListNode(new int[]{1, 3, 5, 2, 4}), new OddEvenLinkedList().oddEvenList(new ListNode(new int[]{1, 2, 3, 4, 5})));
        assertEquals(new ListNode(new int[]{1}), new OddEvenLinkedList().oddEvenList(new ListNode(new int[]{1})));
        assertEquals(new ListNode(new int[]{1, 2}), new OddEvenLinkedList().oddEvenList(new ListNode(new int[]{1, 2})));
        assertEquals(new ListNode(new int[]{2, 3, 6, 7, 1, 5, 4}), new OddEvenLinkedList().oddEvenList(new ListNode(new int[]{2, 1, 3, 5, 6, 4, 7})));
    }
}