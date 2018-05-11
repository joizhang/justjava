package com.joizhang.imooc.datastructure;

/**
 * @author joizhang
 * @param <E>
 */
public interface Queue<E> {

    int getSize();

    boolean isEmpty();

    void enqueue(E e);

    E dequeue();

    E getFront();

}