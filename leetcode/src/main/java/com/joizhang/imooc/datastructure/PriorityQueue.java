package com.joizhang.imooc.datastructure;

/**
 * 基于最大堆实现的优先队列
 *
 * @param <E>
 * @author joizhang
 */
public class PriorityQueue<E extends Comparable<E>> implements Queue<E> {

    private MaxHeap<E> maxHeap;

    public PriorityQueue() {
        maxHeap = new MaxHeap<>();
    }

    @Override
    public int getSize() {
        return maxHeap.size();
    }

    @Override
    public boolean isEmpty() {
        return maxHeap.isEmpty();
    }

    @Override
    public void enqueue(E e) {
        maxHeap.add(e);
    }

    @Override
    public E dequeue() {
        return maxHeap.extractElement();
    }

    @Override
    public E getFront() {
        return maxHeap.getElement();
    }

}
