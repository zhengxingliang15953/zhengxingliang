package com.example.demo.service;

import com.example.demo.entity.TbStudent;

import java.util.List;

public interface TbStudentService {
    TbStudent studentLogin(String sno,String pwd);
    public TbStudent getIndexStudent();
    public void updatePwd(String sno,String pwd);
    List<TbStudent> selectAllStudent(String sno,Integer start);

}
