package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_ds_dimension")
public class LogDsDimension {
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
     * 字段id
     */
    @Column(name = "fieldId")
    private String fieldId;

    /**
     * order
     */
    @Column(name = "sortNum")
    private Byte sortNum;

}