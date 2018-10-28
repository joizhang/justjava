package com.joizhang.imooc.datastructure;

/**
 * <strong>平衡二叉树</strong>
 * <p>对于任意一个节点，左子树和右子树的高度差不能超过1</p>
 *
 * @param <K>
 * @param <V>
 */
public class AVLTree<K extends Comparable<K>, V> {

    private class Node {
        K key;

        V value;

        Node left;

        Node right;

        int height;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node root;

    private int size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 判断该二叉树是否是一个二分搜索树
     */
    public boolean isBST() {
        Array<K> keys = new Array<>(size);
        inOrder(root, keys);
        for (int i = 1; i < keys.getSize(); i++) {
            if (keys.get(i - 1).compareTo(keys.get(i)) > 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * 通过中序遍历二分搜索树获得有序列表
     */
    private void inOrder(Node node, Array<K> keys) {
        if (node == null) {
            return;
        }
        inOrder(node.left, keys);
        keys.addLast(node.key);
        inOrder(node.right, keys);
    }

    public int getHeight(Node node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 获得 node 的平衡因子
     */
    private int getBalanceFactor(Node node) {
        if (node == null) {
            return 0;
        }
        return getHeight(node.left) - getHeight(node.right);
    }

    public void add(K key, V value) {
        root = add(root, key, value);
    }

    /**
     * 递归的向以 node 为根的二分搜索树中插入元素 e
     *
     * @return 返回插入新节点后二分搜索树的根
     */
    private Node add(Node node, K key, V value) {
        if (node == null) {
            size++;
            return new Node(key, value);
        }
        if (key.compareTo(node.key) < 0) {
            node.left = add(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = add(node.right, key, value);
        }
        // 更新 height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 计算平衡因子
        int balanceFactor = Math.abs(getBalanceFactor(node));
        if (balanceFactor > 1) {

        }
        return node;
    }

}
