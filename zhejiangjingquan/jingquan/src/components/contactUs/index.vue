<template>
  <div style="overflow: hidden">
    <swiper></swiper>
    <row class="mt-8 rowOfContent" type="flex" justify="center">
      <Col :lg="2"></Col>
      <Col :lg="12"  :md="12" :sm="24" class="contentOfAbout">
        <h2 class="titleOfAbout">{{$t('contactUs')}}</h2>
        <div style="width:80%;" class="text-mobile1">
          <!-- <div class="infoOfContact" v-html="info.body"> -->
            <div>
              <iframe src="map.html" width="100%" height="310px" scrolling="no"></iframe><!--导入地图api-->
            </div>
        </div>
      </Col>
      <Col :lg="8" :md="8" :sm="24" class="text-mobile2">
        <p>地址：中国浙江省湖州市南门外施家桥104国道西侧</p>
        <p>负责人：李　杰</p>
        <p>电话：0572-3112233&nbsp;3112201&nbsp;3112202</p>
        <p>传真：0572-3112203</p>
        <p>邮编：313022<br/></p>
        <p>网址：<a href="http://www.jing-quan.com\">www.jing-quan.com</a></p>
        <p>邮箱：info@jing-quan.com&nbsp;&nbsp;</p><p>销售部：&nbsp;</p>
        <p>联系人： 胡先生&nbsp;</p><p>联系电话： 15257225188</p>
        <p>联系人： 王先生&nbsp;</p><p>联系电话： 15257226158&nbsp;</p>
        <p>&nbsp; &nbsp;&nbsp;</p><p>售后服务部：&nbsp;</p>
        <p>联系人： 王先生&nbsp;</p>
        <p>联系电话： 15257226158&nbsp;</p><p>联系人： 朱先生&nbsp;</p>
        <p>联系电话： 15067217888</p><p>澳洲办事处：</p><p>联系人：Leo</p>
        <p>联系电话：0061426901198</p>
      </Col>
      <Col :lg="2"></Col>
    </row>
  </div>
</template>

<script>
import snav from '../../base/snav';
import swiper from '../../base/swiper';
import {getcontact} from '../../api';
export default {
  name: 'contactUs',
  created () {
    this.getinfolist(this.$i18n.locale)
  },
  data () {
    return {
      info: ''
    }
  },
  methods: {
    async getinfolist (lang) {
      this.info = await getcontact(lang)
      this.info = this.info.data
    }
  },
  computed: {},
  components: {
    snav, swiper
  }
}
</script>

<style scoped lang="less">
  .boxOfContact{
    display: flex;
    justify-content: space-around;
    align-items: flex-start;
    .infoOfContact{
      .titleOfContact{
        line-height: 3em;
        font-size: 18px;
        font-weight: 600;
      }
      p{
        line-height: 2em;
      }
    }
  }
  
 @media screen and (max-width:771px) {
   .text-mobile1{
     margin-left: 10%;
   }
   .text-mobile2{
     margin-left: 20%;
   }
   
 }

  @media screen and (max-width:500px ){
    .text-mobile2{
     margin-left: 10%;
   }
  }
</style>
