package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_alarm_var")
public class LogAlarmRuleVar {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 变量名
     */
    @Column(name = "alarmVarName")
    private String alarmVarName;

    /**
     * 告警id
     */
    @Column(name = "alarmId")
    private String alarmId;

    /**
     * 数据集id
     */
    @Column(name = "dsId")
    private String dsId;

}