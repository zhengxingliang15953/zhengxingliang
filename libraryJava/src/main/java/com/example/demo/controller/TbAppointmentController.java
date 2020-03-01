package com.example.demo.controller;

import com.example.demo.entity.TbAppointment;
import com.example.demo.service.TbAppointmentService;
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
public class TbAppointmentController {

    @Resource
    private TbAppointmentService tbAppointmentService;

    /**
     * 预约图书
     * @param appId
     * @param bookName
     * @param isbn
     * @param studentName
     * @param sno
     * @param appTime
     * @return
     */
    @RequestMapping(value = "api/getAppointment",method = RequestMethod.GET)
    public TbAppointment insertAppointment(String appId, String bookName, String isbn, String studentName, String sno,String appTime){
        return tbAppointmentService.insertAppointment(appId, bookName, isbn, studentName, sno, appTime);
    }

    /**
     * 我的预约
     * @param sno
     * @return
     */
    @RequestMapping(value = "api/getMyAppointment",method = RequestMethod.GET)
    public List<TbAppointment> selectMyAppointment(String sno){
        return tbAppointmentService.selectSnoAppointment(sno);
    }

    /**
     * 取消预约
     * @param appId
     * @param status
     */
    @RequestMapping(value = "api/getDeleteAppointment",method = RequestMethod.GET)
    public void deleteAppointment(String appId,Integer status){
        tbAppointmentService.deleteAppointment(appId, status);
    }

    /**
     * 预约列表
     * @param sno
     * @param isbn
     * @param appTime
     * @param start
     * @return
     */
    @RequestMapping(value = "api/getAllAppointment",method = RequestMethod.GET)
    public List<TbAppointment> selectAllAppointment(String sno, String isbn, String appTime,Integer start){
        return tbAppointmentService.selectThreeAppointment(sno, isbn, appTime, start);
    }

    /**
     * 状态改变
     * @param appId
     * @param status
     */
    @RequestMapping(value = "api/getUpdateAppointment",method = RequestMethod.GET)
    public void updateAppointment(String appId,Integer status,String isbn){
        tbAppointmentService.updateAppointment(appId, status,isbn);
    }
}
