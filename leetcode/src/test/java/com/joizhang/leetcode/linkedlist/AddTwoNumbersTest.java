package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class AddTwoNumbersTest {

    @Test
    public void addTwoNumbers() {
        ListNode l1 = new ListNode(new int[]{2, 4, 3});
        ListNode l2 = new ListNode(new int[]{5, 6, 4});
        assertEquals(new ListNode(new int[]{7, 0, 8}), new AddTwoNumbers().addTwoNumbers(l1, l2));

        l1 = new ListNode(new int[]{9});
        l2 = new ListNode(new int[]{1});
        assertEquals(new ListNode(new int[]{0, 1}), new AddTwoNumbers().addTwoNumbers(l1, l2));

        l1 = new ListNode(new int[]{1});
        l2 = new ListNode(new int[]{9, 9, 9});
        assertEquals(new ListNode(new int[]{0, 0, 0, 1}), new AddTwoNumbers().addTwoNumbers(l1, l2));

        l1 = new ListNode(new int[]{9, 8});
        l2 = new ListNode(new int[]{1});
        assertEquals(new ListNode(new int[]{0, 9}), new AddTwoNumbers().addTwoNumbers(l1, l2));
    }
}