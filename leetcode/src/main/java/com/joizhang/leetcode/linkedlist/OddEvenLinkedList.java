package com.joizhang.leetcode.linkedlist;

/**
 * 328. Odd Even Linked List
 *
 * @author joizhang
 */
 class OddEvenLinkedList {

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode oddTail = head;
        ListNode evenTail = head.next;
        while (evenTail != null && evenTail.next != null) {
            ListNode evenHead = oddTail.next;
            oddTail.next = evenTail.next;
            evenTail.next = evenTail.next.next;
            oddTail.next.next = evenHead;
            oddTail = oddTail.next;
            evenTail = evenTail.next;
        }
        return head;
    }

}
