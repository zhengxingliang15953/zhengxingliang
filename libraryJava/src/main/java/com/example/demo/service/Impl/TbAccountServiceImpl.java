package com.example.demo.service.Impl;

import com.example.demo.entity.TbAccount;
import com.example.demo.mapper.TbAccountMapper;
import com.example.demo.service.TbAccountService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;
import java.util.Random;

@Service
public class TbAccountServiceImpl implements TbAccountService {
    @Resource
    private TbAccountMapper tbAccountMapper;
    private TbAccount indexAccount;
    /**
     * 管理员登陆验证
     * @param account
     * @param pwd
     * @return
     */
    public TbAccount getLogin(String account, String pwd) {
        TbAccount backAccount=new TbAccount();
        List<TbAccount> tbAccountList=tbAccountMapper.selectAllAccount();
        for(TbAccount tbAccount : tbAccountList){
            if(tbAccount.getAccount().equals(account)&&tbAccount.getPwd().equals(pwd)){
                backAccount=tbAccount;
                backAccount.setPwd("0");
                backAccount.setMsg(getToken(account,20));
                indexAccount=backAccount;
                break;
            }
        }
        return backAccount;
    }

    /**
     * 获取当前登录信息
     * @return
     */
    @Override
    public TbAccount getIndexAccount() {
        return indexAccount;
    }

    /**
     * 添加管理员
     * @param account
     * @param pwd
     */
    @Override
    public TbAccount insertAccount(String account, String pwd,String role) {
        TbAccount tbAccount=new TbAccount();
        for(TbAccount account1:tbAccountMapper.selectAllAccount()){
            if(account1.getAccount().equals(account)){
                tbAccount.setMsg("该账号已存在");
                return tbAccount;
            }
        }
        if(role.equals("普通管理员")){
            tbAccountMapper.insertAccount(account,pwd,2);
        }else{
            tbAccountMapper.insertAccount(account,pwd,1);
        }
        tbAccount.setMsg("添加成功");
        return tbAccount;
    }

    /**
     * 修改密码
     * @param account
     * @param pwd
     */
    @Override
    public void updateAccount(String account, String pwd) {
        tbAccountMapper.updateAccount(account, pwd);
    }

    /**
     * 获取所有的管理员信息
     * @return
     */
    @Override
    public List<TbAccount> selectAllAccount() {
        return tbAccountMapper.selectAllAccount();
    }

    /**
     * 冻结账号or解冻账号
     * @param account
     * @param type
     */
    @Override
    public void updateAccountType(String account, Integer type) {
        if(type==1){
            tbAccountMapper.updateAccountType(account,2);
        }else{
            tbAccountMapper.updateAccountType(account,1);
        }
    }

    /**
     * 删除管理员
     * @param account
     */
    @Override
    public void deleteAccount(String account) {
        tbAccountMapper.deleteAccount(account);
    }


    /**
     * 生成token
     * @param value
     */
    String getToken(String value,Integer length){
        String str="abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random=new Random();
        StringBuffer sb=new StringBuffer();
        for(int i=0;i<length;i++){
            int number=random.nextInt(62);
            sb.append(str.charAt(number));
        }
        return sb.toString()+value;
    }
}
