package com.xiaofeng.thread;

import com.google.common.collect.Lists;
import org.apache.http.util.TextUtils;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;
import java.util.concurrent.locks.Lock;

/**
 * Created by xiaofeng on 2017/10/5
 * Description:
 */
public class ThreadTest
{
	public static void main(String[] args)
	{
		//testMutex();
		List<Integer> list = Lists.newArrayList();
		list.add(1);
		list.add(2);
		list.stream().filter( p -> p ==1).forEach( c -> System.out.println(c));
		getStartTimeOfDay(0,"");

	}
	public static long getStartTimeOfDay(long now, String timeZone) {
		String tz = TextUtils.isEmpty(timeZone) ? "GMT+8" : timeZone;
		TimeZone curTimeZone = TimeZone.getTimeZone(tz);
		Calendar calendar = Calendar.getInstance(curTimeZone);
		calendar.setTimeInMillis(now);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);

		return calendar.getTimeInMillis();
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