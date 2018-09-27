package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.*;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.*;

public class WeightedGraphFillerTest {

    @Test
    public void testReadEdgesIntoDenseWeightedGraph() throws IOException {
        WeightedGraph graph = new DenseWeightedGraph(8, false);
        new WeightedGraphFiller(graph, "testWeightedG1.txt");
        assertEquals(8, graph.V());
        assertEquals(16, graph.E());
        System.out.println(graph);
    }

    @Test
    public void testReadEdgesIntoSparseWeightedGraph() throws IOException {
        WeightedGraph graph = new SparseWeightedGraph(8, false);
        new WeightedGraphFiller(graph, "testWeightedG1.txt");
        assertEquals(8, graph.V());
        assertEquals(16, graph.E());
        System.out.println(graph);
    }

}