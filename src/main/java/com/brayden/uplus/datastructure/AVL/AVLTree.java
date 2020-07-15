package com.brayden.uplus.datastructure.AVL;

import java.util.Stack;

/**
 * AVL树
 * @Description：
 * @Date: Created in 2020/7/15 22:59
 * @Author Brayden
 * @Version 1.0
 */
public class AVLTree<E extends Comparable> {

    public class Node<E> {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
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


    public void add(E e) {

        if (root == null) {
            root = new Node(e);
            size++;
        } else {
            add(root, e);
        }
    }

    //以node为根的二分搜索树中插入元素e,递归算法
    private void add(Node <E> node, E e) {

        if (e.equals(root.e)) {
            return;
        }
        if (e.compareTo(node.e) < 0 && node.left == null) {
            node.left = new Node(e);
            size++;
        } else if (e.compareTo(node.e) > 0 && node.right == null) {
            node.right = new Node(e);
            size++;
        }

        if (e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            add(node.right, e);
        }
    }

    /**
     * 二分搜素树更加细粒度的分，null也是一个节点 ，递归算法
     *
     * @param e
     */
    public void addPlus(E e) {
        root = addPlus(root, e);
    }

    private Node addPlus(Node <E> node, E e) {
        if (node == null) {
            size++;
            return new Node(e);
        }
        if (e.compareTo(node.e) < 0) {
            node.left = addPlus(node.left, e);
        } else if (e.compareTo(node.e) > 0) {
            node.right = addPlus(node.right, e);
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
     * 非递归实现二分搜索树的前序遍历（优先深度遍历）
     */
    public void beforeNoRecursion() {
        Stack <Node> stack = new Stack <>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node cur = stack.pop();
            System.out.println(cur.e);

            if (cur.right != null) {
                stack.push(cur.right);
            }
            if (cur.left != null) {
                stack.push(cur.left);
            }
        }
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
