package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_field")
public class LogField {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 字段类型:0.String 1.long
     */
    @Column(name = "fieldType")
    private Byte fieldType;

    /**
     * 字段别名
     */
    @Column(name = "fieldName")
    private String fieldName;

    /**
     * 字段名
     */
    @Column(name = "fieldKey")
    private String fieldKey;

}