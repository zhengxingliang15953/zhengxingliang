<template>
  <div class="contactUs mt-7">
    <p>联系我们 / CONTACT US</p>
    <ul class="listOfContentUs">
      <li>
        <i><img src="../../assets/img/icon-tel-ccc.png" alt="icon-tel"></i>
        {{$t('Hotline')}}：<br>0572-3112233<br>0572-3112201<br>0572-3112202  4000572007
      </li>
      <li>
        <i><img src="../../assets/img/icon-mail-ccc.png" alt="icon-mail"></i>
        {{$t('Mailbox')}}：<br>info@jing-quan.com
      </li>
      <li>
        <i><img src="../../assets/img/icon-addr-ccc.png" alt="icon-addr"></i>
        {{$t('Address')}}：{{$t('West Side of Shijiaqiao 104 National Road, Nanmen, Huzhou City, Zhejiang Province, China')}}
      </li>
      <div class="qrcode mt-7">
        <img src="../../assets/img/qrcode.png" alt="qrcode">
        <p>{{$t('Sweep and pay attention to us')}}</p>
      </div>
    </ul>
  </div>
</template>

<script>
export default {
  name: 'contactUsInside',
  data () {
    return {}
  },
  methods: {},
  computed: {},
  components: {}
}
</script>

<style scoped>
</style>
