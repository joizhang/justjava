package com.joizhang.concurrent;

import org.junit.Test;

import java.util.concurrent.*;

import static org.junit.Assert.*;

public class CompletableFutureExampleTest {

    private CompletableFutureExample completableFutureExample = new CompletableFutureExample();

    @Test
    public void calculateAsync() throws ExecutionException, InterruptedException {
        Future<String> stringFuture = completableFutureExample.calculateAsync();
        String result = stringFuture.get();
        assertEquals("Hello", result);
    }

    @Test(expected = CancellationException.class)
    public void calculateAsyncWithCancellation() throws ExecutionException, InterruptedException {
        Future<String> stringFuture = completableFutureExample.calculateAsyncWithCancellation();
        String result = stringFuture.get();
        assertEquals("Hello", result);
    }

    @Test
    public void encapsulated() throws ExecutionException, InterruptedException {
        CompletableFuture<String> future = CompletableFuture.supplyAsync(() -> "Hello");
        assertEquals("Hello", future.get());
    }

    @Test
    public void asynchronousComputations() throws ExecutionException, InterruptedException {
        long startTime = System.nanoTime();
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        CompletableFuture<String> future = completableFuture.thenApply(s -> {
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return s + " World";
        });
        assertEquals("Hello World", future.get());
        long endTime = (System.nanoTime() - startTime) / 1000000000;
        System.out.println(endTime);
        assertEquals(3, endTime);
    }

    @Test
    public void synchronousComputations() throws ExecutionException, InterruptedException {
        long startTime = System.nanoTime();
        CompletableFuture<String> future1 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "Hello";
        });
        CompletableFuture<String> future2 = CompletableFuture.supplyAsync(() -> {
            try {
                TimeUnit.SECONDS.sleep(5);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return "World";
        });
        CompletableFuture<Void> combinedFuture = CompletableFuture.allOf(future1, future2);
        combinedFuture.get();
        assertTrue(future1.isDone());
        assertTrue(future2.isDone());
        long endTime = (System.nanoTime() - startTime) / 1000000000;
        System.out.println(endTime);
        assertEquals(5, endTime);
    }

}