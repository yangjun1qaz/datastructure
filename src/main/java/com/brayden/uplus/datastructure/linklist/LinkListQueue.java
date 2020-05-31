package com.brayden.uplus.datastructure.linklist;

import com.brayden.uplus.datastructure.queue.Queue;

/**
 * @Description：
 * @Date: Created in 2020/5/31 22:01
 * @Author Brayden
 * @Version 1.0
 */
public class LinkListQueue<E> implements Queue <E> {


    public class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "" + e;
        }
    }

    private Node head, tail;
    private int size;

    public  LinkListQueue() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    @Override
    public void enqueue(E e) {
        if (tail == null) {
            tail = new Node(e);
            head = tail;
        } else {
            tail.next = new Node(e);
            tail = tail.next;
        }
        size++;
    }

    @Override
    public E dequeue() {
        if (isEmpty()) {
            System.out.println("current queue is null");
        }
        if (head == null) {
            head = tail;
        } else {
            Node retNode = head;
            head = head.next;
            retNode.next = null;
            size--;
            return retNode.e;
        }
        return null;
    }

    @Override
    public E getFront() {
        if (isEmpty()) {
            System.out.println("current queue is null");
        }
        if (head == null) {
            head = tail;
        } else {
            Node retNode = head;
            return retNode.e;
        }
        return null;
    }

    @Override
    public int getSize() {
        return size;
    }

    @Override
    public Boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        Node cur = head;
        sb.append("head[");
        while (cur != null) {
            sb.append(cur.e+"-->");
            cur = cur.next;
        }
        sb.append("] tail");
        return sb.toString();
    }


    public static void main(String[] args) {
        LinkListQueue <Integer> queue = new LinkListQueue <>();
        for (int i = 0; i < 10; i++) {
            queue.enqueue(i);
            if (i % 3 == 2) {
                queue.dequeue();
            }
            System.out.println(queue);
        }
    }


}
