package com.joizhang.leetcode.linkedlist;

import java.util.Objects;

class ListNode {

    int val;

    ListNode next;

    ListNode(int x) {
        val = x;
    }

    ListNode(int[] arr) {
        if (arr == null || arr.length == 0) {
            throw new IllegalArgumentException("arr can not be empty");
        }
        this.val = arr[0];
        ListNode cur = this;
        for (int i = 1; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ListNode listNode = (ListNode) o;
        if (val != listNode.val) {
            return false;
        }
        ListNode thisNodeCur = next;
        ListNode thatNodeCur = listNode.next;
        while (thisNodeCur != null && thatNodeCur != null) {
            if (thisNodeCur.val != thatNodeCur.val) {
                return false;
            }
            thisNodeCur = thisNodeCur.next;
            thatNodeCur = thatNodeCur.next;
        }
        return thisNodeCur == null && thatNodeCur == null;
    }

    @Override
    public int hashCode() {
        return Objects.hash(val, next);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListNode cur = this;
        while (cur != null) {
            stringBuilder.append(cur.val).append("->");
            cur = cur.next;
        }
        stringBuilder.append("null");
        return stringBuilder.toString();
    }
}
