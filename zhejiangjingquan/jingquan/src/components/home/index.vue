<template>
  <div style="overflow: hidden">
    <swiper></swiper>
    <row class="mt-6" type="flex" justify="center">
      <Col :lg="1"></Col>
      <Col :lg="15" :sm="24" class="fadeInLeft">
        <div class="mainTitle-en">ABOUT US</div>
        <div class="mainTitle-cn flex">
          <span>关于晶泉</span>
          <div class="line-aboutUs">
            <div></div>
            <div></div>
          </div>
        </div>
        <div class="text-default about-index mt-4">
          <div v-html="about.body"></div>
        </div>
        <ul class="flex listOfAbout">
          <li>
            <router-link to="/aboutUs/companyIntro">
              <img src="../../assets/img/icon_company_0001.png" alt="icon">
              <p>{{ $t('company profile') }}</p>
            </router-link>
          </li>
          <li>
            <router-link to="/aboutUs/qualificationHonor">
              <img src="../../assets/img/icon_culture_0001.png" alt="icon">
              <p>{{ $t('qualification honor') }}</p>
            </router-link>
          </li>
          <li>
            <router-link to="/aboutUs/companyConcept">
              <img src="../../assets/img/icon_honor_0001.png" alt="icon">
              <p>{{ $t('company concept') }}</p>
            </router-link>
          </li>
        </ul>
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="6" :sm="24" class="fadeInRight">
        <img src="../../assets/img/img-about-index.png" alt="" class="aboutImg">
      </Col>
      <Col :lg="1"></Col>
    </row>
    <backFixedBox class="fadeInUp"></backFixedBox>
    <products class="fadeInUp"></products>
    <application class="fadeInUp"></application>
    <cooperative class="fadeInUp"></cooperative>
    <newsInIndex class="fadeInUp"></newsInIndex>
  </div>
</template>

<script>
import swiper from '../../base/swiper'
import backFixedBox from '../../base/backFixedBox'
import products from '../../base/productsDefault'
import application from '../../base/applicationOfIndex'
import cooperative from '../../base/cooperative'
import newsInIndex from '../../base/newsInIndex'

import {getaboutdel} from '../../api'

export default {
  name: 'home',
  created () {
    this.getaboutmsg(1, this.$i18n.locale)
  },
  data () {
    return {
      about: ''
    }
  },
  methods: {
    async getaboutmsg (id, lang) {
      this.about = await getaboutdel(id, lang)
      this.about = this.about.data
    }
  },
  computed: {},
  components: {
    backFixedBox, products, application, cooperative, newsInIndex, swiper
  }
}
</script>

<style scoped>
  .aboutImg{
    margin-top:45%;
  }

  @media screen and (max-width:993px) {
    .aboutImg{
    margin-top:0%;
  }
  }
</style>
