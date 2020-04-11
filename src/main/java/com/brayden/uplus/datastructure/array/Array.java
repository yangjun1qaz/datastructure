package com.brayden.uplus.datastructure.array;

/**
 * 封装数组类
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/3/31 21:31
 */
public class Array<E> {

    private E[] data;
    /**
     * 数组中多少个元素，同时指向数组中第一个没有元素的位置
     */
    private int size;

    /**
     * 构造函数
     *
     * @param capacity 数组容量
     */
    public Array(int capacity) {
        data = (E[]) new Object[capacity];
        size = 0;
    }

    /**
     * 无参构造函数
     */
    public Array() {
        this(20);
    }

    /**
     * 获取数组中元素个数
     *
     * @return
     */
    public int getSize() {
        return size;
    }

    /**
     * 获取数组的容量
     *
     * @return
     */


    public int getCapacity() {
        return data.length;
    }

    /**
     * 判断数组是否为空
     *
     * @return
     */
    public Boolean isEmpty() {
        return size == 0;
    }

    /**
     * 数组末尾增加元素
     *
     * @param e 元素
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 取出最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 取出第一个元素
     *
     * @return
     */
    public E getFirst() {
        return data[0];
    }

    /**
     * 数组第一位增加元素
     *
     * @param e
     */
    public void addFirst(E e) {
        add(0, e);
    }

    /**
     * 数组中指定索引增加元素
     *
     * @param index 索引
     * @param e     元素
     */
    public void add(int index, E e) {
        if (size == data.length - 1) {
            resize(2 * data.length);
        }
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add fails Require index<0||index>size");
        }
        for (int i = size; i >= index; i--) {
            data[i + 1] = data[i];
        }
        data[index] = e;
        size++;
    }

    /**
     * 获取元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("get fails index is illegal");
        }
        return data[index];
    }

    /**
     * 更新数组
     *
     * @param index
     * @param e
     * @return
     */
    public void set(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("get fails index is illegal");
        }
        data[index] = e;
    }

    /**
     * 查找数组中是否包含元素
     *
     * @param e
     * @return
     */
    public Boolean contain(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return true;
            }
        }
        return false;
    }

    /**
     * 查找原因的索引
     *
     * @param e
     * @return -1 没有改元素
     */
    public int find(E e) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 删除元素
     *
     * @param index
     * @param e
     * @return
     */
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("delete fails Require index<0||index>=size");
        }
        E tem = data[index];
        for (int i = index; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        //当容量过大，里面元素少的话，自动回收,防止产生data[0]的情况
        if (size < data.length / 4 && data.length / 2 != 0) {
            resize(data.length / 2);
        }
        return tem;
    }


    /**
     * 移除最后一个元素
     *
     * @param e
     * @return
     */
    public E removeLast() {
        return remove(size - 1);
    }

    /**
     * 移除第一个元素
     *
     * @param e
     * @return
     */
    public E removeFirset() {
        return remove(0);
    }

    /**
     * 自动扩容
     *
     * @param newCapacity 新的容量
     */
    private void resize(int newCapacity) {
        E[] newData = (E[]) new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        data = newData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Array size= %d,capacity = %d %n", size, data.length));
        sb.append("[");
        for (int i = 0; i < size; i++) {
            sb.append(data[i]);
            if (i != size - 1) {
                sb.append(",");
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
