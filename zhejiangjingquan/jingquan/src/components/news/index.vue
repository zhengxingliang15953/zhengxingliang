<template>
  <div style="overflow: hidden">
    <swiper></swiper>
    <row class="mt-8 rowOfContent" type="flex" justify="center">
      <Col :lg="2"></Col>
      <Col :lg="4" :sm="24">
        <navOfInside :navData="navdata" v-if="this.$i18n.locale=='cn'">  
          <p>{{$t('news')}}</p>
        </navOfInside>

        <div class="navOfInside" v-if="this.$i18n.locale=='en'">
            <div class="boxOfTitleInside">
              <img src="../../assets/img/icon-about-inside.png" alt="icon-about-inside">
              <p>{{$t('news')}}</p>
            </div>
            <ul class="listOfNavInside">
              <li v-for="(item, index) in navdata" :key="index" @click="chance(index)">
                  <span>{{item.name}}</span>
                  <span>-></span>
              </li>
            </ul>
        </div>

        <div class="contactUs mt-7">
          <p>联系我们 / CONTACT US</p>
          <ul class="listOfContentUs">
            <li>
              <i><img src="../../assets/img/icon-tel-ccc.png" alt="icon-tel"></i>
              {{$t('Hotline')}}：<br>0572-3112233<br>0572-3112201<br>0572-3112202  4000572007
            </li>
            <li>
              <i><img src="../../assets/img/icon-mail-ccc.png" alt="icon-mail"></i>
              {{$t('Mailbox')}}：<br>info@jing-quan.com
            </li>
            <li>
              <i><img src="../../assets/img/icon-addr-ccc.png" alt="icon-addr"></i>
              {{$t('Address')}}：{{$t('West Side of Shijiaqiao 104 National Road, Nanmen, Huzhou City, Zhejiang Province, China')}}
            </li>
            <div class="qrcode mt-7">
              <img src="../../assets/img/qrcode.png" alt="qrcode">
              <p>{{$t('Sweep and pay attention to us')}}</p>
            </div>
          </ul>
        </div>
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="15" :sm="24" class="contentOfAbout" >

          <div v-if="this.$i18n.locale=='en'">
            <h2 class="titleOfAbout">{{this.navdata[this.index].name}}</h2>
            <div class="text-default mt-5"><!--text-default mt-5-->
              <bussiness v-if="this.index==2"></bussiness>
              <comapny v-if="this.index==1"></comapny>
              <hangye v-if="this.index==0"></hangye>
            </div>
          </div>

        <router-view v-if="this.$i18n.locale=='cn'"></router-view>
      </Col>
      <Col :lg="2"></Col>
    </row>
  </div>
</template>

<script>
import swiper from '../../base/swiper';
import navOfInside from '../../base/navOfInside';
import bussiness from './bussiness.vue';
import comapny from './company.vue';
import hangye from './hangye.vue';
export default {
  name: 'news',
  data () {
    return {
      navdata: [
        {
          'name': 'Industry News',
          'url': '/news/industryNews'
        },
        {
          'name': 'Company News',
          'url': '/news/companyNews'
        },
        {
          'name': 'Business Bulletin',
          'url': '/news/businessBulletin'
        }
      ],
      index:'0'
    }
  },
  methods: {
    chance(item){
      this.index=item;
    }
  },
  computed: {},
  components: {
    swiper, navOfInside,bussiness,comapny,hangye
  },
}
</script>

<style >
.listOfNavInside>li{
    cursor: pointer;
  }
</style>
