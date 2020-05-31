package com.brayden.uplus.datastructure.linklist;

import com.brayden.uplus.datastructure.stack.Stack;

/**
 * @Description：
 * @Date: Created in 2020/5/31 20:53
 * @Author Brayden
 * @Version 1.0
 */
public class LinkListStack<E> implements Stack <E> {

    private LinkList <E> linkList;

    public LinkListStack() {
        linkList = new LinkList <E>();
    }

    @Override
    public void push(E e) {
        linkList.addLast(e);
    }

    @Override
    public E pop() {
        return linkList.deleteLast();
    }

    @Override
    public E peek() {
        return linkList.getFirst();
    }

    @Override
    public Integer getSize() {
        return linkList.getSize();
    }

    @Override
    public Boolean isEmpty() {
        return linkList.isEmpty();
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(linkList);
        return sb.toString();
    }

    public static void main(String[] args) {
        LinkListStack <Integer> stack = new LinkListStack <>();

        for(int i=0;i<10;i++){
            stack.push(i);
        }
        System.out.println(stack);
    }
}
