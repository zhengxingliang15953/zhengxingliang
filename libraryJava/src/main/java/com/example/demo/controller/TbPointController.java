package com.example.demo.controller;


import com.example.demo.entity.TbPoint;
import com.example.demo.service.TbPointService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "配送管理api")
@Controller
@CrossOrigin
@RestController
public class TbPointController {


    @Resource
    private TbPointService tbPointService;


    /**
     * 添加配送单
     * @param openId
     * @param appId
     * @return
     */
    @ApiOperation(value = "添加配送单", notes = "添加配送单",httpMethod = "GET")
    @RequestMapping(value = "api/getAddPoint",method = RequestMethod.GET)
    public TbPoint getAddPoint(String openId,String appId){
        return tbPointService.insertPoint(openId, appId);
    }

    /**
     * 根据openId获取配送单
     * @param openId
     * @return
     */
    @ApiOperation(value = "根据openId获取配送单", notes = "根据openId获取配送单",httpMethod = "GET")
    @RequestMapping(value = "api/getOpenIdPoint",method = RequestMethod.GET)
    public List<TbPoint> selectOpenIdPoint(String openId){
        return tbPointService.selectOpenId(openId);
    }
}
