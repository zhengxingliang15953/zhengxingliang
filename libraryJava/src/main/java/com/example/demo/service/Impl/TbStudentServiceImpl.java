package com.example.demo.service.Impl;

import com.example.demo.entity.TbStudent;
import com.example.demo.mapper.TbStudentMapper;
import com.example.demo.service.TbStudentService;
import org.apache.ibatis.session.RowBounds;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class TbStudentServiceImpl implements TbStudentService {

    @Resource
    private TbStudentMapper tbStudentMapper;

    @Resource
    private TbAccountServiceImpl tbAccountServiceImpl;

    public TbStudent tbStudent;


    /**
     * 学生登录验证
     * @param sno
     * @param pwd
     */
    @Override
    public TbStudent studentLogin(String sno, String pwd) {
        TbStudent student=new TbStudent();
        List<TbStudent> tbStudentList=tbStudentMapper.selectSnoStudent(sno);
        if(tbStudentList.size()<=0){
            student.setMsg("0");
            student.setPwd("0");
            return student;
        }
        student=tbStudentMapper.selectOneStudent(sno);
        if(tbStudentList.size()>=1&&student.getPwd()==null){
                tbStudentMapper.updatePwd(sno,student.getIdCard().substring(12));
            }
            if(tbStudentList.size()>=1&&pwd.equals(student.getPwd())){
                student.setMsg(tbAccountServiceImpl.getToken(sno,20));
            }else{
                student.setMsg("0");
            }
        student.setPwd("0");
        this.tbStudent=student;
        return student;
    }

    /**
     * 获取当前登陆信息
     * @return
     */
    @Override
    public TbStudent getIndexStudent() {
        return this.tbStudent;
    }

    /**
     * 修改密码
     * @param sno
     * @param pwd
     */
    @Override
    public void updatePwd(String sno, String pwd) {
        tbStudentMapper.updatePwd(sno, pwd);
    }

    /**
     * 获取所有的学生
     * @return
     */
    @Override
    public List<TbStudent> selectAllStudent(String sno,Integer start) {
        List<TbStudent> studentList=null;
        if(sno.equals("")){
            studentList= tbStudentMapper.selectAllStudent(new RowBounds((start-1)*10,10));
            for(TbStudent student:studentList){
                student.setPwd("0");
                student.setMsg("0");
                student.setStatus(tbStudentMapper.selectNumberStudent().size());
            }
        }else{
            studentList=tbStudentMapper.selectSnoStudent(sno);
            for(TbStudent student:studentList){
                student.setPwd("0");
                student.setMsg("0");
                student.setStatus(1);
            }
        }
        return studentList;
    }

    public static boolean isNullOrEmpty(Object obj) {
        if (obj == null)
            return true;

        if (obj instanceof CharSequence)
            return ((CharSequence) obj).length() == 0;

        if (obj instanceof Collection)
            return ((Collection) obj).isEmpty();

        if (obj instanceof Map)
            return ((Map) obj).isEmpty();

        if (obj instanceof Object[]) {
            Object[] object = (Object[]) obj;
            if (object.length == 0) {
                return true;
            }
            boolean empty = true;
            for (int i = 0; i < object.length; i++) {
                if (!isNullOrEmpty(object[i])) {
                    empty = false;
                    break;
                }
            }
            return empty;
        }
        return false;
    }
}
