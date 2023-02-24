package com.joizhang.concurrent;

import java.util.concurrent.*;

public class ExecutorServiceDemo {

    private static  final ExecutorService SERVICE = new ThreadPoolExecutor(
            4,
            10,
            0, TimeUnit.SECONDS,
            new LinkedBlockingDeque<>(50),
            Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.AbortPolicy());

    public static void main(String[] args) {
        SERVICE.submit(()->{
            System.out.println("Hello");
        });
        SERVICE.shutdown();
    }

}

