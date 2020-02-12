import Vue from "vue";
import VueRouter from "vue-router";
import RouterHooks from "./hooks";
import { getIndexAccount } from '../api';

const routes = [
  {
    name:'login',//登录
    path:'/',
    component:()=>import('../views2/login.vue'),
  },
  {
    name:'index',
    path:'/index',
    component:()=>import('../views2/index.vue'),
    redirect:'/index/notice',
    children:[
      {
        name:'notice',//公告管理
        path:'/index/notice',
        component:()=>import('../views2/head/notice.vue'),
      },
      {
        name:'student',//学生管理
        path:'/index/student',
        component:()=>import('../views2/head/student.vue'),
      },
      {
        name:'appointment',//预约管理
        path:'/index/appointment',
        component:()=>import('../views2/head/appointment.vue'),
      },
      {
        name:'readMessage',//留言管理
        path:'/index/readMessage',
        component:()=>import('../views2/head/readMessage.vue'),
      },
      {
        name:'person',//个人中心
        path:'/index/person',
        component:()=>import('../views2/head/person.vue'),
      },
      {
        name:'resource',//资源管理
        path:'/index/resource',
        component:()=>import('../views2/head/resource.vue'),
      },
      {
        name:'book',//图书管理
        path:'/index/book',
        component:()=>import('../views2/head/book.vue'),
      },
    ]
  }
];
const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

var token = '';
router.beforeEach((to, from, next) => {
  console.log(to.path);
  getIndexAccount().then((data) => {
    token = data.data.msg;
    console.log(token);
    console.log(window.sessionStorage.getItem('token'));
    if (to.path == '/') {
      next();
    } else {
      if (window.sessionStorage.getItem('token') == token) {
        next();
      } else {
        next('/');
      }
    }
  })
})

RouterHooks.init(router);
Vue.use(VueRouter);

export default router;
