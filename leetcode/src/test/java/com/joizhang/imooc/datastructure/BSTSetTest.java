package com.joizhang.imooc.datastructure;

import com.joizhang.imooc.algorithms.FileOperation;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class BSTSetTest {

    @Test
    public void testBSTSet() {
        List<String> words = new ArrayList<>();
        FileOperation.readFile("A-Tale-of-Two-Cities.txt", words);
        System.out.println(words.size());

        BSTSet<String> bstSet = new BSTSet<>();
        for (String word : words) {
            bstSet.add(word);
        }
        System.out.println(bstSet.getSize());
    }

}