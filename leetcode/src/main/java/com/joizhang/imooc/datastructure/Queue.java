package com.joizhang.imooc.datastructure;

/**
 * 队列接口
 *
 * @param <E>
 * @author joizhang
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}