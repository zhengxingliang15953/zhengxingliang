<template>
  <div style="overflow: hidden">
    <swiper></swiper>
    <row class="mt-8 rowOfContent" type="flex" justify="center">
      <Col :lg="2"></Col>
      <Col :lg="4" :sm="24">
        <div class="navOfInside">
          <div class="boxOfTitleInside">
            <img src="../../assets/img/icon-about-inside.png" alt="icon-about-inside">
            <p>{{$t('humanResources')}}</p>
          </div>
          <ul class="listOfNavInside">
            <li v-for="(item, index) in infolist" :key="index" @click="getProData(item.id, $i18n.locale)">
              <span>{{item.title}}</span>
              <span>-></span>
            </li>
          </ul>
        </div>
        <contactUsInside></contactUsInside>
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="15" :sm="24" class="contentOfAbout" >
        <h2 class="titleOfAbout">{{info.title}}</h2>
        <div class="text-default mt-5" >
          <div v-html="info.body"></div>
        </div>
      </Col>
      <Col :lg="2"></Col>
    </row>
  </div>
</template>

<script>
import snav from '../../base/snav'
import swiper from '../../base/swiper'
import contactUsInside from '../../base/contactUsInside'
import {getcase} from '../../api'
export default {
  name: 'human',
  created () {
    this.getinfolist('', 'human', this.$i18n.locale);
  },
  data () {
    return {
      info: '',
      infolist: ''
    }
  },
  methods: {
    async getinfolist (id, category, lang) {
      this.info = await getcase(id, category, lang);
      this.info = this.info.data;
      this.infolist = this.info.rows;
    }
  },
  computed: {},
  components: {
    snav, swiper, contactUsInside
  }
}
</script>

<style scoped>
  .boxOfTitleInside p{
    width:100%;
    font-size:70%;
    word-wrap:break-word;
  }
  
</style>
