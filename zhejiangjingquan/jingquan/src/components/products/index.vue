<template>
  <div style="overflow: hidden">
      <swiper></swiper>
      <row class="mt-8 rowOfContent" type="flex" justify="center">
        <Col :lg="2"></Col>
        <Col :lg="4" :sm="24">
          <div class="navOfInside">
            <div class="boxOfTitleInside">
              <img src="../../assets/img/icon-about-inside.png" alt="icon-about-inside">
              <p>{{$t('products')}}</p>
            </div>
            <ul class="listOfNavInside">
              <li v-for="(item, index) in navData" :key="index" @click="getProData(item.id, $i18n.locale)" v-show="item.title!='水处理设备'&&item.title!='Water treatment equipment'">
                  <span>{{item.title}}</span>
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
        <Col :lg="15" :sm="24" class="contentOfAbout">
          <div>
            <h2 class="titleOfAbout">{{prodetail.title}}</h2>
            <div class="text-default mt-5"><!--text-default mt-5-->
              <div v-html="prodetail.body"></div>
            </div>
          </div>

          <row type="flex" justify="center" v-if="prodetail.title=='多介质过滤器'||prodetail.title=='Multi-media filter'">
            <Col :lg="8"><img src="../../assets/img/duojiezhiguolvqi1.png" alt="" width="99%" height="100%"></Col>
            <Col :lg="8"><img src="../../assets/img/duojiezhiguolvqi2.png" alt="" width="99%"></Col> 
            <Col :lg="8"><img src="../../assets/img/duojiezhiguolvqi3.png" alt="" width="99%"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='叠片过滤器'||prodetail.title=='Laminated filter'">
            <!--<Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629846750340262945185.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col> -->
            <Col :lg="11"><img src="../../assets/img/upload/image/20191010/6370629847499839835505213.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="2"></Col> 
            <Col :lg="11"><img src="../../assets/img/upload/image/20191010/6370629853720698659641272.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="11"><img src="../../assets/img/diepianguolvqi1.png" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="2"></Col>
            <Col :lg="11"><img src="../../assets/img/diepianguolvqi2.png" alt="" width="100%" height="80%" class="imgTop"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='除铁除锰过滤器'||prodetail.title=='iron and manganese filters'">
            <Col :lg="11"><img src="../../assets/img/upload/image/20191010/6370629859494123245324708.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="2"></Col> 
            <Col :lg="11"><img src="../../assets/img/upload/image/20191010/6370629867356580256121538.jpg" alt="" width="100%" class="imgTop"></Col>
            <!--<Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629867672946021459646.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col>-->
            <Col :lg="11"><img src="../../assets/img/chutiemeng3.png" alt="" width="100%"  class="imgTop"></Col>
            <Col :lg="2"></Col>
            <Col :lg="11"><img src="../../assets/img/chutiemeng2.png" alt="" width="100%"  class="imgTop"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='活性炭过滤器'||prodetail.title=='Activated carbon filter'">
            <Col :lg="11" ><img src="../../assets/img/huoxintan1.png" width="80%" style="margin-left:10%;" class="imgTop"></Col>
            <Col :lg="2"></Col>
            <Col :lg="11"><img src="../../assets/img/huoxintan2.png" width="80%" style="margin-left:10%;" class="imgTop"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='超滤装置'||prodetail.title=='The ultrafiltration device'">
            <Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629876753964179634310.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col> 
            <Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629877208601095312290.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/chaolv4.png" width="100%" height="95%" class="imgTop"></Col>
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/cholv2.png" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/chaolv3.png" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/chaolv1.png" height="75%" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='反渗透设备'||prodetail.title=='Reverse osmosis equipment'">
            <Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629884923850153360722.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col> 
            <Col :lg="7"><img src="../../assets/img/6370629882848138648263216.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/fansheng2.png" alt="" width="100%" class="imgTop"></Col> 
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/fansheng3.png" alt="" width="100%" class="imgTop"></Col> 
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/fansheng4.png" alt="" width="100%" class="imgTop"></Col> 
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/fansheng1.png" alt="" width="100%" class="imgTop"></Col> 
            <Col :lg="1"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='预处理系统'||prodetail.title=='Pretreatment system'">
            <Col :lg="11"><img src="../../assets/img/upload/image/20191010/6370629885924413918370301.jpg" alt="" width="100%"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='蒸馏水系统'||prodetail.title=='Distilled water system'">
            <!--<Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629914281996224277457.jpg" alt="" width="100%"></Col>
            <Col :lg="1"></Col> 
            <Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629914570950635437650.jpg" alt="" width="100%"></Col> 
            <Col :lg="1"></Col>-->
            <Col :lg="16"><img src="../../assets/img/zhengliushui1.png" width="100%" alt=""></Col>
            
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='透析用纯水装置'||prodetail.title=='Dialysis with pure water device'">
            <Col :lg="11"><img src="../../assets/img/upload/image/20191010/6370629970297670504822832.jpg" alt="" width="100%"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='精滤及微孔过滤'||prodetail.title=='Fine filtration and microporous'">
            <!--<Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629914972223877757765.jpg" alt="" width="100%"></Col>
            <Col :lg="1"></Col> 
            <Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629916441937485244947.jpg" alt="" width="60%"></Col> 
            <Col :lg="1"></Col>-->
            <Col :lg="9"><img src="../../assets/img/jinglv1.png" alt="" width="100%"></Col>
            <Col :lg="1"></Col>
            <Col :lg="14"><img src="../../assets/img/jinglv2.png" alt="" style="margin-top:7px;" width="100%"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='配料、结晶设备'||prodetail.title=='Ingredients and crystallization'">
            <Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629921219073887353698.jpg" alt="" width="100%"></Col>
            <Col :lg="1"></Col> 
            <Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629924492440367287171.jpg" alt="" width="100%"></Col> 
            <Col :lg="1"></Col>
            <Col :lg="7"><img src="../../assets/img/upload/image/20191010/6370629925034877025749310.jpg" alt="" width="100%"></Col> 
            <Col :lg="1"></Col>
            <Col :lg="10"><img src="../../assets/img/upload/image/20191010/6370629922960759969823568.jpg" alt="" width="100%"></Col> 
            <Col :lg="2"></Col>
            <Col :lg="10"><img src="../../assets/img/upload/image/20191010/6370629925538634222108620.jpg" alt="" width="100%"></Col> 
            <Col :lg="2"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='其他产品及配件'||prodetail.title=='Other products and accessorie'">
            <Col :lg="6"><img src="../../assets/img/upload/image/20191010/6370629928861990338502191.jpg" alt="" ></Col>
            <Col :lg="6"><img src="../../assets/img/upload/image/20191010/6370629931824068723212453.jpg" alt="" ></Col> 
            <Col :lg="6"><img src="../../assets/img/upload/image/20191010/6370629928039158587072370.jpg" alt="" ></Col>
              
            <!--<Col :lg="7" :xs="17"><img src="../../assets/img/upload/image/20191010/6370629926438648318264084.jpg" alt="" width="53%" style="margin-left:23.5%;"></Col>
            <Col :lg="1"></Col> 
            <Col :lg="7" :xs="17"><img src="../../assets/img/upload/image/20191010/6370629930039432501908182.jpg" alt="" width="61%" style="margin-left:19.5%;"></Col> 
            <Col :lg="1"></Col>-->
            <Col :lg="6"><img src="../../assets/img/upload/image/20191010/6370629931509556187971896.jpg" alt="" ></Col> 
            
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='离子交换器'||prodetail.title=='on-exchanger'">
            <Col :lg="11"><img src="../../assets/img/6370629934090663966499727.jpg" alt="" width="100%" class="imgTop"></Col>
            <Col :lg="2"></Col> 
            <Col :lg="11"><img src="../../assets/img/63706299344.jpg" alt="" height="97%" class="imgTop"></Col>
          </row>

          <row type="flex" justify="center" v-if="prodetail.title=='电渗析器'||prodetail.title=='Electrodialyser'">
            <Col :lg="5"><img src="../../assets/img/upload/image/20191010/6370629936588353582316841.jpg" alt="" width="100%"></Col>
            <Col :lg="1"></Col> 
            <Col :lg="5"><img src="../../assets/img/upload/image/20191010/6370629936817433883395789.jpg" alt="" width="100%"></Col>
            <Col :lg="1"></Col>
            <Col :lg="5"><img src="../../assets/img/upload/image/20191010/6370629937068835959595030.jpg" alt="" width="100%"></Col>
            <Col :lg="1"></Col>
            <Col :lg="5"><img src="../../assets/img/upload/image/20191010/6370629937393368276060524.jpg" alt="" width="100%"></Col>
            <Col :lg="1"></Col>
          </row>
        </Col>
        <Col :lg="2"></Col>
      </row>
    </div>
