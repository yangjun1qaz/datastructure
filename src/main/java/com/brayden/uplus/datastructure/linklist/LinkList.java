package com.brayden.uplus.datastructure.linklist;

/**
 * @Description： 实现链表相关的操作
 * @Date: Created in 2020/5/26 22:58
 * @Author Brayden
 * @Version 1.0
 */
public class LinkList<E> {

    public class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return "" + e;
        }
    }

    private int size;
    private Node head;

    //获取链表的长度
    public Integer getSize() {
        return size;
    }

    //头结点中增加元素
    public void addFirst(E e) {
//        Node node = new Node(e, null);
//        node.next=head;
        head = new Node(e, null);
        size++;
    }

    public void add(int index, E e) {
        Node prve = head;
        if (index < 0 || index > size) {
            System.out.println("invail index");
        }
        if (index == 0) {
            head = new Node(e, null);
            size++;
        } else {
            for (int i = 0; i < index - 1; i++) {
                prve = prve.next;
            }
            prve.next = new Node(e, prve.next);
            size++;
        }
    }

    public void addLast(E e) {
        add(size, e);
    }

    public Boolean isContain(E e) {
        Node cur = head;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.e + "-->");
        }
        return sb.toString();
    }
}
