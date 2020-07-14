package com.brayden.uplus.datastructure.unionfind;

/**
 * 路径压缩，让树的所有节点指向同一跟节点
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/7/14
 */
public class UnionFind6 implements UF {

    private int[] parent;
    private int[] rank;//rank[i] 表示以i为根的集合所表示树的层数

    public UnionFind6(int size) {
        parent = new int[size];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = i;
            rank[i] = 1;
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
          parent[p]=find(p);
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
        //将深度低的指向深度高的
        if (rank[pROOT] < rank[qRoot]) {
            parent[pROOT] = qRoot;
        } else if (rank[pROOT] > rank[qRoot]) {
            parent[qRoot] = pROOT;
        }//如果深度相等，不管任意一方谁指向谁，指向放树的深度会增加1
        else {
            parent[qRoot] = pROOT;
            rank[qRoot] += 1;
        }
    }
}
