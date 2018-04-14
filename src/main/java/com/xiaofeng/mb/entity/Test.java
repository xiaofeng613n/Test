package com.xiaofeng.mb.entity;

import lombok.Data;

/**
 * Created by xiaofeng on 2018/4/14
 * Description:
 */
@Data
public class Test {
    private Integer id;
    private String name;

    @Override
    public String toString() {
        return "Test{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}