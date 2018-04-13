package com.hqyg.elog.core.api.entity.log;

import javax.persistence.*;

@Table(name = "flume_tailfile")
public class FlumeTailfile {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * 日志目录
     */
    @Column(name = "dirName")
    private String dirname;

    /**
     * 文件inode
     */
    private String inode;

    /**
     * 文件路径
     */
    private String filename;

    /**
     * offset
     */
    private Integer offset;

    /**
     * flume_intance主键
     */
    @Column(name = "flumeInstancId")
    private String flumeinstancid;

    /**
     * 获取id
     *
     * @return id - id
     */
    public String getId() {
        return id;
    }

    /**
     * 设置id
     *
     * @param id id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取日志目录
     *
     * @return dirName - 日志目录
     */
    public String getDirname() {
        return dirname;
    }

    /**
     * 设置日志目录
     *
     * @param dirname 日志目录
     */
    public void setDirname(String dirname) {
        this.dirname = dirname;
    }

    /**
     * 获取文件inode
     *
     * @return inode - 文件inode
     */
    public String getInode() {
        return inode;
    }

    /**
     * 设置文件inode
     *
     * @param inode 文件inode
     */
    public void setInode(String inode) {
        this.inode = inode;
    }

    /**
     * 获取文件路径
     *
     * @return filename - 文件路径
     */
    public String getFilename() {
        return filename;
    }

    /**
     * 设置文件路径
     *
     * @param filename 文件路径
     */
    public void setFilename(String filename) {
        this.filename = filename;
    }

    /**
     * 获取offset
     *
     * @return offset - offset
     */
    public Integer getOffset() {
        return offset;
    }

    /**
     * 设置offset
     *
     * @param offset offset
     */
    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    /**
     * 获取flume_intance主键
     *
     * @return flumeInstancId - flume_intance主键
     */
    public String getFlumeinstancid() {
        return flumeinstancid;
    }

    /**
     * 设置flume_intance主键
     *
     * @param flumeinstancid flume_intance主键
     */
    public void setFlumeinstancid(String flumeinstancid) {
        this.flumeinstancid = flumeinstancid;
    }
}