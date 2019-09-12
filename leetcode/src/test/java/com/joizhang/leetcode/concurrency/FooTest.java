package com.joizhang.leetcode.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.Assert.*;

public class FooTest {

    @Test
    public void testFoo() {
        Foo foo = new Foo();
        Runnable a = () -> {
            try {
                foo.first(() -> System.out.print("first"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable b = () -> {
            try {
                foo.second(() -> System.out.print("second"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable c = () -> {
            try {
                foo.third(() -> System.out.print("third"));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(a);
        executorService.execute(b);
        executorService.execute(c);
    }

}