package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class InsertionSortListTest {

    @Test
    public void insertionSortList() {
        ListNode head = new ListNode(new int[]{1, 3, 4, 2, 5});
        InsertionSortList insertionSortList = new InsertionSortList();
        insertionSortList.insertionSortList(head);
        System.out.println(head);
    }
}