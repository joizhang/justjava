package com.joizhang.imooc.datastructure;

/**
 * 用 @{@link ArrayList} 实现的栈
 *
 * @param <E>
 * @author joizhang
 */
public class ArrayStack<E> implements Stack<E> {

    private ArrayList<E> arrayList;

    public ArrayStack() {
        arrayList = new ArrayList<>();
    }

    public ArrayStack(int capacity) {
        arrayList = new ArrayList<>(capacity);
    }

    @Override
    public void push(E e) {
        arrayList.addLast(e);
    }

    @Override
    public E pop() {
        return arrayList.removeLast();
    }

    @Override
    public E peek() {
        return arrayList.getLast();
    }

    @Override
    public int getSize() {
        return arrayList.getSize();
    }

    @Override
    public boolean isEmpty() {
        return arrayList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("Stack: ");
        res.append('[');
        for (int i = 0; i < arrayList.getSize(); i++) {
            res.append(arrayList.get(i));
            if (i != arrayList.getSize() - 1) {
                res.append(", ");
            }
        }
        res.append("] top");
        return res.toString();
    }

}
