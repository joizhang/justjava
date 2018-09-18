package com.joizhang.imooc.algorithms;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FibonacciTest {

    @Test
    public void fib() {
        int n = 40;
        Fibonacci fibonacci = new Fibonacci(n);
        assertEquals(102334155, fibonacci.fib(n));

        Fibonacci fibonacci2 = new Fibonacci(n);
        assertEquals(102334155, fibonacci2.fib2(n));
    }

}