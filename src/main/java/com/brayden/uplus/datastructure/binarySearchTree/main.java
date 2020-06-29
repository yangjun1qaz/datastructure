package com.brayden.uplus.datastructure.binarySearchTree;

import java.util.concurrent.CountDownLatch;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/6/22
 */
public class main {

    public static void main(String[] args) {
        BST<Integer> bst = new BST<>();
        Integer[] test=new Integer[]{4,1,2,6,5,8};
        for(int i=0;i<test.length;i++){
            bst.addPlus(test[i]);
        }
        //bst.afterOrder();
        bst.preOrder();

        CountDownLatch countDownLatch = new CountDownLatch(2);
    }


}
