package com.example.demo.controller;

import com.example.demo.entity.TbReadMessage;
import com.example.demo.service.TbReadMessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

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
    @RequestMapping(value = "api/getAllReadMessage",method = RequestMethod.GET)
    public List<TbReadMessage> selectAllReadMessage(Integer start){
       return tbReadMessageService.selectAllReadMessage(start);

    }

    /**
     * 添加留言
     * @param sno
     * @param message
     */
    @RequestMapping(value = "api/addReadMessage",method = RequestMethod.GET)
    public void insertReadMessage(String sno,String message,String readId){
        tbReadMessageService.insertReadMessage(sno, message,readId);
    }

    /**
     * 删除留言
     * @param readId
     */
    @RequestMapping(value = "api/deleteReadMessage",method = RequestMethod.GET)
    public void deleteReadMessage(String readId){
        tbReadMessageService.deleteReadMessage(readId);
    }

    /**
     * 根据sno查询
     * @param sno
     * @return
     */
    @RequestMapping(value = "api/getOneReadMessage",method = RequestMethod.GET)
    public List<TbReadMessage> selectOneReadMessage(String sno){
        return tbReadMessageService.selectOneReadMessage(sno);
    }

}
