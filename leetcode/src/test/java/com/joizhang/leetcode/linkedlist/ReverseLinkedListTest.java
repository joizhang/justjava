package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReverseLinkedListTest {

    @Test
    public void reverseList() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseLinkedList.reverseList(head));
    }

    @Test
    public void reverseList2() {
        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        ListNode head = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(reverseLinkedList.reverseList2(head));

    }
}