<template>
  <div id="app">
    <siteHead></siteHead>
    <!--<swiper></swiper>-->
    <transition
      enter-active-class="animated fadeIn delay-1s"
      leave-active-class="animated fadeOut fast"
    >
    <router-view></router-view>
    </transition>
    <defaultFooter></defaultFooter>
  </div>
</template>

<script>
import swiper from './base/swiper/index.vue'
import siteHead from './base/header'
import defaultFooter from './base/defaultFooter'

export default {
  name: 'app',
  components: {
    swiper, siteHead, defaultFooter
  }
}
</script>

<style>
</style>
