package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class ReadGraphTest {

    @Test
    public void testReadEdgesIntoDenseGraph() {
        Graph graph = new DenseGraph(13, false);
        new ReadGraph(graph, "testG1.txt");
        assertEquals(13, graph.V());
        assertEquals(13, graph.E());
        System.out.println(graph);

        graph = new DenseGraph(7, false);
        new ReadGraph(graph, "testG2.txt");
        assertEquals(7, graph.V());
        assertEquals(8, graph.E());
        System.out.println(graph);
    }

    @Test
    public void testReadEdgesIntoSparseGraph() {
        Graph graph = new SparseGraph(13, false);
        new ReadGraph(graph, "testG1.txt");
        assertEquals(13, graph.V());
        assertEquals(13, graph.E());
        System.out.println(graph);

        graph = new SparseGraph(7, false);
        new ReadGraph(graph, "testG2.txt");
        assertEquals(7, graph.V());
        assertEquals(8, graph.E());
        System.out.println(graph);
    }


}