package com.xiaofeng;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaofeng on 2018/1/18
 * Description:
 */
public class Test{
    public static void main(String[] args) {
//        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
//        executor.scheduleWithFixedDelay(()->{
//            Long time= System.currentTimeMillis();
//            SimpleDateFormat format =  new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss" );
//            String d = format.format(time);
//            try {
//                Date date=format.parse(d);
//                System.err.println("Format To String(Date):"+d);
//            } catch (ParseException e) {
//                e.printStackTrace();
//            }
//        },5,5, TimeUnit.SECONDS);
    }

    public static void StraightInsertSort(int[] array) {
        if (array == null || array.length < 2)
            return;
        for (int i = 1; i < array.length; i++) {
            int currentValue = array[i];
            int position = i;
            for (int j = i - 1; j >= 0; j--) {
                if (array[j] > currentValue) {
                    array[j + 1] = array[j];
                    position -= 1;
                } else {
                    break;
                }
            }
            array[position] = currentValue;
        }
    }

    enum a{

    }
}