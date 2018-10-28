package com.joizhang.imooc.datastructure;

/**
 * 最小堆
 *
 * @param <E>
 * @author joizhang
 */
public class MinHeap<E extends Comparable<E>> implements Heap<E> {

    private Array<E> data;

    public MinHeap() {
        data = new Array<>();
    }

    public MinHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MinHeap(E[] arr) {
        data = new Array<>(arr);
        for (int i = parent(arr.length - 1); i >= 0; i--) {
            shiftDown(i);
        }
    }

    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent");
        }
        return (index - 1) / 2;
    }

    private int leftChild(int index) {
        return index * 2 + 1;
    }

    private int rightChild(int index) {
        return index * 2 + 2;
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 添加元素
     */
    @Override
    public void add(E e) {
        data.addLast(e);
        shiftUp(data.getSize() - 1);
    }

    /**
     * 上浮
     */
    private void shiftUp(int k) {
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) < 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 看堆中的最小元素
     */
    @Override
    public E getElement() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Cannot find minimum when heap is empty!");
        }
        return data.get(0);
    }

    /**
     * 取出堆中的最小元素
     */
    @Override
    public E extractElement() {
        E ret = extractElement(data);
        shiftDown(0);
        return ret;
    }

    /**
     * 下沉，和孩子节点中最小的元素交换
     */
    private void shiftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) < 0) {
                j = rightChild(k);
            }
            // data[j] 是 leftChild 和 rightChild 中的最大值
            if (data.get(k).compareTo(data.get(j)) <= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

}
