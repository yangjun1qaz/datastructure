package com.brayden.uplus.datastructure.AVL;

import java.util.ArrayList;
import java.util.List;

/**
 * AVL树  自平衡的二分搜素树
 *
 * @Description：
 * @Date: Created in 2020/7/15 22:59
 * @Author Brayden
 * @Version 1.0
 */
public class AVLTree<E extends Comparable> {

    public class Node<E> {
        public E e;
        public Node left, right;
        public int height;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
            this.height = 1;
        }
    }

    private Node <E> root;
    private Integer size;

    public AVLTree() {
        root = null;
        size = 0;
    }

    public Integer size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 计算节点的高度
     *
     * @param node
     * @return
     */
    private int getHeigth(Node <E> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    /**
     * 计算该节点的平衡因子
     *
     * @param node
     * @return
     */
    private int getBalanceFactor(Node <E> node) {
        if (node == null) {
            return 0;
        }
        return getHeigth(node.left) - getHeigth(node.right);
    }


    /**
     * 检查是否为二分搜素树
     *
     * @return
     */
    public Boolean isBST() {
        ArrayList <E> list = new ArrayList <>();
        List list1 = inOrder(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i - 1).compareTo(list.get(i)) > 0) {
                return false;
            }
        }
        return true;

    }

    /**
     * 判断是不是平衡的二分搜素树
     *
     * @return
     */
    public Boolean isBalanceBST() {
        return isBalanceBST(root);
    }

    private Boolean isBalanceBST(Node <E> node) {
        if (node == null) {
            return true;
        }
        int balanceFactor = getBalanceFactor(node);
        if (Math.abs(balanceFactor) > 1) {
            return false;
        }
        return isBalanceBST(node.left) && isBalanceBST(node.right);
    }


    /**
     * 二分搜素树更加细粒度的分，null也是一个节点 ，递归算法
     *
     * @param e
     */
    public void addPlus(E e) {
        root = addPlus(root, e);
    }

    /**
     * 以node为根的二分搜素树中添加元素
     *
     * @param node
     * @param e
     * @return
     */
    private Node addPlus(Node <E> node, E e) {

        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0) {
            node.left = addPlus(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addPlus(node.right, e);
        } else {
            node.e = e;
        }

        //维护当前节点的高度
        node.height = 1 + Math.max(getHeigth(node.left), getHeigth(node.right));

        //判断当前节点是否平衡
        if (getBalanceFactor(node) > 1) {
            System.out.println("当前tree不是平衡二分搜素树,factor=" + getBalanceFactor(node));
        }
        return node;
    }

    /**
     * 前序遍历
     */
    public void beforeOrder() {
        root = beforeOrder(root);
    }

    private Node beforeOrder(Node <E> node) {

        if (node == null) {
            return null;
        }
        System.out.println(node.e);
        node.left = beforeOrder(node.left);
        node.right = beforeOrder(node.right);
        return node;
    }

    /**
     * 中序遍历
     */
    public void inOrder() {
        root = inOrder(root);
    }

    private Node inOrder(Node <E> node) {
        if (node == null) {
            return null;
        }
        node.left = inOrder(node.left);
        System.out.println(node.e);
        node.right = inOrder(node.right);
        return node;
    }

    /**
     * 中序遍历
     */
    public List inOrder(List <E> list) {
        root = inOrder1(root, list);
        return list;
    }

    private Node inOrder1(Node <E> node, List <E> list) {
        if (node == null) {
            return null;
        }
        node.left = inOrder1(node.left, list);
        list.add(node.e);
        node.right = inOrder1(node.right, list);
        return node;
    }

    /**
     * 后序遍历
     */
    public void afterOrder() {
        root = afterOrder(root);
    }

    private Node afterOrder(Node <E> node) {
        if (node == null) {
            return null;
        }
        node.left = afterOrder(node.left);
        node.right = afterOrder(node.right);
        System.out.println(node.e);
        return node;
    }


    /**
     * 判断是否包含元素
     *
     * @param e
     * @return
     */
    public Boolean isContain(E e) {

        return isContain(root, e);
    }

    private boolean isContain(Node <E> node, E e) {
        //递归中止条件
        if (node == null) {
            return false;
        }
        if (e.compareTo(node.e) == 0) {
            return true;
        } else if (e.compareTo(node.e) < 0) {
            return isContain(node.left, e);
        } else {
            return isContain(node.right, e);
        }
    }
}
