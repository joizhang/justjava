package com.joizhang.imooc.datastructure;

import java.util.*;

/**
 * @author joizhang
 */
public abstract class AbstractTraversal {

    /**
     * 图的引用
     */
    protected Graph graph;

    /**
     * 起始点
     */
    protected int s;

    /**
     * 记录 dfs 的过程中节点是否被访问
     */
    protected boolean[] visited;

    /**
     * 记录路径, from[i] 表示查找的路径上 i 的上一个节点
     */
    protected int[] from;

    AbstractTraversal(Graph graph, int s) {
        this.graph = graph;
        if (s < 0 || s >= graph.V()) {
            throw new IllegalArgumentException("Argument s must bigger than zero and less than vertex number.");
        }

        visited = new boolean[graph.V()];
        Arrays.fill(visited, false);

        from = new int[graph.V()];
        Arrays.fill(from, -1);

        this.s = s;
    }

    /**
     * 查询从 s 点到 w 点是否有路径
     */
    public boolean hasPath(int w) {
        if (w < 0 || w >= graph.V()) {
            throw new IllegalArgumentException("Argument s must bigger than zero and less than vertex number.");
        }
        return visited[w];
    }

    public List<Integer> path(int w) {
        if (!hasPath(w)) {
            throw new IllegalArgumentException("Path not exists.");
        }
        Deque<Integer> stack = new ArrayDeque<>();
        // 通过 from 数组逆向查找到从 s 到 w 的路径, 存放到栈中
        int p = w;
        while (p != -1) {
            stack.addFirst(p);
            p = from[p];
        }

        List<Integer> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.removeFirst());
        }
        return res;
    }

    public void showPath(int w) {
        if (!hasPath(w)) {
            throw new IllegalArgumentException("Path not exists.");
        }
        List<Integer> path = path(w);
        for (int i = 0; i < path.size(); i++) {
            System.out.print(path.get(i));
            if (i == path.size() - 1) {
                System.out.println();
            } else {
                System.out.print(" -> ");
            }
        }
    }

}
