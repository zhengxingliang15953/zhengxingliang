package com.example.demo.service.Impl;

import com.example.demo.entity.TbAppointment;
import com.example.demo.entity.TbBook;
import com.example.demo.entity.TbStudent;
import com.example.demo.entity.TbWait;
import com.example.demo.mapper.TbAppointmentMapper;
import com.example.demo.mapper.TbBookMapper;
import com.example.demo.mapper.TbStudentMapper;
import com.example.demo.mapper.TbWaitMapper;
import com.example.demo.service.TbAppointmentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
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
        if(tbBookList.get(0).getType()==0||tbBookList.size()<=0){//该书已经下架
            tbAppointment.setMsg("4");
            return  tbAppointment;
        }else if(tbAppointmentMapper.selectIfAppointment(sno, isbn).size()>=1||tbWaitMapper.selectSnoIsbnWait(sno, isbn).size()>=1){
            tbAppointment.setMsg("0");//已经预约过了
            return  tbAppointment;
        }else if(tbWaitList.size()>5){
            tbAppointment.setMsg("1");//不可预约
            return  tbAppointment;
        }else if(tbBookList.size()>=1&&tbBookList.get(0).getAppNumber()+tbBookList.get(0).getReadNumber()>=tbBookList.get(0).getBookNumber()){
            tbAppointment.setMsg("2");//排队
            tbAppointment.setLendingNumber(tbWaitList.size());
            tbWaitMapper.insertWait(appId,sno,isbn,appTime);
            return  tbAppointment;
        }else{
            tbAppointmentMapper.insertAppointment(appId,bookName,isbn,studentName,sno,getTime(),tbWaitList.size());
            Integer readNumber=tbBookList.get(0).getReadNumber();
            Integer appNumber1=tbBookList.get(0).getAppNumber();
            appNumber1++;
            tbBookMapper.updateReadLend(isbn,appNumber1,readNumber);
            tbAppointment.setMsg("3");//可以预约
            return  tbAppointment;
        }
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
        if(tbAppointmentList.size()>=1){
            for(TbAppointment tbAppointment:tbAppointmentList){
                tbAppointment.setTbBook(tbBookMapper.selectIsbnBook(tbAppointment.getIsbn()).get(0));
            }
        }else{
            TbAppointment tbAppointment=new TbAppointment();
            tbAppointment.setMsg("0");
            tbAppointmentList.add(tbAppointment);
        }
        if(tbWaitList.size()>=1){
            for(TbWait tbWait:tbWaitList){
                tbWait.setTbBook(tbBookMapper.selectIsbnBook(tbWait.getIsbn()).get(0));
            }
        }
        tbAppointmentList.get(0).setTbWaitList(tbWaitList);
        return tbAppointmentList;
    }

    /**
     * 取消预约
     * @param appId
     */
    @Override
    public TbAppointment deleteAppointment(String appId,Integer status) {
        TbAppointment tbAppointment=new TbAppointment();
        List<TbAppointment> tbAppointmentList=tbAppointmentMapper.selectDeleteList(1,appId);
            if(tbWaitMapper.selectWaitId(appId).size()>=1){
                tbWaitMapper.deleteWait(appId);
                tbAppointment.setMsg("1");
                return tbAppointment;
            }else if(tbAppointmentList.size()>=1){
                List<TbWait> tbWaitList=tbWaitMapper.selectIsbnWait(tbAppointmentList.get(0).getIsbn());
                TbBook tbBook=tbBookMapper.selectIsbnBook(tbAppointmentList.get(0).getIsbn()).get(0);
                Integer appNumber1=tbBook.getAppNumber();
                Integer readNumber1=tbBook.getReadNumber();
                if(tbWaitList.size()<=0){
                    appNumber1--;
                }
                tbBookMapper.updateReadLend(tbAppointmentList.get(0).getIsbn(),appNumber1,readNumber1);
                    tbAppointmentMapper.deleteAppointment(appId);
                    if(tbWaitList.size()>=1){
                        TbWait tbWait=tbWaitList.get(0);
                        tbWaitMapper.deleteWait(tbWait.getWaitId());
                        TbStudent tbStudent=tbStudentMapper.selectSnoStudent(tbWait.getSno()).get(0);
                        tbAppointmentMapper.insertAppointment(tbWait.getWaitId(),tbAppointmentList.get(0).getBookName(),tbWait.getIsbn(),tbStudent.getName(),tbWait.getSno(),getTime(),tbWaitList.size()-1>=0?tbWaitList.size():0);
                    }
                    tbAppointment.setMsg("1");
                    return tbAppointment;
                }else{
                    tbAppointment.setMsg("0");
                    return tbAppointment;
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
    public void updateAppointment(String appId, Integer status,String isbn) {//status==3:借阅&&status==5:已归还
        tbAppointmentMapper.updateAppointment(appId, status,getTime());
        List<TbBook> tbBookList= tbBookMapper.selectIsbnBook(isbn);
        Integer appNumber1=tbBookList.get(0).getAppNumber();
        Integer readNumber1=tbBookList.get(0).getReadNumber();
        appNumber1--;
        readNumber1++;
        tbBookMapper.updateReadLend(isbn,appNumber1,readNumber1);
    }

    /**
     * 归还图书
     * @param appId
     * @param isbn
     */
    @Override
    public void updateBackBook(String appId,  String isbn) {
        tbAppointmentMapper.updateBackBook(appId,getTime());
        List<TbBook> tbBookList= tbBookMapper.selectIsbnBook(isbn);
        Integer appNumber1=tbBookList.get(0).getAppNumber();
        Integer readNumber1=tbBookList.get(0).getReadNumber();
        List<TbWait> tbWaitList=tbWaitMapper.selectIsbnWait(isbn);
        if(tbWaitList.size()<=0){
            readNumber1--;
        }
        tbBookMapper.updateReadLend(isbn,appNumber1,readNumber1);
        if(tbWaitList.size()>=1){
            TbWait tbWait=tbWaitList.get(0);
            tbWaitMapper.deleteWait(tbWait.getWaitId());
            TbStudent tbStudent=tbStudentMapper.selectSnoStudent(tbWait.getSno()).get(0);
            tbAppointmentMapper.insertAppointment(tbWait.getWaitId(),tbBookList.get(0).getBookName(),isbn,tbStudent.getName(),tbWait.getSno(),getTime(),tbWaitList.size()-1>=0?tbWaitList.size():0);
        }
    }

    /**
     * 获取归还图书列表
     * @param sno
     * @param appTime
     * @param start
     * @return
     */
    @Override
    public List<TbAppointment> selectBackBook(String sno, String appTime, Integer start) {
        List<TbAppointment> tbAppointmentList=null;
        if(sno.equals("")&&appTime.equals("")){//所有
            tbAppointmentList=tbAppointmentMapper.selectAllBackBookList(new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectAllBackBookNumber().size()+"");
            }
            return tbAppointmentList;
        }else if(!sno.equals("")){//有学号传入
            tbAppointmentList=tbAppointmentMapper.selectSnoBackBook(sno,new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectSnoBackBookNumber(sno).size()+"");
            }
            return tbAppointmentList;
        }else{//有日期传入
            tbAppointmentList=tbAppointmentMapper.selectAppTimeBackBook(appTime,new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectAppTimeBackBookNumber(appTime).size()+"");
            }
            return tbAppointmentList;
        }
    }

    /**
     * 获取已归还列表
     * @param sno
     * @param backTime
     * @param start
     * @return
     */
    @Override
    public List<TbAppointment> selectBackingBook(String sno, String backTime, Integer start) {
        List<TbAppointment> tbAppointmentList=null;
        if(sno.equals("")&&backTime.equals("")){
            tbAppointmentList=tbAppointmentMapper.selectAllBackingBook(new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectAllBackingBookNumber().size()+"");
            }
            return tbAppointmentList;
        }else if(!sno.equals("")){
            tbAppointmentList=tbAppointmentMapper.selectSnoBackingBook(sno,new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectSnoBackingNumberBook(sno).size()+"");
            }
            return tbAppointmentList;
        }else{
            tbAppointmentList=tbAppointmentMapper.selectBackTimeBackingBook(backTime,new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectBackTimeBackingBookNumber(backTime).size()+"");
            }
            return tbAppointmentList;
        }
    }

    /**
     * 续借
     * @param appId
     * @return
     */
    @Override
    public TbAppointment continueBrow(String appId,String isbn) throws ParseException {
        TbAppointment tbAppointment=new TbAppointment();
        if(tbAppointmentMapper.selectDeleteList(5,appId).size()>=1){//状态有问题
            tbAppointment.setMsg("0");
            return tbAppointment;
        }else if(tbAppointmentMapper.selectDeleteList(4,appId).size()>=1){//已逾期无法续借
            tbAppointment.setMsg("1");
            return tbAppointment;
        }else if(tbWaitMapper.selectIsbnWait(isbn).size()>=1){//该书后续已有人预约
            tbAppointment.setMsg("2");
            return tbAppointment;
        }else if(tbAppointmentMapper.selectAppIdList(appId).get(0).getLendingTime().equals("")&&betweenDate(tbAppointmentMapper.selectAppIdList(appId).get(0).getLendTime(),getTime())<=27){
            tbAppointment.setMsg("3");//没有在最后三天续借
            return tbAppointment;
        }else if(betweenDate(tbAppointmentMapper.selectAppIdList(appId).get(0).getLendingTime(),getTime())<=27){
            tbAppointment.setMsg("3");//没有在最后三天续借
            return tbAppointment;
        }else{
            tbAppointmentMapper.updateLendingTime(appId,getTime());//可以续借
            tbAppointment.setMsg("4");
            return tbAppointment;
        }
    }

    /**
     * 预约预期列表
     * @param sno
     * @param appTime
     * @param start
     * @return
     */
    @Override
    public List<TbAppointment> selectAppAfter(String sno, String appTime, Integer start) {
        List<TbAppointment> tbAppointmentList=null;
        if(sno.equals("")&&appTime.equals("")){
            tbAppointmentList=tbAppointmentMapper.selectAllAfter(new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectAllAfterNumber().size()+"");
            }
            return tbAppointmentList;
        }else if(!sno.equals("")){
            tbAppointmentList=tbAppointmentMapper.selectSnoAfter(sno,new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectSnoAfterNumber(sno).size()+"");
            }
            return tbAppointmentList;
        }else{
            tbAppointmentList=tbAppointmentMapper.selectAppTimeAfter(appTime,new RowBounds((start-1)*10,10));
            if(tbAppointmentList.size()<=0){
                TbAppointment tbAppointment=new TbAppointment();
                tbAppointment.setMsg("0");
                tbAppointmentList.add(tbAppointment);
            }else{
                tbAppointmentList.get(0).setMsg(tbAppointmentMapper.selectAppTimeAfterNumber(appTime).size()+"");
            }
            return tbAppointmentList;
        }
    }

    /**
     * 时间格式生成
     * @return
     */
    public String getTime(){
        String time=new Date().toString();
        String[] list=time.split(" ");
        String str="";
        switch(list[1]){
            case "Jan":str="01";break;
            case "Feb":str="02";break;
            case "Mar":str="03";break;
            case "Apr":str="04";break;
            case "May":str="05";break;
            case "Jun":str="06";break;
            case "Jul":str="07";break;
            case "Aug":str="08";break;
            case "Sept":str="09";break;
            case "Oct":str="10";break;
            case "Nov":str="11";break;
            case "Dec":str="12";break;
        }
        return list[5]+"-"+str+"-"+list[2];
    }

    /**
     * 时间相差计算
     * @param lendTime
     * @param nowTime
     * @return
     * @throws ParseException
     */
    public long betweenDate(String lendTime,String nowTime) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-mm-dd");
        Date date1=sdf.parse(lendTime);
        Date date2=sdf.parse(nowTime);
        return (date2.getTime()-date1.getTime()+1000000)/(60*60*24*1000);
    }
}
