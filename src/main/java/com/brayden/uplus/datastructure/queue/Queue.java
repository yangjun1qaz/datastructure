package com.brayden.uplus.datastructure.queue;

/**
 * @Description： 数组实现队列
 * @Date: Created in 2020/4/8 22:27
 * @Author Brayden
 * @Version 1.0
 */
public interface Queue<E> {

    /**
     * 队列中增加元素
     */
    public void enqueue(E e);

    /**
     * 队列中取出元素
     *
     * @return
     */
    public E dequeue();

    /**
     * 取出队首的元素
     *
     * @return
     */
    public E getFront();

    /**
     * 队列中元素的个数
     *
     * @return
     */
    public int getSize();

    /**
     * 判断队列是否为空
     *
     * @return
     */
    public Boolean isEmpty();
}
