package com.example.demo.controller;

import com.example.demo.entity.TbNotice;
import com.example.demo.service.TbNoticeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "通知公告api")
@Controller
@CrossOrigin
@RestController
public class TbNoticeController {

    @Resource
    private TbNoticeService tbNoticeService;

    /**
     * 添加公告通知
     * @param title
     * @param message
     */
    @ApiOperation(value = "添加公告", notes = "添加公告",httpMethod = "GET")
    @RequestMapping(value = "api/getAddNotice",method = RequestMethod.GET)
    public void insertNotice(String title,String message,String noticeId){
        tbNoticeService.insertNotice(title,message,noticeId);
    }

    /**
     * 删除公告
     * @param noticeId
     */
    @ApiOperation(value = "删除公告", notes = "删除公告",httpMethod = "GET")
    @RequestMapping(value = "api/getDeleteNotice",method = RequestMethod.GET)
    public void deleteNotice(String noticeId){
        tbNoticeService.deleteNotice(noticeId);
    }

    /**
     * 获取所有公告通知
     * @return
     */
    @ApiOperation(value = "获取所有公告", notes = "获取所有公告",httpMethod = "GET")
    @RequestMapping(value = "api/selectAllNotice",method = RequestMethod.GET)
    public List<TbNotice> selectAll(Integer start){
        return tbNoticeService.selectAll(start);
    }

    /**
     * 修改公告
     * @param title
     * @param message
     * @param noticeId
     */
    @ApiOperation(value = "修改公告", notes = "修改公告",httpMethod = "GET")
    @RequestMapping(value = "api/getUpdateNotice",method = RequestMethod.GET)
    public void updateNotice(String title,String message,String noticeId){
        tbNoticeService.updateNotice(title, message, noticeId);
    }
}
