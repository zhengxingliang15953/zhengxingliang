<template>
  <div style="overflow: hidden">
    <swiper></swiper>
    <row class="mt-8 rowOfContent" type="flex" justify="center">
      <Col :lg="2"></Col>
      <Col :lg="20" :sm="24" class="contentOfAbout">
        <h2 class="titleOfAbout">{{newsdata.title}}</h2>
        <div class="text-default">
          <div v-html="newsdata.body"></div>
        </div>
      </Col>
      <Col :lg="2"></Col>
    </row>
  </div>
</template>

<script>
import {getnewsdetail} from '../../../api'
import swiper from '../../../base/swiper'
export default {
  name: 'newsDetail',
  created () {
    this.getnewscontent(this.nid, this.$i18n.locale)
  },
  data () {
    return {
      newsdata: ''
    }
  },
  methods: {
    async getnewscontent (pid, lang) {
      this.newsdata = await getnewsdetail(pid, lang)
      this.newsdata = this.newsdata.data
    }
  },
  computed: {
    nid () {
      return this.$route.params.nid
    }
  },
  components: {
    swiper
  }
}
</script>

<style scoped>
</style>
