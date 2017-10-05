package com.xiaofeng.thread;

import java.util.concurrent.locks.Lock;

/**
 * Created by xiaofeng on 2017/10/5
 * Description:
 */
public class ThreadTest
{
	public static void main(String[] args)
	{
		testMutex();
	}


	public static void testMutex()
	{
		Lock lock = new Mutex();
		lock.lock();
		try
		{

		}
		finally
		{
			lock.unlock();
		}
	}
}