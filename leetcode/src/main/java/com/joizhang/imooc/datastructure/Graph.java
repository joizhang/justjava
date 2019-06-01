package com.joizhang.imooc.datastructure;

/**
 * 图接口
 *
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
     *
     * @param v 顶点
     * @param w 顶点
     */
    void addEdge(int v, int w);

    /**
     * 是否有 v 和 w 组成的边
     *
     * @param v 顶点
     * @param w 顶点
     * @return 是否有 v 和 w 组成的边
     */
    boolean hasEdge(int v, int w);

    /**
     * 返回图中所有定点的一个邻边
     *
     * @param v 顶点
     */
    Iterable<Integer> adj(int v);

}
