package com.wujian.多线程.CountDownLatch测试;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest2 {

    public static void main(String[] args) {
        int threadSize = 5;
        ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);

        CountDownLatch countDownLatch = new CountDownLatch(threadSize);

        for (int i = 0; i < threadSize ; i++) {
            threadPool.submit(()->{
                try {
                    Thread.sleep(3000);
                    System.out.println("线程"+Thread.currentThread().getName()+"到达终点");
                    countDownLatch.countDown();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            countDownLatch.await();
            System.out.println("比赛结束");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
