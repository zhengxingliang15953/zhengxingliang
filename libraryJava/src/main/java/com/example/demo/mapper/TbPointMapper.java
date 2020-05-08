package com.example.demo.mapper;

import com.example.demo.entity.TbPoint;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TbPointMapper {
    List<TbPoint> selectAppAll(String appId,Integer status);
    void insertPoint(String pointId,String openId,String appId);
    List<TbPoint> selectOpenIdAppId(String openId,String appId);
    List<TbPoint> selectOpenId(String openId);
    void deletePoint(String appId,String openId);
    void agreePoint(String pointId,Integer status);
    List<TbPoint> selectOpenIdStatus(String openId,Integer status);
    List<TbPoint> selectIngPoint(String appId);
    List<TbPoint> deleteRider(String openId);
    void deleteAppId(String appId);
    List<TbPoint> selectAllOpenId(String openId);
}
