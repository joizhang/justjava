package com.joizhang.imooc.datastructure;

/**
 * 稠密图 - 邻接矩阵
 *
 * @author joizhang
 */
public class DenseGraph implements Graph {

    /**
     * 节点数
     */
    private final int n;

    /**
     * 边数
     */
    private int m;

    /**
     * 是否为有向图
     */
    private boolean directed;

    /**
     * 图的具体数据
     */
    private boolean[][] g;

    public DenseGraph(int n, boolean directed) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative.");
        }
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new boolean[n][n];
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @Override
    public void addEdge(int v, int w) {
        boolean valid = (v >= 0 && v < n) && (w >= 0 && w < n);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        if (hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        m++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        boolean valid = (v >= 0 && v < n) && (w >= 0 && w < n);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        return g[v][w];
    }

    @Override
    public Iterable<Integer> adj(int v) {
        Array<Integer> adj = new Array<>();
        for (int i = 0; i < n; i++) {
            if (g[v][i]) {
                adj.addLast(i);
            }
        }
        return adj;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n).append(" vertices, ").append(m).append(" edges\n");
        for (int v = 0; v < n; v++) {
            for (int w = 0; w < n; w++) {
                if (hasEdge(v, w)) {
                    s.append(1).append(" ");
                } else {
                    s.append(0).append(" ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

}
