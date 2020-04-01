package com.brayden.uplus.datastructure.array;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/3/31 23:16
 */
public class Student {

    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("Student name= %s,age=%d",name,age));
        return sb.toString();
    }
}
