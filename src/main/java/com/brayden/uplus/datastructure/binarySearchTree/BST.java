package com.brayden.uplus.datastructure.binarySearchTree;

/**
 * 二分搜索树（binary search tree）
 * <p>
 * 二分搜素树每一个节点的值
 * 必须小于于左子树所有节点的值
 * 必须大于右子树所有节点的值
 * <p>
 * 二分搜素树里面存储的元素必须要有可比较性（数据跟链表中没有）
 * <p>
 * 为了保证有可比较性 泛型 E 继承 Comparable
 * <p>
 * 下面主要通过递归算法进行实现二分搜素树
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/6/10
 */
public class BST<E extends Comparable<E>> {


    public class Node<E> {
        public E e;
        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node<E> root;
    private Integer size;

    public BST() {
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
        }else{
            add(root, e);
        }
    }

    //以node为根的二分搜索树中插入元素e,递归算法
    private void add(Node<E> node, E e) {

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
     * @param e
     */
    public void addPlus(E e){
        root=addPlus(root,e);
    }

    private Node addPlus(Node<E> node,E e){
        if(node ==null){
            size++;
           return  new Node(e);
        }
        if(e.compareTo(node.e)<0){
            node.left=addPlus(node.left,e);
        }else if(e.compareTo(node.e)>0){
            node.right=addPlus(node.right,e);
        }
        return node;
    }
}
