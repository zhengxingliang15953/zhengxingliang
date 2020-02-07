<template>
  <div id="index">

    <!--登录弹窗-->
    <Modal v-model="modal1" width="400">
        <p slot="header" style="color:#4876FF;text-align:center">
            <span>欢迎登录湖州师范学院图书馆</span>
        </p>
        <div >
            <Form :model="formItem" :label-width="38">
              <FormItem label="账号">
                <Input v-model="formItem.account" placeholder="请输入你的账号"></Input>
              </FormItem>
              <FormItem label="密码">
                <Input v-model="formItem.pwd" placeholder="请输入你的密码" type="password"></Input>
              </FormItem>
            </Form>
        </div>
        <div slot="footer">
            <Button type="primary" size="large" long >登录</Button>
        </div>
    </Modal>
    <!--登录弹窗-->

     <!--header-->
    <el-menu
      default-active="/index"
      class="el-menu-demo"
      mode="horizontal"
      text-color="black"
      active-text-color="white"
    >
      <img src="../../assets/logo.png" height="60px" alt style="float:left;" />
      <el-menu-item index="4" class="logoItem">关于湖图</el-menu-item>
      <el-menu-item index="3" class="logoItem">湖师官网</el-menu-item>
      <el-menu-item index="2" class="logoItem">网上借阅</el-menu-item>
      <el-menu-item index="1" class="logoItem" >首页</el-menu-item>
    </el-menu>
    <!--header-->

    <div class="lendBack">
      <Row type="flex" justify="center" class="lendItem">
        <Col :lg="16">
          <ul>
            <li>馆藏目录</li>
            <li>电子图书</li>
          </ul>
          <div style="height:240px;">
<el-input placeholder="请输入内容" class="input-with-select">
    <el-select  slot="prepend" placeholder="请选择" v-model="select" style="width:100px;">
      <el-option label="题名" value="1"></el-option>
      <el-option label="著者" value="2"></el-option>
      <el-option label="ISSN" value="3"></el-option>
    </el-select>
    <el-button slot="append" icon="el-icon-search" @click="toLend" style="background-color:orange;color:white"></el-button>
  </el-input>
          <p style="color:white;font-size:15px;margin-left:80px;margin-top:2px;">说明:查找馆藏的纸质图书</p>
          </div>
        </Col>
          


        
        <Col :lg="8" class="three">
          <Row type="flex" justify="center">
            <Col :lg="8" >
              <img src="../../assets/six1.png" alt="" width="70%" @click="loginBtn">
              <p>登录</p>
            </Col>
            <Col :lg="8">
              <img src="../../assets/six2.png" alt="" width="70%" @click="openTimeBtn">
              <p>开放时间</p>
            </Col>
            <Col :lg="8">
              <img src="../../assets/six3.png" alt="" width="70%" @click="messageBtn">
              <p>我要留言</p>
            </Col>
            <Col :lg="8">
              <img src="../../assets/six3.png" alt="" width="70%">
              <p>我要留言</p>
            </Col>
            <Col :lg="8">
              <img src="../../assets/six5.png" alt="" width="70%" @click="hutuBtn">
              <p>关于湖图</p>
            </Col>
            <Col :lg="8">
              <a href="http://www.zjhu.edu.cn" target="_blank" >
                <img src="../../assets/six6.png" alt="" width="70%">
              <p>湖师官网</p>
              </a>
            </Col>
          </Row>
        </Col>
      </Row>
    </div>

    <Row id="sixImg" type="flex" justify="center">
      <Col :lg="3"></Col>
      <Col :lg="6" class="sixImgItem">
        <img src="../../assets/library1.jpg" alt width="90%" />
      </Col>
      <Col :lg="6" class="sixImgItem">
        <img src="../../assets/library1.jpg" alt width="90%" />
      </Col>
      <Col :lg="6" class="sixImgItem">
        <img src="../../assets/library1.jpg" alt width="90%" />
      </Col>
      <Col :lg="3"></Col>
    </Row>

    <Row type="flex" justify="center" style="margin-top:2%;">
      <Col :lg="3"></Col>
      <Col :lg="11">
        <Row type="flex" justify="center">
          <Col :lg="6">
            <Menu mode="vertical" :active-name="name" width="100%" class="left" @on-select="selectName">
            <MenuItem name="1">
              <Icon type="ios-paper" />
              资源导航
            </MenuItem>
            <MenuItem name="2">
              <Icon type="ios-paper" />
              热门新书
            </MenuItem>
         </Menu>  
          </Col>
          <Col :lg="18" class="resource" v-if="this.name=='1'">
            <ul class="left">
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="http://www.ireadweek.com/index.php/Index/index.html" target="_blank">周读</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
            </ul>

            <ul class="left">
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="http://www.ireadweek.com/index.php/Index/index.html" target="_blank">周读</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
              <li><a href="https://www.jiumodiary.com/" target="_blank">摩鸠搜书</a></li>
            </ul>
          </Col>

          <Col :lg="18" class="resource" v-if="this.name=='2'">
          fds
          </Col>
        </Row>  
      </Col>

      <Col :lg="7">
        <Tabs type="card">
          <TabPane label="通知公告">
            <!--通知公告-->
            <List>
              <ListItem>
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  title="春节闭关通知"
                  description="This is description, this is description."
                />
              </ListItem>
              <ListItem>
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  title="新型冠状"
                  description="This is description, this is description."
                />
              </ListItem>
            </List>
            <!--通知公告-->
          </TabPane>
          <TabPane label="读者留言">
            <!--读者留言-->
            <List>
              <ListItem>
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  title="2018284129留言:"
                  description="太好看了"
                />
              </ListItem>
              <ListItem>
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  title="2018284129留言:"
                  description="This is description, this is description."
                />
              </ListItem>
            </List>
            <!--读者留言-->
          </TabPane>
        </Tabs>
      </Col>
      <Col :lg="3"></Col>
    </Row>
    <hr style="width:75%;margin:0 auto;"></hr>
    <Row type="flex">
    <Col :lg="3"></Col>
      <h2>友情链接</h2>
      <el-link type="primary" href="http://lib.tsinghua.edu.cn/about/branch.html" target="_blank" class="friendly">清华大学图书馆</el-link>
      <el-link type="primary" href="http://www.library.fudan.edu.cn" target="_blank" class="friendly">复旦大学图书馆</el-link>
      <el-link type="primary" href="http://libweb.zju.edu.cn" target="_blank" class="friendly">浙江大学图书馆</el-link>
      <el-link type="primary" href="https://www.lib.tongji.edu.cn" target="_blank" class="friendly">同济大学图书馆</el-link>
      <el-link type="primary" href="http://lib.imu.edu.cn" target="_blank" class="friendly">内蒙古大学图书馆</el-link>
      <el-link type="primary" href="http://library.nudt.edu.cn" target="_blank" class="friendly">国防科技大学图书馆</el-link>
    
    <Col :lg="3"></Col>
    </Row>

    <p class="footer">湖ICP备20182841 湖州师范学院图书馆</p>
  </div>
