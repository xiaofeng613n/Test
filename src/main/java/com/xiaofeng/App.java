package com.xiaofeng;

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
<<<<<<< HEAD
        String s = null;
        String s2 = "";
        String s3 = s + s2;
        System.out.println(s + s2);
        int i = Integer.valueOf("00");
        System.out.println(i);
        test();
        System.out.println( "Hello World!" );
=======
         int i = Integer.valueOf("00");
         System.out.println(i);
         test();
         System.out.println( "Hello World!" );

         ExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

>>>>>>> 37187e9559290170e4f22944a42085bed67998f1
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
