package com.joizhang.leetcode.stack;

import org.junit.Test;

import static org.junit.Assert.*;

public class MyQueueTest {

    @Test
    public void test() {
        MyQueue myQueue = new MyQueue();
        assertTrue(myQueue.empty());

        myQueue.push(1);
        assertEquals(1, myQueue.peek());

        myQueue.push(2);
        assertEquals(1, myQueue.peek());

        myQueue.push(3);
        assertEquals(1, myQueue.peek());

        myQueue.push(4);
        assertEquals(1, myQueue.peek());

        myQueue.push(5);
        assertEquals(1, myQueue.peek());

        assertEquals(1, myQueue.pop());
        assertEquals(2, myQueue.pop());
        assertEquals(3, myQueue.pop());
        assertEquals(4, myQueue.pop());
        assertEquals(5, myQueue.pop());
    }

}