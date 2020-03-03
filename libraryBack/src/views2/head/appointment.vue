<template>
  <div id="appointment">
    <Row type="flex">
      <Col :lg="3">
        <Menu active-name="1" style="width:100%;">
          <MenuItem name="1" to="/index/appointment/appint">预约列表</MenuItem>
          <MenuItem name="2">预约预期</MenuItem>
          <MenuItem name="3" to="/index/appointment/backBook">还书列表</MenuItem>
          <MenuItem name="4" to="/index/appointment/backingBook">已还列表</MenuItem>    
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
      
    };
  }
};
</script>

<style lang="less" scoped>

</style>