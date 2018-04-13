package com.hqyg.elog.core.api.entity.log;

import javax.persistence.*;

@Table(name = "flume_instance")
public class FlumeInstance {
    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;

    /**
     * agentName
     */
    @Column(name = "agentName")
    private String agentname;

    /**
     * 机器ip
     */
    private String ip;

    /**
     * 机器host
     */
    private String hostname;

    /**
     * flume配置
     */
    @Column(name = "flumeConfig")
    private String flumeconfig;

    /**
     * 最近收集时间
     */
    @Column(name = "lastCollectTime")
    private Integer lastcollecttime;

    /**
     * heapInit
     */
    @Column(name = "heapInit")
    private Integer heapinit;

    /**
     * heapUsed
     */
    @Column(name = "heapUsed")
    private Integer heapused;

    /**
     * heapMax
     */
    @Column(name = "heapMax")
    private Integer heapmax;

    /**
     * heapCommitted
     */
    @Column(name = "heapCommitted")
    private Integer heapcommitted;

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
     * 获取agentName
     *
     * @return agentName - agentName
     */
    public String getAgentname() {
        return agentname;
    }

    /**
     * 设置agentName
     *
     * @param agentname agentName
     */
    public void setAgentname(String agentname) {
        this.agentname = agentname;
    }

    /**
     * 获取机器ip
     *
     * @return ip - 机器ip
     */
    public String getIp() {
        return ip;
    }

    /**
     * 设置机器ip
     *
     * @param ip 机器ip
     */
    public void setIp(String ip) {
        this.ip = ip;
    }

    /**
     * 获取机器host
     *
     * @return hostname - 机器host
     */
    public String getHostname() {
        return hostname;
    }

    /**
     * 设置机器host
     *
     * @param hostname 机器host
     */
    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    /**
     * 获取flume配置
     *
     * @return flumeConfig - flume配置
     */
    public String getFlumeconfig() {
        return flumeconfig;
    }

    /**
     * 设置flume配置
     *
     * @param flumeconfig flume配置
     */
    public void setFlumeconfig(String flumeconfig) {
        this.flumeconfig = flumeconfig;
    }

    /**
     * 获取最近收集时间
     *
     * @return lastCollectTime - 最近收集时间
     */
    public Integer getLastcollecttime() {
        return lastcollecttime;
    }

    /**
     * 设置最近收集时间
     *
     * @param lastcollecttime 最近收集时间
     */
    public void setLastcollecttime(Integer lastcollecttime) {
        this.lastcollecttime = lastcollecttime;
    }

    /**
     * 获取heapInit
     *
     * @return heapInit - heapInit
     */
    public Integer getHeapinit() {
        return heapinit;
    }

    /**
     * 设置heapInit
     *
     * @param heapinit heapInit
     */
    public void setHeapinit(Integer heapinit) {
        this.heapinit = heapinit;
    }

    /**
     * 获取heapUsed
     *
     * @return heapUsed - heapUsed
     */
    public Integer getHeapused() {
        return heapused;
    }

    /**
     * 设置heapUsed
     *
     * @param heapused heapUsed
     */
    public void setHeapused(Integer heapused) {
        this.heapused = heapused;
    }

    /**
     * 获取heapMax
     *
     * @return heapMax - heapMax
     */
    public Integer getHeapmax() {
        return heapmax;
    }

    /**
     * 设置heapMax
     *
     * @param heapmax heapMax
     */
    public void setHeapmax(Integer heapmax) {
        this.heapmax = heapmax;
    }

    /**
     * 获取heapCommitted
     *
     * @return heapCommitted - heapCommitted
     */
    public Integer getHeapcommitted() {
        return heapcommitted;
    }

    /**
     * 设置heapCommitted
     *
     * @param heapcommitted heapCommitted
     */
    public void setHeapcommitted(Integer heapcommitted) {
        this.heapcommitted = heapcommitted;
    }
}