package com.brayden.uplus.datastructure.linklist;

/**
 * @Description：
 * @Date: Created in 2020/5/26 23:27
 * @Author Brayden
 * @Version 1.0
 */
public class Main {

    public static void main(String[] args) {

        LinkList <Integer> linkList = new LinkList <>();



        for(int i=0;i<5;i++){
            linkList.add(i,i);
            System.out.println(linkList);
        }
        linkList.add(3,55);
        Boolean contain = linkList.isContain(55);
        System.out.println(linkList);
        System.out.println("contain--->"+contain);

    }
}
