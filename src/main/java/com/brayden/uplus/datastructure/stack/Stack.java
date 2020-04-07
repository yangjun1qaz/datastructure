package com.brayden.uplus.datastructure.stack;

/**
 * @Description：
 * @Date: Created in 2020/4/7 22:39
 * @Author Brayden
 * @Version 1.0
 */
public interface Stack<E> {
    /**
     * 栈中push一个元素
     *
     * @param e
     */
    void push(E e);

    /**
     * 栈中弹出一个元素
     *
     * @return
     */
    E pop();

    /**
     * 弹出栈顶的元素
     *
     * @return
     */
    E peek();

    /**
     * 栈中元素的个数
     *
     * @return
     */
    Integer getSize();

    /**
     * 判断是否为空
     *
     * @return
     */
    Boolean isEmpty();
}
