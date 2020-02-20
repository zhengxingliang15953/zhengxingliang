package com.example.demo.mapper;

import com.example.demo.entity.TbResource;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.session.RowBounds;

import java.util.List;

@Mapper
public interface TbResourceMapper {
    List<TbResource> selectAllResource(RowBounds rowBounds);
    void deleteResource(String resourceId);
    void insertResource(String title,String resourceUrl,String resourceId);
    List<TbResource> selectNumberResource();
}
