package com.joizhang.imooc.datastructure;

/**
 * @param <E>
 * @author joizhang
 */
@FunctionalInterface
public interface Merger<E> {

    E merge(E a, E b);

}
