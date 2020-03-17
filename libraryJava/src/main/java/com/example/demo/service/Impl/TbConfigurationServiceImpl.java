package com.example.demo.service.Impl;

import com.example.demo.entity.TbConfiguration;
import com.example.demo.mapper.TbConfigurationMapper;
import com.example.demo.service.TbConfigurationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TbConfigurationServiceImpl implements TbConfigurationService {

    @Resource
    private TbConfigurationMapper tbConfigurationMapper;

    /**
     * 修改骑手使用开关状态
     * @param riderSwitch
     */
    @Override
    public void updateRider(Integer riderSwitch) {
        tbConfigurationMapper.updateRider(riderSwitch);
    }

    /**
     * 获取配置信息
     * @return
     */
    @Override
    public TbConfiguration selectAllConfig() {
        return tbConfigurationMapper.selectAllConfig();
    }
}
