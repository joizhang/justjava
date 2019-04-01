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
    private ArrayList<E> data;

    /**
     * 最大索引堆中的索引
     */
    private ArrayList<Integer> indexes;

    public IndexMaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
        indexes = new ArrayList<>(capacity);
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
