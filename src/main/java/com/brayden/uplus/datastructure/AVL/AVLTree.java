package com.brayden.uplus.datastructure.AVL;

import com.brayden.uplus.datastructure.binarySearchTree.BST;

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
     * 右旋转
     *        y
     *       / \
     *      x   T1   ====>               X
     *    /  \                         /   \
     *   z    T2                      Z     y
     * /  \                         /  \   / \
     *T3   T4                      T3  T4  T2 T1
     * @param ndoe
     * @return
     */
    private Node RightRotate(Node<E> y){
        Node x = y.left;
        Node T2 = x.right;
        x.right=y;
        y.left=T2;

        //更新节点的height值
        y.height=Math.max(getHeigth(y.left),getHeigth(y.right))+1;
        x.height=Math.max(getHeigth(x.left),getHeigth(x.right))+1;
        return x;
    }

    /**左旋转
     *
     *      y
     *    /   \
     *   T1    x        =====>              X
     *       /  \                        /    \
     *      T2   Z                      y      z
     *          /  \                   / \    / \
     *         T3   T4                T1  T2 T3  T4
     *
     * @param y
     * @return
     */
    private Node leftRotate(Node<E> y){
        Node x = y.right;
        Node T2 = x.left;
        x.left=y;
        y.right=T2;
        //维护节点高度
        y.height=Math.max(getHeigth(y.right),getHeigth(y.left))+1;
        x.height=Math.max(getHeigth(x.left),getHeigth(x.right))+1;
        return x;
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

        //判断当前节点是否平衡，如果不平衡的话，进行旋转
        //LL
        if (getBalanceFactor(node) > 1&&getBalanceFactor(node.left)>=0) {
            //进行右旋转，并且将返回的节点的return 到上面的递归中
            return RightRotate(node);
        }
        //RR
        if(getBalanceFactor(node)<-1&&getBalanceFactor(node.right)<=0){
            //进行左旋转，并且将返回的节点的return 到上面的递归中
            return leftRotate(node);
        }
        //LR
        if(getBalanceFactor(node)>1&&getBalanceFactor(node.left)<0){
            node.left=leftRotate(node.left);
            return RightRotate(node);
        }
        //RL
        if(getBalanceFactor(node)<-1&&getBalanceFactor(node.right)>0){
            node.right=RightRotate(node.right);
            return leftRotate(node);
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

    /**
     * 删除二分搜索树中的任何一个节点
     *
     * @param e
     */
    public void remove(E e) {
        root = remove(root, e);
    }

    /**
     * 删除节点左右子树都有，这种情况采用Hibbard delete 删除
     * 待删除节点d,找出d右孩子中最小的节点s，用s代替d的位置
     *
     * @param node
     * @param e
     * @return
     */
    private Node<E> remove(Node<E> node, E e) {
        if (node == null) {
            return null;
        }
        //当前值小，进入左子树进行查找
        if (e.compareTo(node.e) < 0) {
            node.left = remove(node.left, e);
            return node;
        } else if (e.compareTo(node.e) > 0) {
            node.right = remove(node.right, e);
            return node;
            //值相等
        } else {//e=node.e

            //左子树为null
            if (node.left == null) {
                Node right = node.right;
                node.right = null;
                size--;
                return right;

                //右子树为null
            } else if (node.right == null) {
                Node left = node.left;
                node.left = null;
                size--;
                return left;
                //左右子树都不为null 采用Hibbard delete
                //找到待删除节点的右子树中最小的节点，然后放在跟节点的位置
            } else {
                Node min = getMin(node.right);
                min.right=delMinRecursion(node.right);
                min.left=node.left;
                node.left=node.right=null;
                return min;
            }
        }
    }

    /**
     * 删除最小元素递归
     *
     * @return
     */
    public E delMinRecursion() {
        Node<E> min = getMin(root);
        root = delMinRecursion(root);
        return min.e;
    }

    private Node<E> delMinRecursion(Node<E> node) {
        //递归中止条件
        if (node.left == null) {
            Node right = node.right;
            node.left = null;
            size--;
            return right;
        }
        node.left = delMinRecursion(node.left);
        return node;
    }

    /**
     * 获取最小元素
     * @param node
     * @return
     */
    public Node<E> getMin(Node<E> node) {
        //递归终止条件
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }


}
