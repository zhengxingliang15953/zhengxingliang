package com.example.demo.controller;

import com.example.demo.entity.TbReadMessage;
import com.example.demo.service.TbReadMessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "留言管理api")
@Controller
@CrossOrigin
@RestController
public class TbReadMessageController {

    @Resource
    private TbReadMessageService tbReadMessageService;

    /**
     * 获取所有的读者留言
     * @return
     */
    @ApiOperation(value = "获取所有留言", notes = "获取所有留言",httpMethod = "GET")
    @RequestMapping(value = "api/getAllReadMessage",method = RequestMethod.GET)
    public List<TbReadMessage> selectAllReadMessage(Integer start){
       return tbReadMessageService.selectAllReadMessage(start);

    }

    /**
     * 添加留言
     * @param sno
     * @param message
     */
    @ApiOperation(value = "添加留言", notes = "添加留言",httpMethod = "GET")
    @RequestMapping(value = "api/addReadMessage",method = RequestMethod.GET)
    public void insertReadMessage(String sno,String message,String readId){
        tbReadMessageService.insertReadMessage(sno, message,readId);
    }

    /**
     * 删除留言
     * @param readId
     */
    @ApiOperation(value = "删除留言", notes = "删除留言",httpMethod = "GET")
    @RequestMapping(value = "api/deleteReadMessage",method = RequestMethod.GET)
    public void deleteReadMessage(String readId){
        tbReadMessageService.deleteReadMessage(readId);
    }

    /**
     * 根据sno查询
     * @param sno
     * @return
     */
    @ApiOperation(value = "根据sno查询留言", notes = "根据sno查询留言",httpMethod = "GET")
    @RequestMapping(value = "api/getOneReadMessage",method = RequestMethod.GET)
    public List<TbReadMessage> selectOneReadMessage(String sno){
        return tbReadMessageService.selectOneReadMessage(sno);
    }

}
