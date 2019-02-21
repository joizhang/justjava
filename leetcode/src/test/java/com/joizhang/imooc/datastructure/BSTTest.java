package com.joizhang.imooc.datastructure;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BSTTest {

    private BST<Integer> bst;

    @Before
    public void setUp() {
        bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums) {
            bst.add(num);
        }
    }

    @Test
    public void testPreOrder() {
        bst.preOrder();
        System.out.println();
        bst.preOrderNR();
    }

    @Test
    public void testInOrder() {
        bst.inOrder();
        System.out.println();
        bst.inOrderNR();
    }

    @Test
    public void testPostOrder() {
        bst.postOrder();
        System.out.println();
        bst.postOrderNR();
    }

    @Test
    public void testLevelOrder() {
        bst.levelOrder();
    }

    @Test
    public void testDeleteMax() {
        BST<Integer> bst1 = new BST<>();
        Random random = new Random(47);
        int n = 1000;
        for (int i = 0; i < n; i++) {
            bst1.add(random.nextInt(10000));
        }

        List<Integer> nums = new ArrayList<>();
        while (!bst1.isEmpty()) {
            nums.add(bst1.removeMax());
        }
        System.out.println(nums);

        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) < nums.get(i)) {
                throw new IllegalArgumentException("Error " + i + ": " + nums.get(i) + " " + (i - 1) + ": " + nums.get(i - 1));
            }
        }
    }

}