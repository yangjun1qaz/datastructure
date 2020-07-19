package com.brayden.uplus.datastructure.AVL;

import java.util.Random;

/**
 * @Description：
 * @Date: Created in 2020/7/19 22:39
 * @Author Brayden
 * @Version 1.0
 */
public class Mian {
    public static void main(String[] args) {
        Random random = new Random();
        AVLTree <Integer> avl = new AVLTree <>();
        for(int i=0;i<1200;i++){
            avl.addPlus(random.nextInt(1000));
        }
        avl.inOrder();
        System.out.println(avl.isBST());
        System.out.println(avl.isBalanceBST());
    }

}
