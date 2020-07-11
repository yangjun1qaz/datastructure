package com.brayden.uplus.datastructure.binaryHeap;


import com.brayden.uplus.datastructure.array.Array;

/**
 * @Description：最大二叉堆的实现
 * @Date: Created in 2020/7/6 23:15
 * @Author Brayden
 * @Version 1.0
 */
public class MaxHeap<E extends Comparable<E>> {

    private Array<E> data;

    private Integer size;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public Integer getSize() {
        return size;
    }

    public Boolean isEmpty() {
        return data.isEmpty();
    }

    /**
     * 通过索引获取父亲节点
     *
     * @param i
     * @return
     * @throws Exception
     */
    private int getParent(int i) throws Exception {
        if (i <= 0) {
            throw new Exception("current node not exist parent node");
        }
        return (i - 1) / 2;
    }

    /**
     * 获取左孩子的索引
     *
     * @param i
     * @return
     * @throws Exception
     */
    private int leftChild(int i) throws Exception {
        if (i <= 0) {
            throw new Exception("current node not exist parent node");
        }
        return (i * 2) + 1;
    }

    /**
     * 获取右孩子的索引
     *
     * @param i
     * @return
     * @throws Exception
     */
    private int rightChild(int i) throws Exception {
        if (i <= 0) {
            throw new Exception("current node not exist parent node");
        }
        return (i * 2) + 2;
    }

    /**
     * 获取堆中的最大元素
     *
     * @return
     */
    public E findMax() {
        return data.get(size - 1);
    }

    /**
     * 堆中添加元素，采用sift up 上浮法
     *
     * @param e
     */
    public void add(E e) throws Exception {
        //数组末尾增加元素
        data.addLast(e);
        //元素增加完之后，采用上浮法进行排序
        siftUp(data.getSize() - 1);
    }

    /**
     * 根据索引上浮
     *
     * @param i
     */
    private void siftUp(int i) throws Exception {
        while (data.get(i).compareTo(data.get(getParent(i))) > 0) {
            swap(i, getParent(i));
            i = getParent(i);
        }
    }

    /**
     * 元素交换位置
     *
     * @param i
     * @param j
     */
    private void swap(int i, int j) {
        E temp = data.get(i);
        data.set(i, data.get(j));
        data.set(j, temp);
    }

    /**
     * 删除二叉堆中的元素e
     *
     * @param e
     */
    public E extMaxValue(E e) throws Exception {
        E max = findMax();
        data.set(0, data.get(size - 1));
        siftDown(0);
        size--;
        return max;
    }

    /**
     * 下沉
     *
     * @param k
     * @throws Exception
     */
    private void siftDown(int k) throws Exception {

        while (leftChild(k) < data.getSize()) {

            int i = leftChild(k);

            //假如有左右孩子，取出最大的孩子
            if (i + 1 < data.getSize() && data.get(i + 1).compareTo(data.get(i)) > 0) {
                i = rightChild(k);
            }

            if (data.get(k).compareTo(data.get(i)) > 0) {
                break;
            }
            swap(k, i);
            k = i;

        }
    }

    /**
     * 替换做大元素，返回最大的元素
     *
     * @return
     */
    public E replace(E e) throws Exception {
        E max = findMax();
        data.set(0, e);
        siftDown(0);
        return max;
    }
}
