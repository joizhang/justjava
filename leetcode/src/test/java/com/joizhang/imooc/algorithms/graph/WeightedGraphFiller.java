package com.joizhang.imooc.algorithms.graph;

import com.joizhang.imooc.algorithms.FileOperation;
import com.joizhang.imooc.datastructure.Edge;
import com.joizhang.imooc.datastructure.Graph;
import com.joizhang.imooc.datastructure.WeightedGraph;

import java.io.BufferedReader;
import java.io.IOException;

public class WeightedGraphFiller {


    public WeightedGraphFiller(WeightedGraph graph, String filename) throws IOException {
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
            Double weight = Double.parseDouble(lineSplit[2]);
            graph.addEdge(new Edge(v, w, weight));
        }
    }
}
