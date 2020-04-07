package com.brayden.uplus.datastructure.stack;

/**
 * @Description：
 * @Date: Created in 2020/4/7 23:00
 * @Author Brayden
 * @Version 1.0
 */
public class Main {


    public static void main(String[] args) {
        ArrayStackImpl <Integer> stack = new ArrayStackImpl();
        for (int i = 0; i < 5; i++) {
            stack.push(i);
            System.out.println(stack);
        }
        stack.pop();
        System.out.println(stack);
        stack.peek();
        System.out.println(stack);
    }

}