</template>

<script>
import {getproducts} from '../../api'
import swiper from '../../base/swiper'
export default {
  name: 'products',
  created () {
    this.getprolist('', this.$i18n.locale)
  },
  mounted () {
    this.getprodetail(this.pid, this.$i18n.locale)
  },
  data () {
    return {
      navData: '',//列表
      prodetail: '',
      }
  },
  methods: {
    async getProData (id, lang) {
      this.prodetail = await getproducts(id, lang);
      this.prodetail = this.prodetail.data;
    },
    async getprolist (id, lang) {
      this.navData = await getproducts(id, lang);
      this.navData = this.navData.data.rows;
    },
    async getprodetail (id, lang) {
      this.prodetail = await getproducts(id, lang);
      this.prodetail = this.prodetail.data;
    }
  },
  computed: {
    pid () {
      if (this.$route.params.pid) {
        return this.$route.params.pid
      } else {
        if(this.$i18n.locale=='cn'){
          return '22';
        }else{
          return '123';
        }
        
      }
    }
  },
  components: {
    swiper
  }
}
</script>

<style>
  .listOfNavInside>li{
    cursor: pointer;
  }

  .lizi{
    height:100%;
  }

  @media screen and (max-width:993px){
    .lizi{
      width: 100%;
    }
  }
.imgTop{
  margin-top:10px;
}
</style>
