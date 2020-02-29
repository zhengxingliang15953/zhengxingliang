import Vue from "vue";
import VueRouter from "vue-router";
import RouterHooks from "./hooks";
import {getIndexStudent} from '../api';

const routes = [
  {
    name:'index',//首页
    path:'/',
    component: () => import('../views2/index/index.vue'),
  },
  {
    path:'/header',
    component:()=>import('../views2/index/header.vue'),
    redirect:'/header/hutu',
    children:[
      {
        name:'hutu',//关于湖图
        path:'/header/hutu',
        component:()=>import('../views2/header/hutu.vue'),
      },
      {
        name:'opentime',//开放时间
        path:'/header/opentime',
        component:()=>import('../views2/header/opentime.vue'),
      },
      {
        name:'notice',//公告通知
        path:'/header/notice',
        component:()=>import('../views2/header/notice.vue'),
      },
      {
        name:'readMessage',//读者留言
        path:'/header/readMessage',
        component:()=>import('../views2/header/readmessage.vue'),
      },
      {
        name:'person',//个人中心
        path:'/header/person',
        component:()=>import('../views2/header/person.vue'),
      }
    ],
  },
  {
    name:'lend',//检索
    path:'/lend',
    component:()=>import('../views2/lend/lend.vue'),
  }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

router.beforeEach((to, from, next) => {
  getIndexStudent().then(data=>{
    if(window.sessionStorage.getItem("token") != data.data.msg ||typeof data.data.msg == "undefined"){
      window.sessionStorage.removeItem('token');
    }
  })
  next();
})

RouterHooks.init(router);
Vue.use(VueRouter);

export default router;
