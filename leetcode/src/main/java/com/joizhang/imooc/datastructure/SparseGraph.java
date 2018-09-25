package com.joizhang.imooc.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 稀疏图 - 邻接表
 *
 * @author joizhang
 */
public class SparseGraph implements Graph {

    /**
     * 节点数
     */
    private final int V;

    /**
     * 边数
     */
    private int E;

    /**
     * 是否为有向图
     */
    private boolean directed;

    /**
     * 图的具体数据
     */
    private List<Integer>[] g;

    @SuppressWarnings("unchecked")
    public SparseGraph(int v, boolean directed) {
        if (v < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative.");
        }
        this.V = v;
        this.directed = directed;
        g = new List[v];
        for (int i = 0; i < v; i++) {
            g[i] = new ArrayList<>();
        }
    }

    @Override
    public int V() {
        return V;
    }

    @Override
    public int E() {
        return E;
    }

    @Override
    public void addEdge(int v, int w) {
        boolean valid = (v >= 0 && v < V) && (w >= 0 && w < V);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        g[v].add(w);
        // 不允许平行边代价会很高
        if (v != w && !directed) {
            g[w].add(v);
        }
        E++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        boolean valid = (v >= 0 && v < V) && (w >= 0 && w < V);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        return g[v].contains(w);
    }

    @Override
    public Iterable<Integer> adj(int v) {
        return g[v];
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" vertices, ").append(E).append(" edges\n");
        for (int v = 0; v < V; v++) {
            s.append(v).append(": ");
            for (int w : g[v]) {
                s.append(w).append(" ");
            }
            s.append("\n");
        }
        return s.toString();
    }

}
