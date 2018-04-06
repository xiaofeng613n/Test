package com.xiaofeng.log;


import org.apache.log4j.Logger;

import java.util.concurrent.TimeUnit;

/**
 * Created by xiaofeng on 2017/9/27
 * Description:
 */
public class Main
{
	final Logger logger = Logger.getLogger(Main.class);
	//final Logger logger = LoggerFactory.getLogger(Main.class);

	public void test()
	{
		logger.info("hello ,just for log4j!");
		//logger.info("hello ,just test for slf4j! {}","ok");
	}

	public void log(){
		logger.info("hello ,just for log4j! 1" + System.currentTimeMillis());
		logger.info("hello ,just for log4j! 2" + System.currentTimeMillis());
		logger.info("hello ,just for log4j! 3" + System.currentTimeMillis());
	}
	public static void main(String[] args) throws InterruptedException {
		Main main = new Main();
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true){
					main.log();
					try {
						TimeUnit.MILLISECONDS.sleep(500);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		thread.start();
		TimeUnit.SECONDS.sleep(Integer.MAX_VALUE);

	}
}