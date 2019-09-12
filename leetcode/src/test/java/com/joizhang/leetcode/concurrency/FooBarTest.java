package com.joizhang.leetcode.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class FooBarTest {

    @Test
    public void testFooBar() {
        FooBar fooBar = new FooBar(2);
        Runnable a = () -> {
            try {
                fooBar.foo(() -> System.out.print("foo"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable b = () -> {
            try {
                fooBar.bar(() -> System.out.print("bar"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(a);
        executorService.execute(b);
    }

}