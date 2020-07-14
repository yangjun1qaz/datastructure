package com.brayden.uplus.datastructure.unionfind;

/**
 * 基于size优化   相当于把元素个数少的节点指向元素个数多的节点，这样益于提升效率
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/14
 */
public class UnionFind3 implements UF {

    private int[] parent;
    private int[] sz;//sz[i] 表示以i为根的集合中的元素个数

    public UnionFind3(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            sz[i] = 1;
        }
    }

    @Override
    public int getSize() {
        return parent.length;
    }

    /**
     * 通过元素找到跟节点
     *
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

    @Override
    public Boolean isConnection(int p, int q) throws Exception {
        return find(p) == find(q);
    }

    @Override
    public void unionElements(int p, int q) throws Exception {
        int pROOT = find(p);
        int qRoot = find(q);

        if (pROOT == qRoot) {
            return;
        }
        if (sz[pROOT] < sz[qRoot]) {
            parent[pROOT] = qRoot;
            sz[qRoot] += sz[qRoot];
        } else {
            parent[qRoot] = pROOT;
            sz[pROOT] += sz[qRoot];
        }
    }
}
