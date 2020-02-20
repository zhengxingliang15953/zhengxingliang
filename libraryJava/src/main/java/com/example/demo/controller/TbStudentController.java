package com.example.demo.controller;

import com.example.demo.entity.TbStudent;
import com.example.demo.service.TbStudentService;
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
public class TbStudentController {

    @Resource
    private TbStudentService tbStudentService;

    /**
     * 学生登录验证
     * @param sno
     * @param pwd
     * @return
     */
    @RequestMapping(value = "api/getStudentLogin",method = RequestMethod.POST)
    public TbStudent getStudentLogin(String sno,String pwd){
        return tbStudentService.studentLogin(sno, pwd);
    }

    /**
     * 获取当前登陆信息
     * @return
     */
    @RequestMapping(value = "api/getIndexStudent",method = RequestMethod.GET)
    public TbStudent getIndexStudent(){
        return tbStudentService.getIndexStudent();
    }

    /**
     * 修改密码
     * @param sno
     * @param pwd
     */
    @RequestMapping(value = "api/getUpdatePwd",method = RequestMethod.POST)
    public void updatePwd(String sno,String pwd){
        tbStudentService.updatePwd(sno, pwd);
    }

    /**
     * 获取所有的学生
     * @return
     */
    @RequestMapping(value = "api/getAllStudent",method = RequestMethod.GET)
    public List<TbStudent> selectAllStudent(String sno,Integer start){
        return tbStudentService.selectAllStudent(sno, start);
    }
}
