import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store.js";
import "./plugins/vconsole";
import "./plugins/ui";
import "./assets/file.css";
import BaiduMap from 'vue-baidu-map';

Vue.use(BaiduMap, {
  ak: 'GdxI7nmOnetq8NrHHigd78vbGYpMUvSg'    //这个地方是官方提供的ak密钥
})

Vue.config.productionTip = false;
document.documentElement.style.fontSize = document.documentElement.clientWidth / 7.5 + 'px';
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");


Vue.filter('appTime',function(value){//全局appTime过滤器
  let list=[];
  let str="";
  list=value.split(' ');
  switch(list[1]){
    case 'Jan':str='01';break;
    case 'Feb':str='02';break;
    case 'Mar':str='03';break;
    case 'Apr':str='04';break;
    case 'May':str='05';break;
    case 'Jun':str='06';break;
    case 'Jul':str='07';break;
    case 'Aug':str='08';break;
    case 'Sept':str='09';break;
    case 'Oct':str='10';break;
    case 'Nov':str='11';break;
    case 'Dec':str='12';break;
  }
  return `${list[3]}年${str}月${str}日`;
})

Vue.filter('appType',function(value){
  switch(value){
    case 0:return '排队';
    case 1:return '已预约';
    case 2:return '预约预期';
    case 3:return '已借阅';
    case 4:return '借阅预期';
    case 5:return '已归还';
    case 6:return '待指派';
    case 7:return '骑手未接单';
    case 8:return '骑手取书中';
    case 9:return '骑手配送中';
  }
})