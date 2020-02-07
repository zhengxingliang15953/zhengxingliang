<template>
  <div>
    <row class="mt-8 bgOfFooter" type="flex" justify="center">
      <div class="backUp" @click="toTop">
        <img src="../../assets/img/icon-backTop.png" alt="backTop">
      </div>
      <Col :lg="4"></Col>
      <Col :lg="16">
        <div class="flex-between">
          <ul class="listOfContent">
            <li>
              <i><img src="../../assets/img/icon-tel.png" alt="icon-tel"></i>
              {{$t('Hotline')}}：0572-3112233 3112201 3112202  4000572007
            </li>
            <li>
              <i><img src="../../assets/img/icon-mail.png" alt="icon-mail"></i>
              {{$t('Mailbox')}}：info@jing-quan.com
            </li>
            <li>
              <i><img src="../../assets/img/icon-addr.png" alt="icon-addr"></i>
              {{$t('Address')}}：{{$t('West Side of Shijiaqiao 104 National Road, Nanmen, Huzhou City, Zhejiang Province, China')}}
            </li>
          </ul>
          <div class="qrcode" >
            <div class="codebox">
            <img src="../../assets/img/qrcode.png" alt="qrcode">
            </div>
            <p>{{$t('Sweep and pay attention to us')}}</p>
          </div>
        </div>
      </Col>
      <Col :lg="4"></Col>
    </row>
    <row class="bgOfFooter" type="flex" justify="center" style="font-size: 14px;line-height: 3em;">
      <Col :lg="4"></Col>
      <Col :lg="16" class="info-web">
        <div>CopyRight @2019 {{$t('Copyright Zhejiang Jingquan Water Treatment Equipment Co., Ltd.')}}</div>
        <div><a href="http://www.beian.miit.gov.cn" style="color:white;" target="_blank">浙ICP备05026892号-1 </a>{{$t('Website construction')}}：
          <a style="color: #ffffff;" href="http://www.hzpangu.cn/" target="_blank">{{$t('Pangu network')}}</a>
        </div>
      </Col>
      <Col :lg="4"></Col>
    </row>
  </div>
</template>

<script>
import {getcontact} from '../../api'
export default {
  name: 'defaultFooter',
  created () {
    this.getContent(this.$i18n.locale);
  },
  data () {
    return {}
  },
  methods: {
    toTop () {
      var currentScroll = document.documentElement.scrollTop || document.body.scrollTop;
      if (currentScroll > 0) {
        window.requestAnimationFrame(this.toTop);
        window.scrollTo(0, currentScroll - (currentScroll / 5));
      }
    },
    async getContent (lang) {
      this.contentData = await getcontact(lang);
      this.contentData = this.contentData.data;
    }
  },
  computed: {},
  components: {}
}
</script>

<style scoped lang="less">
  .bgOfFooter {
    background: #4d4d4d;
    color: #fff;
    font-size: 16px;
    padding: 20px 0 0 0;
  }

  .listOfContent {
    line-height: 4em;
    i {
      margin-right: 10px;
    }
  }

  .qrcode {
    text-align: center;
    line-height: 2em;
  }
  .info-web {
    display: flex;
    justify-content: center;
    align-items: center;
    div {
      padding: 0 7px;
    }
  }

  @media screen and (max-width: 600px) {
    .bgOfFooter {
      padding: 30px 10px;
    }
    .codebox{
      background: #fff;
      padding: 5px;
      width: 150px;
      margin: 0 auto;
    }

    .backUp {
      margin-top: -30px !important;
    }

    .listOfContent {
      margin-top: 30px;
      li {
        text-align: center;
      }
      i {
        margin-right: 0 !important;
        text-align: center;
        display: block;
      }
    }
  }

  .backUp {
    width: 50px;
    height: 50px;
    position: absolute;
    display: flex;
    align-items: center;
    justify-content: center;
    cursor: pointer;
    z-index: 999;
    margin-top: -20px;
  }
  .codebox{
    background: #fff;
    padding: 5px;
    width: 150px;
  }
</style>
