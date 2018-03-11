package com.xiaofeng.reactor;

import lombok.Data;

/**
 * Created by xiaofeng on 2018/3/6
 * Description:
 */
@Data
public class Event {
    private InputSource source;
    private EventType type;

    public String toString(){
        return "type:" + type.name() + " source:" + source.toString();
    }
}