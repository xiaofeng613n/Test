package com.xiaofeng.thread;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by xiaofeng on 2017/10/13
 * Description:
 */
public class TestPrint
{
	public static void main(String[] args)
	{
		AtomicInteger i = new AtomicInteger();
		Lock lock = new ReentrantLock();
		Thread thread1 = new Thread(new PrintTask("PrintA",i ,lock));
		Thread thread2 = new Thread(new PrintTask("PrintB",i ,lock));
		thread1.start();
		thread2.start();
	}

	public static class PrintTask implements Runnable
	{
		private AtomicInteger i;
		private String taskName;
		private Lock lock;

		public PrintTask(String taskName,AtomicInteger i,Lock lock )
		{
			this.i = i;
			this.taskName = taskName;
			this.lock = lock;
		}

		@Override
		public void run()
		{
			while (true && i.get() < 100)
			{
				lock.lock();
				try
				{
					print();
					//Thread.sleep(100);
				}/* catch (InterruptedException e) {
					e.printStackTrace();
				} */finally
				{
					lock.unlock();
				}
			}

		}

		private void print()
		{
			System.out.println( taskName +":" + i.getAndIncrement());
		}
	}
}