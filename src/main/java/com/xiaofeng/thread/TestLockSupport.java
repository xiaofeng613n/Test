package com.xiaofeng.thread;

import java.util.concurrent.locks.LockSupport;

/**
 * Created by xiaofeng on 2017/10/6
 * Description:
 */
public class TestLockSupport
{
	public static void main(String[] args)
	{
		Thread thread1 = new Thread1();
		thread1.start();
		Thread thread2 = new Thread1();
		thread2.start();
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