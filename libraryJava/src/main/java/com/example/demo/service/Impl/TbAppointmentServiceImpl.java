package com.example.demo.service.Impl;

import com.example.demo.entity.TbAppointment;
import com.example.demo.entity.TbBook;
import com.example.demo.entity.TbStudent;
import com.example.demo.mapper.TbAppointmentMapper;
import com.example.demo.mapper.TbBookMapper;
import com.example.demo.mapper.TbStudentMapper;
import com.example.demo.service.TbAppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class TbAppointmentServiceImpl  implements TbAppointmentService {

    @Resource
    private TbAppointmentMapper tbAppointmentMapper;

    @Resource
    private TbBookMapper tbBookMapper;

    @Resource
    private TbStudentMapper tbStudentMapper;

    /**
     * 预约图书
     * @param appId
     * @param bookName
     * @param isbn
     * @param studentName
     * @param sno
     * @return
     */
    @Override
    public TbAppointment insertAppointment(String appId, String bookName, String isbn, String studentName, String sno,String appTime) {
        TbAppointment tbAppointment=new TbAppointment();
        if(tbAppointmentMapper.selectIfAppointment(sno, isbn).size()>=1){
            tbAppointment.setMsg("0");//已经订阅过了
        }else if(){

        }
    }
}
