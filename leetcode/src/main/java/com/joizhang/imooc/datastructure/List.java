package com.joizhang.imooc.datastructure;

/**
 * 表
 *
 * @author joizhang
 */
public interface List<E> {

    /**
     * 获取数组中的元素个数
     *
     * @return 数组中的元素个数
     */
    int getSize();

    /**
     * 返回数组是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

    /**
     * 在index索引的位置插入一个新元素e
     *
     * @param index 索引位置
     * @param e 新元素
     */
    void add(int index, E e);

    /**
     * 向所有元素后添加一个新元素
     *
     * @param e 新元素
     */
    void addLast(E e);

    /**
     * 在所有元素前添加一个新元素
     *
     * @param e 新元素
     */
    void addFirst(E e);

    /**
     * 获取index索引位置的元素
     *
     * @param index 索引
     * @return index索引位置的元素
     */
    E get(int index);

    /**
     * 获取最后的元素
     * @return 最后的元素
     */
    E getLast();

    /**
     * 修改index索引位置的元素为e
     *
     * @param index 索引位置
     * @param e 新元素
     */
    void set(int index, E e);

    /**
     * 判断数组中是否有元素e
     *
     * @param e 待查找元素
     * @return 是否有元素e
     */
    boolean contains(E e);

    /**
     * 查找数组中元素e所在的索引，如果不存在元素e，则返回-1
     *
     * @param e 待查找元素
     * @return 元素e所在的索引
     */
    int find(E e);

    /**
     * 从数组中删除index位置的元素, 返回删除的元素
     *
     * @param index 索引位置
     * @return 删除的元素
     */
    E remove(int index);

    /**
     * 从数组中删除第一个元素, 返回删除的元素
     *
     * @return 删除的元素
     */
    E removeFirst();

    /**
     * 从数组中删除最后一个元素, 返回删除的元素
     *
     * @return 删除的元素
     */
    E removeLast();

    /**
     * 从数组中删除元素e
     * @param e
     */
    void removeElement(E e);

    /**
     * 交换i, j位置的元素
     *
     * @param i 位置
     * @param j 位置
     */
    void swap(int i, int j);



}
