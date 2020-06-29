package com.brayden.uplus.datastructure.jdk18feature;

/**
 * 1. 内存可见性
 * 内存可见性（Memory Visibility）是指当某个线程正在使用对象状态而另一个线程在同时修改该状态，需要确保当一个线程修改了对象状态后，
 * 其他线程能够看到发生的状态变化。
 * 可见性错误是指当读操作与写操作在不同的线程中执行时，我们无法确保执行读操作的线程能适时地看到其他线程写入的值，有时甚至是根本不可能的事情。
 * 我们可以通过同步来保证对象被安全地发布。除此之外我们也可以使用一种更加轻量级的 volatile变量。
 * <p>
 * 2. volatile 关键字
 * Java 提供了一种稍弱的同步机制，即 volatile 变量，用来确保将变量的更新操作通知到其他线程。可以将 volatile 看做一个轻量级的锁，
 * 但是又与锁有些不同：
 * <p>
 * 对于多线程，不是一种互斥关系
 * 不能保证变量状态的“原子性操作”
 *
 * @author Brayden
 * @version 1.0
 * @date 2020/6/22
 */
public class VolatileTest {

    public static void main(String[] args) {
        ThreadA threadA = new ThreadA();
        new Thread(threadA).start();
        while(true){
            if(threadA.getFlag()){
                System.out.println("flag="+threadA.getFlag());
              break;
            }
            System.out.println("运行中");
        }
    }


}

class ThreadA implements Runnable {

    public volatile boolean flag = false;

    @Override
    public void run() {
        try {
            Thread.sleep(1000);
            flag = true;
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public Boolean getFlag(){
        return flag;
    }
}

