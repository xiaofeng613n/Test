package com.xiaofeng;

import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Scanner;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by xiao on 2017/11/29.
 */
public class CPUTest
{
	public static void main(String[] args) {
		Integer idleTime = new Integer(30);
		Boolean run = true;
		Task task1 = new Task(idleTime,run);
		Task task2 = new Task(idleTime,run);
		Task task3 = new Task(idleTime,run);
		Task task4 = new Task(idleTime,run);
		ExecutorService pool =Executors.newFixedThreadPool(4);
		pool.execute(task1);
		pool.execute(task2);
		pool.execute(task3);
		pool.execute(task4);
		Scanner scanner = new Scanner(System.in);

		while (true){
			int i = scanner.nextInt();
			idleTime = new Integer(i);
			task1.stop();
			task2.stop();
			task3.stop();
			task4.stop();
			 task1 = new Task(idleTime,run);
			 task2 = new Task(idleTime,run);
			 task3 = new Task(idleTime,run);
			 task4 = new Task(idleTime,run);
			pool =Executors.newFixedThreadPool(4);
			pool.execute(new Task(idleTime,run));
			pool.execute(new Task(idleTime,run));
			pool.execute(new Task(idleTime,run));
			pool.execute(new Task(idleTime,run));
		}
	}
	public static class Task implements Runnable{
		int busyTime = 10;
		//int idleTime = 20;
		Integer idleTime;
		long startTime = 0;
		Boolean run;
		public Task(Integer idleTime,Boolean run){
			this.idleTime = idleTime;
			this.run = run;
		}
		@Override
		public void run()
		{
			while (run) {
				startTime = System.currentTimeMillis();
				// busy loop
				while ((System.currentTimeMillis() - startTime) <= busyTime)
					;
				// idle loop
				try {
					Thread.sleep(idleTime);
				} catch (InterruptedException e) {
					System.out.println(e);
				}
			}
			System.out.println("end");
		}

		public void stop()
		{
			run = false;
		}
	}
}
