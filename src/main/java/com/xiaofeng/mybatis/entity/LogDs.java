package com.xiaofeng.mybatis.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Table(name = "log_ds")
public class LogDs {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 数据集名称
     */
    @Column(name = "dsName")
    private String dsName;

    /**
     * 时间字段
     */
    @Column(name = "timeFieldKey")
    private String timeFieldKey;

    /**
     * sampleFileKey
     */
    @Column(name = "sampleFileKey")
    private String sampleFileKey;

    /**
     * appName
     */
    @Column(name = "appName")
    private String appName;

}