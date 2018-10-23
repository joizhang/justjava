package com.joizhang.imooc.datastructure;

/**
 * 最大索引堆
 *
 * @author joizhang
 */
public class IndexMaxHeap<E extends Comparable<E>> implements Heap<E> {

    /**
     * 最大索引堆中的数据
     */
    private Array<E> data;

    /**
     * 最大索引堆中的索引
     */
    private Array<Integer> indexes;

    public IndexMaxHeap(int capacity) {
        data = new Array<>(capacity);
        indexes = new Array<>(capacity);
    }


    @Override
    public void add(E e) {

    }

    @Override
    public E getElement() {
        return null;
    }

    @Override
    public E extractElement() {
        return null;
    }

}
