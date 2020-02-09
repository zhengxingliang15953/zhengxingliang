package com.example.demo.controller;


import com.example.demo.entity.TbAccount;
import com.example.demo.service.TbAccountService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;


@Controller
@CrossOrigin
@RestController
public class TbAccountController {

    @Resource
    private TbAccountService tbAccountService;

    /**
     * 管理员登录验证
     * @param account
     * @param pwd
     * @return
     */
    @RequestMapping(value = "api/getLogin",method = RequestMethod.POST)
    public TbAccount getLogin(String account,String pwd){
        return tbAccountService.getLogin(account,pwd);
    }

    /**
     * 获取当前登录账号
     * @return
     */
    @RequestMapping(value = "api/getIndexAccount",method = RequestMethod.GET)
    public TbAccount getIndexAccount(){
        return tbAccountService.getIndexAccount();
    }

    /**
     * 添加管理员
     * @param account
     * @param pwd
     */
    @RequestMapping(value = "api/getAddAccount",method = RequestMethod.POST)
    public TbAccount insertAccount(String account,String pwd){
        return tbAccountService.insertAccount(account, pwd);
    }

    /**
     * 修改密码
     * @param account
     * @param pwd
     */
    @RequestMapping(value = "api/getUpdateAccountPwd",method = RequestMethod.POST)
    public void updatePwd(String account,String pwd){
        tbAccountService.updateAccount(account, pwd);
    }

}
