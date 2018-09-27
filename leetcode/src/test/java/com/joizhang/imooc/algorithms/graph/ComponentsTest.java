package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.Graph;
import com.joizhang.imooc.datastructure.SparseGraph;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ComponentsTest {

    /**
     * 13 vertices, 13 edges
     * 0: 5 1 2 6
     * 1: 0
     * 2: 0
     * 3: 4 5
     * 4: 3 6 5
     * 5: 0 4 3
     * 6: 4 0
     * 7: 8
     * 8: 7
     * 9: 12 10 11
     * 10: 9
     * 11: 12 9
     * 12: 9 11
     */
    @Test
    public void testG1() throws IOException {
        Graph graph = new SparseGraph(13, false);
        new GraphFiller(graph, "testG1.txt");
        Components components = new Components(graph);
        assertTrue(components.isConnected(0, 5));
        assertEquals(3, components.count());
    }

    /**
     * 7 vertices, 8 edges
     * 0: 1 2 5 6
     * 1: 0
     * 2: 0
     * 3: 4 5
     * 4: 3 5 6
     * 5: 0 3 4
     * 6: 0 4
     */
    @Test
    public void testG2() throws IOException {
        Graph graph = new SparseGraph(7, false);
        new GraphFiller(graph, "testG2.txt");
        Components components = new Components(graph);
        assertTrue(components.isConnected(0, 5));
        assertEquals(1, components.count());
    }

}