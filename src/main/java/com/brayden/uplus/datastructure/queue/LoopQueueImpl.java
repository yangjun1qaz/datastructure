package com.brayden.uplus.datastructure.queue;

/**
 * @Description：
 * @Date: Created in 2020/5/31 19:18
 * @Author Brayden
 * @Version 1.0
 */
public class LoopQueueImpl<E> implements Queue <E> {

    private int front, tail;
    private int size;
    private E[] data;

    public LoopQueueImpl(int capaCity) {
        this.front = 0;
        this.tail = 0;
        this.size = 0;
        data = (E[]) (new Object[capaCity + 1]);
    }


    public LoopQueueImpl() {
        this(10 + 1);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    /**
     * 循环队列中  front==tail 说明队列为null     (tail+1)%c==front 说明队列已满
     *
     * @param e
     */
    @Override
    public void enqueue(E e) {
        //说明队列已满，需要扩容
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }
        data[tail] = e;
        tail = (tail + 1) % (data.length);
        size++;
    }

    private void resize(int newCapacity) {
        E[] newData = (E[]) (new Object[newCapacity + 1]);
        for (int i = 0; i < size; i++) {
            newData[i] = data[(front + 1) % data.length];
        }
        data = newData;
        front = 0;
        tail = getSize() + 1;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("current queue is null");
        }
        E retData = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size--;
        //取完元素之后，空间容量过大的话，要进行缩容
        if (getCapacity() / 4 == size && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }
        return retData;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            System.out.println("current queue is null");
        }
        return data[front];

    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append("front[");
        for (int i = front; i != tail; i = (i + 1) % data.length) {
            sb.append(data[i]);
            if (i + 1 % data.length != tail) {
                sb.append(",");
            }
        }
        sb.append("] tail");
        sb.append("capacity=");
        sb.append(getCapacity());
        return sb.toString();
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Boolean isEmpty() {
        if (tail == front) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        LoopQueueImpl <Integer> loopQueue = new LoopQueueImpl <Integer>(10);
        for (int i = 0; i < 10; i++) {
            loopQueue.enqueue(i);
            System.out.println(loopQueue);
        }
    }
}
