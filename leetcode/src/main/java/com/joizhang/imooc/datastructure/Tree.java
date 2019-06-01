package com.joizhang.imooc.datastructure;

/**
 * @author joizhang
 * @param <E>
 */
public interface Tree<E extends Comparable<E>> {

    int getSize();

    boolean isEmpty();

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    E get(E e);

}
