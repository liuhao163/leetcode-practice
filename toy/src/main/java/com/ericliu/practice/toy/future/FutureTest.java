package com.ericliu.practice.toy.future;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/**
 * @Author: liuhaoeric
 * Create time: 2019/10/21
 * Description:
 */
public class FutureTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        AtomicReference<Object> c= new AtomicReference<>(new Object());

        FutureTask<Object> futureTask=new FutureTask<Object>(()->{
            c.getAndSet("liuhao");
        },c);

        Thread t=new Thread(()->{
            //runable ,result
            //start
            try {
                Thread.sleep(10000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            futureTask.run();
        });
        t.start();

        //get ~
        System.out.println("=====开始future.get获取值");
        Object rest=futureTask.get();

        //print
        System.out.println(c.get());
    }
}
