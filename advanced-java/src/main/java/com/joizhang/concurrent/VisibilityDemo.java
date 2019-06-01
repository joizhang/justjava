package com.joizhang.concurrent;

/**
 * 并发问题源头之一：缓存导致的可见性问题
 *
 * @author joizhang
 */
public class VisibilityDemo {

    private static long count = 0;

    private void add10K() {
        int idx = 0;
        while (idx++ < 10000) {
            count += 1;
        }
    }

    public static long calc() throws InterruptedException {
        final VisibilityDemo test = new VisibilityDemo();
        // 创建两个线程，执行 add() 操作
        Thread th1 = new Thread(() -> {
            test.add10K();
        });
        Thread th2 = new Thread(() -> {
            test.add10K();
        });
        // 启动两个线程
        th1.start();
        th2.start();
        // 等待两个线程执行结束
        th1.join();
        th2.join();
        return count;
    }

    public static void main(String[] args) {
        try {
            System.out.println(VisibilityDemo.calc());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
