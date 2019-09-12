package com.joizhang.leetcode.concurrency;

import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

public class ZeroEvenOddTest {

    @Test
    public void testZeroEvenOdd() throws InterruptedException {
        ZeroEvenOdd zeroEvenOdd = new ZeroEvenOdd(2);
        Runnable a = ()-> {
            try {
                zeroEvenOdd.zero(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable b = ()-> {
            try {
                zeroEvenOdd.even(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        Runnable c = ()-> {
            try {
                zeroEvenOdd.odd(System.out::print);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(a);
        executorService.execute(b);
        executorService.execute(c);
        TimeUnit.SECONDS.sleep(1);
    }

}