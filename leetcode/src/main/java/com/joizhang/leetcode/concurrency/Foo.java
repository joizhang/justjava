package com.joizhang.leetcode.concurrency;

import java.util.concurrent.Semaphore;

/**
 * 1114. Print in Order
 *
 * @author joizhang
 */
class Foo {

    private Semaphore run2;
    private Semaphore run3;

    public Foo() {
        this.run2 = new Semaphore(0);
        this.run3 = new Semaphore(0);
    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        this.run2.release();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        // printSecond.run() outputs "second". Do not change or remove this line.
        this.run2.acquire();
        printSecond.run();
        this.run3.release();
    }

    public void third(Runnable printThird) throws InterruptedException {
        // printThird.run() outputs "third". Do not change or remove this line.
        this.run3.acquire();
        printThird.run();
    }

}
