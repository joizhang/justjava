package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.algorithms.FileOperation;
import com.joizhang.imooc.datastructure.Graph;

import java.io.BufferedReader;
import java.io.IOException;

/**
 * @author joizhang
 */
class GraphFiller {

    GraphFiller(Graph graph, String filename) throws IOException {
        BufferedReader bufferedReader = FileOperation.getFileBufferedReader(filename);

        String line = bufferedReader.readLine();
        String[] lineSplit = line.split("\\s");

        int V = Integer.parseInt(lineSplit[0]);
        if (V < 0) {
            throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
        }

        if (V != graph.V()) {
            throw new IllegalArgumentException("Illegal input file.");
        }

        int E = Integer.parseInt(lineSplit[1]);
        if (E < 0) {
            throw new IllegalArgumentException("number of vertices in a Graph must be non-negative");
        }
        for (int i = 0; i < E; i++) {
            line = bufferedReader.readLine();
            lineSplit = line.split("\\s");
            int v = Integer.parseInt(lineSplit[0]);
            int w = Integer.parseInt(lineSplit[1]);
            graph.addEdge(v, w);
        }
    }

}
