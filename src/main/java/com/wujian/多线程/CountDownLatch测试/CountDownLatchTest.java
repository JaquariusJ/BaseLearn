package com.wujian.多线程.CountDownLatch测试;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CountDownLatchTest {


    public static void main(String[] args) {
        int threadSize = 5;
        ExecutorService threadPool = Executors.newFixedThreadPool(threadSize);
        CountDownLatch countDownLatch = new CountDownLatch(1);

        for (int i = 0; i < threadSize ; i++) {
            threadPool.submit(()->{
                try {
                    countDownLatch.await();
                    System.out.println("线程"+Thread.currentThread().getName()+"开始跑");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("枪声响起");
        countDownLatch.countDown();

    }
}
