package com.xiaofeng.thread.task;

import java.util.concurrent.*;

/**
 * Created by xiaofeng on 2018/4/11
 * Description:
 */
public class TaskTest {

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executor = Executors.newSingleThreadExecutor();
        MyCallable myCallable =new MyCallable();
        Future<Integer> future =  executor.submit(myCallable);
        int result = future.get();
        System.out.println("result:" + result);

        FutureTask<Integer> futureTask = new FutureTask<Integer>(myCallable);
        executor.submit(futureTask);
        int r2 = futureTask.get();
        System.out.println("result:" + r2);

    }

    static class MyCallable implements Callable<Integer>{

        @Override
        public Integer call() throws Exception {
            System.out.println("MyCallable start");
            TimeUnit.SECONDS.sleep(3);
            System.out.println("MyCallable end");
            return 100;
        }
    }
}