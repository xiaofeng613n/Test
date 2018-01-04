package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_ds_quota")
public class LogDsQuota {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 数据集id
     */
    @Column(name = "dsId")
    private String dsId;

    /**
     * 指标类型:0.sum 1.count 2.max 3.rate 4.count_distinct 5.复合指标
     */
    @Column(name = "quotaType")
    private Byte quotaType;

    /**
     * 指标名称
     */
    @Column(name = "quotaName")
    private String quotaName;

    /**
     * 字段id(当为复合指标时,存储指标名表达式)
     */
    @Column(name = "fieldId")
    private String fieldId;

}