<template>
    <div>
      <newslist :newsListData = "newsListData">
        <h2 class="titleOfAbout">{{$t('Company News')}}</h2>
      </newslist>
    </div>
</template>

<script>
import {getnews} from '../../../api'
import newslist from '../../../base/newslist'
export default {
  name: 'CompanyNews',
  created () {
    this.getaboutmsg('company', this.$i18n.locale)
  },
  data () {
    return {
      newsListData: ''
    }
  },
  methods: {
    async getaboutmsg (category, lang) {
      this.newsListData = await getnews(category, lang)
      this.newsListData = this.newsListData.data.rows
    }
  },
  computed: {},
  components: {
    newslist
  }
}
</script>

<style scoped>
</style>
