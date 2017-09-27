package com.xiaofeng.log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by xiaofeng on 2017/9/27
 * Description:
 */
public class Main
{
	//final Logger logger = Logger.getLogger(Main.class);
	final Logger logger = LoggerFactory.getLogger(Main.class);

	public void test()
	{
		logger.info("hello ,just for log4j!");
		logger.info("hello ,just test for slf4j! {}","ok");
	}
	public static void main(String[] args)
	{
		Main main = new Main();
		main.test();
	}
}