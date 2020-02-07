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
                backAccount.setAccount(account);
                backAccount.setMsg(getToken(account,20));
                backAccount.setPwd("0");
                backAccount.setStatus(tbAccount.getStatus());
            }else{
                backAccount.setAccount("0");
                backAccount.setMsg("0");
                backAccount.setPwd("0");
                backAccount.setStatus(0);
            }
        }
        indexAccount=backAccount;
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
