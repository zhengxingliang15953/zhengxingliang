import Vue from "vue";
import App from "./App.vue";
import router from "./router";
import store from "./store.js";
import "./plugins/vconsole";
import "./plugins/ui";
import "./assets/file.css";


Vue.config.productionTip = false;
document.documentElement.style.fontSize = document.documentElement.clientWidth / 7.5 + 'px';
new Vue({
  router,
  store,
  render: h => h(App)
}).$mount("#app");


