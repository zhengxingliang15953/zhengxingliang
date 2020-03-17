package com.example.demo.mapper;

import com.example.demo.entity.TbPoint;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;

@Mapper
public interface TbPointMapper {
    List<TbPoint> selectAppAll(String appId);
    void insertPoint(String pointId,String openId,String appId);
    List<TbPoint> selectOpenIdAppId(String openId,String appId);
    List<TbPoint> selectOpenId(String openId);
}
