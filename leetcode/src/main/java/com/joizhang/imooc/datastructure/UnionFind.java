package com.joizhang.imooc.datastructure;

/**
 * 并查集接口
 *
 * @author joizhang
 */
public interface UnionFind {

    /**
     * 查找元素 p 所对应的集合编号
     *
     * @param p 元素 p
     * @return 集合编号
     */
    int find(int p);

    /**
     * 合并元素 p 和 元素 q 所属的集合
     *
     * @param p 元素 p
     * @param q 元素 q
     */
    void union(int p, int q);

    /**
     * 查看元素 p 和 元素 q 是否属于一个集合
     *
     * @param p 元素 p
     * @param q 元素 q
     * @return 是否属于一个集合
     */
    boolean isConnected(int p, int q);

}
