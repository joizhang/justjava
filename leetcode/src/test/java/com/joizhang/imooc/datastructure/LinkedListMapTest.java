package com.joizhang.imooc.datastructure;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class LinkedListMapTest {

    @Test
    public void testLinkedListMap() {
        List<String> words = new ArrayList<>();
        FileOperation.readFile("A-Tale-of-Two-Cities.txt", words);
        System.out.println(words.size());

        LinkedListMap<String, Integer> map = new LinkedListMap<>();
        for (String word: words) {
            if (map.contains(word)) {
                map.set(word, map.get(word) + 1);
            } else {
                map.add(word, 1);
            }
        }
        System.out.println(map.get("the"));
    }

}