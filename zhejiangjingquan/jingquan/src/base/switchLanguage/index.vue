<template>
  <button type="button" class="btn" @click="changeLocale">中文/EN</button>
</template>

<script>
export default {
  name: 'switchLanguage',
  data () {
    return {}
  },
  methods: {
    changeLocale () {
      let locale = this.$i18n.locale;
      locale === 'cn' ? this.$i18n.locale = 'en' : this.$i18n.locale = 'cn';
      let lang = this.$i18n.locale;
      sessionStorage.setItem('locale', lang);
      location.reload();
    }
  },
  computed: {},
  components: {}
}
</script>

<style scoped>
</style>
