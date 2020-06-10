package com.brayden.uplus.datastructure.linklist;

/**
 * @Description： 实现链表相关的操作   索引从0 开始
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
    private Node dummyHead;

    public LinkList(int size, Node dummyHead) {
        this.size = size;
        this.dummyHead = new Node(null, null);
    }

    public LinkList() {
        this(0, null);
    }


    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    /**
     * 链表长度
     *
     * @return
     */
    public Integer getSize() {
        return size;
    }

    /**
     * 链表头中增加元素
     *
     * @param e
     */
    public void addFirst(E e) {
//        Node node = new Node(e, null);
//        node.next=head;
//        dummyHead.next = new Node(e, null);
//        size++;
        add(0, e);
    }

    /**
     * 链表尾部增加元素
     *
     * @param e
     */
    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 链表中增加元素
     * 增加主要是定位到前一个节点
     *
     * @param index
     * @param e
     */
    public void add(int index, E e) {
        Node prve = dummyHead;
        if (index < 0 || index > size) {
            System.out.println("invail index");
        }
        for (int i = 0; i < index; i++) {
            prve = prve.next;
        }
        prve.next = new Node(e, prve.next);
        size++;
    }

    /**
     * 查询链表index位置的元素
     * 这个要定位到具体的某个元素
     *
     * @param index
     * @return
     */
    public E get(int index) {
        if (index < 0 || index > size) {
            System.out.println("invalid index");
        }
        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        return cur.e;
    }

    /**
     * 取出第一个元素
     *
     * @return
     */
    public E getFirst() {
        return get(0);
    }

    /**
     * 取出最后一个元素
     *
     * @return
     */
    public E getLast() {
        return get(size - 1);
    }

    /**
     * 链表中是否包含某个元素
     *
     * @param e
     * @return
     */
    public Boolean isContain(E e) {
        Node cur = dummyHead;
        while (cur != null) {
            if (e.equals(cur.e)) {
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    /**
     * 删除index位置的元素
     * 定位到前一个元素的位置
     *
     * @param index
     * @return
     */
    public E delete(int index) {
        if (index < 0 || index > size) {
            System.out.println("invalid index");
        }
        Node prve = dummyHead;
        for (int i = 0; i < index; i++) {
            prve = prve.next;
        }
        Node retNode = prve.next;
        prve.next = retNode.next;
        size--;
        return retNode.e;
    }

    public E deleteFirst() {
        return delete(0);
    }

    public E deleteLast() {
        return delete(size - 1);
    }


    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            sb.append(cur.e + "-->");
        }
        return sb.toString();
    }
}
