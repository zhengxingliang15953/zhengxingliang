package com.example.demo.service;

import com.example.demo.entity.TbConfiguration;

public interface TbConfigurationService {
    void updateRider(Integer riderSwitch);
    TbConfiguration selectAllConfig();
}
