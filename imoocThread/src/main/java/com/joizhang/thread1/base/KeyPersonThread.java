package com.joizhang.thread1.base;

/**
 * Created by joizhang on 16-8-8.
 */
public class KeyPersonThread extends Thread {

    public void run() {
        System.out.println(Thread.currentThread().getName() + "开始了战斗");

        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + "左突优杀，攻击隋军...");
        }

        System.out.println(Thread.currentThread().getName() + "结束了战斗");
    }
}
