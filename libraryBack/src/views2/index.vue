<template>
  <div id="index">
    <Layout>
      <Sider ref="side1" hide-trigger collapsible :collapsed-width="78" v-model="isCollapsed">
        <Menu active-name="1-1" theme="dark" width="auto" :class="menuitemClasses">
          <MenuItem name="1-1" to="/index/notice">
            <Icon type="ios-navigate"></Icon>
            <span>公告管理</span>
          </MenuItem>
          <MenuItem name="1-2" to="/index/student">
            <Icon type="ios-search"></Icon>
            <span>学生管理</span>
          </MenuItem>
          <MenuItem name="1-3">
            <Icon type="ios-settings"></Icon>
            <span>图书管理</span>
          </MenuItem>
          <MenuItem name="1-4" to="/index/readMessage">
            <Icon type="ios-settings"></Icon>
            <span>留言管理</span>
          </MenuItem>
          <MenuItem name="1-5">
            <Icon type="ios-settings"></Icon>
            <span>资源管理</span>
          </MenuItem>
          <MenuItem name="1-6" to="/index/appointment">
            <Icon type="ios-settings"></Icon>
            <span>预约管理</span>
          </MenuItem>
          <MenuItem name="1-7" to="/index/person">
            <Icon type="ios-settings"></Icon>
            <span>个人中心</span>
          </MenuItem>
        </Menu>
      </Sider>
      <Layout>
        <Header :style="{padding: 0}" class="layout-header-bar">
          <Icon
            @click.native="collapsedSider"
            :class="rotateIcon"
            :style="{margin: '0 20px'}"
            type="md-menu"
            size="24"
          ></Icon>
          <Button type="primary" style="margin-right:70%;" @click="back">退出</Button><span style="font-size:0.08rem;color:#1E90FF;">超级管理员</span>
        </Header>
        <Content id="content" :style="{margin: '20px', background: '#fff',minHeight:`622px`}">
            <router-view></router-view>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>

<script>
export default {
  name: "index",
  data() {
    return {
      isCollapsed: false,
      screenHeight:''
    };
  },
  mounted() {
    let _this = this;
    window.onresize = function() {
      // 定义窗口大小变更通知事件
      _this.screenHeight = document.documentElement.clientHeight; //窗口高度
    };
  },
  computed: {
    rotateIcon() {
      return ["menu-icon", this.isCollapsed ? "rotate-icon" : ""];
    },
    menuitemClasses() {
      return ["menu-item", this.isCollapsed ? "collapsed-menu" : ""];
    }
  },
  methods: {
    collapsedSider() {
      this.$refs.side1.toggleCollapse();
    },
    back(){//退出
      this.$router.push('/');
    }
  }
};
</script>

<style lang="less" scoped>
#index {
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: hidden;
}

.layout-header-bar {
  background: #fff;
  box-shadow: 0 1px 1px rgba(0, 0, 0, 0.1);
}
.layout-logo-left {
  width: 90%;
  height: 30px;
  background: #5b6270;
  border-radius: 3px;
  margin: 15px auto;
}
.menu-icon {
  transition: all 0.3s;
}
.rotate-icon {
  transform: rotate(-90deg);
}
.menu-item span {
  display: inline-block;
  overflow: hidden;
  width: 69px;
  text-overflow: ellipsis;
  white-space: nowrap;
  vertical-align: bottom;
  transition: width 0.2s ease 0.2s;
}
.menu-item i {
  transform: translateX(0px);
  transition: font-size 0.2s ease, transform 0.2s ease;
  vertical-align: middle;
  font-size: 16px;
}
.collapsed-menu span {
  width: 0px;
  transition: width 0.2s ease;
}
.collapsed-menu i {
  transform: translateX(5px);
  transition: font-size 0.2s ease 0.2s, transform 0.2s ease 0.2s;
  vertical-align: middle;
  font-size: 22px;
}
</style>