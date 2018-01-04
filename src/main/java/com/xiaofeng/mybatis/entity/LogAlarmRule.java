package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_alarm_rule")
public class LogAlarmRule {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 时间区间(分钟)
     */
    @Column(name = "thresholdTime")
    private Integer thresholdTime;

    /**
     * 规则表达式
     */
    private String expression;

    /**
     * 计算:0.avg 1.sum 2.max 3.min
     */
    private Byte target;

    /**
     * 操作:0.>= 1.<= 2.环比上升 3.环比下降 4.与上小时同比上升 5.与上小时同比下降 6.与昨日同比上升 7.与昨日同比下降 
     */
    private Byte op;

    /**
     * 阀值
     */
    @Column(name = "thresholdVaule")
    private Integer thresholdVaule;

    /**
     * 告警id
     */
    @Column(name = "alarmId")
    private String alarmId;

}