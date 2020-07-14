package com.brayden.uplus.datastructure.unionfind;

/**
 * 并查集不关注元素的值，关注两个元素之间是否相连
 * 该方式采用数组形式实现，数组的索引代表的第一个元素，里面存储的是关系id
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/14
 */
public class UnionFind1 implements UF {

    private int[] id;


    public UnionFind1(int size) {
        id = new int[size];
        for (int i = 0; i < id.length; i++) {
            id[i] = i;
        }
    }


    @Override
    public int getSize() {
        return id.length;
    }

    /**
     * 找到元素p对应的集合
     * 时间复杂度  O(1)
     * @param p
     * @return
     */
    private int find(int p) {
        return id[p];
    }

    /**
     * 时间复杂度：O(1)
     * @param p
     * @param q
     * @return
     */
    @Override
    public Boolean isConnection(int p, int q) {
        return id[p] == id[q];
    }

    //O(n)
    @Override
    public void unionElements(int p, int q) {
        int pId = find(p);
        int qId = find(q);
        if (pId == qId) {
            return;
        }
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pId) {
                id[i] = qId;
            }
        }
    }
}
