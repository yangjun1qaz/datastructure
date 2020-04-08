package com.brayden.uplus.datastructure.queue;

import com.brayden.uplus.datastructure.array.Array;

/**
 * @Description：
 * @Date: Created in 2020/4/8 22:31
 * @Author Brayden
 * @Version 1.0
 */
public class ArrayQueueImpl<E> implements Queue <E> {

    private Array <E> array;

    public ArrayQueueImpl(int capacity) {
        this.array = new Array <E>(capacity);
    }

    public ArrayQueueImpl() {
        this.array = new Array <>();
    }

    @Override
    public void enqueue(E e) {
        array.addLast(e);
    }

    @Override
    public E dequeue() {
        return array.removeFirset();
    }

    @Override
    public E getFront() {
        return array.getFirst();
    }

    @Override
    public int getSize() {
        return array.getSize();
    }

    @Override
    public Boolean isEmpty() {
        return array.isEmpty();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("front [");
        for (int i = 0; i < array.getSize(); i++) {
            sb.append(array.get(i));
            if (i != array.getSize() - 1) {
                sb.append(",");
            }
        }
        sb.append("] top");
        return sb.toString();
    }
}
