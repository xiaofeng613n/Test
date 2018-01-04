package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_ds_condition")
public class LogDsCondition {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 字段id
     */
    @Column(name = "fieldId")
    private String fieldId;

    /**
     * 字段操作:long 0.> 1.>= 2.== 3.< 4.<= 5.!= 6.== String 7.!= 8.包含 3.不包含
     */
    @Column(name = "fieldOp")
    private Byte fieldOp;

    /**
     * 字段值
     */
    @Column(name = "fieldValue")
    private String fieldValue;

    /**
     * 数据集id
     */
    @Column(name = "dsId")
    private String dsId;

}