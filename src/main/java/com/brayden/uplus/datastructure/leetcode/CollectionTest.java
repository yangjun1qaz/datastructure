package com.brayden.uplus.datastructure.leetcode;

import java.util.ArrayList;
import java.util.TreeSet;

/**
 * @Description：
 * @Date: Created in 2020/7/2 21:28
 * @Author Brayden
 * @Version 1.0
 */
public class CollectionTest {


    private Integer[] jiaoji(int[] a, int[] b) {

        TreeSet <Integer> set = new TreeSet <>();
        for (int num1 : a) {
            set.add(num1);
        }
        ArrayList <Integer> result = new ArrayList <Integer>();
        for (int num2 : b) {
            if (set.contains(num2)) {
                result.add(num2);
                set.remove(num2);
            }
        }
        Integer[] integers = new Integer[result.size()];
        for (int i = 0; i < result.size(); i++) {
            integers[i] = result.get(i);
        }
        return integers;
    }


    public static void main(String[] args) {
        int[] a = {1, 3, 2, 5, 6};
        int[] b = {2, 3, 7, 8, 9, 0};
        CollectionTest collectionTest = new CollectionTest();
        Integer[] jiaoji = collectionTest.jiaoji(a, b);
        for (int num : jiaoji) {
            System.out.println(num);
        }
    }
}
