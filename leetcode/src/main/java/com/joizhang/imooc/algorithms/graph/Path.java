package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.Graph;

/**
 * 深度优先求路径
 *
 * @author joizhang
 */
public class Path extends AbstractTraversal {

    /**
     * 寻路算法, 寻找图 graph 从 s 点到其他点的路径
     */
    public Path(Graph graph, int s) {
        super(graph, s);
        dfs(s);
    }

    private void dfs(int v) {
        visited[v] = true;
        for (int i : graph.adj(v)) {
            if (!visited[i]) {
                from[i] = v;
                dfs(i);
            }
        }
    }

}
