package com.xiaofeng.thread.safe;

/**
 * Created by xiaofeng on 2017/11/21
 * Description:
 */
public class InstanceFactory {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance(){
        return InstanceHolder.instance;
    }
}