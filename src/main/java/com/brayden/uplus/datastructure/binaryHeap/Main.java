package com.brayden.uplus.datastructure.binaryHeap;

import com.brayden.uplus.datastructure.array.Array;

/**
 * @Description：
 * @Date: Created in 2020/7/11 11:43
 * @Author Brayden
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Integer[] ssa={1,3,78,45,24,7,23,67,89};
        Integer[] ss={1,3,7};
        MaxHeap <Integer> maxHeap = new MaxHeap <Integer>(ss);
        Array <Integer> list = new Array <>();
            while(maxHeap.getSize()>0){
                list.addFirst(maxHeap.extMaxValue());
            }
        for(int j=0;j<list.getSize();j++){
            System.out.println(list.get(j));
        }

    }
}
