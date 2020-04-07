package com.brayden.uplus.datastructure.stack;

import com.brayden.uplus.datastructure.array.Array;

/**
 * @Description：
 * @Date: Created in 2020/4/7 22:46
 * @Author Brayden
 * @Version 1.0
 */
public class ArrayStackImpl<E> implements Stack <E> {

    private Array <E> array;

     ArrayStackImpl(int capacity) {
        this.array = new Array <>(capacity);
    }

     ArrayStackImpl() {
        this.array = new Array <>();
    }

    @Override
    public void push(E e) {
        array.addLast(e);
    }

    @Override
    public E pop() {
        return array.removeLast();
    }

    @Override
    public E peek() {
        return array.removeLast();
    }

    @Override
    public Integer getSize() {
        return array.getSize();
    }

    @Override
    public Boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("[");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(i);
            if (i < array.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] stack top");
        return sb.toString();
    }
}
