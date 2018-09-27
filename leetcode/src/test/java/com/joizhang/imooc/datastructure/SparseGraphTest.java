package com.joizhang.imooc.datastructure;

import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;

public class SparseGraphTest {

    @Test
    public void testGraph() {
        SparseGraph graph = new SparseGraph(6, false);
        assertEquals(6, graph.V());
        assertEquals(0, graph.E());
        graph.addEdge(2, 3);
        assertEquals(1, graph.E());
    }

    @Test
    public void testGenerateGraph() {
        Random random = new Random(47);
        int v = 20;
        int e = 100;
        SparseGraph graph = new SparseGraph(v, false);
        for (int i = 0; i < e; i++) {
            graph.addEdge(Math.abs(random.nextInt() % v), Math.abs(random.nextInt() % v));
        }
        System.out.println(graph);
        assertEquals(e, graph.E());
    }

}