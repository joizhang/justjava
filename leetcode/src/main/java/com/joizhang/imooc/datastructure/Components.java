package com.joizhang.imooc.datastructure;

import java.util.Arrays;

/**
 * 深度优先求无权图的连通分量
 *
 * @author joizhang
 */
public class Components {

    /**
     * 图的引用
     */
    private Graph graph;

    /**
     * 记录dfs的过程中节点是否被访问
     */
    private boolean[] visited;

    /**
     * 记录连通分量个数
     */
    private int count;

    /**
     * 每个节点所对应的连通分量标记
     */
    private int[] id;

    public Components(Graph graph) {
        this.graph = graph;

        this.visited = new boolean[graph.V()];
        Arrays.fill(visited, false);

        this.id = new int[graph.V()];
        Arrays.fill(id, -1);

        this.count = 0;

        // 求图的连通分量
        for (int i = 0; i < graph.V(); i++) {
            if (!visited[i]) {
                dfs(i);
                this.count++;
            }
        }
    }

    /**
     * 图的深度优先遍历
     */
    private void dfs(int v) {
        visited[v] = true;
        id[v] = count;
        for (int i : graph.adj(v)) {
            if (!visited[i]) {
                dfs(i);
            }
        }
    }

    /**
     * 返回图的连通分量个数
     */
    public int count() {
        return count;
    }

    public boolean isConnected(int v, int w) {
        boolean valid = (v >= 0 && v < graph.V()) && (w >= 0 && w < graph.V());
        if (!valid) {
            throw new IllegalArgumentException("Argument v and w must bigger than zero and less than vertex number.");
        }
        return id[v] == id[w];
    }

}
