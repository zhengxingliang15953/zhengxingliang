package com.example.demo.service.Impl;

import com.example.demo.entity.TbAppointment;
import com.example.demo.entity.TbBook;
import com.example.demo.entity.TbWait;
import com.example.demo.mapper.TbAppointmentMapper;
import com.example.demo.mapper.TbBookMapper;
import com.example.demo.mapper.TbStudentMapper;
import com.example.demo.mapper.TbWaitMapper;
import com.example.demo.service.TbAppointmentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TbAppointmentServiceImpl  implements TbAppointmentService {

    @Resource
    private TbAppointmentMapper tbAppointmentMapper;

    @Resource
    private TbBookMapper tbBookMapper;

    @Resource
    private TbStudentMapper tbStudentMapper;

    @Resource
    private TbWaitMapper tbWaitMapper;

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
        List<TbBook> tbBookList=tbBookMapper.selectIsbnBook(isbn);
        List<TbWait> tbWaitList=tbWaitMapper.selectIsbnWait(isbn);
        if(tbAppointmentMapper.selectIfAppointment(sno, isbn).size()>=1||tbWaitMapper.selectSnoIsbnWait(sno, isbn).size()>=1){
            tbAppointment.setMsg("0");//已经预约过了
        }else if(tbWaitList.size()>5){
            tbAppointment.setMsg("1");//不可预约
        }else if(tbBookList.size()>=1&&tbBookList.get(0).getAppNumber()+tbBookList.get(0).getReadNumber()>=tbBookList.get(0).getBookNumber()){
            tbAppointment.setMsg("2");//排队
            tbAppointment.setLendingNumber(tbWaitList.size());
            tbWaitMapper.insertWait(appId,sno,isbn,appTime);
        }else{
            tbAppointmentMapper.insertAppointment(appId,bookName,isbn,studentName,sno,appTime,tbWaitList.size());
            Integer readNumber=tbBookList.get(0).getReadNumber();
            Integer appNumber1=tbBookList.get(0).getAppNumber();
            appNumber1++;
            tbBookMapper.updateReadLend(isbn,appNumber1,readNumber);
            tbAppointment.setMsg("3");//可以预约
        }
        return  tbAppointment;
    }

    /**
     * 获取我的预约
     * @param sno
     * @return
     */
    @Override
    public List<TbAppointment> selectSnoAppointment(String sno) {
        List<TbAppointment> tbAppointmentList=tbAppointmentMapper.selectSnoAppointment(sno);
        List<TbWait> tbWaitList=tbWaitMapper.selectSnoWait(sno);
        for(TbAppointment tbAppointment:tbAppointmentList){
            tbAppointment.setTbBook(tbBookMapper.selectIsbnBook(tbAppointment.getIsbn()).get(0));
        }
        for(TbWait tbWait:tbWaitList){
            tbWait.setTbBook(tbBookMapper.selectIsbnBook(tbWait.getIsbn()).get(0));
        }
        tbAppointmentList.get(0).setTbWaitList(tbWaitList);
        return tbAppointmentList;
    }

    /**
     * 取消预约
     * @param appId
     */
    @Override
    public void deleteAppointment(String appId,Integer status) {
        if(status==0){
            tbWaitMapper.deleteWait(appId);
        }else{
            tbAppointmentMapper.deleteAppointment(appId);
        }
    }

    /**
     * 预约列表
     * @param sno
     * @param appTime
     * @return
     */
    @Override
    public List<TbAppointment> selectThreeAppointment(String sno, String appTime,Integer start) {
       List<TbAppointment> tbAppointmentList=null;
       if(sno.equals("")&&appTime.equals("")){
           tbAppointmentList=tbAppointmentMapper.selectAllAppointment(new RowBounds((start-1)*10,10));
           if(tbAppointmentList.size()<=0){
               TbAppointment tbAppointment=new TbAppointment();
               tbAppointment.setMsg("0");
               tbAppointmentList.add(tbAppointment);
           }else{
               tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectAllAppointmentNumber().size()+"");
           }
           return tbAppointmentList;
       }else if(!sno.equals("")){
           tbAppointmentList=tbAppointmentMapper.selectSno(sno,new RowBounds((start-1)*10,10));
           if(tbAppointmentList.size()<=0){
               TbAppointment tbAppointment=new TbAppointment();
               tbAppointment.setMsg("0");
               tbAppointmentList.add(tbAppointment);
           }else{
               tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectSnoAppointment(sno).size()+"");
           }
           return tbAppointmentList;
       }else{
           tbAppointmentList=tbAppointmentMapper.selectAppTime(appTime,new RowBounds((start-1)*10,10));
           if(tbAppointmentList.size()<=0){
               TbAppointment tbAppointment=new TbAppointment();
               tbAppointment.setMsg("0");
               tbAppointmentList.add(tbAppointment);
           }else{
               tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectAppTimeNumber(appTime).size()+"");
           }
           return tbAppointmentList;
       }
    }

    /**
     * 状态改变
     * @param appId
     * @param status
     */
    @Override
    public void updateAppointment(String appId, Integer status,String isbn) {
        tbAppointmentMapper.updateAppointment(appId, status);
        List<TbBook> tbBookList= tbBookMapper.selectIsbnBook(isbn);
        Integer appNumber1=tbBookList.get(0).getAppNumber();
        Integer readNumber1=tbBookList.get(0).getReadNumber();
        appNumber1--;
        readNumber1++;
        tbBookMapper.updateReadLend(isbn,appNumber1,readNumber1);
    }
}
