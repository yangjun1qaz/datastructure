package com.brayden.uplus.datastructure.unionfind;

import java.util.Random;

/**
 * @Description：
 * @Date: Created in 2020/7/14 22:01
 * @Author Brayden
 * @Version 1.0
 */
public class Main {

    public double test(UF uf, int m) throws Exception {
        int size = uf.getSize();
        Random random = new Random();
        long startTime = System.nanoTime();

        for (int i = 0; i < m; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            uf.isConnection(p, q);
        }

        for (int i = 0; i < m; i++) {
            int p = random.nextInt(size);
            int q = random.nextInt(size);
            uf.unionElements(p, q);
        }

        long endTime = System.nanoTime();
        return (endTime - startTime) / 100000000.0;

    }

    public static void main(String[] args) throws Exception {
        int m = 10000;
        int size = 100000;
        Main main = new Main();
        UnionFind1 unionFind1 = new UnionFind1(size);
        UnionFind1 unionFind2 = new UnionFind1(size);
        UnionFind1 unionFind3 = new UnionFind1(size);
        UnionFind1 unionFind4 = new UnionFind1(size);
        UnionFind1 unionFind5 = new UnionFind1(size);
        UnionFind1 unionFind6 = new UnionFind1(size);
        System.out.println("one type cost time= " + main.test(unionFind1, m));
        System.out.println("two type cost time= " + main.test(unionFind2, m));
        System.out.println("three type cost time= " + main.test(unionFind3, m));
        System.out.println("four type cost time= " + main.test(unionFind4, m));
        System.out.println("five type cost time= " + main.test(unionFind5, m));
        System.out.println("six type cost time= " + main.test(unionFind6, m));

    }
}
