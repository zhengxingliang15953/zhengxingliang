package com.example.demo.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
public class SendSmsController {
    @Resource
    private RestTemplate restTemplate;

    @RequestMapping(value = "/sendsmsTest",method = RequestMethod.GET)
    public String sendsmsTest(){
        //单发短信API
        String url = "https://open.ucpaas.com/ol/sms/sendsms";
        JSONObject jsonObject = new JSONObject();
        //基础配置，在开发平台认证后获取
        jsonObject.put("sid","6f661f1602eb77bfde003a28e7abff29");
        jsonObject.put("token","53325d1cf3435d6a4db6668637694f58");
        jsonObject.put("appid","0f18c715d32e4b83974fcfce37d0e531");
        //模板ID，在开发平台创建模板对应的模板ID
        jsonObject.put("templateid", "533773");
        //模板对应的参数，参数之间拼接用逗号作为间隔符
        //jsonObject.put("param","");
        //要发送的手机号
        jsonObject.put("mobile", "15314652021");
        //用户透传ID，随状态报告返回,可以不填写
        jsonObject.put("uid","");
        String json = JSONObject.toJSONString(jsonObject);
        //使用restTemplate进行访问远程服务
        HttpHeaders headers = new HttpHeaders();
        //headers.setContentType(MediaType.APPLICATION_JSON_UTF8);
        HttpEntity<String> httpEntity = new HttpEntity<String>(json, headers);
        String result = restTemplate.postForObject(url, httpEntity, String.class);
        return result;
    }
}
