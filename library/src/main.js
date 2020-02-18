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
