package com.ericliu.practice.toy.concurrently;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author <a href=mailto:ericliu@fivewh.com>ericliu</a>,Date:2019/10/5
 */
public class RWLock {


    public static void main(String[] args) {
        ExecutorService tp = Executors.newFixedThreadPool(100);

        List<Integer> list = new ArrayList<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        tp.submit(() -> {
            while (true) {
                lock.readLock().lock();
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " t1 睡一秒 打印" + list.remove(0));
                lock.readLock().unlock();
            }
        });

        tp.submit(() -> {
            while (true) {
                lock.readLock().lock();
                Thread.sleep(1000L);
                System.out.println(Thread.currentThread().getName() + " t2 睡一秒 打印" + list.remove(0));
                lock.readLock().unlock();
            }
        });

        tp.submit(() -> {
            Thread.sleep(5000L);
            lock.writeLock().lock();
            System.out.println("我开始上写锁了");
            while (true) {
            }
        });


        for (int i = 0; i < 100; i++) {
            list.add(i);
        }

    }
}
