<template>
  <row class="mt-8" type="flex" justify="center">
    <Col :lg="4"></Col>
    <Col :lg="16" :sm="24">
      <div class="mainTitle">
        <div class="mainTitle-en">COOPERATIVE</div>
        <div>
          <div class="mainTitle-cn bgOfMainTitle">合作伙伴</div>
        </div>
      </div>
      <div class="boxOfCooprative mt-6">
        <img src="../../assets/img/img-cooprative-01.png" alt="cooprative">
      </div>
    </Col>
    <Col :lg="4"></Col>
  </row>
</template>

<script>
export default {
  name: 'cooperative',
  data () {
    return {}
  },
  methods: {},
  computed: {},
  components: {}
}
</script>

<style scoped>
  .boxOfCooprative{
    text-align: center;
  }
</style>
