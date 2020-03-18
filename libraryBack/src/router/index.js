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
    redirect:'/index/book',
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
        name:'Rider1',//骑手管理
        path:'/index/Rider1',
        component:()=>import('../views2/Rider/Rider1.vue'),
        redirect:'/index/Rider1/Rider2',
        children:[
          {
            name:'Rider2',//骑手列表
            path:'/index/Rider1/Rider2',
            component:()=>import('../views2/Rider/Rider2.vue')
          },
          {
            name:'Rider3',//骑手审批
            path:'/index/Rider1/Rider3',
            component:()=>import('../views2/Rider/Rider3.vue')
          }
        ]
      },
      {
        name:'appointment',//预约管理
        path:'/index/appointment',
        component:()=>import('../views2/head/appointment.vue'),
        redirect:'/index/appointment/appint',
        children:[
          {
            name:'appint',//预约列表
            path:'/index/appointment/appint',
            component:()=>import('../views2/appointment/appint.vue'),
          },
          {
            name:'backBook',//还书列表
            path:'/index/appointment/backBook',
            component:()=>import('../views2/appointment/backBook.vue'),
          },
          {
            name:'backingBook',//已还列表
            path:'/index/appointment/backingBook',
            component:()=>import('../views2/appointment/backingBook.vue'),
          },
          {
            name:'appointmentAfter',//预约预期
            path:'/index/appointment/appointmentAfter',
            component:()=>import('../views2/appointment/appointmentAfter.vue'),
          },
          {
            name:'waitDesignate',//待指派
            path:'/index/appointment/waitDesignate',
            component:()=>import('../views2/appointment/waitDesignate.vue'),
          },
          {
            name:'ingDesignate',//正在配送
            path:'/index/appointment/ingDesignate',
            component:()=>import('../views2/appointment/ingDesignate.vue')
          }
        ]
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
  getIndexAccount().then((data) => {
    token = data.data.msg;
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
