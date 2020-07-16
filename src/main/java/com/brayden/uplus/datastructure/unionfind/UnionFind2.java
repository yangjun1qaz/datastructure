package com.brayden.uplus.datastructure.unionfind;

/**
 * 这种采用的是一种抽象的倒树形式实现
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/14
 */
public class UnionFind2 implements UF {

    private int[] parent;

    public UnionFind2(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 通过元素找到跟节点
     *时间复杂度跟树的深度 h  有关 o(H)
     * @param p
     * @return
     */
    private int find(int p) throws Exception {
        if (p < 0 || p > parent.length) {
            throw new Exception("p out of boud");
        }
        while (p != parent[p]) {
            p = parent[p];
        }
        return parent[p];
    }

    //O(h)
    @Override
    public Boolean isConnection(int p, int q) throws Exception {
        return find(p) == find(q);
    }
    //O(h)
    @Override
    public void unionElements(int p, int q) throws Exception {
        int pROOT = find(p);
        int qRoot = find(q);

        if (pROOT == qRoot) {
            return;
        }
        parent[pROOT] = qRoot;
    }
}
