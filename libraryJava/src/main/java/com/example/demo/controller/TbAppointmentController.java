package com.example.demo.controller;

import com.example.demo.entity.TbAppointment;
import com.example.demo.service.TbAppointmentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
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
    public TbAppointment deleteAppointment(String appId,Integer status){
        return tbAppointmentService.deleteAppointment(appId, status);
    }

    /**
     * 预约列表
     * @param sno
     * @param appTime
     * @param start
     * @return
     */
    @RequestMapping(value = "api/getAllAppointment",method = RequestMethod.GET)
    public List<TbAppointment> selectAllAppointment(String sno,  String appTime,Integer start){
        return tbAppointmentService.selectThreeAppointment(sno, appTime, start);
    }

    /**
     * 借阅改变
     * @param appId
     * @param status
     */
    @RequestMapping(value = "api/getUpdateAppointment",method = RequestMethod.GET)
    public void updateAppointment(String appId,Integer status,String isbn){
        tbAppointmentService.updateAppointment(appId, status,isbn);
    }

    /**
     * 图书归还
     * @param appId
     * @param isbn
     */
    @RequestMapping(value = "api/getBackBookBtn",method = RequestMethod.GET)
    public void updateBackBook(String appId,String isbn){
        tbAppointmentService.updateBackBook(appId, isbn);
    }

    /**
     * 获取归还列表
     * @param sno
     * @param appTime
     * @param start
     * @return
     */
    @RequestMapping(value = "api/getAllBackBook",method = RequestMethod.GET)
    public List<TbAppointment> selectBackBook(String sno, String appTime, Integer start){
        return tbAppointmentService.selectBackBook(sno,appTime,start);
    }

    /**
     * 获取已归还列表
     * @param sno
     * @param backTime
     * @param start
     * @return
     */
    @RequestMapping(value = "api/getAllBackingBook",method = RequestMethod.GET)
    public List<TbAppointment> selectBackingBook(String sno,String backTime,Integer start){
        return tbAppointmentService.selectBackingBook(sno, backTime, start);
    }

    /**
     * 续借
     * @param appId
     * @param isbn
     * @return
     * @throws ParseException
     */
    @RequestMapping(value = "api/getUpdateLendingTime",method = RequestMethod.GET)
    public TbAppointment updateLendingTime(String appId,String isbn) throws ParseException {
        return tbAppointmentService.continueBrow(appId, isbn);
    }

    /**
     * 获取预约预期列表
     * @param sno
     * @param appTime
     * @param start
     * @return
     */
    @RequestMapping(value = "api/getAppointmentAfter",method = RequestMethod.GET)
    public List<TbAppointment> selectAppointmentAfter(String sno,String appTime,Integer start){
        return tbAppointmentService.selectAppAfter(sno, appTime, start);
    }
}
