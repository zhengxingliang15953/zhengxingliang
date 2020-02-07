<!--suppress ALL -->
<template>
    <Menu mode="horizontal" :theme="theme1" :active-name="active">
          <MenuItem
          v-for="(item,index) in navs"
          :name="item.index"
          :to="item.path"
          @click.native="toggle(item.index)"
        
          >
       
        {{$t(item.title)}}
      </MenuItem>
        
      
    </Menu>
</template>

<script>
export default {
  name: 'mainNav',
  data () {
    return {
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
        {title: 'waterKnowledge', path: '/waterKnowledge', index: "9"},
        {title: 'contactUs', path: '/contactUs', index: "10"}
      ]
    }
  },
  methods: {
    toggle (index) {
      this.$emit('toggle')
      this.active = index
      sessionStorage.setItem('index',index)
    }
  },
  computed: {},
  components: {}
}
</script>

<style scoped lang="less">
</style>
