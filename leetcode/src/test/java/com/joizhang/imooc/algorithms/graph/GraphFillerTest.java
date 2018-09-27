package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.DenseGraph;
import com.joizhang.imooc.datastructure.Graph;
import com.joizhang.imooc.datastructure.SparseGraph;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;

public class GraphFillerTest {

    @Test
    public void testReadEdgesIntoDenseGraph() throws IOException {
        Graph graph = new DenseGraph(13, false);
        new GraphFiller(graph, "testG1.txt");
        assertEquals(13, graph.V());
        assertEquals(13, graph.E());
        System.out.println(graph);

        graph = new DenseGraph(7, false);
        new GraphFiller(graph, "testG2.txt");
        assertEquals(7, graph.V());
        assertEquals(8, graph.E());
        System.out.println(graph);
    }

    @Test
    public void testReadEdgesIntoSparseGraph() throws IOException {
        Graph graph = new SparseGraph(13, false);
        new GraphFiller(graph, "testG1.txt");
        assertEquals(13, graph.V());
        assertEquals(13, graph.E());
        System.out.println(graph);

        graph = new SparseGraph(7, false);
        new GraphFiller(graph, "testG2.txt");
        assertEquals(7, graph.V());
        assertEquals(8, graph.E());
        System.out.println(graph);
    }


}