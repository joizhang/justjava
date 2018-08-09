package com.joizhang.imooc.datastructure;

@FunctionalInterface
public interface Merger<E> {

    E merge(E a, E b);

}
