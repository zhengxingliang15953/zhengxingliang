<template>
    <div>
        <h2 class="titleOfAbout">{{$t('Zhejiang Jingquan Water Treatment Equipment Co., Ltd.')}}</h2>
      <div class="text-default mt-5">
        <div v-html="about.body"></div>
        <!--<div>-->
          <!--浙江晶泉水处理设备有限公司成立于1994年，是一家集二十年水处理工程设计、设备制造、总包水站工程、技术开发等于一身的专业企业。公司座落于湖州南门施家桥104国道西侧，位于沪、杭、苏黄金三角区，地理位置优越，交通、运输十分便利。-->
        <!--</div>-->
        <!--<div>-->
          <!--公司在和国内多家水处理科研单位的共同努力下，产品品种和质量得到不断的开发和提高，同时引进国外最新技术，成功推出了应用于制药、医疗、饮料、食品、生物、化工、电子、电力、纺织、涂装等行业的不同工艺的水处理成套生产线，并采用微机自动控制，满足了不同的用水要求。产品遍及全国各省市，并以自身过硬的技术和优良的售后服务受到了广大用户的一致好评。-->
        <!--</div>-->
        <!--<div>-->
          <!--公司严格执行ISO9001质量管理认证，同事积极开展对外合作，已同陶氏化学、丹麦格兰富、瑞士GF等国际领先膜器材及泵阀仪表研发制造企业建立良好的合作关系，并与许多科研机构及行业顾问进行着广泛的合作和交流，确保公司在技术应用领域始终处于行业的前沿。公司拥有高价值专利技术达六十多项，2007年公司被评为湖州市诚信企业，2009年公司承担科技型中小企业技术创新基金一项并成功验收，2011年公司入选“国家高新技术企业”，2012年公司入选“湖州市专利示范企业”。 2013年公司被授予“科技成长企业”的荣誉称号。-->
        <!--</div>-->
        <!--<div>-->
          <!--浙江晶泉将一如既往，配合用户的需要，提供更完善的设计和工艺，并以合理的价格与优良的品质，不断创新适应用户的需求。切实奉行"质量第一、信誉至上"的原则，与您携手共进，共创明天！-->
        <!--</div>-->
        <div class="mt-5 imgOfTextDefault">
          <img src="../../../assets/img/img-about.jpg" alt="">
        </div>
      </div>
    </div>
</template>

<script>
import {getaboutdel} from '../../../api'
export default {
  name: 'companyIntro',
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
  components: {}
}
</script>

<style scoped>
</style>
