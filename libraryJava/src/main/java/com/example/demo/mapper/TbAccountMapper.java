package com.example.demo.mapper;

import com.example.demo.entity.TbAccount;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface TbAccountMapper {
    public List<TbAccount> selectAllAccount();
}