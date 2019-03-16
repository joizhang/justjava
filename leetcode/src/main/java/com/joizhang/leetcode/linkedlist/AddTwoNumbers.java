package com.joizhang.leetcode.linkedlist;

/**
 * 2. Add Two Numbers
 *
 * @author joizhang
 */
class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = l1;
        int a = 0;
        int sum;
        while (l1.next != null && l2.next != null) {
            sum = l1.val + l2.val + a;
            l1.val = sum % 10;
            a = sum / 10;
            l1 = l1.next;
            l2 = l2.next;
        }

        sum = l1.val + l2.val + a;
        l1.val = sum % 10;
        a = sum / 10;
        if (l1.next != null && l2.next == null) {
            l1 = l1.next;
        } else if (l1.next == null && l2.next != null) {
            l1.next = l2.next;
            l2.next = null;
            l1 = l1.next;
        } else if (l1.next == null && l2.next == null) {
            if (a != 0) {
                l1.next = new ListNode(a);
            }
            return res;
        }

        while (a != 0) {
            sum = l1.val + a;
            l1.val = sum % 10;
            a = sum / 10;
            if (l1.next == null) {
                if (a != 0) {
                    l1.next = new ListNode(a);
                }
                break;
            }
            l1 = l1.next;
        }

        return res;
    }

}
