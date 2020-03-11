package com.example.demo.controller;

import com.example.demo.entity.TbResource;
import com.example.demo.service.TbResourceService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@Api(description = "导航资源管理api")
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
    @ApiOperation(value = "获取所有的导航资源", notes = "获取所有的导航资源",httpMethod = "GET")
    @RequestMapping(value = "api/getAllResource",method = RequestMethod.GET)
    public List<TbResource> selectAllResource(Integer start){
        return tbResourceService.selectAllResource(start);
    }

    /**
     * 删除导航资源
     * @param resourceId
     */
    @ApiOperation(value = "删除导航资源", notes = "删除导航资源",httpMethod = "GET")
    @RequestMapping(value = "api/getDetailResource",method = RequestMethod.GET)
    public void deleteResource(String resourceId){
        tbResourceService.deleteResource(resourceId);
    }

    /**
     * 添加导航资源
     * @param title
     * @param resourceUrl
     * @param resourceId
     */
    @ApiOperation(value = "添加导航资源", notes = "添加导航资源",httpMethod = "GET")
    @RequestMapping(value = "api/getAddResource",method = RequestMethod.GET)
    public void insertResource(String title,String resourceUrl,String resourceId){
        tbResourceService.insertResource(title, resourceUrl, resourceId);
    }
}
