<template>
  <div>
    <Row type="flex">
      <Col :lg="3">
        <Menu active-name="1" style="width:100%;" >
          <MenuItem name="1" to="/index/Rider1/Rider2">骑手列表</MenuItem>
          <MenuItem name="2" to="/index/Rider1/Rider3">骑手审批</MenuItem>
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
  data() {
    return {};
  }
};
</script>

<style lang="less" scoped>
</style>