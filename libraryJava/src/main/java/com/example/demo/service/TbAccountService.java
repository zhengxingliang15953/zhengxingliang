package com.example.demo.service;

import com.example.demo.entity.TbAccount;

import java.util.List;

public interface TbAccountService {
    //管理员登陆验证
    public TbAccount getLogin(String account,String pwd);

    //获取当前登陆信息
    public TbAccount getIndexAccount();

    TbAccount insertAccount(String account,String pwd,String role);

    void updateAccount(String account,String pwd);

    List<TbAccount> selectAllAccount();
    void updateAccountType(String account,Integer type);
    void deleteAccount(String account);
}
