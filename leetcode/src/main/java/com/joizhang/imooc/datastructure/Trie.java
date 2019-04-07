package com.joizhang.imooc.datastructure;

import java.util.TreeMap;

/**
 * <p>如果有 n 个条目，使用树结构，查询的时间复杂度为 O(logn)，
 * <p>如果有100万个条目 （2^20），logn 大约为 20<br>
 * <br>
 * <p>Trie 查询每个条目的时间复杂度和字典中一共有多少条目无关，
 * <p>它的时间复杂度为O(w)，w 为查询单词的长度，大多数单词的
 * <p>长度小于10；
 * <p>每个节点有若干个指向下个节点的指针；<br>
 * <br>
 * <p>Trie 的局限性：空间
 *
 * @author joizhang
 */
public class Trie {

    private class Node {

        /**
         * 是否是一个单词的结尾
         */
        boolean isWord;

        TreeMap<Character, Node> next;

        Node() {
            this(false);
        }

        Node(boolean isWord) {
            this.isWord = isWord;
            next = new TreeMap<>();
        }

    }

    private Node root;

    private int size;

    public Trie() {
        root = new Node();
        size = 0;
    }

    /**
     * 获得 Trie 中存储的单词数量
     */
    public int getSize() {
        return size;
    }

    /**
     * 向 Trie 中添加一个新的单词 word
     */
    public void add(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }

        if (!cur.isWord) {
            cur.isWord = true;
            size++;
        }
    }

    /**
     * 查询单词 word 是否在Trie 中
     */
    public boolean contains(String word) {
        Node cur = root;
        return isPrefix(word) && cur.isWord;
    }

    /**
     * 查询是否在 Trie 中有单词以 prefix 为前缀
     */
    public boolean isPrefix(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return false;
            }
            cur = cur.next.get(c);
        }
        return true;
    }

}
