package com.joizhang.leetcode.linkedlist;

/**
 * 147. Insertion Sort List
 *
 * @author joizhang
 */
class InsertionSortList {

    public ListNode insertionSortList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode helper = new ListNode(0);
        ListNode pre = helper;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            while (pre.next != null && cur.val > pre.next.val) {
                pre = pre.next;
            }
            cur.next = pre.next;
            pre.next = cur;
            pre = helper;
            cur = next;
        }
        return helper.next;
    }

}
