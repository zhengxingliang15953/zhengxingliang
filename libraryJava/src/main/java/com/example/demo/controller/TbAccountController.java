package com.example.demo.controller;


import com.example.demo.entity.TbAccount;
import com.example.demo.service.TbAccountService;
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
    public TbAccount insertAccount(String account,String pwd,String role){
        return tbAccountService.insertAccount(account, pwd,role);
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

    /**
     * 获取所有的管理员
     * @return
     */
    @RequestMapping(value = "api/getAllAccount",method = RequestMethod.GET)
    public List<TbAccount> selectAllAccount(){
        return tbAccountService.selectAllAccount();
    }

    /**
     * 冻结账号or解冻账号
     * @param account
     * @param type
     */
    @RequestMapping(value = "api/getUpdateType",method = RequestMethod.GET)
    public void updateType(String account,Integer type){
        tbAccountService.updateAccountType(account, type);
    }

    /**
     * 删除管理员
     * @param account
     */
    @RequestMapping(value = "api/getDeleteAccount",method = RequestMethod.GET)
    public void deleteAccount(String account){
        tbAccountService.deleteAccount(account);
    }
}
