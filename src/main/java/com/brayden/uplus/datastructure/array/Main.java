package com.brayden.uplus.datastructure.array;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/3/31 23:06
 */
public class Main {

    public static void main(String[] args) {
        Array array = new Array(15);
        for(int i=0;i<100;i++){
            array.addLast(i);
        }
        System.out.println(array);
        array.add(2,18);
        System.out.println(array);
        System.out.println(array.find(9));

        Array<Student> array1 = new Array<>();
        array1.addFirst(new Student("brayden",14));
        array1.addFirst(new Student("yangxiaoran",12));
        array1.addFirst(new Student("tiantian",16));
        System.out.println(array1);
    }
}
