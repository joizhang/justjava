package com.joizhang.imooc.datastructure;

/**
 * 稠密图
 *
 * @author joizhang
 */
public class DenseWeightedGraph<W extends Number & Comparable>
        implements WeightedGraph {

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
    private Edge<W>[][] g;

    @SuppressWarnings("unchecked")
    public DenseWeightedGraph(int n, boolean directed) {
        if (n < 0) {
            throw new IllegalArgumentException("Number of vertices must be non-negative.");
        }
        this.n = n;
        this.m = 0;
        this.directed = directed;
        g = new Edge[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                g[i][j] = null;
            }
        }
    }

    @Override
    public int V() {
        return n;
    }

    @Override
    public int E() {
        return m;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addEdge(Edge e) {
        boolean valid = (e.v() >= 0 && e.v() < n) && (e.w() >= 0 && e.w() < n);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        if (hasEdge(e)) {
            return;
        }
        g[e.v()][e.w()] = new Edge<>(e);
        if (e.v() != e.w() && !directed) {
            g[e.w()][e.v()] = new Edge(e.w(), e.v(), e.weight());
        }
        m++;
    }

    @Override
    public boolean hasEdge(Edge e) {
        boolean valid = (e.v() >= 0 && e.v() < n) && (e.w() >= 0 && e.w() < n);
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        return g[e.v()][e.w()] != null;
    }

    @Override
    public Iterable<Edge> adj(int v) {
        ArrayList<Edge> edges = new ArrayList<>();
        for (int i = 0; i < g[v].length; i++) {
            if (g[v][i] != null) {
                edges.addLast(g[v][i]);
            }
        }
        return edges;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(n).append(" vertices, ").append(m).append(" edges\n");
        for (int v = 0; v < n; v++) {
            for (int w = 0; w < n; w++) {
                if (g[v][w] != null && hasEdge(g[v][w])) {
                    s.append(g[v][w].weight()).append(" ");
                } else {
                    s.append("null").append(" ");
                }
            }
            s.append("\n");
        }
        return s.toString();
    }

}
