<template>
  <div id="appointment">
    <Row type="flex">
      <Col :lg="3">
        <Menu active-name="1" style="width:100%;">
          <MenuItem name="1">预约列表</MenuItem>
          <MenuItem name="2">借阅列表</MenuItem>
          <MenuItem name="3">预约预期</MenuItem>
          <MenuItem name="4">借阅完成</MenuItem>
          <MenuItem name="5">还书列表</MenuItem>
          <MenuItem name="6">还书预期</MenuItem>
          <MenuItem name="7">续借审批</MenuItem>  
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