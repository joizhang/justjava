package com.joizhang.leetcode.linkedlist;

/**
 * 86. Partition List
 *
 * @author joizhang
 */
class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        while (slow.next != null && slow.next.val < x) {
            slow = slow.next;
        }
        ListNode fast = slow.next;
        while (fast != null && fast.next != null) {
            if (fast.next.val < x) {
                ListNode temp = fast.next;
                fast.next = fast.next.next;
                temp.next = slow.next;
                slow.next = temp;
                slow = slow.next;
            } else {
                fast = fast.next;
            }
        }
        return dummy.next;
    }

}
