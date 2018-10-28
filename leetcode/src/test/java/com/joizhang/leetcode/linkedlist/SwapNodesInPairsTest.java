package com.joizhang.leetcode.linkedlist;

import org.junit.Test;

import static org.junit.Assert.*;

public class SwapNodesInPairsTest {

    @Test
    public void swapPairs() {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
//        ListNode head1 = new ListNode(new int[]{});
//        System.out.println(swapNodesInPairs.swapPairs(head1));

        ListNode head2 = new ListNode(new int[]{1});
        System.out.println(swapNodesInPairs.swapPairs(head2));

        ListNode head3 = new ListNode(new int[]{1, 2});
        System.out.println(swapNodesInPairs.swapPairs(head3));

        ListNode head4 = new ListNode(new int[]{1, 2, 3});
        System.out.println(swapNodesInPairs.swapPairs(head4));

        ListNode head5 = new ListNode(new int[]{1, 2, 3, 4});
        System.out.println(swapNodesInPairs.swapPairs(head5));

        ListNode head6 = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(swapNodesInPairs.swapPairs(head6));
    }

    @Test
    public void swapPairs2() {
        SwapNodesInPairs swapNodesInPairs = new SwapNodesInPairs();
        ListNode head6 = new ListNode(new int[]{1, 2, 3, 4, 5});
        System.out.println(swapNodesInPairs.swapPairs2(head6));
    }

}