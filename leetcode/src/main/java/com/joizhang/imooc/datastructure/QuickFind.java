package com.joizhang.imooc.datastructure;

/**
 * <p><strong>并查集</strong></p><br>
 *
 * <p><strong>连接问题</strong></p>
 * <p>网络中节点的连接状态</p>
 * <p>数学中的集合类实现</p><br>
 *
 * <p><strong>连接问题和路径问题</strong></p>
 * <p>连接问题比路径问题要回答的问题少</p>
 *
 * @author joizhang
 */
public class QuickFind implements UnionFind {

    private int[] id;

    public QuickFind(int size) {
        id = new int[size];
        for (int i = 0; i < size; i++) {
            id[i] = i;
        }
    }

    @Override
    public void union(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }

    @Override
    public int find(int p) {
        validate(p);
        return id[p];
    }

    @Override
    public boolean isConnected(int p, int q) {
        return find(p) == find(q);
    }

    /**
     * validate that p is a valid index
     */
    private void validate(int p) {
        if (p < 0 || p >= id.length) {
            throw new IllegalArgumentException("Index " + p +
                    " is not between 0 and " + (id.length - 1));
        }
    }

}
