package com.joizhang.imooc.algorithms;

/**
 * @author joizhang
 */
public class Stopwatch {

    private final long start;

    Stopwatch() {
        start = System.currentTimeMillis();
    }

    double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }

}
