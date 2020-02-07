<template>
    <div>
      <newslist :newsListData = "newsListData">
        <h2 class="titleOfAbout">{{$t('Business Bulletin')}}</h2>
      </newslist>
      
    </div>
</template>

<script>
import {getnews} from '../../../api'
import newslist from '../../../base/newslist'
export default {
  name: 'businessBulletin',
  created () {
    this.getaboutmsg('notice', this.$i18n.locale)
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
