<template>
  <row class="mt-8" type="flex" justify="center">
    <Col :lg="4"></Col>
      
    
    <Col :lg="16" :sm="24" :xs="24">
      <div class="mainTitle">
        <div class="mainTitle-en">NEWS</div>
        <div>
          <div class="mainTitle-cn bgOfMainTitle">资讯动态</div>
        </div>
      </div>
      <row class="mt-6 flex-between newsContainer">
        <Col :lg="1"></Col>
          
        
        <Col :lg="7" :sm="24" :xs="24" class="boxOfTreatment">
          <div class="titleOfTreatment">
            <p>水处理知识</p>
            <p>WATER TREATMENT</p>
          </div>
          <div class="itemOfTreatment" v-for="(item, index) in knowledge" :key="index">
            <div class="boxOfQuestion">
            <img src="../../assets/img/icon-Q.png" alt="icon-Q">
              <router-link :to="{name:'knowDetail',params:{kid:item.id}}">
                <span>{{item.title}}</span>
              </router-link>
            </div>
            <div class="boxOfAnswer">
            <img src="../../assets/img/icon-A.png" alt="icon-Q">
            <div class="exceed-3">{{item.body}}</div>
            </div>
          </div>
        </Col>

        <Col :lg="1"></Col>
        <Col :lg="14" :sm="24" :xs="24" class="boxOfTreatment">
          <div class="titleOfTreatment">
            <p>新闻资讯</p>
            <p>NEWS AND INFORMATION</p>
          </div>
          <div class="typeOfNews flex">
            <p @click="getNews('company', $i18n.locale)">{{$t('Company News')}}</p>
            <p @click="getNews('industry', $i18n.locale)">{{$t('Industry News')}}</p>
            <p @click="getNews('notice', $i18n.locale)">{{$t('Business Bulletin')}}</p>
          </div>
          <ul class="listOfNewsIndex">
            <!--<li class="flex-between">-->
              <!--<router-link to="/home">-->
              <!--{{$t('Five Measures to Promote the Development of Membrane Water Treatment Industry in Huzhou, Zhejiang Province')}}-->
                <!--</router-link>-->
              <!--<p><span>{{$t('Release Time')}}  :  </span>2018-05-20 16:43</p>-->
            <!--</li>-->
            <li class="flex-between" v-for="(item, index) in newsData" :key="index">
              <router-link :to="{name:'newsDetail',params:{nid:item.id}}">
                {{item.title}}
                </router-link>
              <p><span>{{$t('Release Time')}}  :  </span>{{item.addTime}}</p>
            </li>
          </ul>
        </Col>
        <Col :lg="1"></Col>
      </row>
    </Col>

    <Col :lg="4"></Col>
  </row>
</template>

<script>
import {getindexnews, getindexknowledge} from '../../api';
export default {
  name: 'newsInIndex',
  created () {
    this.getNews('company', this.$i18n.locale);
    this.getknowledge(this.$i18n.locale);
  },
  data () {
    return {
      newsData: '',
      knowledge: ''
    }
  },
  methods: {
    async getNews (category, lang) {
      this.newsData = await getindexnews(category, lang);
      this.newsData = this.newsData.data;
      
    },
    async getknowledge (lang) {
      this.knowledge = await getindexknowledge(lang);
      this.knowledge = this.knowledge.data;
    }
  },
  computed: {},
  components: {}
}
</script>

<style scoped lang="less">
  .boxOfTreatment{
    background: #f3f3f3;
    .titleOfTreatment{
      background:linear-gradient(to right, #3965cd , rgba(57, 101, 205, .14));
      color: #ffffff;
      padding: 15px 20px;
      border-top-left-radius: 10px;
      border-top-right-radius: 10px;
      p:first-child{
        font-size: 30px;
      }
    }
    .itemOfTreatment{
      padding: 15px;
      border-bottom: 1px solid #ccc;
      .boxOfQuestion{
        color: #222;
        font-weight: 600;
      }
      .boxOfAnswer{
        padding: 5px 0;
        img{
          float: left;
          margin-right: 10px;
        }
      }
    }
  }
  .typeOfNews{
    justify-content: space-around;
    line-height: 3em;
    font-size: 18px;
    color: #222;
    font-weight: 500;
    border-bottom: 1px solid #cccccc;
    >p{
      cursor: pointer;
    }
  }
  .listOfNewsIndex{
    li{
      line-height: 2em;
      p{
        color: #a2a2a2;
        font-size: 13px;
        span{
          color: #cccccc;
        }
      }
    }
    .flex-between{
      padding: 5px 10px;
    }
  }
  .newsContainer{
    align-items: start;
  }
</style>
