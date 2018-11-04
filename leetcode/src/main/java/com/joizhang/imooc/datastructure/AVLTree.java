package com.joizhang.imooc.datastructure;

/**
 * <strong>平衡二叉树</strong>
 * <p>对于任意一个节点，左子树和右子树的高度差不能超过1</p>
 *
 * @param <K>
 * @param <V>
 * @author joizhang
 */
public class AVLTree<K extends Comparable<K>, V> implements Map<K, V> {

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

    @Override
    public int getSize() {
        return size;
    }

    @Override
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

    /**
     * 判断该二叉树是否是一个平衡二叉树
     */
    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = Math.abs(getBalanceFactor(node));
        if (balanceFactor > 1) {
            return false;
        }
        return isBalanced(node.left) && isBalanced(node.right);
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

    @Override
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
        } else {
            node.value = value;
        }
        // 更新 height
        node.height = 1 + Math.max(getHeight(node.left), getHeight(node.right));
        // 计算平衡因子，维护平衡
        int balanceFactor = getBalanceFactor(node);
        if (balanceFactor > 1) {
            if (getBalanceFactor(node.left) >= 0) {
                // LL
                // 右旋转
                return rightRotate(node);
            } else {
                // LR
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        } else if (balanceFactor < -1) {
            if (getBalanceFactor(node.right) <= 0) {
                // RR
                //左旋转
                return leftRotate(node);
            } else {
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }

        }
        return node;
    }

    /**
     * <pre>
     * 对节点 y 进行向右旋转操作，返回旋转后新的根节点 x （新插入的节点再在 y 的 LL 导致不平衡）
     *        y                              x
     *       / \                           /   \
     *      x   T4     向右旋转 (y)        z     y
     *     / \       - - - - - - - ->    / \   / \
     *    z   T3                       T1  T2 T3 T4
     *   / \
     * T1   T2
     * </pre>
     */
    private Node rightRotate(Node y) {
        Node x = y.left;
        Node t3 = x.right;
        // 向右旋转
        x.right = y;
        y.left = t3;
        // 更新height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    /**
     * <pre>
     * 对节点 y 进行向左旋转操作，返回旋转后新的根节点 x （新插入的节点再在 y 的 RR 导致不平衡）
     *     y                             x
     *   /  \                          /   \
     *  T1   x      向左旋转 (y)       y     z
     *      / \   - - - - - - - ->   / \   / \
     *    T2  z                     T1 T2 T3 T4
     *       / \
     *      T3 T4
     * </pre>
     */
    private Node leftRotate(Node y) {
        Node x = y.right;
        Node t2 = x.left;
        // 向左旋转
        x.left = y;
        y.right = t2;
        // 更新height
        y.height = 1 + Math.max(getHeight(y.left), getHeight(y.right));
        x.height = 1 + Math.max(getHeight(x.left), getHeight(x.right));
        return x;
    }

    @Override
    public V remove(K key) {
        return null;
    }

    @Override
    public boolean contains(K key) {
        return getNode(root, key) != null;
    }

    @Override
    public V get(K key) {
        Node node = getNode(root, key);
        return node == null ? null : node.value;
    }

    @Override
    public void set(K key, V value) {

    }

    private Node getNode(Node node, K key) {
        if (node == null) {
            return null;
        }
        if (key.compareTo(node.key) == 0) {
            return node;
        } else if (key.compareTo(node.key) < 0) {
            return getNode(node.left, key);
        } else {
            return getNode(node.right, key);
        }
    }

}
