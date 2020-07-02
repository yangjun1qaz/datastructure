package com.brayden.uplus.datastructure.leetcode;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * @Description：
 * @Date: Created in 2020/7/2 22:22
 * @Author Brayden
 * @Version 1.0
 */
public class MapTest {


    public Integer[] test(int[] a, int[] b) {
        TreeMap <Integer, Integer> map = new TreeMap <>();
        for (int num : a) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                map.put(num, map.get(num) + 1);
            }
        }
        ArrayList <Integer> result = new ArrayList <>();
        for (int num2 : b) {
            if (map.containsKey(num2)) {
                result.add(num2);
                map.put(num2, map.get(num2) - 1);
                if (map.get(num2) == 0) {
                    map.remove(num2);
                }
            }
        }
        Integer[] integers = new Integer[result.size()];
        for (int i = 0; i < result.size(); i++) {
            integers[i] = result.get(i);
        }
        return integers;
    }


    public static void main(String[] args) {
        int[] a = {1, 3,2,2,5, 6};
        int[] b = {2, 3, 2,7, 8, 9, 0};
        MapTest mapTest = new MapTest();
        Integer[] jiaoji = mapTest.test(a, b);
        for (int num : jiaoji) {
            System.out.println(num);
        }
    }

}
