package com.xiaofeng.thread.util;

import java.util.Date;
import java.util.concurrent.*;

/**
 * Created by xiaofeng on 2018/3/7
 * Description:
 */
public class Test {

    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue = new LinkedBlockingQueue<>();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1,1,1, TimeUnit.HOURS,new ArrayBlockingQueue<Runnable>(10));

//        Future future = executor.submit(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(new Date());
//                try {
//                    TimeUnit.SECONDS.sleep(10);
//                } catch (InterruptedException e) {
//                    System.out.println("interrupted by ...");
//                    e.printStackTrace();
//                }
//            }
//        });
//
//        TimeUnit.SECONDS.sleep(2);
//
//        future.cancel(true);
//        Executors.newSingleThreadScheduledExecutor();
//        Executors.callable()
        //Executors.newScheduledThreadPool()
        final SynchronousQueue<Integer> queue = new SynchronousQueue<Integer>();

        Thread putThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread start");
                try {
                    queue.put(1);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread end");
            }
        });

        Thread putThread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("put thread2 start");
                try {
                    queue.put(2);
                } catch (InterruptedException e) {
                }
                System.out.println("put thread2 end");
            }
        });

        Thread takeThread = new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("take thread start");
                try {
                    System.out.println("take from putThread: " + queue.take());
                } catch (InterruptedException e) {
                }
                System.out.println("take thread end");
            }
        });

        putThread.start();
        putThread2.start();
        Thread.sleep(1000);
        takeThread.start();
    }
}