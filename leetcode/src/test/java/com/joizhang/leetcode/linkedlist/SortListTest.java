package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

public class SortListTest {

    @Test
    public void sortList() {
        int[] nums = {4, 2, 1, 3};
        ListNode head = new ListNode(nums);
        ListNode res = new SortList().sortList(head);
        System.out.println(res);
    }
}