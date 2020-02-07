<template>
  <div style="overflow: hidden">
    <swiper></swiper>
    <row class="mt-8 rowOfContent" type="flex" justify="center">
      <Col :lg="2"></Col>
      <Col :lg="4" :sm="24">
        <navOfInside :navData="navdata">
          <p>{{$t('Jingquan')}}</p>
        </navOfInside>
        <contactUsInside></contactUsInside>
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="15" :sm="24" class="contentOfAbout">
        <router-view></router-view>
      </Col>
      <Col :lg="2"></Col>
    </row>
  </div>
</template>

<script>
import swiper from '../../base/swiper'
import contactUsInside from '../../base/contactUsInside'
import navOfInside from '../../base/navOfInside'

export default {
  name: 'aboutUs',
  data () {
    return {
      navdata: [
        {
          'name': 'company profile',
          'url': '/aboutUs/companyIntro'
        },
        {
          'name': 'manager address',
          'url': '/aboutUs/managerAddress'
        },
        {
          'name': 'development history',
          'url': '/aboutUs/developmentHistory'
        },
        {
          'name': 'company concept',
          'url': '/aboutUs/companyConcept'
        },
        {
          'name': 'company strategy',
          'url': '/aboutUs/companyStrategy'
        },
        {
          'name': 'honor',
          'url': '/aboutUs/qualificationHonor'
        },
        {
          'name': 'enterprise architecture',
          'url': '/aboutUs/enterpriseArchitecture'
        }
      ]
    }
  },
  methods: {},
  computed: {},
  components: {
    swiper, contactUsInside, navOfInside
  }
}
</script>

<style scoped lang="less">
</style>
