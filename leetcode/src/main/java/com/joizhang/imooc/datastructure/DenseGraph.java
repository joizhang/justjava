package com.joizhang.imooc.datastructure;

import java.util.ArrayList;
import java.util.List;

/**
 * 稠密图 - 邻接矩阵
 *
 * @author joizhang
 */
public class DenseGraph implements Graph {

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
    private boolean[][] g;

    public DenseGraph(int v, boolean directed) {
        if (v < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative.");
        }
        this.V = v;
        this.E = 0;
        this.directed = directed;
        g = new boolean[v][v];
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
        if(hasEdge(v, w)) {
            return;
        }
        g[v][w] = true;
        if (!directed) {
            g[w][v] = true;
        }
        E++;
    }

    @Override
    public boolean hasEdge(int v, int w) {
        boolean valid = (v >= 0 && v < V) && (w >= 0 && w < V);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        return g[v][w];
    }

    @Override
    public Iterable<Integer> adj(int v) {
        List<Integer> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (g[v][i]) {
                adj.add(i);
            }
        }
        return adj;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V).append(" vertices, ").append(E).append(" edges\n");
        for (int v = 0; v < V; v++) {
            for (int w = 0; w < V; w++) {
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
