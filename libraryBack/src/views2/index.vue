<template>
  <div id="index">
    <Layout style="height:100%;">
      <Sider ref="side1" hide-trigger collapsible :collapsed-width="78" v-model="isCollapsed">
        <Menu :active-name="select" @on-select="menuSelect" theme="dark" width="auto" :class="menuitemClasses">
          <MenuItem name="1" to="/index/book">
            <Icon type="ios-book"></Icon>
            <span>图书管理</span>
          </MenuItem>
          <MenuItem name="2" to="/index/student">
            <Icon type="md-contacts"></Icon>
            <span>学生管理</span>
          </MenuItem>
          <MenuItem name="3" to="/index/appointment">
            <Icon type="md-calculator"></Icon>
            <span>预约管理</span>
          </MenuItem>
          <MenuItem name="4" to="/index/readMessage">
            <Icon type="md-chatbubbles"></Icon>
            <span>留言管理</span>
          </MenuItem>
          <MenuItem name="5" to="/index/resource">
            <Icon type="md-briefcase"></Icon>
            <span>资源管理</span>
          </MenuItem>
          <MenuItem name="6" to="/index/notice">
            <Icon type="md-browsers"></Icon>
            <span>公告管理</span>
          </MenuItem>
          <MenuItem name="8" to="/index/Rider1">
            <Icon type="ios-car"></Icon>
            <span>骑手管理</span>
          </MenuItem>
          <MenuItem name="7" to="/index/person">
            <Icon type="md-contact"></Icon>
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
          <Button type="primary" style="margin-right:70%;" @click="back">退出</Button><span style="font-size:0.08rem;color:#1E90FF;">{{value1}}</span>
        </Header>
        <Content id="content" :style="{margin: '20px', background: '#fff'}">
            <router-view></router-view>
        </Content>
      </Layout>
    </Layout>
  </div>
</template>

<script>
import {getIndexAccount} from '../api'
export default {
  name: "index",
  data() {
    return {
      isCollapsed: false,
      screenHeight:'',
      value1:'',//超级管理员、普通管理员
      select:''
    };
  },
  created(){
    getIndexAccount().then((data)=>{
      if(data.data.status=='1'){
        this.value1='超级管理员';
      }else{
        this.value1='普通管理员';
      }
    })
    this.select=window.sessionStorage.getItem('select')||'1';
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
      window.sessionStorage.removeItem('token');
      this.$router.push('/');
    },
    menuSelect(value){//menu选择回调
      window.sessionStorage.setItem('select',value);
    }
  },
};
</script>

<style lang="less" scoped>
#index {
  border: 1px solid #d7dde4;
  background: #f5f7f9;
  position: relative;
  border-radius: 4px;
  overflow: hidden;
  height: 100%;
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