package com.joizhang.imooc.datastructure;

/**
 * 栈接口
 *
 * @author joizhang
 */
public interface Stack<E> {

    /**
     * 入栈
     * @param e 入栈元素
     */
    void push(E e);

    /**
     * 出栈
     * @return 出栈元素
     */
    E pop();

    /**
     * 获取栈顶元素
     *
     * @return 栈顶元素
     */
    E peek();

    /**
     * 获取栈中元素个数
     *
     * @return 栈元素个数
     */
    int getSize();

    /**
     * 栈是否为空
     *
     * @return 是否为空
     */
    boolean isEmpty();

}
