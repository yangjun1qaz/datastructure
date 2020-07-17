package com.brayden.uplus.datastructure.thread;

import java.util.concurrent.CountDownLatch;

/**
 * @author Brayden
 * @version 1.0
 * @date 2020/7/16
 */
public class ThreadOderRun {
    public static void main(String[] args) {
        ThreadOderRun threadOderRun = new ThreadOderRun();
        CountDownLatch l1 = new CountDownLatch(0);
        CountDownLatch l2 = new CountDownLatch(1);
        CountDownLatch l3 = new CountDownLatch(1);
        Thread work1 = new Thread(threadOderRun.new Work(l1, l2, "1"));
        Thread work2 = new Thread(threadOderRun.new Work(l2, l3, "2"));
        Thread work3 = new Thread(threadOderRun.new Work(l3, l3, "3"));
        work1.start();
        work2.start();
        work3.start();
    }


    class Work implements Runnable {
        CountDownLatch c1;
        CountDownLatch c2;
        String msg;

        public Work(CountDownLatch c1, CountDownLatch c2, String msg) {
            this.c1 = c1;
            this.msg = msg;
            this.c2=c2;
        }

        public void run() {
            try {
                c1.await();
                System.out.println(msg);
                c2.countDown();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}