package com.example.demo.service;

import com.example.demo.entity.TbPoint;

import java.util.List;

public interface TbPointService {
    TbPoint insertPoint(String openId,String appId);
    List<TbPoint> selectOpenId(String openId);
    TbPoint agreeOrder(String appId,String openId,String pointId);
    List<TbPoint> selectHavePointId(String openId);
    void finishTake(String pointId,String appId);
    List<TbPoint> selectWaitFinish(String openId);
    void finishOrder(String pointId,String appId,String openId);
    List<TbPoint> selectHistory(String openId);
}
