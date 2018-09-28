package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.Edge;
import com.joizhang.imooc.datastructure.MinHeap;
import com.joizhang.imooc.datastructure.WeightedGraph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Prim 求最小生成树
 *
 * @author joizhang
 */
public class LazyPrimMinSpanningTree<W extends Number & Comparable> {

    private WeightedGraph<W> graph;

    private MinHeap<Edge<W>> minHeap;

    /**
     * 标记数组, 在算法运行过程中标记节点i是否被访问
     */
    private boolean[] marked;

    /**
     * 最小生成树所包含的所有边
     */
    private List<Edge<W>> mst;

    /**
     * 最小生成树的权值
     */
    private Number mstWeight;

    @SuppressWarnings("unchecked")
    public LazyPrimMinSpanningTree(WeightedGraph<W> graph) {
        this.graph = graph;
        minHeap = new MinHeap(graph.E());
        marked = new boolean[graph.V()];
        Arrays.fill(marked, false);
        mst = new ArrayList<>();

        // Lazy Prim
        visit(0);
        while (!minHeap.isEmpty()) {
            // 使用最小堆找出已经访问的边中权值最小的边
            Edge<W> e = minHeap.extractMin();
            // 如果这条边的两端都已经访问过了, 则扔掉这条边
            if (marked[e.v()] == marked[e.w()]) {
                continue;
            }
            // 否则, 这条边则应该存在在最小生成树中
            mst.add(e);
            // 访问和这条边连接的还没有被访问过的节点
            if (!marked[e.v()]) {
                visit(e.v());
            } else {
                visit(e.w());
            }
        }

        // 计算最小生成树的权值
        mstWeight = mst.get(0).weight();
        for( int i = 1 ; i < mst.size() ; i ++ ) {
            mstWeight = mstWeight.doubleValue() + mst.get(i).weight().doubleValue();
        }
    }

    /**
     * 访问节点v
     */
    @SuppressWarnings("unchecked")
    private void visit(int v) {
        if (marked[v]) {
            throw new IllegalArgumentException("This vertex has already bean visited!");
        }
        marked[v] = true;
        // 将和节点 v 相连接的所有未访问的边放入最小堆中
        for (Edge<W> e : graph.adj(v)) {
            if (!marked[e.other(v)]) {
                minHeap.add(e);
            }
        }
    }

    /**
     * 返回最小生成树的所有边
     */
    public List<Edge<W>> mstEdges() {
        return mst;
    }

    /**
     * 返回最小生成树的权值
     */
    public Number result() {
        return mstWeight;
    }


}
