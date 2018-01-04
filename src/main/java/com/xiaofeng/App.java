package com.xiaofeng;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//         int i = Integer.valueOf("00");
//         System.out.println(i);
//         test();
//         System.out.println( "Hello World!" );
//
//         ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

//        String arrayStr = "[{\"id\":\"eeretg44334\",\"dsId\":\"xxx\",\"quotaType\":1,\"quotaName\":\"sum xx\",\"fieldKey\":\"xx\"},\n" +
//                "{\"id\":\"eeretg44334\",\"dsId\":\"xxx\",\"quotaType\":1,\"quotaName\":\"sum xx\",\"fieldKey\":\"xx\"}]";
//        JSONArray jsonArray = JSON.parseArray(arrayStr);
//        System.out.println(jsonArray);
        String arrayStr = "[\"method\",\"url\",\"ts\"]";
        List<String> fieldList = JSON.parseArray(arrayStr,String.class);
        System.out.println(fieldList);
    }

    public static void test()
    {
        Matcher matcher = Pattern.compile("^(([1-9]{1})|([0-1][0-9])|([1-2][0-3])):([0-5][0-9])$").matcher("121:30");
        Matcher matcher2 = Pattern.compile("^(([1-9]{1})|([0-1][0-9])|([1-2][0-3])):([0-5][0-9])$").matcher("1:23");
        if (!matcher.find() || !matcher2.find() )
        {
            System.out.println("sss");
        }
    }
}
