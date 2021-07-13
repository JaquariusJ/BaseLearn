package com.wujian.多线程.CyclicBarrier测试;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {

    public static void main(String[] args) {
        ExecutorService threadPool = Executors.newFixedThreadPool(5);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5,()->{
            System.out.println("都准备好了，准备出发");
        });

        for (int i = 0; i < 5 ; i++) {
            threadPool.submit(()->{
                try {
                    System.out.println("线程"+Thread.currentThread().getName()+"在准备....");
                    Thread.sleep(new Random().nextInt(1)*1000);
                    cyclicBarrier.await();
                    System.out.println("线程"+Thread.currentThread().getName()+"出发....");
                } catch (InterruptedException | BrokenBarrierException e) {
                    e.printStackTrace();
                }
            });
        }
        threadPool.shutdown();
    }
}
