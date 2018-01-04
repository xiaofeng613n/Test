package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_alarm")
public class LogAlarm {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 告警名称
     */
    @Column(name = "alarmName")
    private String alarmName;

    /**
     * 告警类型:0.基于已有下钻数据集创建报警
     */
    @Column(name = "alarmType")
    private Byte alarmType;

    /**
     * 告警规则类型:0.&& 1.||
     */
    @Column(name = "alarmRuleType")
    private Byte alarmRuleType;

    /**
     * 告警开始时间
     */
    @Column(name = "alarmStartTime")
    private Integer alarmStartTime;

    /**
     * 告警结束时间
     */
    @Column(name = "alarmEndTime")
    private Integer alarmEndTime;

    /**
     * alarmLevel
     */
    @Column(name = "alarmLevel")
    private Byte alarmLevel;

    /**
     * appName
     */
    @Column(name = "appName")
    private String appName;

}