package com.xiaofeng.test;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xiaofeng on 2017/11/15
 * Description:
 */
public class StringTest
{
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static void main(String[] args)
	{
		StringTest test = new StringTest();
		test.testPlus();
		test.testConcat();
		test.testJoin();
		test.testStringBuffer();
		test.testStringBuilder();
		test.testStringFormat();
	}
	public void testPlus() {
		String s = "";
		long ts = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			s = s + String.valueOf(i);
		}
		long te = System.currentTimeMillis();
		logger.info(" + cost {} ms", te - ts);
	}

	public void testConcat() {
		String s = "";
		long ts = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {
			s = s.concat(String.valueOf(i));
		}
		long te = System.currentTimeMillis();
		logger.info("concat cost {} ms", te - ts);
	}

	public void testJoin() {
		List<String> list = new ArrayList<String>();
		long ts = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			list.add(String.valueOf(i));
		}
		StringUtils.join(list, "");
		long te = System.currentTimeMillis();
		logger.info("StringUtils.join cost {} ms", te - ts);
	}

	public void testStringBuffer() {
		StringBuffer sb = new StringBuffer();
		long ts = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			sb.append(String.valueOf(i));
		}
		sb.toString();
		long te = System.currentTimeMillis();
		logger.info("StringBuffer cost {} ms", te - ts);
	}

	public void testStringBuilder() {
		StringBuilder sb = new StringBuilder();
		long ts = System.currentTimeMillis();
		for (int i = 0; i < 100000; i++) {
			sb.append(String.valueOf(i));
		}
		sb.toString();
		long te = System.currentTimeMillis();
		logger.info("StringBuilder cost {} ms", te - ts);
	}

	public void testStringFormat() {
		String str="";
		long ts = System.currentTimeMillis();
		for (int i = 0; i < 10000; i++) {

			str=String.format("%s%s",str,String.valueOf(i));

		}
		str.toString();
		long te = System.currentTimeMillis();
		logger.info("StringFormat cost {} ms", te - ts);
	}
}