package com.example.demo.schedule;

import com.example.demo.entity.TbAppointment;
import com.example.demo.entity.TbBook;
import com.example.demo.entity.TbWait;
import com.example.demo.mapper.TbAppointmentMapper;
import com.example.demo.mapper.TbBookMapper;
import com.example.demo.mapper.TbStudentMapper;
import com.example.demo.mapper.TbWaitMapper;
import com.example.demo.service.Impl.TbAppointmentServiceImpl;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.text.ParseException;
import java.util.List;

/**
 * 定时任务类
 */
@Component
public class Schedule {

    @Resource
    private TbAppointmentMapper tbAppointmentMapper;

    @Resource
    private TbAppointmentServiceImpl tbAppointmentService;

    @Resource
    private TbWaitMapper tbWaitMapper;

    @Resource
    private TbBookMapper tbBookMapper;

    @Resource
    private TbStudentMapper tbStudentMapper;

    //@Scheduled(fixedRate = 60000)//60秒执行一次
    @Scheduled(cron = "0 0 0 * * ?") //每天凌晨执行
    public void scheduleTime() throws ParseException {
        appointmentBefore();//检测预约过期
        System.out.println("预约过期检测");
        lendAfter();//检测借阅过期
        System.out.println("借阅过期检测");
    }

    public void appointmentBefore() throws ParseException {//预约过期检测
        List<TbAppointment> tbAppointmentList=tbAppointmentMapper.selectSchedule(1);
        for(TbAppointment appointment:tbAppointmentList){
            String appTime=appointment.getAppTime();
            if(tbAppointmentService.betweenDate(appTime,tbAppointmentService.getTime())>3){//预约周期为3天
                List<TbAppointment> appointmentList=tbAppointmentMapper.selectAppIdList(appointment.getAppId());
                tbAppointmentMapper.updateAfter(appointment.getAppId(),2);
                List<TbWait> tbWaitList=tbWaitMapper.selectIsbnWait(appointment.getIsbn());
                if(tbWaitList.size()>=1){
                    tbWaitMapper.deleteWait(tbWaitList.get(0).getWaitId());
                    String studentName=tbStudentMapper.selectOneStudent(tbWaitList.get(0).getSno()).getName();//学生姓名
                    String bookName=tbBookMapper.selectIsbnBook(tbWaitList.get(0).getIsbn()).get(0).getBookName();
                    tbAppointmentMapper.insertAppointment(tbWaitList.get(0).getWaitId(),bookName,tbWaitList.get(0).getIsbn(),studentName,tbWaitList.get(0).getSno(),tbAppointmentService.getTime(),tbWaitList.size()-1);
                }else{
                    List<TbBook> tbBookList=tbBookMapper.selectIsbnBook(appointment.getIsbn()); //图书预约人数、借阅人数修改
                    Integer appNumber=tbBookList.get(0).getAppNumber();
                    Integer readNumber=tbBookList.get(0).getReadNumber();
                    appNumber--;
                    tbBookMapper.updateReadLend(appointment.getIsbn(),appNumber,readNumber);
                }
            }
        }
    }

    public void lendAfter() throws ParseException {//借阅预期检测
        List<TbAppointment> tbAppointmentList=tbAppointmentMapper.selectSchedule(3);
        for(TbAppointment tbAppointment:tbAppointmentList){
            if(tbAppointment.getLendingTime().equals("")){//跟借阅时间比较
                if(tbAppointmentService.betweenDate(tbAppointment.getLendTime(),tbAppointmentService.getTime())>30){//借阅周期为30天
                    tbAppointmentMapper.updateAfter(tbAppointment.getAppId(),4);
                }
            }else{
                if(tbAppointmentService.betweenDate(tbAppointment.getLendingTime(),tbAppointmentService.getTime())>30){
                    tbAppointmentMapper.updateAfter(tbAppointment.getAppId(),4);
                }
            }
        }
    }
}
