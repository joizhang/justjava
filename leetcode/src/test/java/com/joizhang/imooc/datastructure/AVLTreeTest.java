package com.joizhang.imooc.datastructure;

import org.junit.Before;
import org.junit.Test;

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

}