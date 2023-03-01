package com.joizhang.concurrent;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    private static final ExecutorService SERVICE = new ThreadPoolExecutor(
            4,
            10,
            0, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(50),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            int finalI = i;
            SERVICE.execute(() -> {
                System.out.println("Hello" + finalI);
            });
        }
        SERVICE.shutdown();
    }

}

