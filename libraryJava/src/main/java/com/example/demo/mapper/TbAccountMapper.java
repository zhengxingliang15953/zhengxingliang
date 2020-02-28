package com.example.demo.mapper;

import com.example.demo.entity.TbAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbAccountMapper {
    public List<TbAccount> selectAllAccount();
    void insertAccount(String account,String pwd,Integer status);
    void updateAccount(String account,String pwd);
    void updateAccountType(String account,Integer type);
    void deleteAccount(String account);
    TbAccount selectOneAccount(String account);
}
