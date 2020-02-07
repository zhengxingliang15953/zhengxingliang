<template>
  <row class="mt-8 containerOfProducts" type="flex" justify="center">
    <Col :lg="2"></Col>
    <Col :lg="20" :sm="24">
      <div class="mainTitle">
        <div class="mainTitle-en">PRODUCTS</div>
        <div>
          <div class="mainTitle-cn bgOfMainTitle">产品展示</div>
        </div>
      </div>
      <div class="boxOfProducts mt-6">
        <div class="itemOfProducts" v-for="(item, index) in prodata" :key="index">
          <router-link :to="{name:'proDetail',params:{pid:item.id}}">
          <img :src="item.img" alt="products">
          <div class="titleOfPro">{{item.title}}</div>
          <!--<img :src="item.img" alt="products">-->
          </router-link>
        </div>
      </div>
    </Col>
    <Col :lg="2"></Col>
  </row>
</template>

<script>
import {getindexproducts} from '../../api'
export default {
  name: 'products',
  created () {
    this.getprodata(this.$i18n.locale)
  },
  data () {
    return {
      prodata: ''
    }
  },
  methods: {
    async getprodata (lang) {
      this.prodata = await getindexproducts(lang)
      this.prodata = this.prodata.data
    }
  },
  computed: {},
  components: {}
}
</script>

<style scoped lang="less">
  .boxOfProducts {
    display: flex;
    justify-content: center;
    flex-wrap: wrap;
    .itemOfProducts {
      width: 275px;
      height: 185px;
      margin: 0 20px 60px 20px;
      cursor: pointer;
      .titleOfPro{
        text-align: center;
        line-height: 2em;
      }
    }
  }
</style>
