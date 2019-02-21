package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class ArrayStackTest {

    @Test
    public void testStack() {
        Stack<Integer> stack = new ArrayStack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        assertEquals(Integer.valueOf(3), stack.peek());
        assertEquals(Integer.valueOf(3), stack.pop());
        assertEquals(Integer.valueOf(2), stack.pop());
        assertEquals(Integer.valueOf(1), stack.pop());
    }

}