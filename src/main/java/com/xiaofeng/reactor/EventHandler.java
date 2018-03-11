package com.xiaofeng.reactor;

import lombok.Data;

/**
 * Created by xiaofeng on 2018/3/6
 * Description:
 */
@Data
public abstract class EventHandler {
    private InputSource source;
    public abstract void handle(Event event);

}