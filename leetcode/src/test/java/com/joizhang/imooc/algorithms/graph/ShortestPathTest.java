package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.Graph;
import com.joizhang.imooc.datastructure.SparseGraph;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ShortestPathTest {

    @Test
    public void test() throws IOException {
        Graph graph = new SparseGraph(7, false);
        new GraphFiller(graph, "testG2.txt");
        ShortestPath shortestPath = new ShortestPath(graph, 0);

        assertTrue(shortestPath.hasPath(6));

        shortestPath.showPath(1);
        shortestPath.showPath(2);
        shortestPath.showPath(3);
        shortestPath.showPath(4);
        shortestPath.showPath(5);
        shortestPath.showPath(6);

        assertEquals(1, shortestPath.length(1));
        assertEquals(1, shortestPath.length(2));
        assertEquals(2, shortestPath.length(3));
        assertEquals(2, shortestPath.length(4));
        assertEquals(1, shortestPath.length(5));
        assertEquals(1, shortestPath.length(6));
    }

}