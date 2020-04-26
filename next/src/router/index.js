import Vue from "vue";
import VueRouter from "vue-router";
import RouterHooks from "./hooks";


const routes = [
  {
    name:'login',//登录
    path:'/',
    component:()=>import('../views2/login.vue'),
  },
  {
    name:'index',//首页
    path:'/index',
    component:()=>import('../views2/index.vue'),
    redirect:'/index/apply',
    children:[
      {
        name:'apply',//开支管理
        path:'/index/apply',
        component:()=>import('../views2/apply.vue'),
      },
      {
        name:'customer',//客户管理
        path:'/index/customer',
        component:()=>import('../views2/customer.vue'),
      },
      {
        name:'supply',//供应管理
        path:'/index/supply',
        component:()=>import('../views2/supply.vue'),
      },
      {
        name:'order',//订单管理
        path:'/index/order',
        component:()=>import('../views2/order.vue'),
      },
      {
        name:'install',//安装人员管理
        path:'/index/install',
        component:()=>import('../views2/install.vue'),
      },
    ]
  }
];
const router = new VueRouter({
  // mode: "history",
  base: process.env.BASE_URL,
  routes
});

/* var token = '';
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
}) */

RouterHooks.init(router);
Vue.use(VueRouter);

export default router;
