package com.joizhang.leetcode.linkedlist;

/**
 * 203 Remove all elements from a linked list of integers that have value val.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }
        ListNode prev = head;
        while(prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return head;
    }

    /**
     * 使用虚拟头节点
     */
    public ListNode removeElements2(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while(prev.next != null) {
            if (prev.next.val == val) {
                prev.next = prev.next.next;
            } else {
                prev = prev.next;
            }
        }
        return dummyHead.next;
    }

    /**
     * 递归
     */
    public ListNode removeElements3(ListNode head, int val) {
        if(head == null){
            return null;
        }

//        ListNode res = removeElements3(head.next, val);
//        if (head.val == val){
//            return res;
//        } else {
//            head.next = res;
//            return head;
//        }

        head.next = removeElements3(head.next, val);
        return head.val == val ? head.next : head;
    }
}
