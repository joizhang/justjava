package com.joizhang.leetcode.concurrency;

import java.util.concurrent.Semaphore;

/**
 * @author joizhang
 */
class FooBar {

    private Semaphore s1;
    private Semaphore s2;

    private int n;

    public FooBar(int n) {
        this.n = n;
        this.s1 = new Semaphore(0);
        this.s2 = new Semaphore(1);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printFoo.run() outputs "foo". Do not change or remove this line.
            this.s2.acquire();
            printFoo.run();
            this.s1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            // printBar.run() outputs "bar". Do not change or remove this line.
            this.s1.acquire();
            printBar.run();
            this.s2.release();
        }
    }

}
