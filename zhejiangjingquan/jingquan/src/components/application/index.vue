<template>
  <div style="overflow: hidden">
    <swiper></swiper>
    <row class="mt-8 rowOfContent" type="flex" justify="center">
      <Col :lg="2"></Col>
      <Col :lg="4" :sm="24">
      <!--工程应用列表区域-->
        <div class="navOfInside">
          <div class="boxOfTitleInside">
            <img src="../../assets/img/icon-about-inside.png" alt="icon-about-inside">
            <p>{{$t('application')}}</p>
          </div>
          
          <ul class="listOfNavInside" v-if="cnzn">
            <li v-for="(item, index) in infolist" :key="index" @click="getProData(item.id,'application',$i18n.locale)">
              <span>{{item.title}}</span>
              <span>-></span>
            </li>

            
          </ul>
          <ul class="listOfNavInside" v-if="!cnzn">
            <li v-for="(item, index) in titles" :key="index" @click="getChance(index)">
              <span>{{item}}</span>
              <span>-></span>
            </li>
          </ul>
          
        </div>
        <!--工程应用列表区域-->
        <contactUsInside></contactUsInside>
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="15" :sm="24" class="contentOfAbout">
        <h2 class="titleOfAbout" v-if="this.$i18n.locale=='cn'">{{info.title}}</h2>
        <h2 class="titleOfAbout" v-if="this.$i18n.locale=='en'">{{titles[index]||titles[0]}}</h2>
        <div class="text-default mt-5">
          <div v-html="info.body" v-if="!imgId">

          </div>
          <operativefirmenglisg v-if="this.index==4&&this.$i18n.locale=='en'"></operativefirmenglisg>
          <copperative v-if="this.index==3&&this.$i18n.locale=='en'"></copperative>
          <design v-if="this.index==2&&this.$i18n.locale=='en'"></design>
          <project v-if="this.index==0&&this.$i18n.locale=='en'"></project>
          <operative v-if="(info.title=='合作厂商'&&this.$i18n.locale=='cn')"></operative>
          <!--后来加的图片（数据库没改），只是显示作用，后期修改可以删掉-->
          <div v-if="(info.title=='应用领域'&&this.$i18n.locale=='cn')||(this.index==1&&this.$i18n.locale=='en')">
            <Row>
              <Col :lg="10">
                <img src="../../assets/img/upload/image/20191010/6370629964842893959157423.jpg" alt="" width="100%">
              </Col>
              <Col :lg="12" :push="1">
                <h2>{{$t('Petroleum and Chemical Industry')}}</h2>
                <p>{{$t('Chemical process and water system for boilers, chemicals, fertilizers, fine chemicals and cosmetics manufacturing')}}</p>
              </Col>
            </Row>
            <br>
            <Row>
              <Col :lg="10">
                <img src="../../assets/img/upload/image/20191010/6370629968298584083180145.jpg" alt="" width="100%">
              </Col>
              <Col :lg="12" :push="1">
                <h2>{{$t('Life and Industry')}}</h2>
                <p>{{$t('Purification of water for hotels, airports, living areas, swimming pools and various industrial uses')}}</p>
              </Col>
            </Row>
            <br>
            <Row>
              <Col :lg="10">
                <img src="../../assets/img/upload/image/20191010/6370629969053570631971898.jpg" alt="" width="100%">
              </Col>
              <Col :lg="12" :push="1">
                <h2>{{$t('Power and Electronics Industry')}}</h2>
                <p>{{$t('Thermoelectric, Firepower, Boiler Power Water, Single Crystal Semiconductor, Integrated Circuit Fast, Picture Tube Manufacturing Process Water Ultra Pure Water')}}</p>
              </Col>
            </Row>
            <br>
            <Row>
              <Col :lg="10">
                <img src="../../assets/img/upload/image/20191010/6370629969593745904362530.jpg" alt="" width="100%">
              </Col>
              <Col :lg="12" :push="1">
                <h2>{{$t('Food and beverage industry')}}</h2>
                <p>{{$t('Drinking water, materials, low blending water, pure draft beer filtration, juice concentration, protein recovery, kelp extraction mannitol')}}</p>
              </Col>
            </Row>
            
            <!--<img src="../../assets/img/yong1.jpg" alt=""><br><br>
            <img src="../../assets/img/yong2.jpg" alt=""><br><br>
            <img src="../../assets/img/yong3.jpg" alt="">-->
          </div>
          

          <img src="../../assets/img/hezuo.jpg" alt="" v-if="info.title=='合作客户'">
          <img src="../../assets/img/yejiSum.jpg" alt="" v-if="info.title=='工程业绩'||(this.index==0&&this.$i18n.local=='en')">
          <img src="../../assets/img/zhizao.jpg" alt="" v-if="info.title=='工程设计'">
          <img src="../../assets/img/yanfa.jpg" alt="" v-if="info.title=='工程设计'">
          <!--后来加的图片，后期修改可以删掉-->
        </div>
      </Col>
      <Col :lg="2"></Col>
    </row>
  </div>
</template>

<script>
import snav from '../../base/snav';
import swiper from '../../base/swiper';
import contactUsInside from '../../base/contactUsInside';
import {getcase} from '../../api';
import operative from './operativefirm.vue';
import project from './project.vue';
import design from './design.vue';
import copperative from './copperative.vue';
import operativefirmenglisg from './operativefirmEnglish.vue';
export default {
  name: 'application',
  created () {
    this.getinfolist('', 'application', this.$i18n.locale)
  },
  data () {
    return {
      info: '',
      infolist: '',
      titles:['project performance','application area','engineering design','cooperative client','cooperative firm'],
      index:'',
    }
  },
  methods: {
    async getinfolist (id, category, lang) {
      this.info = await getcase(id, category, lang)
      this.info = this.info.data
      this.infolist = this.info.rows
    },
    async getProData(id,category,lang){
      this.info= await getcase(id,category,lang);
      this.info= this.info.data;
    },
    getChance(item){
      this.index= item;
    }
  },
  computed: {
    imgId(){//新增的图片监听显示
      return this.info.title =='应用领域'||this.info.title=='合作厂商'||(this.$i18n.locale=='en');
    },
    cnzn(){
      return this.$i18n.locale=='cn';
    },
  },
  components: {
    snav, swiper, contactUsInside,operative,project,design,copperative,operativefirmenglisg
  }
}
</script>

<style scoped>
  .boxOfTitleInside p{
    width:100%;
    word-wrap:break-word;
  }
</style>
