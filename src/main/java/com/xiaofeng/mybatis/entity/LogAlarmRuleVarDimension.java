package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_alarm_var_dimension")
public class LogAlarmRuleVarDimension {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * varId
     */
    @Column(name = "varId")
    private String varId;

    /**
     * fieldId
     */
    @Column(name = "fieldId")
    private String fieldId;

    /**
     * fieldType
     */
    @Column(name = "fieldType")
    private Byte fieldType;

    /**
     * fieldKey
     */
    @Column(name = "fieldKey")
    private String fieldKey;

    /**
     * 0.无 1.= 2.in 3.遍历
     */
    @Column(name = "valueMethod")
    private Byte valueMethod;

    /**
     * 字段值
     */
    @Column(name = "fieldValue")
    private String fieldValue;

}