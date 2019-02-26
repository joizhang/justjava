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
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
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
