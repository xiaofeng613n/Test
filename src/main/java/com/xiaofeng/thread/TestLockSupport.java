package com.xiaofeng.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by xiaofeng on 2017/10/6
 * Description:
 */
public class TestLockSupport
{
	public static void main(String[] args) throws InterruptedException {
		Thread t = new Thread(new Runnable()
		{
			private int count = 0;

			@Override
			public void run()
			{
				long start = System.currentTimeMillis();
				long end = 0;

				while ((end - start) <= 1000)
				{
					count++;
					end = System.currentTimeMillis();
				}

				System.out.println("after 1 second.count=" + count);

				//等待或许许可
				LockSupport.park();
				System.out.println("thread over." + Thread.currentThread().isInterrupted());

			}
		});

		t.start();

		Thread.sleep(2000);

		// 中断线程
		t.interrupt();


		System.out.println("main over");
	}

	static class Thread1 extends Thread
	{
		@Override
		public void run()
		{
			System.out.println("begin");
			LockSupport.park();
			System.out.println("end");
		}
	}
}