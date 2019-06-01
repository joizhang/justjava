package com.joizhang.imooc.datastructure;

import com.joizhang.imooc.algorithms.FileOperation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AVLTreeTest {

    class WordCount implements Comparable<WordCount> {
        private String word;

        private int count;

        public WordCount(String word, int count) {
            this.word = word;
            this.count = count;
        }

        @Override
        public int compareTo(WordCount other) {
            return this.word.compareTo(other.word);
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    private AVLTree<Integer> avlTree;

    @Before
    public void setUp() {
        avlTree = new AVLTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            avlTree.add(num);
        }
    }

    @Test
    public void testBST() {
        assertTrue(avlTree.isBST());
    }

    @Test
    public void testAdd() {
        List<String> words = new ArrayList<>();
        FileOperation.readFile("Pride-And-prejudice.txt", words);
        System.out.println(words.size());

        AVLTree<WordCount> avlTree = new AVLTree<>();
        for (String word : words) {
            WordCount wordCount = new WordCount(word, 1);
            if (avlTree.contains(wordCount)) {
                wordCount = avlTree.get(wordCount);
                wordCount.setCount(wordCount.getCount() + 1);
            }
            avlTree.add(wordCount);
        }

        assertTrue(avlTree.isBST());
        assertTrue(avlTree.isBalanced());
    }

}