package com.joizhang.nettydefinitiveguide.bio;

import com.google.common.util.concurrent.ThreadFactoryBuilder;

import java.util.concurrent.*;

/**
 * @author joizhang
 */
public class TimeServerHandlerExecutePool {

    private ExecutorService executor;

    TimeServerHandlerExecutePool(int maxPoolSize, int queueSize) {
        ThreadFactory namedThreadFactory = new ThreadFactoryBuilder().setNameFormat("demo-pool-%d").build();
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxPoolSize,
                120L,
                TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(queueSize),
                namedThreadFactory, new ThreadPoolExecutor.AbortPolicy());
    }

    public void execute(Runnable task) {
        executor.execute(task);
    }

}
