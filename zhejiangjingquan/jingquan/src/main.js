// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'
import App from './App'
import router from './router'

import iView from 'iview'
import 'iview/dist/styles/iview.css'
import VueI18n from 'vue-i18n'
import en from 'iview/dist/locale/en-US'
import cn from 'iview/dist/locale/zh-CN'
import appZh from './language/zh-CN.json'
import appEn from './language/en-US.json'

import VueAwesomeSwiper from 'vue-awesome-swiper'
import 'swiper/dist/css/swiper.css'
import 'animate.css/animate.min.css'
import './assets/css/global.css'
import './assets/css/main.css'

Vue.use(VueI18n)

const messages = {
  en: Object.assign(appEn, en),
  cn: Object.assign(appZh, cn),
}

// Create VueI18n instance with options
const i18n = new VueI18n({
  locale: sessionStorage.getItem('locale') || 'cn', // set locale
  messages, // set locale messages
  silentTranslationWarn: true
})
Vue.use(iView, {
  i18n: (key, value) => i18n.t(key, value)
})
// Vue.config.lang = 'cn'
Vue.use(VueAwesomeSwiper)

Vue.config.productionTip = false

router.beforeEach((to, from, next) => {
  /* 路由发生变化修改页面title */
  if (to.meta.title) {
    document.title = to.meta.title
  }
  next()
})

router.beforeEach((to, from, next) => {
  // chrome
  document.body.scrollTop = 0;
  // firefox
  document.documentElement.scrollTop = 0;
  // safari
  window.pageYOffset = 0;
  next();
})

/* eslint-disable no-new */
new Vue({
  el: '#app',
  router,
  i18n,
  components: { App },
  template: '<App/>'
})
