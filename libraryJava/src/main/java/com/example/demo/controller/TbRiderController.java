package com.example.demo.controller;

import com.example.demo.entity.TbRider;
import com.example.demo.service.TbRiderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.annotation.Resource;
import java.util.List;

@Api(description = "骑手管理api")
@Controller
@CrossOrigin
@RestController
public class TbRiderController {

    @Resource
    private TbRiderService tbRiderService;

    /**
     * 申请骑手
     * @param openId
     * @param studentName
     * @param sno
     * @return
     */
    @ApiOperation(value = "申请骑手", notes = "申请骑手",httpMethod = "GET")
    @RequestMapping(value = "api/getApply",method = RequestMethod.GET)
    public TbRider apply(String openId,String studentName,String sno){
        return tbRiderService.apply(openId, studentName, sno);
    }

    /**
     * 获取审批列表
     * @param sno
     * @param start
     * @return
     */
    @ApiOperation(value = "审批列表", notes = "审批列表",httpMethod = "GET")
    @RequestMapping(value = "api/getApprove",method = RequestMethod.GET)
    public List<TbRider> selectApprove(String sno,Integer start){
        return tbRiderService.selectApply(sno, start);
    }

    /**
     * 审批通过
     * @param openId
     * @param status
     * @return
     */
    @ApiOperation(value = "审批列表", notes = "审批列表",httpMethod = "GET")
    @RequestMapping(value = "api/getAgreement",method = RequestMethod.GET)
    public TbRider agreement(String openId,Integer status){
        return tbRiderService.agreement(openId,status);
    }

    /**
     * 根据openID获取用户信息
     * @param openId
     * @return
     */
    @ApiOperation(value = "根据openID获取用户信息", notes = "根据openID获取用户信息",httpMethod = "GET")
    @RequestMapping(value = "api/getOpenIdUser",method = RequestMethod.GET)
    public TbRider selectOpenId(String openId){
        return tbRiderService.selectOpenId(openId);
    }

    /**
     * 审批不通过
     * @param openId
     * @return
     */
    @ApiOperation(value = "审批不通过", notes = "审批不通过",httpMethod = "GET")
    @RequestMapping(value = "api/getRefuse",method = RequestMethod.GET)
    public TbRider deleteRider(String openId){
        return tbRiderService.refuse(openId);
    }

    /**
     * 骑手小程序上线下线
     * @param openId
     * @param status
     */
    @ApiOperation(value = "骑手上下线", notes = "骑手上下线",httpMethod = "GET")
    @RequestMapping(value = "api/getLineType",method = RequestMethod.GET)
    public void getLineType(String openId,Integer status){
        tbRiderService.riderLineType(openId, status);
    }

    /**
     * 根据appId获取相应的骑手
     * @param appId
     * @return
     */
    @ApiOperation(value = "根据appId获取骑手列表", notes = "根据appId获取骑手列表",httpMethod = "GET")
    @RequestMapping(value = "api/getAppRider",method = RequestMethod.GET)
    public List<TbRider> getAppRider(String appId){
        return tbRiderService.selectAppId(appId);
    }
}
