package com.joizhang.imooc.datastructure;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 动态数组
 *
 * @param <E>
 * @author joizhang
 */
public class ArrayList<E> implements List<E>, Iterable<E> {


    private E[] data;
    private int size;

    /**
     * 构造函数，传入数组的容量capacity构造Array
     */
    @SuppressWarnings("unchecked")
    public ArrayList(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参数的构造函数，默认数组的容量capacity=10
     */
    public ArrayList() {
        this(10);
    }

    @SuppressWarnings("unchecked")
    public ArrayList(E[] arr) {
        data = (E[]) new Object[arr.length];
        System.arraycopy(arr, 0, data, 0, arr.length);
        size = arr.length;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Require index >= 0 and index <= size.");
        }
        if (size == data.length) {
            resize(2 * data.length);
        }
        if (size - index >= 0) {
            System.arraycopy(data, index, data, index + 1, size - index);
        }
        data[index] = e;
        size++;
    }

    /**
     * 将数组空间的容量变成newCapacity大小
     */
    @SuppressWarnings("unchecked")
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        if (size >= 0) {
            System.arraycopy(data, 0, newData, 0, size);
        }
        data = newData;
    }

    @Override
    public void addLast(E e) {
        add(size, e);
    }

    @Override
    public void addFirst(E e) {
        add(0, e);
    }

    @Override
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed. Index is illegal.");
        }
        return data[index];
    }

    @Override
    public E getLast() {
        return get(getSize() - 1);
    }

    @Override
    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed. Index is illegal.");
        }
        data[index] = e;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Index is illegal.");
        }

        E ret = data[index];
        for (int i = index + 1; i < size; i++) {
            data[i - 1] = data[i];
        }
        size--;
        // loitering objects != memory leak
        data[size] = null;

        if (size == data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return ret;
    }

    @Override
    public E removeFirst() {
        return remove(0);
    }

    @Override
    public E removeLast() {
        return remove(size - 1);
    }

    @Override
    public void removeElement(E e) {
        int index = find(e);
        if (index != -1) {
            remove(index);
        }
    }

    @Override
    public void swap(int i, int j) {
        if (i < 0 || i >= size || j < 0 || j >= size) {
            throw new IllegalArgumentException("Index is illegal.");
        }
        E t = data[i];
        data[i] = data[j];
        data[j] = t;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append("ArrayList: size = ").append(size).append(", capacity = ").append(data.length).append("\n");
        res.append('[');
        for (int i = 0; i < size; i++) {
            res.append(data[i]);
            if (i != size - 1) {
                res.append(", ");
            }
        }
        res.append(']');
        return res.toString();
    }

    @SuppressWarnings("unchecked")
    @Override
    public Iterator iterator() {
        return new Iterator() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < size;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                return data[index++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}
