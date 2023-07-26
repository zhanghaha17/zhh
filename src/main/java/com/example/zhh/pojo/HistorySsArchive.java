package com.example.zhh.pojo;

public class HistorySsArchive {

    String fydm;//法院代码，3个字符长，UTF-8编码，适用最高法规范的3位分级码

    String username;//访问WebService服务的帐户名称，UTF-8编码，最多20个字符

    String userpwd;//访问WebService服务的用户口令，UTF-8编码，最多20个字符

    String ywid;//业务ID，UTF-8编码，格式为：SS_法院代码（3位分级码）_业务标识
    // ywid为XML包的文件名，格式为：SS_法院代码（3位分级码）_业务标识，
    // 其中业务标识为业务系统描述业务数据的唯一标识，长度限制在40个字符内

    String archiveinfo;//对XML文件包作过Base64编码的字符串，其中文件内容需要预编。

    String SystemId;//对接系统ID，UTF-8编码,系统约定见1.4.5

    String ajzt;//对接业务系统状态，UTF-8编码,系统约定见1.4.6

    public String getFydm() {
        return fydm;
    }

    public void setFydm(String fydm) {
        this.fydm = fydm;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getUserpwd() {
        return userpwd;
    }

    public void setUserpwd(String userpwd) {
        this.userpwd = userpwd;
    }

    public String getYwid() {
        return ywid;
    }

    public void setYwid(String ywid) {
        this.ywid = ywid;
    }

    public String getArchiveinfo() {
        return archiveinfo;
    }

    public void setArchiveinfo(String archiveinfo) {
        this.archiveinfo = archiveinfo;
    }

    public String getSystemId() {
        return SystemId;
    }

    public void setSystemId(String systemId) {
        SystemId = systemId;
    }

    public String getAjzt() {
        return ajzt;
    }

    public void setAjzt(String ajzt) {
        this.ajzt = ajzt;
    }
}