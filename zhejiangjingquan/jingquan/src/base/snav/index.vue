<template>
  <div class="navOfInside">
    <div class="boxOfTitleInside">
      <img src="../../assets/img/icon-about-inside.png" alt="icon-about-inside">
      <slot></slot>
      <slot name="titleOfInside"></slot>
    </div>
    <ul class="listOfNavInside">
      <li v-for="(item, index) in navData" :key="index">
          <span>{{$t(item.proTitle)}}</span>
          <span>-></span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'snav',
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

<style scoped lang="less">
  .listOfNavInside>li{
    cursor: pointer;
  }
</style>
