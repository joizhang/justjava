package com.joizhang.leetcode.linkedlist;

/**
 * Sort a linked list using merge sort.
 *
 * @author joizhang
 */
public class MergeSortList {

    public ListNode mergeSortList(ListNode head) {
        ListNode p = head;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }
        for (int sz = 1; sz < n; sz += sz) {
            for (int i = 0; i < n; i += sz * 2) {
                //if ()
            }
        }
        return head;
    }

}