</template>

<script> 
export default {
  name: "index",
  data() {
    return {
      split1:0.5,
      name:'1',//资源导航/热门新书
      modal1:false,//登录弹窗控制
      formItem:{//账号密码
        account:'',
        pwd:''
      },
      select:'',
    };
  },
  methods: {
    selectName(value){
      this.name=value;
    },
    loginBtn(){
      this.modal1=true;
    },
    openTimeBtn(){//开放时间跳转
      this.$router.push('/header/opentime');
    },
    hutuBtn(){//关于湖图跳转
      this.$router.push('/header/hutu');
    },
    messageBtn(){//我要留言跳转
      this.$router.push('/header/readMessage');
    },
    toLend(){//检索跳转
      this.$router.push('/lend');
    }
  }
};
</script>

<style scoped  lang="less">
#sixImg {
  img {
    transition: all 0.5s;
  }
  .sixImgItem {
    overflow: hidden;
  }
}
#sixImg img:hover {
  transform: scale(1.3);
}
.logoItem {
  float: right;
}
.left{
  display: inline-block;
}
.resource{
  padding: 3%;
  ul{
    width: 42%;
    li{
      a{
        font-size: 15px;
        color: #4F4F4F;
      }
    }
  }
}
.friendly{
  margin-left:15px;
}

.lendBack{
        height: 430px;
        margin-top:30px;
        margin-bottom:30px;
        padding-top:65px;
        background: url('../../assets/lendback.jpg') no-repeat;
        background-size:100%; 
        .lendItem{
          width:75%;
          height: 300px;
          margin:auto;
          background: #363636;
          opacity: 0.7;
          ul{
            list-style: none;
            height: 60px;
            background-color: #104E8B;
            li{
              float: left;
              color: white;
              font-size: 20px;
              line-height: 60px;
              width: 100px;
              text-align: center;
            }
          }
        }
    }
    .three{
      background-color:#E8E8E8;
      padding-left:3px;
      padding-top:20px;
      p{
        text-align: center;
        font-size: 15px;
        color:black;
      }
      img{
        margin-left:13%;
        transition: 0.2s all;
      }
      img:hover{
        cursor: pointer;
        transform: scale(0.9);
      }
    }
</style>