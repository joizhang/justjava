package com.joizhang.imooc.datastructure;

/**
 * 基于 @{@link BST} 的集合
 *
 * @param <E>
 * @author joizhang
 */
public class BSTSet<E extends Comparable<E>> implements Set<E> {

    private BST<E> bst;

    BSTSet() {
        bst = new BST<>();
    }

    @Override
    public void add(E e) {
        bst.add(e);
    }

    @Override
    public void remove(E e) {
        bst.remove(e);
    }

    @Override
    public boolean contains(E e) {
        return bst.contains(e);
    }

    @Override
    public int getSize() {
        return bst.size();
    }

    @Override
    public boolean isEmpty() {
        return bst.size() == 0;
    }

}
