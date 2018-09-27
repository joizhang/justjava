package com.joizhang.imooc.datastructure;

import com.joizhang.imooc.algorithms.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @author joizhang
 */
public class TrieTest {

    @Test
    public void trieBenchmark() {
        List<String> words = new ArrayList<>();
        if (FileOperation.readFile("Pride-And-prejudice.txt", words)) {
            long startTime = System.nanoTime();

            BSTSet<String> set = new BSTSet<>();
            for (String word : words) {
                set.add(word);
            }

            for (String word : words) {
                set.contains(word);
            }

            long endTime = System.nanoTime();
            double time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + set.getSize());
            System.out.println("BSTSet: " + time + "s");

            // ---

            startTime = System.nanoTime();

            Trie trie = new Trie();
            for (String word : words) {
                trie.add(word);
            }

            for (String word : words) {
                trie.contains(word);
            }

            endTime = System.nanoTime();
            time = (endTime - startTime) / 1000000000.0;

            System.out.println("Total different words: " + trie.getSize());
            System.out.println("Trie: " + time + "s");
        }
    }

}