<template>
  <div id="header" style="margin-bottom:1%;">
    <!--<row id="topNav" class="flex" :class="{show:this.scrollTag, toggleBg:this.navOpen}">
      <Col :lg="1"></Col>
      <Col span="4" :xs="24" :sm="24" :lg="5" class="box-logo">
        <img src="../../assets/img/logo.png" alt="logo">
        <div class="iconOfMobileNav">
          <img src="../../assets/img/icon-mobileNav.png" alt="mobileNav" @click="toggleNav">
        </div>
      </Col>
      <Col span="20" :xs="24" :sm="24" :lg="17" :class="{open:this.navOpen}" class="toggleMobileNav">
        <mainNav @toggle="toggleNav" class="mainNav"></mainNav>
      </Col>
      <Col :xs="24" :sm="24" :lg="1" class="flex containerOfSwitch toggleMobileNav" :class="{open:this.navOpen}">
        <switchLanguage></switchLanguage>
      </Col>
    </row>-->


    <row>
      <Col :lg="24">
        <img src="../../assets/img/logo.png" alt="logo" class="logImg">
        <switchLanguage class="switch"></switchLanguage>
        <img src="../../assets/img/icon-mobileNav.png" alt="mobileNav" @click="toggleNav"  class="imgBtn imgBtn2">
      </Col>
      <Col :lg="24" class="toggleMobileNav toggleMobileNav2" :class="{open:this.navOpen}">
          <Menu mode="horizontal" :theme="theme1" :active-name="active" style="width:100%;" >
            <MenuItem
            v-for="(item,index) in navs"
            :name="item.index"
            :to="item.path"
            @click.native="toggle(item.index)"
            >
              <p class="text">{{$t(item.title)}}</p>
          </MenuItem>
      </Menu>
      </Col>  
      <!--<Col :lg="1" class="toggleMobileNav" :class={open:this.navOpen}>
        <switchLanguage></switchLanguage>
      </Col>-->
    </row>
  

  </div>
</template>

<script>
import mainNav from '../../base/mainNav/index.vue'
import switchLanguage from '../../base/switchLanguage'

export default {
  name: 'siteHead',
  data () {
    return {
      scrollTag: false,
      navOpen: false,
      theme1: 'light',
      active: sessionStorage.getItem('index') || "1",
      navs: [
        {title: 'home', path: '/home', index: "1"},
        {title: 'aboutUs', path: '/aboutUs', index: "2"},
        {title: 'news', path: '/news', index: "3"},
        {title: 'products', path: '/products', index: "4"},
        {title: 'projectScope', path: '/projectScope', index: "5"},
        {title: 'application', path: '/application', index: "6"},
        {title: 'process', path: '/process', index: "7"},
        {title: 'humanResources', path: '/humanResources', index: "8"},
        //{title: 'waterKnowledge', path: '/waterKnowledge', index: "9"},
        {title: 'contactUs', path: '/contactUs', index: "10"}
      ],
      
    }
  },
  mounted () {
    let _this = this;
    window.onresize=function(){//监听窗口宽 
      if(document.documentElement.clientWidth > 920){
        _this.navOpen=false;
      }
    }
    window.addEventListener('scroll', function () {
      let top = document.documentElement.scrollTop;//获取滚动条位置
      if (top >= 500) {
        _this.scrollTag = true;
      } else {
        _this.scrollTag = false;
      }
    }) 
  },
  methods: {
    toggleNav () {
      this.navOpen = !this.navOpen;
    },
    toggle (index) {
      this.$emit('toggle');
      this.active = index;
      sessionStorage.setItem('index',index);
      this.toggleNav();
    }
  },
  computed: {},
  components: {
    mainNav, switchLanguage
  }
}
</script>

<style scoped>
  .show {
    background: rgba(255, 255, 255, 1) !important;
  }

  .imgBtn{
    opacity: 0;
  }
  .imgBtn2{
    width:10%;
    float:right;
  }
  .logImg{
      width:50%;margin-left:4%;
      }

  @media screen and (max-width: 1100px){
    .text{
      font-size: 60%;
    }
  }
  @media screen and (max-width: 920px){
    .imgBtn{
      opacity: 1;
    }
    
    .toggleMobileNav {
      height: 0;
      opacity: 0;
      transition: all .5s;
      
    }
    .open {
      display: flex;
      height: auto !important;
      opacity: 1 !important;
    }
    .text{
      font-size: 60%;
    }
    .logImg{/* logo自适应*/
      width:65%;margin-left:4%;
    } 
  }
  
  @media screen and (max-width: 600px) {   

  .toggleBg {
    background: #fff !important;
  }
  }

  @media screen and (max-width: 600px) {
    .toggleMobileNav {
      height: 0;
      overflow: hidden;
      opacity: 0;
      transition: all .5s;
    }
  }
  .mainNav{
    margin-left:-10%;
  }

  .switch{
    float:right;
    margin-top:1.5%;
  }
  .toggleMobileNav2{
    width:100%;
    margin-top:-4.5%;
  }
</style>
