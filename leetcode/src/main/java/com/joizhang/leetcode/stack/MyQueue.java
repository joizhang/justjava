package com.joizhang.leetcode.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 232. Implement Queue using Stacks
 *
 * @author joizhang
 */
class MyQueue {

    private Deque<Integer> inputStack;

    private Deque<Integer> outputStack;

    /**
     * Initialize your data structure here.
     */
    public MyQueue() {
        inputStack = new ArrayDeque<>();
        outputStack = new ArrayDeque<>();
    }

    /**
     * Push element x to the back of queue.
     */
    public void push(int x) {
        while (!outputStack.isEmpty()) {
            inputStack.addLast(outputStack.removeLast());
        }
        inputStack.addLast(x);
    }

    /**
     * Removes the element from in front of queue and returns that element.
     */
    public int pop() {
        while (!inputStack.isEmpty()) {
            outputStack.addLast(inputStack.removeLast());
        }
        return outputStack.removeLast();
    }

    /**
     * Get the front element.
     */
    public int peek() {
        while (!inputStack.isEmpty()) {
            outputStack.addLast(inputStack.removeLast());
        }
        return outputStack.getLast();
    }

    /**
     * Returns whether the queue is empty.
     */
    public boolean empty() {
        return inputStack.isEmpty() && outputStack.isEmpty();
    }

}
