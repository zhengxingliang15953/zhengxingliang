<template>
  <row class="mt-8 bgOfApplication" type="flex" justify="center">
    <Col :lg="4"></Col>
    <Col :lg="20" :sm="24">
      <div class="mainTitle-en" >APPLICATION</div>
      <div class="mainTitle-cn">应用领域</div>
      <ul class="listOfApp">
        <li class="itemOfApp">
          <p>A.{{$t('Petroleum and Chemical Industry')}}</p>
          <p>{{$t('Chemical process and water system for boilers, chemicals, fertilizers, fine chemicals and cosmetics manufacturing')}}</p>
        </li>
        <li class="itemOfApp">
          <p>B.{{$t('Life and Industry')}}</p>
          <p>{{$t('Purification of water for hotels, airports, living areas, swimming pools and various industrial uses')}}</p>
        </li>
        <li class="itemOfApp">
          <p>C.{{$t('Power and Electronics Industry')}}</p>
          <p>{{$t('Thermoelectric, Firepower, Boiler Power Water, Single Crystal Semiconductor, Integrated Circuit Fast, Picture Tube Manufacturing Process Water Ultra Pure Water')}}</p>
        </li>
        <li class="itemOfApp">
          <p>D.{{$t('Food and beverage industry')}}</p>
          <p>{{$t('Drinking water, materials, low blending water, pure draft beer filtration, juice concentration, protein recovery, kelp extraction mannitol')}}</p>
        </li>
        <li class="itemOfApp">
          <p>E.{{$t('Sewage treatment industry')}}</p>
          <p>{{$t('Recycling of Wastewater from Municipal Wastewater, Chemical Industry and Food Industry')}}</p>
        </li>
      </ul>
    </Col>
    
  </row>
</template>

<script>
export default {
  name: 'applicationOfIndex',
  data () {
    return {}
  },
  methods: {},
  computed: {},
  components: {}
}
</script>

<style scoped lang="less">
  @media screen and (max-width: 600px) {
    .mainTitle-en, .mainTitle-cn{
      padding-left: 0px!important;
    }
  }
  .mainTitle-en, .mainTitle-cn {
    color: #ffffff;
    padding-left: 50px;
    display: inline-block;
  }

  .listOfApp {
    padding: 0 5px;
    .itemOfApp {
      letter-spacing: .1em;
      padding-bottom: 15px;
      padding-left: 100px;
      p {
        line-height: 2em;
        padding: 10px 0 0 0;
      }
      p:first-child {
        font-size: 20px;
        font-weight: bold;
        color: #3965cd;
        text-shadow: 0em 0em 0.2em #fff;
      }
      p:last-child {
        color: #ffffff;
      }
    }
    .itemOfApp:nth-child(1){
      padding-left: 1%;
    }
    .itemOfApp:nth-child(2){
      padding-left:4%;
    }
    .itemOfApp:nth-child(3){
      padding-left: 7%;
    }
    .itemOfApp:nth-child(4){
      padding-left: 11%;
    }
    .itemOfApp:nth-child(5){
      padding-left: 15%;
    }
  }
</style>
