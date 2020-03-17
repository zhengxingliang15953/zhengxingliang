package com.example.demo.controller;

import com.example.demo.entity.TbConfiguration;
import com.example.demo.service.TbConfigurationService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@Api(description = "配置管理api")
@Controller
@CrossOrigin
@RestController
public class TbConfigurationController {

    @Resource
    private TbConfigurationService tbConfigurationService;


    @ApiOperation(value = "骑手配置", notes = "骑手配置",httpMethod = "GET")
    @RequestMapping(value = "api/getRiderConfig",method = RequestMethod.GET)
    public void getUpdateRider(Integer riderSwitch){
        tbConfigurationService.updateRider(riderSwitch);
    }

    @ApiOperation(value = "获取配置信息", notes = "获取配置信息",httpMethod = "GET")
    @RequestMapping(value = "api/getAllConfig",method = RequestMethod.GET)
    public TbConfiguration selectAllConfig(){
        return tbConfigurationService.selectAllConfig();
    }
}
