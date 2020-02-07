import Vue from 'vue'
import Router from 'vue-router'

import '../language/zh-CN'

Vue.use(Router)

export default new Router({
  mode: 'history',
  // linkActiveClass:"ivu-menu-item-active"
  routes: [
    {
      path: '/',
      component: () => import('../components/home/index.vue'),
      meta: {keepAlive: true, title: '浙江晶泉水处理设备有限公司-首页'}
    }, {
      path: '/home',
      component: () => import('../components/home/index.vue'),
      meta: {keepAlive: true, title: '浙江晶泉水处理设备有限公司-首页'}
    }, {
      path: '/aboutUs',
      component: () => import('../components/about/index.vue'),
      redirect: '/aboutUs/companyIntro',
      meta: {title: '浙江晶泉水处理设备有限公司-关于我们'},
      children: [
        {
          path: '/aboutUs/companyIntro',
          component: () => import('../components/about/companyIntro'),
          meta: {title: '浙江晶泉水处理设备有限公司-企业简介'}
        },
        {
          path: '/aboutUs/managerAddress',
          component: () => import('../components/about/managerAddress'),
          meta: {title: '浙江晶泉水处理设备有限公司-总经理致辞'}
        },
        {
          path: '/aboutUs/developmentHistory',
          component: () => import('../components/about/developmentHistory'),
          meta: {title: '浙江晶泉水处理设备有限公司-发展历程'}
        },
        {
          path: '/aboutUs/companyConcept',
          component: () => import('../components/about/companyConcept'),
          meta: {title: '浙江晶泉水处理设备有限公司-公司理念'}
        },
        {
          path: '/aboutUs/companyStrategy',
          component: () => import('../components/about/companyStrategy'),
          meta: {title: '浙江晶泉水处理设备有限公司-公司战略'}
        },
        {
          path: '/aboutUs/qualificationHonor',
          component: () => import('../components/about/qualificationHonor'),
          meta: {title: '浙江晶泉水处理设备有限公司-资质荣誉'}
        },
        {
          path: '/aboutUs/enterpriseArchitecture',
          component: () => import('../components/about/enterpriseArchitecture'),
          meta: {title: '浙江晶泉水处理设备有限公司-企业架构'}
        }]
    }, {
      path: '/news',
      component: () => import('../components/news/index.vue'),
      meta: {title: '浙江晶泉水处理设备有限公司-新闻中心'},
      redirect: '/news/industryNews',
      children: [
        {
          path: '/news/industryNews',
          component: () => import('../components/news/industryNews'),
          meta: {title: '浙江晶泉水处理设备有限公司-行业新闻'}
        },
        {
          path: '/news/companyNews',
          component: () => import('../components/news/companyNews'),
          meta: {title: '浙江晶泉水处理设备有限公司-公司新闻'}
        },
        {
          path: '/news/businessBulletin',
          component: () => import('../components/news/businessBulletin'),
          meta: {title: '浙江晶泉水处理设备有限公司-企业公告'}
        }]
    },
    {
      path: '/newsDetail/:nid',
      component: () => import('../components/news/newsDetail'),
      name: 'newsDetail',
      meta: {title: '浙江晶泉水处理设备有限公司-新闻详情'}
    },
    {
      path: '/products',
      component: () => import('../components/products/index.vue'),
      name: 'proDetail',
      meta: {title: '浙江晶泉水处理设备有限公司-产品展示'}
    },
    {
      path: '/projectScope',
      component: () => import('../components/Project scope/index.vue'),
      meta: {title: '浙江晶泉水处理设备有限公司-工程范围'}
    },
    {
      path: '/application',
      component: () => import('../components/application/index.vue'),
      meta: {title: '浙江晶泉水处理设备有限公司-工程应用'}
    },
    {
      path: '/process',
      component: () => import('../components/process/index.vue'),
      meta: {title: '浙江晶泉水处理设备有限公司-工艺流程'}
    },
    {
      path: '/humanResources',
      component: () => import('../components/human resources/index.vue'),
      meta: {title: '浙江晶泉水处理设备有限公司-人力资源'}
    },
    {
      path: '/waterKnowledge',
      component: () => import('../components/water knowledge/index.vue'),
      name: 'knowDetail',
      meta: {title: '浙江晶泉水处理设备有限公司-水处理知识'}
    },
    {
      path: '/contactUs',
      component: () => import('../components/contactUs'),
      meta: {title: '浙江晶泉水处理设备有限公司-联系我们'}
    },
   
  ]
})
