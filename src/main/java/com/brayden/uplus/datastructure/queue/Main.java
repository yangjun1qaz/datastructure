package com.brayden.uplus.datastructure.queue;

/**
 * @Description：
 * @Date: Created in 2020/4/8 22:39
 * @Author Brayden
 * @Version 1.0
 */
public class Main {
    public static void main(String[] args) {
        ArrayQueueImpl <Integer> queue = new ArrayQueueImpl <>();
        for(int i=0;i<10;i++){
            queue.enqueue(i);
            System.out.println(queue);
            if(i%3==2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
