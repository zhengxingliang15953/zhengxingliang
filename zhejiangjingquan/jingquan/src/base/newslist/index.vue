<template>
  <div>
    <slot></slot>
    <ul class="newsList mt-5">
      <li class="flex itemOfNews" v-for="(item,index) in newsListData" :key="index">
        <div class="imgOfNews">
          <img :src="item.img" alt="img-news">
        </div>
        <div class="contentOfNews">
          <router-link :to="{name:'newsDetail',params:{nid:item.id}}">
            <p class="titleOfNews">{{item.title}}</p>
          </router-link>
          <p><span>{{$t('Release Time')}}  :  </span>{{item.addTime}}</p>
          <!--<div class="text-default exceed-4" v-html="newsListData.body"> </div>-->
          <div  v-html="item.body"> </div>
        </div>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'newslist',
  data () {
    return {}
  },
  props: {
    newsListData: {
      type:Array,
      required: true
    }
  },
  methods: {},
  computed: {},
  components: {}
}
</script>

<style scoped lang="less">
  .newsList {
    padding: 0 5px;
    .imgOfNews {
      width: 25%;
    }
    .contentOfNews {
      width: 73%;
      line-height: 2em;
      padding: 5px;
      .titleOfNews {
        font-weight: bold;
        font-size: 20px;
        color: #565656;
        line-height: 2em;
      }
      .text-default {
        font-size: 14px;
      }
    }
    .itemOfNews {
      justify-content: space-between;
      flex-wrap: wrap;
      margin-bottom: 20px;
      transition: all .5s;
      padding-left: 10px;

    }
    .itemOfNews:hover {
      box-shadow: 0 0 5px #cccccc;
    }
  }

  @media screen and (max-width: 600px) {
    .imgOfNews {
      width: 100% !important;
    }
    .contentOfNews{
      width: 100%!important;
    }
  }
</style>
