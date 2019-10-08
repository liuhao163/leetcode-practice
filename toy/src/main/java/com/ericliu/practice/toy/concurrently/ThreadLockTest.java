package com.ericliu.practice.toy.concurrently;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/10/5
 */
public class ThreadLockTest {


    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        ExecutorService tp = Executors.newFixedThreadPool(100);


        List<Integer> list=new ArrayList<>();

        tp.submit(() -> {
            while (true) {
                synchronized (lock1) {
                    try {
                        lock1.wait(1L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println(Thread.currentThread().getName()+" t1 睡一秒 打印"+list.remove(0));
                }
            }
        });

        tp.submit(() -> {
            while (true) {
                synchronized (lock1) {
                    try {
                        lock1.wait(1L);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                    System.out.println(Thread.currentThread().getName()+" t1 睡一秒 打印"+list.remove(0));
                }
            }
        });

        tp.submit(() -> {
            synchronized (lock2) {
                System.out.println(Thread.currentThread().getName()+" t2持有锁lock1不释放");
                while (true) {
                }
            }
        });

        for (int i=0;i<100;i++){
            list.add(i);
        }
    }
}
