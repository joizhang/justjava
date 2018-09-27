package com.joizhang.imooc.datastructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 广度优先求最短路径
 *
 * @author joizhang
 */
public class ShortestPath extends AbstractTraversal {

    /**
     * 记录路径中节点的次序。ord[i]表示i节点在路径中的次序。
     */
    private int[] ord;

    public ShortestPath(Graph graph, int s) {
        super(graph, s);

        ord = new int[graph.V()];
        Arrays.fill(ord, -1);

        bfs(s);
    }

    private void bfs(int s) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(s);
        visited[s] = true;
        ord[s] = 0;
        while (!queue.isEmpty()) {
            int v = queue.remove();
            for (int i : graph.adj(v)) {
                if (!visited[i]) {
                    queue.add(i);
                    visited[i] = true;
                    from[i] = v;
                    ord[i] = ord[v] + 1;
                }
            }
        }
    }

    /**
     * 查看从s点到w点的最短路径长度
     * 若从s到w不可达，返回-1
     */
    public int length(int w) {
        if (w < 0 || w >= graph.V()) {
            throw new IllegalArgumentException("Argument s must bigger than zero and less than vertex number.");
        }
        return ord[w];
    }

}
