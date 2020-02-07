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


}
