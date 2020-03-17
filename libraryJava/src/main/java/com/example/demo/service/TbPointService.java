package com.example.demo.service;

import com.example.demo.entity.TbPoint;

import java.util.List;

public interface TbPointService {
    TbPoint insertPoint(String openId,String appId);
    List<TbPoint> selectOpenId(String openId);
}
