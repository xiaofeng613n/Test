package com.xiaofeng;

import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.function.Consumer;
import java.util.function.Predicate;
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


//        String s = "{\"query\": \"FROM \\\"M\\\" FROM \\\"jvm-db\\\".\\\"autogen\\\".\\\"%s\\\" WHERE time > :dashboardTime:\",}%";
//      String s1 = s.replaceAll("FROM","xx");
//        System.out.println(s);
//        System.out.println(s1);
        Consumer<String> consumer = string -> System.out.println(string);
        for (int i = 0; i < 4; i ++){
            consumer.accept("aa");
        }
        //Predicate<Map<String,Object>> filter =  stringObjectMap -> stringObjectMap.forEach( c -> );
        Map<String,Object> map = null;
        List<Object> list = map.values();
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
