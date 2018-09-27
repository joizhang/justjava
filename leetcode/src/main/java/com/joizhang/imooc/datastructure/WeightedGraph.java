package com.joizhang.imooc.datastructure;

/**
 * @author joizhang
 */
public interface WeightedGraph<W extends Number & Comparable> {

    /**
     * 定点数
     */
    int V();

    /**
     * 边数
     */
    int E();

    /**
     * 向图中添加一条边
     */
    void addEdge(Edge<W> e);

    /**
     * 是否有 v 和 w 组成的边
     */
    boolean hasEdge(Edge<W> e);

    /**
     * 返回图中所有定点的一个邻边
     */
    Iterable<Edge<W>> adj(int v);

}
