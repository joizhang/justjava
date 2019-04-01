package com.joizhang.imooc.datastructure;

/**
 * <pre>
 * 最大堆
 * a) 二叉堆是一个完全二叉树
 * b) 堆中某个节点的值总是不大于其父节点的值（最大堆）
 * c) 不使用索引0：parent(i) = i / 2; left child(i) = 2 * i; right child(i) = 2 * i + 1
 * d) 使用索引0：parent(i) = (i - 1) / 2; left child(i) = 2 * i + 1; right child(i) = 2 * i + 2
 * <pre/>
 *
 * @author joizhang
 */
public class MaxHeap<E extends Comparable<E>> implements Heap<E> {

    private ArrayList<E> data;

    public MaxHeap() {
        data = new ArrayList<>();
    }

    public MaxHeap(int capacity) {
        data = new ArrayList<>(capacity);
    }

    /**
     * 将任意数组整理成堆的形状<br>
     * 1. 将n个元素逐个插入到一个空堆中，算法复杂度是O(nlogn)<br>
     * 2. heapify的过程，算法复杂度是O(n)
     */
    public MaxHeap(E[] arr) {
        data = new ArrayList<>(arr);
        // 从最后一个非叶子节点开始进行 shiftDown，最后一个非叶子节点为 parent(arr.length - 1)
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
        while (k > 0 && data.get(k).compareTo(data.get(parent(k))) > 0) {
            data.swap(k, parent(k));
            k = parent(k);
        }
    }

    /**
     * 看堆中的最大元素
     */
    @Override
    public E getElement() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Cannot find maximum when heap is empty!");
        }
        return data.get(0);
    }

    /**
     * 取出堆中的最大元素
     */
    @Override
    public E extractElement() {
        E ret = extractElement(data);
        shiftDown(0);
        return ret;
    }

    /**
     * 下沉，和孩子节点中最大的元素交换
     */
    private void shiftDown(int k) {
        // 终止条件为 k 节点没有孩子了
        while (leftChild(k) < data.getSize()) {
            // data[j] 是 leftChild 和 rightChild 中的最大值
            int j = leftChild(k);
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j = rightChild(k);
            }
            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }
            data.swap(k, j);
            k = j;
        }
    }

    /**
     * 取出最大元素后，放入一个新元素<p>
     *
     * <ul>
     * <li>可以先extractMax，再add，两次O(logn)的操作</li>
     * <li>可以直接将堆顶元素替换以后sift down，一次O(logn)的操作</li>
     * </ul>
     */
    public E replace(E e) {
        E ret = getElement();
        data.set(0, e);
        shiftDown(0);
        return ret;
    }

}
