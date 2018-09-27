package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

public class RemoveLinkedListElementsTest {

    @Test
    public void removeElements() {
        int[] nums = {1, 2, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        ListNode res = new RemoveLinkedListElements().removeElements(head, 1);
        System.out.println(res);
    }
}