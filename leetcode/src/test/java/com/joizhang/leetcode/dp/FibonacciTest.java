package com.joizhang.leetcode.dp;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void fib() {
        assertEquals(0, new Fibonacci().fib(0));
        assertEquals(1, new Fibonacci().fib(2));
        assertEquals(2, new Fibonacci().fib(3));
        assertEquals(3, new Fibonacci().fib(4));

        assertEquals(1, new Fibonacci().fib2(2));
        assertEquals(2, new Fibonacci().fib2(3));
        assertEquals(3, new Fibonacci().fib2(4));
    }

}