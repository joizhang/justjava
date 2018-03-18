package com.joizhang.imooc.hotload;

import java.util.concurrent.TimeUnit;

/**
 * 后台启动线程不停刷新重新加载
 *
 * @author joizhang
 */
public class MsgHandler implements Runnable {

    @Override
    public void run() {
        while (true) {
            BaseManager manager = ManagerFactory.getManager(ManagerFactory.MY_MANAGER);
            manager.logic();
            try {
                TimeUnit.MILLISECONDS.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

}
