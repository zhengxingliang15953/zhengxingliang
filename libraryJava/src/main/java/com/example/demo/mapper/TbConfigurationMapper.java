package com.example.demo.mapper;

import com.example.demo.entity.TbConfiguration;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TbConfigurationMapper {
    void updateRider(Integer riderSwitch);
    TbConfiguration selectAllConfig();
}
