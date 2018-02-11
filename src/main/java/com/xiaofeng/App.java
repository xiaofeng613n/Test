package com.xiaofeng;

import java.util.List;
import java.util.List;
import java.util.Map;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Queues;

import java.util.*;

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

        //Predicate<Map<String,Object>> filter =  stringObjectMap -> stringObjectMap.forEach( c -> );
//        String arrayStr = "[{\"id\":\"eeretg44334\",\"dsId\":\"xxx\",\"quotaType\":1,\"quotaName\":\"sum xx\",\"fieldKey\":\"xx\"},\n" +
//                "{\"id\":\"eeretg44334\",\"dsId\":\"xxx\",\"quotaType\":1,\"quotaName\":\"sum xx\",\"fieldKey\":\"xx\"}]";
//        JSONArray jsonArray = JSON.parseArray(arrayStr);
//        System.out.println(jsonArray);


        Matcher matcher = Pattern.compile("log", Pattern.CASE_INSENSITIVE).matcher("aa.log");
        System.out.println();


        JSONObject provinceJX = new JSONObject();
        provinceJX.put("nc",1);
        provinceJX.put("sr",3);

        JSONObject provinceGD = new JSONObject();
        provinceGD.put("sz",2);

        JSONObject countryCN = new JSONObject();
        countryCN.put("jx",provinceJX);
        countryCN.put("gd",provinceGD);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("CN",countryCN);

        Queue<String> queue = new LinkedList<String>();
        queue.add("country");
        queue.add("province");
        queue.add("city");
        queue.add("count");

        List result = Lists.newArrayList();
        fun(Lists.newLinkedList(), jsonObject,result);

        System.out.println(result);
    }

    public static  void fun(LinkedList<Object> list,JSONObject json,List<LinkedList<Object>> result){
        LinkedList<Object> currentList = Lists.newLinkedList(list);
        Iterator<String> it = json.keySet().iterator();
        while (it.hasNext()) {
            String key = it.next();
            currentList.add(key);
            Object obj = json.get(key);
            if ( obj instanceof Map){
                fun(currentList, (JSONObject) obj,result);
                currentList.removeLast();
            }else {
                currentList.add(obj);
                result.add(Lists.newLinkedList(currentList));
                currentList.removeLast();
                currentList.removeLast();
            }
        }
        String arrayStr = "[\"method\",\"url\",\"ts\"]";
        List<String> fieldList = com.alibaba.fastjson.JSON.parseArray(arrayStr,String.class);
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
