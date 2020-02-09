import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store.js";
import "./plugins/vconsole";
import "./plugins/ui";
import "./assets/file.css";

Vue.filter('identity', function (value) {
  if(value=='1'){
    return "超级管理员";
  }else if(value=='2'){
    return "普通管理员";
  }
})


Vue.config.productionTip = false;
document.documentElement.style.fontSize = document.documentElement.clientWidth / 7.5 + 'px';
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");


