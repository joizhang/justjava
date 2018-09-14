package com.joizhang.leetcode.queue;

/**
 * 622. Design Circular Queue
 *
 * @author joizhang
 */
class MyCircularQueue {

    private int[] data;

    private int front;

    /**
     * 指向最后元素的后一位
     */
    private int tail;

    /**
     * Initialize your data structure here. Set the size of the queue to be k.
     */
    public MyCircularQueue(int k) {
        this.data = new int[k + 1];
        this.front = 0;
        this.tail = 0;
    }

    /**
     * Insert an element into the circular queue. Return true if the operation is successful.
     */
    public boolean enQueue(int value) {
        if (isFull()) {
            return false;
        }
        data[tail] = value;
        tail = (tail + 1) % data.length;
        return true;
    }

    /**
     * Delete an element from the circular queue. Return true if the operation is successful.
     */
    public boolean deQueue() {
        if (isEmpty()) {
            return false;
        }
        front = (front + 1) % data.length;
        return true;
    }

    /**
     * Get the front item from the queue.
     */
    public int Front() {
        if (isEmpty()) {
            return -1;
        }
        return data[front];
    }

    /**
     * Get the last item from the queue.
     */
    public int Rear() {
        if (isEmpty()) {
            return -1;
        }
        int end = tail != 0 ? tail - 1 : data.length - 1;
        return data[end];
    }

    /**
     * Checks whether the circular queue is empty or not.
     */
    public boolean isEmpty() {
        return front == tail;
    }

    /**
     * Checks whether the circular queue is full or not.
     */
    public boolean isFull() {
        return (tail + 1) % data.length == front;
    }

}
