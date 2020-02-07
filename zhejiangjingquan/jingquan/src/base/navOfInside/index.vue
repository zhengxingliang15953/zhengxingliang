<template>
  <div class="navOfInside">
    <div class="boxOfTitleInside">
      <img src="../../assets/img/icon-about-inside.png" alt="icon-about-inside">
      <slot></slot>
      <slot name="titleOfInside"></slot>
    </div>
    <ul class="listOfNavInside">
      <li v-for="(item, index) in navData" :key="index">
        <router-link :to="item.url">
          <span>{{$t(item.name)}}</span>
          <span>-></span>
        </router-link>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'navOfInside',
  data () {
    return {}
  },
  props: {
    navData: Array,
    required: true
  },
  created () {},
  methods: {},
  computed: {},
  components: {}
}
</script>

<style scoped>
  
</style>
