package com.joizhang.imooc.datastructure;

/**
 * @author joizhang
 */
public interface Graph {

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
    void addEdge(int v, int w);

    /**
     * 是否有 v 和 w 组成的边
     */
    boolean hasEdge(int v, int w);

    /**
     * 返回图中所有定点的一个邻边
     */
    Iterable<Integer> adj(int v);

}
