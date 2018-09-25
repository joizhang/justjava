package com.joizhang.imooc.datastructure;

import java.io.*;

public class ReadGraph {

    private BufferedReader bufferedReader;

    public ReadGraph(Graph graph, String filename) {
        readFile(filename);

        try {
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
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void readFile(String filename) {
        assert filename != null;
        File file = new File(filename);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(file)) {
                bufferedReader = new BufferedReader(new FileReader(file));
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            throw new IllegalArgumentException(filename + "doesn't exist.");
        }
    }

}
