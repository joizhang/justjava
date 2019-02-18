package com.joizhang.imooc.datastructure;

import com.joizhang.imooc.algorithms.FileOperation;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class AVLTreeTest {

    private AVLTree<Integer, Integer> avlTree;

    @Before
    public void setUp() {
        avlTree = new AVLTree<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            avlTree.add(num, num);
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

        AVLTree<String, Integer> avlTree = new AVLTree<>();
        for (String word : words) {
            if (avlTree.contains(word)) {
                avlTree.add(word, avlTree.get(word) + 1);
            } else {
                avlTree.add(word, 1);
            }
        }

        assertTrue(avlTree.isBST());
        assertTrue(avlTree.isBalanced());
    }

}