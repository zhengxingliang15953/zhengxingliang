package com.example.demo.entity;

public class TbStudent {
    private String sno;
    private String name;
    private String age;
    private String idCard;
    private String address;
    private String school;
    private String marjor;
    private String pwd;
    private String msg;
    private String tel;

    public String getAge() {
        return age;
    }

    public String getIdCard() {
        return idCard;
    }

    public String getSno() {
        return sno;
    }

    public String getAddress() {
        return address;
    }

    public String getName() {
        return name;
    }

    public String getPwd() {
        return pwd;
    }

    public String getSchool() {
        return school;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getMarjor() {
        return marjor;
    }

    public void setMarjor(String marjor) {
        this.marjor = marjor;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
