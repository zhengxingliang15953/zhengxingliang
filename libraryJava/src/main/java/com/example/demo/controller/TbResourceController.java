package com.example.demo.controller;

import com.example.demo.entity.TbResource;
import com.example.demo.service.TbResourceService;
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
public class TbResourceController {

    @Resource
    private TbResourceService tbResourceService;

    /**
     * 获取所有的导航资源
     * @return
     */
    @RequestMapping(value = "api/getAllResource",method = RequestMethod.GET)
    public List<TbResource> selectAllResource(Integer start){
        return tbResourceService.selectAllResource(start);
    }

    /**
     * 删除导航资源
     * @param resourceId
     */
    @RequestMapping(value = "api/getDetailResource",method = RequestMethod.GET)
    public void deleteResource(String resourceId){
        tbResourceService.deleteResource(resourceId);
    }

    @RequestMapping(value = "api/getAddResource",method = RequestMethod.GET)
    public void insertResource(String title,String resourceUrl,String resourceId){
        tbResourceService.insertResource(title, resourceUrl, resourceId);
    }
}
