package com.xiaofeng.thread.safe;

/**
 * Created by xiaofeng on 2017/11/21
 * Description:
 */
public class SafeDoubleCheckedLocking{

	private volatile static Instance instance;

	public static Instance getInstance(){
	    if (instance == null) {
			synchronized (SafeDoubleCheckedLocking.class) {
				if (instance == null) {
					instance = new Instance();
				}
			}
		}
		return instance;
	}
}