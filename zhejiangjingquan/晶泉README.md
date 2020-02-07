#### 开发者信息：
* 系统名称：` 晶泉水处理 `
* 版权所有： ` 湖州盘古网络有限公司 `

#### 技术简介：
1. 前端技术
* 基于Vue开发。

2. 后端技术
* 程序框架 .Net Core 2.2
* 数据框架 EntityFrameworkCore 2.2.4
* 依赖注入 AutoFac 4.8.1
* 展示层 MVC
* 数据库 MySql 5.7


#### 接口简介：
* AboutUs

接口|访问方式|参数|简介
---|---|---|---:
api/about|Get|lang=cn|关于我们列表
api/about|Get|lang=en|AboutUs
api/about/details|Get|id|关于我们详情


* Banner

接口|访问方式|参数|简介
---|---|---|---:
api/banner|Get|lang=cn|轮播列表
api/banner|Get|lang=en|Banner


* Cases

接口|访问方式|参数|简介
---|---|---|---:
api/cases|Get|id?=null,lang=cn,category=scope|工程范围
api/cases|Get|id?=null,lang=cn,category=application|工程应用
api/cases|Get|id?=null,lang=cn,category=process|工艺流程
api/cases|Get|id?=null,lang=cn,category=human|人力资源
api/cases|Get|id?=null,lang=en,category=scope|scope
api/cases|Get|id?=null,lang=en,category=application|application
api/cases|Get|id?=null,lang=en,category=process|process
api/cases|Get|id?=null,lang=en,category=human|human


* ContactUs

接口|访问方式|参数|简介
---|---|---|---:
api/contactus|Get|lang=cn|联系我们
api/contactus|Get|lang=en|ContactUs



* Knowledge

接口|访问方式|参数|简介
---|---|---|---:
api/knowledge|Get|id?=null,lang=cn|水处理知识
api/knowledge|Get|id?=null,lang=en|水处理知识(英文)
api/knowledge/getindex|Get|lang=cn|首页水处理知识
api/knowledge/getindex|Get|lang=en|首页水处理知识(英文)


* News

接口|访问方式|参数|简介
---|---|---|---:
api/news|Get|category=industry,lang=cn,page=1,limit=10|行业新闻
api/news|Get|category=company,lang=cn,page=1,limit=10|公司新闻
api/news|Get|category=notice,lang=cn,page=1,limit=10|公司公告
api/news|Get|category=industry,lang=en,page=1,limit=10|industry
api/news|Get|category=company,lang=en,page=1,limit=10|company
api/news|Get|category=notice,lang=en,page=1,limit=10|notice
api/news/details|Get|id|新闻详情
api/news/getindex|Get|category=industry,lang=cn|行业新闻
api/news/getindex|Get|category=company,lang=cn|公司新闻
api/news/getindex|Get|category=notice,lang=cn|公司公告
api/news/getindex|Get|category=industry,lang=en|industry
api/news/getindex|Get|category=company,lang=en|company
api/news/getindex|Get|category=notice,lang=en|notice

* Product

接口|访问方式|参数|简介
---|---|---|---:
api/product|Get|id?=null,lang=cn|产品列表
api/product|Get|id?=null,lang=en|Product
api/product/getindex|Get|lang=cn|首页产品列表
api/product/getindex|Get|lang=en|首页产品列表(英文)