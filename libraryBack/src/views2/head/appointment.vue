<template>
  <div id="appointment">
    <Row type="flex">
      <Col :lg="3">
        <Menu :active-name="select" style="width:100%;" @on-select="munuSelect">
          <MenuItem name="1" to="/index/appointment/appint">预约列表</MenuItem>
          <MenuItem name="2" to="/index/appointment/appointmentAfter">预约预期</MenuItem>
          <MenuItem name="3" to="/index/appointment/backBook">还书列表</MenuItem>
          <MenuItem name="4" to="/index/appointment/backingBook">已还列表</MenuItem> 
          <MenuItem name="5" to="/index/appointment/waitDesignate">待指派</MenuItem>  
          <MenuItem name="6" to="/index/appointment/ingDesignate">正在配送</MenuItem>     
        </Menu>
      </Col>
      <Col :lg="21">
        <router-view></router-view>
      </Col>
    </Row>
  </div>
</template>

<script>
export default {
  name: "appointment",
  data() {
    return {
      select:'',
    };
  },
  created(){
    this.select=window.sessionStorage.getItem('select2')||'1';
  },
  methods:{
    munuSelect(value){
      window.sessionStorage.setItem('select2',value);
    }
  },
  destroyed(){
    window.sessionStorage.removeItem('select2');
  }
};
</script>

<style lang="less" scoped>

</style>