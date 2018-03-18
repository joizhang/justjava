package com.joizhang.concurrent;

/**
 * 测试线程可见性问题
 * @author joizhang
 */
public class VisibilityOfMemo extends Thread {

    // 注意比较变量加volatile关键字前后的区别
//	private boolean stop = false;
    private volatile boolean stop = false;

    @Override
    public void run() {
        int count = 0;
        System.out.println("开始计数：" + count);
        while(!stop){
            count++;
        }
        System.out.println("结束计数：" + count);
    }

    /**
     * 停止计数
     */
    private void stopCount(){
        this.stop = true;
    }

    /**
     * @return true-已停止计数；false-未停止计数
     */
    private boolean isStop(){
        return stop;
    }

    public static void main(String[] args) throws InterruptedException {

        VisibilityOfMemo t = new VisibilityOfMemo();
        t.start();

        // 确保测试线程已启动
        Thread.sleep(1000);

        t.stopCount();

        // 确保测试线程执行完毕
        Thread.sleep(1000);

        System.out.println("计数线程中的stop值为：" + t.isStop());

    }

}
