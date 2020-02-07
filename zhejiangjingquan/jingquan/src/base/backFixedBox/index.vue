<template>
  <div class="boxOfFixedback mt-8">
    <row class="flex-between">
      <Col :lg="1"></Col>
      <Col :lg="16" :sm="12" :xs="24">
        <ul class="listOfFeature">
          <li>
            <img class="iconOfFeature" src="../../assets/img/icon-StateKey.png" alt="icon">
            {{$t('National key support for high-tech enterprises')}}
          </li>
          <li>
            <img class="iconOfFeature" src="../../assets/img/icon-patent.png" alt="icon">
            {{$t('Zhejiang Science Technology and Patent Demonstration Enterprises')}}
          </li>
          <li>
            <img class="iconOfFeature" src="../../assets/img/icon-Authentication.png" alt="icon">
            {{$t('CQC ISO9000 Certification Enterprise')}}
          </li>
          <li>
            <img class="iconOfFeature" src="../../assets/img/icon-tel.png" alt="icon">
            {{$t('Phone:4000572007')}}
          </li>
        </ul>
      </col>
      <Col :lg="5" :sm="12" :xs="24" class="bgOfHotline" style="margin-top:2%;"> 
        <div class="flex boxOfHotline">
          <div class="hezuo">{{$t('Cooperation Hotline')}}</div>
          <div>0572-3112233</div>
          <button class="btn mt-7" >
           <a  target="_blank" href="http://wpa.qq.com/msgrd?v=3&amp;uin=2031292260&amp;site=qq&amp;menu=yes" >
            {{$t('Online message')}}
           </a>
            </button>
        </div>
      </col>
      <Col :lg="2"></col>
    </row>
  </div>
</template>

<script>
export default {
  name: 'backFixedBox',
  data () {
    return {}
  },
  methods: {
    
  },
  computed: {},
  components: {}
}
</script>

<style scoped lang="less">
  .boxOfFixedback {
    height: 100%;
  }

  .listOfFeature {
    display: flex;
    flex-direction: column;
    margin-top: 10px;
    li {
      line-height: 2em;
      color: #fff;
      font-size: 28px;
      font-weight: bold;
      letter-spacing: 3px;
      .iconOfFeature {
        width: 50px;
        height: 50px;
      }
    }
  }

  .bgOfHotline {
    height: 220px;
    background: url("../../assets/img/bg-hotline.png") center 0px no-repeat;
    margin-top: -140px;
    .hezuo{
      text-align: center;
    }
  }

  .boxOfHotline {
    flex-direction: column;
    div {
      line-height: 2em;
      font-size: 24px;
      color: #333333;
      font-weight: bold;
    }
  }
  button{
    margin-top: 11%;
  }
</style>
