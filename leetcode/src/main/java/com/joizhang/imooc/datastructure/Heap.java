package com.joizhang.imooc.datastructure;

/**
 * 堆的接口
 *
 * @author joizhang
 */
public interface Heap<E extends Comparable<E>> {

    /**
     * 向堆中添加元素
     *
     * @param e 元素
     */
    void add(E e);

    /**
     * 返回堆顶元素
     *
     * @return 堆顶元素
     */
    E getElement();

    /**
     * 取出堆顶元素
     * @return 堆顶元素
     */
    E extractElement();

}
