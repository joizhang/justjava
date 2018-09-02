package com.joizhang.imooc.datastructure;

/**
 * <pre>
 * 并查集
 *
 * <strong>连接问题</strong>
 * 网络中节点的连接状态
 * 数学中的集合类实现
 *
 * <strong>连接问题和路径问题</strong>
 * 连接问题比路径问题要回答的问题少
 * </pre>
 *
 * @author joizhang
 */
public class UnionFind {

    private int[] id;

    private int count;

    UnionFind(int n) {
        count = n;
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }

    public int find(int p) {
        validate(p);
        return id[p];
    }

    /**
     * validate that p is a valid index
     */
    private void validate(int p) {
        if (p < 0 || p >= count) {
            throw new IllegalArgumentException("index " + p + " is not between 0 and " + (count - 1));
        }
    }

    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < count; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

}
