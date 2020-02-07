<template>
  <div>
    <h2 class="titleOfAbout">{{$t('enterprise architecture')}}</h2>
    <div class="text-default mt-5">
      <div v-html="info.body"></div>
      <img src="../../../assets/img/enterprise2.jpg" alt="">
    </div>
    
  </div>
</template>

<script>
import {getaboutdel} from '../../../api'
export default {
  name: 'enterpriseArchitecture',
  created () {
    this.getaboutmsg(9, this.$i18n.locale)
  },
  data () {
    return {
      info: ''
    }
  },
  methods: {
    async getaboutmsg (id, lang) {
      this.info = await getaboutdel(id, lang)
      this.info = this.info.data
    }
  },
  computed: {},
  components: {}
}
</script>

<style scoped>
</style>
