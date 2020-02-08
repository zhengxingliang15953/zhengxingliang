package com.example.demo.service;

import com.example.demo.entity.TbStudent;

public interface TbStudentService {
    TbStudent studentLogin(String sno,String pwd);
    public TbStudent getIndexStudent();
    public void updatePwd(String sno,String pwd);
}
