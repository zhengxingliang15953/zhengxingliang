package com.example.demo.service;

import com.example.demo.entity.TbResource;

import java.util.List;

public interface TbResourceService {
    List<TbResource> selectAllResource(Integer start);
    void deleteResource(String resourceId);
    void insertResource(String title,String resourceUrl,String resourceId);
}
