package com.xiaofeng.reactor;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Created by xiaofeng on 2018/3/6
 * Description:
 */
@Data
@AllArgsConstructor
public class InputSource {
    private Object data;
    private long id;

    public String toString(){
        return "InputSouce{" + "data=" + data + ",id=" +id +"}";
    }

}