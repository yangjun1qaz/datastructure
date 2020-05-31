package com.brayden.uplus.datastructure.linklist;

import com.brayden.uplus.datastructure.queue.LoopQueueImpl;
import com.brayden.uplus.datastructure.queue.Queue;

import java.util.Random;

/**
 * @Description：
 * @Date: Created in 2020/5/31 23:13
 * @Author Brayden
 * @Version 1.0
 */
public class QueueCompare {


    /**
     * 测试 队列不同实现count个数的效率
     *
     * @param queue
     * @param count
     * @return
     */
    public static double test(Queue <Integer> queue, int count) {
        long startTime = System.nanoTime();
        Random random = new Random();
        for (int i = 0; i < count; i++) {
            queue.enqueue(random.nextInt(Integer.MAX_VALUE));
        }
        for (int i = 0; i < count; i++) {
            queue.dequeue();
        }
        long endTime = System.nanoTime();

        long costTime = endTime-startTime ;

        return costTime / 1000000000.0;
    }

    public static void main(String[] args) {
        int count = 1000000;
//        ArrayQueueImpl <Integer> arrayQueue = new ArrayQueueImpl <>();
//        double test = test(arrayQueue, count);
//        System.out.println("arrayQueue cost time="+test+"ms");

        LoopQueueImpl <Integer> loopQueue = new LoopQueueImpl <>();
        double test1 = test(loopQueue, count);
        System.out.println("loopQueue cost time="+test1+"ms");

        LinkListQueue <Integer> linkListQueue = new LinkListQueue <Integer>();
        double test2 = test(linkListQueue, count);
        System.out.println("linkListQueue cost time="+test2+"ms");
    }
}
