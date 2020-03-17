package com.example.demo.service;

import com.example.demo.entity.TbRider;

import java.util.List;

public interface TbRiderService {
    void insertId(String openId);
    TbRider apply(String openId, String studentName, String sno);
    List<TbRider> selectApply(String sno,Integer start);
    TbRider agreement(String openId,Integer status);
    TbRider selectOpenId(String openId);
    TbRider refuse(String openId);
    void riderLineType(String openId,Integer status);
    List<TbRider> selectAppId(String appId);
}
