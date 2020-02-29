package com.example.demo.controller;

import com.example.demo.entity.TbAppointment;
import com.example.demo.service.TbAppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
}
