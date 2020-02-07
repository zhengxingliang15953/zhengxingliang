<template>
  <div id="header">
    <!--header-->
    <el-menu
      default-active="/index"
      class="el-menu-demo"
      mode="horizontal"
      text-color="black"
      active-text-color="white"
      router="true"
    >
      <img src="../../assets/logo.png" height="60px" alt style="float:left;" />
      <el-menu-item index="4" class="logoItem">关于湖图</el-menu-item>
      <el-menu-item index="3" class="logoItem">湖师官网</el-menu-item>
      <el-menu-item index="/lend" class="logoItem">网上借阅</el-menu-item>
      <el-menu-item index="/index" class="logoItem" >首页</el-menu-item>
    </el-menu>
    <!--header-->

    <!--轮播图-->
    <el-carousel indicator-position="outside" >
      <el-carousel-item>
        <img src="../../assets/head.png" alt width="100%" />
      </el-carousel-item>
      <el-carousel-item>
        <img src="../../assets/head2.jpg" alt width="100%" height="98%" />
      </el-carousel-item>
    </el-carousel>
    <!--轮播图-->

    <Row type="flex" justify="center">
      <Col :lg="2"></Col>
      <Col :lg="3">
        <Menu active-name="1" theme="primary">
            <MenuItem name="1" to="/header/hutu">关于湖图</MenuItem>
            <MenuItem name="2" to="/header/opentime">开放时间</MenuItem>
            <MenuItem name="3" to="/header/notice">通知公告</MenuItem>
            <MenuItem name="4" to="/header/readMessage">读者留言</MenuItem>
            <MenuItem name="5">热门新书</MenuItem>
            <MenuItem name="6" to="/header/person">个人中心</MenuItem>
        </Menu>    
      </Col>  
      <Col :lg="17" style="padding-left:8%;">
        <router-view></router-view>
      </Col>
      <Col :lg="2"></Col>  
    </Row>
    <p class="footer">湖ICP备20182841 湖州师范学院图书馆</p>
  </div>
</template>

<script>
export default {
  name: "header",
  data() {
    return {};
  }
};
</script>

<style lang="less" scoped>
.logoItem {
  float: right;
}
</style>