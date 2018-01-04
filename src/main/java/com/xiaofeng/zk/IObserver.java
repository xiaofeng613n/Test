package com.xiaofeng.zk;

public interface IObserver {
    void notified(String key, String value);
}
