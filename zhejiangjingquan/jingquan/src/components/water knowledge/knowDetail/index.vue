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
import {getknowledge} from '../../../api'
import swiper from '../../../base/swiper'
export default {
  name: 'knowDetail',
  created () {
    this.getcontent(this.kid, this.$i18n.locale);
    
  },
  data () {
    return {
      newsdata: ''
    }
  },
  methods: {
    async getcontent (id, lang) {
      this.newsdata = await getknowledge(id, lang)
      this.newsdata = this.newsdata.data
    }
  },
  computed: {
    kid () {
      return this.$route.params.kid
    }
  },
  components: {
    swiper
  }
}
</script>

<style scoped>
</style>
