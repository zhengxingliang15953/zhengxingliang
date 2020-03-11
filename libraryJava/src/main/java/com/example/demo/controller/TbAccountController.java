package com.example.demo.controller;


import com.example.demo.entity.TbAccount;
import com.example.demo.service.TbAccountService;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import io.swagger.annotations.ApiOperation;
import javax.annotation.Resource;
import java.util.List;


@Api(description = "图书馆管理员管理api")
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
    @ApiOperation(value = "登录", notes = "管理员登陆",httpMethod = "POST")
    public TbAccount getLogin(String account,String pwd){
        return tbAccountService.getLogin(account,pwd);
    }

    /**
     * 获取当前登录账号
     * @return
     */
    @RequestMapping(value = "api/getIndexAccount",method = RequestMethod.GET)
    @ApiOperation(value = "获取管理员当前登陆信息", notes = "管理员当前登陆信息",httpMethod = "GET")
    public TbAccount getIndexAccount(){
        return tbAccountService.getIndexAccount();
    }

    /**
     * 添加管理员
     * @param account
     * @param pwd
     */
    @RequestMapping(value = "api/getAddAccount",method = RequestMethod.POST)
    @ApiOperation(value = "添加管理员", notes = "添加管理员",httpMethod = "POST")
    public TbAccount insertAccount(String account,String pwd,String role){
        return tbAccountService.insertAccount(account, pwd,role);
    }

    /**
     * 修改密码
     * @param account
     * @param pwd
     */
    @ApiOperation(value = "管理员修改密码", notes = "管理员修改密码",httpMethod = "POST")
    @RequestMapping(value = "api/getUpdateAccountPwd",method = RequestMethod.POST)
    public void updatePwd(String account,String pwd){
        tbAccountService.updateAccount(account, pwd);
    }

    /**
     * 获取所有的管理员
     * @return
     */
    @ApiOperation(value = "获取所有管理员", notes = "获取所有管理员",httpMethod = "GET")
    @RequestMapping(value = "api/getAllAccount",method = RequestMethod.GET)
    public List<TbAccount> selectAllAccount(){
        return tbAccountService.selectAllAccount();
    }

    /**
     * 冻结账号or解冻账号
     * @param account
     * @param type
     */
    @ApiOperation(value = "冻结，解冻管理员", notes = "冻结，解冻管理员",httpMethod = "GET")
    @RequestMapping(value = "api/getUpdateType",method = RequestMethod.GET)
    public void updateType(String account,Integer type){
        tbAccountService.updateAccountType(account, type);
    }

    /**
     * 删除管理员
     * @param account
     */
    @ApiOperation(value = "删除管理员", notes = "删除管理员",httpMethod = "GET")
    @RequestMapping(value = "api/getDeleteAccount",method = RequestMethod.GET)
    public void deleteAccount(String account){
        tbAccountService.deleteAccount(account);
    }
}
