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
}
