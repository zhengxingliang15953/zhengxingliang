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

    /**
     * 骑手同意接单
     * @param appId
     * @param openId
     * @return
     */
    @ApiOperation(value = "骑手同意接单", notes = "骑手同意接单",httpMethod = "GET")
    @RequestMapping(value = "api/getAgreePoint",method = RequestMethod.GET)
    public TbPoint getAgreePoint(String appId,String openId,String pointId){
        return tbPointService.agreeOrder(appId, openId,pointId);
    }

    /**
     * 根据openId获取取货单
     * @param openId
     * @return
     */
    @ApiOperation(value = "根据openId获取取货单", notes = "根据openId获取取货单",httpMethod = "GET")
    @RequestMapping(value = "api/selectHavePointId",method = RequestMethod.GET)
    public List<TbPoint> selectHavePointId(String openId){
        return tbPointService.selectHavePointId(openId);
    }


    /**
     * 骑手完成取货
     * @param pointId
     * @param appId
     */
    @ApiOperation(value = "骑手完成取货", notes = "骑手完成取货",httpMethod = "GET")
    @RequestMapping(value = "api/getFinishTake",method = RequestMethod.GET)
    public void getFinishTake(String pointId,String appId){
        tbPointService.finishTake(pointId, appId);
    }

    /**
     * 根据openID获取待送达单
     * @param openId
     * @return
     */
    @ApiOperation(value = "骑手完成取货", notes = "骑手完成取货",httpMethod = "GET")
    @RequestMapping(value = "api/getWaitFinish",method = RequestMethod.GET)
    public List<TbPoint> selectWaitFinish(String openId){
        return tbPointService.selectWaitFinish(openId);
    }

    /**
     * 骑手完成订单
     * @param pointId
     * @param appId
     * @param openId
     */
    @ApiOperation(value = "骑手完成订单", notes = "骑手完成订单",httpMethod = "GET")
    @RequestMapping(value = "api/getFinishOrder",method = RequestMethod.GET)
    public void getFinishOrder(String pointId,String appId,String openId){
        tbPointService.finishOrder(pointId, appId, openId);
    }
}
