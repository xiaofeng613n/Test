package com.xiaofeng;

import org.influxdb.InfluxDB;
import org.influxdb.InfluxDBFactory;
import org.influxdb.dto.Point;

import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by xiaofeng on 2018/1/17
 * Description:
 */
public class InfluxdbTest {

    public static InfluxDB influxDB;
    public static String dbName = "appXX";
    public static String measurementName = "sale";
    public static String server = "http://10.40.6.130:8086";
    public static void main(String[] args) {
        initInfluxDB();

//        for (int i = 0 ; i < Integer.MAX_VALUE; i ++){
//            int minCount = 3;
//            int maxCount = 10;
//            int minSum = 50;
//            int maxSum = 100;
//
//            String[] provinces = {"jiangxi","guangdong","yunnan"};
//            String[][] cities = {{"nanchang","ganzhou"},{"shenzhen","guangzhou"},{"guilin","kunming"}};
//            int provinceIndex = 0 + (int)(Math.random() * (2-0+1));
//            int cityIndex = 0 + (int)(Math.random() * (1-0+1));
//
//            int randomCount = minCount + (int)(Math.random() * (maxCount-minCount+1));
//            int randomSum = minSum + (int)(Math.random() * (maxSum-minSum+1));
//
//            Point point = Point.measurement(measurementName)
//                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
//                    .tag("country","CN")
//                    .tag("province",provinces[provinceIndex])
//                    .tag("city",cities[provinceIndex][cityIndex])
//                    .addField("COUNT", randomCount)
//                    .addField("SUM", randomSum)
//                    .build();
//            influxDB.setDatabase(dbName);
//            influxDB.setRetentionPolicy("rp-7d-test");
//            influxDB.write(point);
//            System.err.println(point);
//            try {
//                Thread.sleep(5000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        for (int i = 0 ; i < Integer.MAX_VALUE; i ++){
            int minCount = 3;
            int maxCount = 10;
            int minSum = 50;
            int maxSum = 100;

            String[] countries = {"CN","USA","UK","JPAN","FRANCE","INDIA"};

            int countryIndex = 0 + (int)(Math.random() * (5-0+1));

            int randomCount = minCount + (int)(Math.random() * (maxCount-minCount+1));
            int randomSum = minSum + (int)(Math.random() * (maxSum-minSum+1));

            Point point = Point.measurement(measurementName)
                    .time(System.currentTimeMillis(), TimeUnit.MILLISECONDS)
                    .tag("country",countries[countryIndex])
                    .addField("COUNT", randomCount)
                    .addField("SUM", randomSum)
                    .build();
            influxDB.setDatabase(dbName);
            influxDB.setRetentionPolicy("rp-7d-test");
            influxDB.write(point);
            System.err.println(point);
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }

    public static void initInfluxDB(){
        influxDB = InfluxDBFactory.connect(server);

        List<String> databases = influxDB.describeDatabases();
        if( !databases.contains(dbName)){
            influxDB.createDatabase(dbName);
            influxDB.createRetentionPolicy("rp-1d-test", dbName, "1d", "30m", 2, true);
        }
        //log.info("influxDB init finshed! server:[{}],DATABASE:[{}]",server,DATABASE);
    }
}