package com.joizhang.leetcode.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularQueueTest {

    @Test
    public void test() {
        MyCircularQueue circularQueue = new MyCircularQueue(3);
        assertTrue(circularQueue.isEmpty());
        assertTrue(circularQueue.enQueue(1));
        assertTrue(circularQueue.enQueue(2));
        assertTrue(circularQueue.enQueue(3));
        assertFalse(circularQueue.enQueue(4));
        assertEquals(3, circularQueue.Rear());
        assertTrue(circularQueue.isFull());
        assertTrue(circularQueue.deQueue());
        assertTrue(circularQueue.enQueue(4));
        assertEquals(4, circularQueue.Rear());

        MyCircularQueue circularQueue2 = new MyCircularQueue(3);
        circularQueue2.enQueue(2);
        assertEquals(2, circularQueue2.Rear());
        assertEquals(2, circularQueue2.Front());
    }

}