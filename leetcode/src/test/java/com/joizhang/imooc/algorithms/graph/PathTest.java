package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.datastructure.Graph;
import com.joizhang.imooc.datastructure.SparseGraph;
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class PathTest {

    @Test
    public void test() throws IOException {
        Graph graph = new SparseGraph(7, false);
        new GraphFiller(graph, "graph/testG2.txt");
        Path path = new Path(graph, 0);
        assertTrue(path.hasPath(6));
        path.showPath(6);
    }

}