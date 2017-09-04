package com.joizhang.thread1.base;

/**
 * 隋唐演义大戏舞台
 */
public class Stage extends Thread {

    public void run() {
        System.out.println("欢迎观看隋唐演义");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("大幕徐徐拉开");

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("话说隋朝末年，隋军与农民起义军杀的昏天黑地...");


        ArmyRunnable armyTaskOfSuiDynasty = new ArmyRunnable();
        ArmyRunnable armyTaskOfRevolt = new ArmyRunnable();

        Thread armyOfSuiDynasty = new Thread(armyTaskOfSuiDynasty, "隋军");
        Thread armyOfRevolt = new Thread(armyTaskOfRevolt, "农民起义军");

        //启动线程，让军队开始作战
        armyOfSuiDynasty.start();
        armyOfRevolt.start();

        //舞台线程休眠大家专心观看军队厮杀
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("正当双方激战正酣，半路杀出了个程咬金");
        Thread mrCheng = new KeyPersonThread();
        mrCheng.setName("程咬金");
        System.out.println("程咬金的理想是结束战争，使百姓安居乐业");

        //军队停止作战
        armyTaskOfSuiDynasty.keepRunning = false;
        armyTaskOfRevolt.keepRunning = false;
        //错误的停止方法
        /*armyOfSuiDynasty.stop();
        armyOfRevolt.stop();*/

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        mrCheng.start();
        //所有线程等待mrCheng结束
        try {
            mrCheng.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("战争结束，任命安居乐业，程咬金实现了梦想，为人民做出了贡献");
        System.out.println("谢谢观看隋唐演义，再见");
    }

    public static void main(String[] args) {
        new Stage().start();
    }
}
