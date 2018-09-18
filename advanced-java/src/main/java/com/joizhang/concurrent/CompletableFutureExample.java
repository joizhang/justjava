package com.joizhang.concurrent;

import java.util.concurrent.*;

/**
 * @author joizhang
 */
public class CompletableFutureExample {

    private static final ExecutorService EXECUTOR_SERVICE = new ThreadPoolExecutor(5, 5, 3000L,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<>(200),
            r -> new Thread(r, "my-tread"),
            new ThreadPoolExecutor.AbortPolicy());

    public Future<String> calculateAsync() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();
        EXECUTOR_SERVICE.submit(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            completableFuture.complete("Hello");
            return null;
        });
        return completableFuture;
    }

    public Future<String> calculateAsyncWithCancellation() {
        CompletableFuture<String> completableFuture = new CompletableFuture<>();

        Executors.newCachedThreadPool().submit(() -> {
            TimeUnit.MILLISECONDS.sleep(1000);
            completableFuture.cancel(false);
            return null;
        });

        return completableFuture;
    }

}
