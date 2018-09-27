package com.joizhang.imooc.datastructure;

import org.junit.Test;

import static org.junit.Assert.*;

public class PathTest {

    @Test
    public void test() {
        Graph graph = new SparseGraph(7, false);
        new ReadGraph(graph, "testG2.txt");
        Path path = new Path(graph, 0);
        assertTrue(path.hasPath(6));
        path.showPath(6);
    }

}