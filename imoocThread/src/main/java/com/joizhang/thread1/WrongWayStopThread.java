package com.joizhang.thread1;

/**
 * Created by joizhang on 16-10-3.
 */
public class WrongWayStopThread extends Thread {
    public static void main(String[] args) {
        WrongWayStopThread thread = new WrongWayStopThread();
        System.out.println("Starting thread...");
        thread.start();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Interrupting thread...");
        thread.interrupt();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Stopping application...");
    }

    @Override
    public void run() {
        while (!this.isInterrupted()) {
            System.out.println("Thread is running...");
            /*long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time) < 1000) {
            }*/

            //无法停止
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //减少屏幕输出的空循环
        }
        /*while (true) {
            System.out.println("Thread is running...");
            long time = System.currentTimeMillis();
            while ((System.currentTimeMillis() - time) < 1000) {
            }
            //减少屏幕输出的空循环
        }*/
    }
}
