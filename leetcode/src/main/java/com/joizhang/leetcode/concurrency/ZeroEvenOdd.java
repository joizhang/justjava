package com.joizhang.leetcode.concurrency;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

/**
 * @author joizhang
 */
class ZeroEvenOdd {

    private int n;

    private Semaphore zero;
    private Semaphore odd;
    private Semaphore even;

    public ZeroEvenOdd(int n) {
        this.n = n;
        this.zero = new Semaphore(1);
        this.odd = new Semaphore(0);
        this.even = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            this.zero.acquire();
            printNumber.accept(0);
            if (i % 2 != 0) {
                this.odd.release();
            } else {
                this.even.release();
            }
        }
    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i+=2) {
            this.even.acquire();
            printNumber.accept(i);
            this.zero.release();
        }

    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i+=2) {
            this.odd.acquire();
            printNumber.accept(i);
            this.zero.release();
        }
    }

}