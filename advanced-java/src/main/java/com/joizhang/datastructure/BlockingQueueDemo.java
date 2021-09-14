package com.joizhang.datastructure;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.*;

class MyBlockingQueue<T> {
    private final int capacity;

    private final Queue<T> queue = new LinkedList<>();

    public MyBlockingQueue() {
        this(Integer.MAX_VALUE);
    }

    public MyBlockingQueue(int capacity) {
        this.capacity = capacity;
    }

    public int size() {
        return queue.size();
    }

    public synchronized void add(T element) throws InterruptedException {
        while (queue.size() == capacity) {
            wait();
        }
        queue.add(element);
        notify();
    }

    public synchronized T remove() throws InterruptedException {
        while (queue.size() == 0) {
            wait();
        }
        T element = queue.remove();
        notify();
        return element;
    }
}

public class BlockingQueueDemo<T> {

    public static void main(String[] args) {
        MyBlockingQueue<Object> queue = new MyBlockingQueue<>(5);

        ExecutorService service = new ThreadPoolExecutor(
                5,
                5,
                0,
                TimeUnit.SECONDS, new LinkedBlockingDeque<>(50),
                Executors.defaultThreadFactory(),
                new ThreadPoolExecutor.AbortPolicy());
        new Thread(() -> {
            while (true) {
                try {
                    queue.add(new Object());
                    System.out.println("produce one new object, queue size is: " + queue.size());
                    TimeUnit.MILLISECONDS.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "demo.BlockingQueueDemo-producer").start();

        for (int i = 0; i < 5; i++) {
            service.submit(() -> {
                while (true) {
                    try {
                        Object object = queue.remove();
                        System.out.println(Thread.currentThread().getName() + " consume object" + object + "queue size is: " + queue.size());
                        int timeout  = new Random().nextInt(6);
                        TimeUnit.SECONDS.sleep(timeout);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
        }
    }

}
