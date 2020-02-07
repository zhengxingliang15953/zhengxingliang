<template>
  <div>
    <h2 class="titleOfAbout">{{$t('development history')}}</h2>
    <div class="text-default mt-5">
      <div v-html="info.body"></div>
    </div>
  </div>
</template>

<script>
import {getaboutdel} from '../../../api'
export default {
  name: 'developmentHistory',
  created () {
    this.getaboutmsg(5, this.$i18n.locale)
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
