package com.joizhang.leetcode.linkedlist;

/**
 * 206. Reverse Linked List
 *
 * @author joizhang
 */
class ReverseLinkedList {

    /**
     * iteratively
     */
    public ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode prev = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }

    /**
     * recursively
     */
    public ListNode reverseList2(ListNode head) {
        return reverse(head, null);
    }

    private ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null) {
            return newHead;
        }
        ListNode next = head.next;
        head.next = newHead;
        return reverse(next, head);
    }

}
