package com.example.demo.entity;

public class TbPoint {
    private String pointId;
    private String openId;
    private String appId;
    private TbStudent tbStudent;
    private String msg;
    private Integer status;

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getOpenId() {
        return openId;
    }

    public String getMsg() {
        return msg;
    }

    public String getAppId() {
        return appId;
    }

    public String getPointId() {
        return pointId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public void setPointId(String pointId) {
        this.pointId = pointId;
    }

    public TbStudent getTbStudent() {
        return tbStudent;
    }

    public void setTbStudent(TbStudent tbStudent) {
        this.tbStudent = tbStudent;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getStatus() {
        return status;
    }
}
