package com.brayden.uplus.datastructure.binarySearchTree;

import java.util.LinkedList;
import java.util.Stack;

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
 * <p>
 * 深度优先遍历 :
 * 前序遍历 : 对当前节点的遍历在对左右孩子节点的遍历之前, 遍历顺序 : 当前节点->左孩子->右孩子
 * 中序遍历 : 对当前节点的遍历在对左右孩子节点的遍历中间, 遍历顺序 : 左孩子->当前节点->右孩子
 * 后序遍历 : 对当前节点的遍历在对左右孩子节点的遍历之后, 遍历顺序 : 左孩子->右孩子->当前节点
 * <p>
 * 广度优先遍历 :
 * 层序遍历 : 按层从左到右进行遍历
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
        } else {
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
     *
     * @param e
     */
    public void addPlus(E e) {
        root = addPlus(root, e);
    }

    private Node addPlus(Node<E> node, E e) {
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

    private Node beforeOrder(Node<E> node) {

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

    private Node inOrder(Node<E> node) {
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

    private Node afterOrder(Node<E> node) {
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
        Stack<Node> stack = new Stack<>();
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
     * 层级遍历（优先广度遍历）
     */
    public void levelOrder() {
        LinkedList<Node> queues = new LinkedList<>();
        queues.add(root);
        while (!queues.isEmpty()) {
            Node cur = queues.poll();
            System.out.println(cur.e);
            if (cur.left != null) {
                queues.add(cur.left);
            }
            if (cur.right != null) {
                queues.add(cur.right);
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

    private boolean isContain(Node<E> node, E e) {
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
     * 获取当前树的最小值
     *
     * @return
     */
    public E getMin() {
        if (size == 0) {
            System.out.println("当前数据结构为空");
        }
        Node<E> min = getMin(root);
        return min.e;
    }

    public Node<E> getMin(Node<E> node) {
        //递归终止条件
        if (node.left == null) {
            return node;
        }
        return getMin(node.left);
    }

    /**
     * 获取当前树的最大值
     *
     * @return
     */
    public E getMax() {
        if (size == 0) {
            System.out.println("当前数据结构为空");
        }
        Node<E> max = getMax(root);
        return max.e;
    }

    public Node<E> getMax(Node<E> node) {
        //递归终止条件
        if (node.right == null) {
            return node;
        }
        return getMax(node.right);
    }

    /**
     * 删除最小元素非递归
     *
     * @return
     */
    public E delMin() {
        Node<E> min = getMin(root);
        Stack<Node<E>> stack = new Stack<Node<E>>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> cur = stack.pop();
            if (cur.left != null && (min.e).equals(cur.left.e)) {
                cur.left = cur.left.right;
                size--;
            } else {
                stack.push(cur.left);
            }
        }
        return min.e;
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
     * 删除最大元素非递归
     *
     * @return
     */
    public E delMax() {
        Node<E> max = getMax(root);
        Stack<Node<E>> stack = new Stack<Node<E>>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<E> cur = stack.pop();
            if (cur.right != null && (max.e).equals(cur.right.e)) {
                cur.right = cur.right.left;
                size--;
            } else {
                stack.push(cur.right);
            }
        }
        return max.e;
    }

    /**
     * 删除最大元素非递归
     *
     * @return
     */
    public E delMaxRecursion() {
        Node<E> max = getMax(root);
        root = delMaxRecursion(root);
        return max.e;
    }

    private Node<E> delMaxRecursion(Node<E> node) {
        //递归中止条件
        if (node.right == null) {
            Node left = node.left;
            node.right = null;
            size--;
            return left;
        }
        node.right = delMaxRecursion(node.right);
        return node;
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

}
