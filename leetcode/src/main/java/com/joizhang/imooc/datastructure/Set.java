package com.joizhang.imooc.datastructure;

/**
 * 集合接口
 *
 * @param <E>
 * @author joizhang
 */
public interface Set<E> {

    void add(E e);

    void remove(E e);

    boolean contains(E e);

    int getSize();

    boolean isEmpty();

}
