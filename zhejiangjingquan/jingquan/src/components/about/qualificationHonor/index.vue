<template>
  <div>
    <h2 class="titleOfAbout">{{$t('honor')}}</h2>
    <div class="text-default mt-5 text-img"><!--class="text-default mt-5"-->
      <div v-html="info.body"></div>
    </div>
  </div>
</template>

<script>
import {getaboutdel} from '../../../api'
export default {
  name: 'qualificationHonor',
  created () {
    this.getaboutmsg(8, this.$i18n.locale)
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
  .text-img{
    margin-left:2%;
  }
</style>

<!--<template>-->
    <!--<div>-->
      <!--<h2 class="titleOfAbout">{{$t('honor')}}</h2>-->
      <!--<div class="listOfHonor mt-5">-->
        <!--<div class="itemOfHonor">-->
          <!--<img src="../../../assets/img/img-honor-01.jpg" alt="">-->
          <!--<p>营业执照</p>-->
        <!--</div>-->
        <!--<div class="itemOfHonor">-->
          <!--<img src="../../../assets/img/img-honor-01.jpg" alt="">-->
          <!--<p>营业执照</p>-->
        <!--</div>-->
        <!--<div class="itemOfHonor">-->
          <!--<img src="../../../assets/img/img-honor-01.jpg" alt="">-->
          <!--<p>营业执照</p>-->
        <!--</div>-->
        <!--<div class="itemOfHonor">-->
          <!--<img src="../../../assets/img/img-honor-01.jpg" alt="">-->
          <!--<p>营业执照</p>-->
        <!--</div>-->
        <!--<div class="itemOfHonor">-->
          <!--<img src="../../../assets/img/img-honor-01.jpg" alt="">-->
          <!--<p>营业执照</p>-->
        <!--</div>-->
        <!--<div class="itemOfHonor">-->
          <!--<img src="../../../assets/img/img-honor-01.jpg" alt="">-->
          <!--<p>营业执照</p>-->
        <!--</div>-->
        <!--<div class="itemOfHonor">-->
          <!--<img src="../../../assets/img/img-honor-01.jpg" alt="">-->
          <!--<p>营业执照</p>-->
        <!--</div>-->
        <!--<div class="itemOfHonor">-->
          <!--<img src="../../../assets/img/img-honor-01.jpg" alt="">-->
          <!--<p>营业执照</p>-->
        <!--</div>-->
      <!--</div>-->
    <!--</div>-->
<!--</template>-->
<!--<script>-->
<!--export default {-->
  <!--name: 'qualificationHonor',-->
  <!--data () {-->
    <!--return {}-->
  <!--},-->
  <!--methods: {},-->
  <!--computed: {},-->
  <!--components: {}-->
<!--}-->
<!--</script>-->
<!--<style scoped lang="less">-->
  <!--.listOfHonor{-->
    <!--display: flex;-->
    <!--justify-content: flex-start;-->
    <!--flex-wrap: wrap;-->
    <!--.itemOfHonor{-->
      <!--width: 24%;-->
      <!--margin-right: 10px;-->
      <!--margin-bottom: 10px;-->
      <!--img{-->
        <!--border: 1px solid #cccccc;-->
      <!--}-->
      <!--p{-->
        <!--text-align: center;-->
        <!--line-height: 2em;-->
      <!--}-->
    <!--}-->
  <!--}-->
<!--</style>-->
