package com.example.demo.entity;

public class TbRider {
    private String openId;
    private String nickName;
    private String studentName;
    private String sno;
    private Integer status;
    private Integer number;
    private String msg;

    public Integer getNumber() {
        return number;
    }

    public Integer getStatus() {
        return status;
    }

    public String getMsg() {
        return msg;
    }

    public String getNickName() {
        return nickName;
    }

    public String getOpenId() {
        return openId;
    }

    public String getSno() {
        return sno;
    }


    public void setMsg(String msg) {
        this.msg = msg;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setOpenId(String openId) {
        this.openId = openId;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
}
