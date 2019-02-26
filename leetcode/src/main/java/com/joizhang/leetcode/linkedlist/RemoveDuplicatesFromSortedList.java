package com.joizhang.leetcode.linkedlist;

/**
 * 83. Remove Duplicates from Sorted List
 *
 * @author joizhang
 */
class RemoveDuplicatesFromSortedList {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode next = cur.next;
        while (next != null) {
            if (cur.val == next.val) {
                cur.next = next.next;
            } else {
                cur = cur.next;
            }
            next = cur.next;
        }
        return head;
    }

}
