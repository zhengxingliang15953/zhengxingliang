package com.example.demo.service.Impl;

import com.example.demo.entity.TbResource;
import com.example.demo.mapper.TbResourceMapper;
import com.example.demo.service.TbResourceService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbResourceServiceImpl implements TbResourceService {

    @Resource
    private TbResourceMapper tbResourceMapper;

    /**
     * 获取所有的导航资源
     * @return
     */
    @Override
    public List<TbResource> selectAllResource() {
        return tbResourceMapper.selectAllResource();
    }

    /**
     * 删除导航资源
     * @param resourceId
     */
    @Override
    public void deleteResource(String resourceId) {
        tbResourceMapper.deleteResource(resourceId);
    }

    /**
     * 添加资源导航
     * @param title
     * @param resourceUrl
     * @param resourceId
     */
    @Override
    public void insertResource(String title, String resourceUrl, String resourceId) {
        tbResourceMapper.insertResource(title, resourceUrl, resourceId);
    }
}
