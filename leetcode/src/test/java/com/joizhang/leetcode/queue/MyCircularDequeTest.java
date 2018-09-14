package com.joizhang.leetcode.queue;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyCircularDequeTest {

    @Test
    public void testEmptyDeque() {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        assertTrue(circularDeque.isEmpty());
        assertEquals(-1, circularDeque.getFront());
        assertEquals(-1, circularDeque.getRear());
    }

    @Test
    public void testInsertLast() {
        MyCircularDeque circularDeque = new MyCircularDeque(3);

        // insert 1
        assertTrue(circularDeque.insertLast(1));
        assertEquals(1, circularDeque.getFront());
        assertEquals(1, circularDeque.getRear());

        // insert 2
        assertTrue(circularDeque.insertLast(2));
        assertEquals(2, circularDeque.getRear());

        // insert 3
        assertTrue(circularDeque.insertLast(3));
        assertEquals(3, circularDeque.getRear());

        // insert 4 fail
        assertFalse(circularDeque.insertLast(4));

        // is full
        assertTrue(circularDeque.isFull());

        // delete 1, 2, 3
        assertTrue(circularDeque.deleteLast());
        assertTrue(circularDeque.deleteLast());
        assertTrue(circularDeque.deleteLast());
        // delete fail
        assertFalse(circularDeque.deleteLast());
        // is empty
        assertTrue(circularDeque.isEmpty());
    }

    @Test
    public void testInsertFront() {
        MyCircularDeque circularDeque = new MyCircularDeque(3);
        // insert 1
        assertTrue(circularDeque.insertFront(1));
        assertEquals(1, circularDeque.getFront());
        // insert 2
        assertTrue(circularDeque.insertFront(2));
        assertEquals(2, circularDeque.getFront());
        // insert 3
        assertTrue(circularDeque.insertFront(3));
        assertEquals(3, circularDeque.getFront());
        // insert 4 fail
        assertFalse(circularDeque.insertFront(4));

        assertTrue(circularDeque.deleteFront());
        assertTrue(circularDeque.deleteFront());
        assertTrue(circularDeque.deleteFront());
        assertFalse(circularDeque.deleteFront());
        assertTrue(circularDeque.isEmpty());
    }

}