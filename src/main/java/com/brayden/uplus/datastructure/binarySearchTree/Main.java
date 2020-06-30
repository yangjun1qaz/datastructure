package com.brayden.uplus.datastructure.binarySearchTree;


/**
 * @Description：
 * @Date: Created in 2020/6/28 14:44
 * @Author Brayden
 * @Version 1.0
 */
public class Main {


    public static void main(String[] args) {
        BST <Integer> bst = new BST <>();
        int[] ints = {4, 7, 2, 5, 9};
        for (int i = 0; i < ints.length; i++) {
            bst.addPlus(ints[i]);
        }
//        4
//       / \
//      2   7
//         / \
//        5   9
        // bst.beforeOrder();
        //bst.inOrder();
        //bst.afterOrder();
        // bst.beforeNoRecursion();
        //bst.levelOrder();
        //System.out.println(bst.isContain(2));
        // System.out.println(bst.getMin());
        // System.out.println(bst.getMax());

//        bst.inOrder();
//        bst.delMin();
//        System.out.println("------------");
//        bst.inOrder();


//        bst.inOrder();
//        bst.delMax();
//        bst.delMax();
//        System.out.println("------------");
//        bst.inOrder();

        bst.inOrder();
        bst.delMinRecursion();
        bst.delMinRecursion();
        bst.delMinRecursion();
        System.out.println("------------");
        bst.inOrder();
    }
}
