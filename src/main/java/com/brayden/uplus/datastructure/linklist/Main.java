package com.brayden.uplus.datastructure.linklist;

/**
 * @Description：
 * @Date: Created in 2020/5/26 23:27
 * @Author Brayden
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        LinkList <Integer> linkList = new LinkList <>(0, null);

        for (int i = 0; i < 5; i++) {
            linkList.add(i, i);
            System.out.println(linkList);
        }
        linkList.addFirst(888);
        linkList.addLast(111);
        System.out.println(linkList);
        Boolean contain = linkList.isContain(55);
        System.out.println("contain--->" + contain);
        System.out.println(linkList.get(3));
        System.out.println(linkList.getFirst());
        System.out.println(linkList.getLast());
        System.out.println(linkList.delete(2));
        System.out.println(linkList);
        System.out.println(linkList.deleteFirst());
        System.out.println(linkList);
        System.out.println(linkList.deleteLast());
        System.out.println(linkList);


    }
}
