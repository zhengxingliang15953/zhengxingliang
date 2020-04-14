<template>
  <!--行业新闻-->
  <div>
    <newslist :newsListData="newsListData">
      <h2 class="titleOfAbout">{{$t('Industry News')}}</h2>
    </newslist>
  </div>
</template>

<script>
import { getnews } from "../../../api";
import newslist from "../../../base/newslist";
export default {
  name: "industryNews",
  created() {
    this.getaboutmsg("industry", this.$i18n.locale);
  },
  data() {
    return {
      newsListData: []
    };
  },
  methods: {
    async getaboutmsg(category, lang) {
      this.newsListData = await getnews(category, lang);
      this.newsListData = this.newsListData.data.rows;
    }
  },
  computed: {},
  components: {
    newslist
  }
};
</script>

<style scoped>
</style>
