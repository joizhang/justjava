package com.joizhang.imooc.datastructure;

import java.util.Objects;

/**
 * 带权图的边
 *
 * @author joizhang
 */
public class Edge<W extends Number & Comparable> implements Comparable<Edge<W>> {

    /**
     * 边的第一个顶点
     */
    private int a;

    /**
     * 边的第二个顶点
     */
    private int b;

    /**
     * 边的权值
     */
    private W weight;

    public Edge(int a, int b, W weight) {
        this.a = a;
        this.b = b;
        this.weight = weight;
    }

    public Edge(Edge<W> e) {
        this.a = e.a;
        this.b = e.b;
        this.weight = e.weight;
    }

    /**
     * 返回第一个顶点
     */
    public int v() {
        return a;
    }

    /**
     * 返回第二个顶点
     */
    public int w() {
        return b;
    }

    /**
     * 返回权值
     */
    public W weight() {
        return weight;
    }

    /**
     * 给定一个顶点, 返回另一个顶点
     */
    public int other(int x) {
        if (x != a && x != b) {
            throw new IllegalArgumentException("Illegal x!");
        }
        return x == a ? b : a;
    }

    @Override
    public String toString() {
        return "" + a + "-" + b + ":" + weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Edge<?> edge = (Edge<?>) o;
        return a == edge.a &&
                b == edge.b &&
                Objects.equals(weight, edge.weight);
    }

    @Override
    public int hashCode() {
        return Objects.hash(a, b, weight);
    }

    @Override
    public int compareTo(Edge that) {
        return Integer.compare(weight.compareTo(that.weight), 0);
    }
}
