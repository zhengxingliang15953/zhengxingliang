<template>
  <div id="index">
    <!--回到顶部-->
    <BackTop></BackTop>
    <!--回到顶部-->

    <!--登录弹窗-->
    <Modal v-model="modal1" width="400">
      <p slot="header" style="color:#4876FF;text-align:center">
        <span>欢迎登录湖州师范学院图书馆</span>
      </p>
      <div>
        <Form :model="formItem" :label-width="38" :rules="ruleModel">
          <FormItem label="学号" prop="sno">
            <Input v-model="formItem.sno" placeholder="请输入您的学号"></Input>
          </FormItem>
          <FormItem label="密码" prop="pwd">
            <Input v-model="formItem.pwd" placeholder="默认密码为您身份证后6位" type="password"></Input>
          </FormItem>
        </Form>
      </div>
      <div slot="footer">
        <Button type="primary" size="large" long @click="studentLogin">登录</Button>
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
    </el-menu>
    <!--header-->

    <!--搜索区-->
    <div class="lendBack">
      <Row type="flex" justify="center" class="lendItem">
        <Col :lg="16">
          <ul>
            <li @click="toLend2">馆藏目录</li>
          </ul>
          <div style="100%;">
            <el-input
              placeholder="请输入检索内容"
              class="input-with-select"
              v-model="searchItem"
              type="text"
            >
              <el-select slot="prepend" placeholder="请选择" v-model="select" style="width:100px;">
                <el-option label="题名(精)" value="1"></el-option>
                <el-option label="题名(糊)" value="2"></el-option>
                <el-option label="著者" value="3"></el-option>
                <el-option label="ISBN" value="4"></el-option>
              </el-select>
              <el-button
                slot="append"
                icon="el-icon-search"
                @click="toLend"
                style="background-color:orange;color:white"
              ></el-button>
            </el-input>
            <p style="color:white;font-size:15px;margin-left:80px;margin-top:2px;">说明:查找馆藏的纸质图书</p>
          </div>
        </Col>

        <Col :lg="8" class="three">
          <Row type="flex" justify="center">
            <Col :lg="8" v-if="this.isToken=='1'">
              <img src="../../assets/six1.png" alt width="70%" @click="loginBtn" />
              <p>登录</p>
            </Col>
            <Col :lg="8" v-if="this.isToken=='2'">
              <img src="../../assets/six1.png" alt width="70%" @click="personBtn" />
              <p>个人中心</p>
            </Col>
            <Col :lg="8">
              <img src="../../assets/six2.png" alt width="70%" @click="openTimeBtn" />
              <p>开放时间</p>
            </Col>
            <Col :lg="8">
              <img src="../../assets/editor.png" alt width="70%" @click="messageBtn" />
              <p>我要留言</p>
            </Col>
            <Col :lg="8">
              <img src="../../assets/six3.png" alt width="70%" @click="noticeBtn"/>
              <p>通知公告</p>
            </Col>
            <Col :lg="8">
              <img src="../../assets/six5.png" alt width="70%" @click="hutuBtn" />
              <p>关于湖图</p>
            </Col>
            <Col :lg="8">
              <a href="http://www.zjhu.edu.cn" target="_blank">
                <img src="../../assets/six6.png" alt width="70%" />
                <p>湖师官网</p>
              </a>
            </Col>
          </Row>
        </Col>
      </Row>
    </div>
    <!--搜索区-->
    <p
      style="font-size:40px;width:220px;text-align:center;margin:0 auto;border-bottom:3px solid orange;margin-bottom:20px;color:#4876FF;font-family:library;"
    >馆园风光</p>
    <Row id="sixImg" type="flex" justify="center">
      <Col :lg="3"></Col>
      <Col :lg="6" class="sixImgItem">
        <img src="../../assets/library1.jpg" alt width="90%" />
      </Col>
      <Col :lg="6" class="sixImgItem">
        <img src="../../assets/library2.jpg" alt width="90%" />
      </Col>
      <Col :lg="6" class="sixImgItem">
        <img src="../../assets/library3.jpg" alt width="109%" />
      </Col>
      <Col :lg="3"></Col>
    </Row>

    <p
      style="font-size:40px;width:220px;text-align:center;margin:30px auto;border-bottom:3px solid orange;margin-bottom:20px;color:#4876FF;font-family:library;"
    >共享平台</p>
    <Row type="flex" justify="center" style="margin-top:2%;">
      <Col :lg="3"></Col>
      <Col :lg="11" >
        <Row type="flex" justify="center">
          <Col :lg="6">
            <Menu
              mode="vertical"
              :active-name="name"
              width="100%"
              class="left"
              @on-select="selectName"
            >
              <MenuItem name="1" >
                <Icon type="ios-paper" />资源导航
              </MenuItem>
              <MenuItem name="2">
                <Icon type="ios-paper" />热门新书
              </MenuItem>
            </Menu>
          </Col>
          <Col :lg="18" class="resource" v-if="this.name=='1'">
            <ul class="left">
              <li v-for="(item,index) in resourceList1" :key="index">
                <el-link type="success" :href="item.resourceUrl" target="_blank">{{item.title}}</el-link>
              </li>
            </ul>

            <ul class="left">
              <li v-for="(item,index) in resourceList2" :key="index">
              <el-link type="success" :href="item.resourceUrl" target="_blank">{{item.title}}</el-link>
              </li>
            </ul>
          </Col>

          <Col :lg="18" class="resource" v-if="this.name=='2'">
            <Row type="flex">
              <Col id="newBookItem" :lg="8" v-for="(item,index) in bookList" :key="index" style="margin-bottom:15px;">
                <img :src="item.bookUrl" @mouseover="newBookOver(item)" alt="加载错误" height="110px" width="100%">
              </Col>
              <Col :lg="24" style="padding-top:20px">
                <p style="text-align:center;font-size:25px;font-family:library;color:red;">{{newBookName}}</p>
              </Col>
            </Row>
          </Col>
        </Row>
      </Col>

      <Col :lg="7">
        <el-link id="more" type="danger" @click="moreResource">更多</el-link>
        <Tabs type="card">
          <TabPane label="通知公告">
            <!--通知公告-->
            <List>
              <ListItem v-for="(item,index) in noticeList" :key="index">
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  :title="item.title"
                  :description="item.message.slice(0,20)"
                />
              </ListItem>
            </List>
            <!--通知公告-->
          </TabPane>
          <TabPane label="读者留言">
            <!--读者留言-->
            <List>
              <ListItem v-for="(item,index) in readMessageList" :key="index">
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  :title="item.sno"
                  :description="item.message"
                />
              </ListItem>
            </List>
            <!--读者留言-->
          </TabPane>
        </Tabs>
      </Col>
      <Col :lg="3"></Col>
    </Row>
    <hr style="width:75%;margin:0 auto;" />
    <Row type="flex">
      <Col :lg="3"></Col>
      <h2>友情链接</h2>
      <el-link
        type="primary"
        href="http://lib.tsinghua.edu.cn/about/branch.html"
        target="_blank"
        class="friendly"
      >清华大学图书馆</el-link>
      <el-link
        type="primary"
        href="http://lib.zzu.edu.cn/"
        target="_blank"
        class="friendly"
      >郑州大学图书馆</el-link>
      <el-link
        type="primary"
        href="http://libweb.zju.edu.cn"
        target="_blank"
        class="friendly"
      >浙江大学图书馆</el-link>
      <el-link
        type="primary"
        href="https://www.lib.tongji.edu.cn"
        target="_blank"
        class="friendly"
      >同济大学图书馆</el-link>
      <el-link type="primary" href="http://lib.imu.edu.cn" target="_blank" class="friendly">内蒙古大学图书馆</el-link>
      <el-link
        type="primary"
        href="http://library.nudt.edu.cn"
        target="_blank"
        class="friendly"
      >国防科技大学图书馆</el-link>

      <Col :lg="3"></Col>
    </Row>

    <p class="footer">湖ICP备2018284129 湖州师范学院图书馆</p>
  </div>
</template>

<script>
import {
  getStudentLogin,
  getAllNotice,
  getAllReadMessage,
  getAllResource,
  getAllBook
} from "../../api";
export default {
  name: "index",
  data() {
    return {
      split1: 0.5,
      name: "1", //资源导航/热门新书
      modal1: false, //登录弹窗控制
      formItem: {
        //账号密码
        sno: "",
        pwd: ""
      },
      select: "1", //四选一
      searchItem: "", //检索内容
      noticeList: [], //通知公告
      readMessageList: [], //读者列表
      resourceList1: [], //资源导航列表1
      resourceList2: [] ,//资源导航列表2
      ruleModel:{//表单验证
        sno:[
          {validator:this.snoRule,trigger:'blur'}
        ],
        pwd:[
          {validator:this.pwdRule,trigger:'blur'},
        ]
      },
      bookList:[],//热门新书列表
      newBookName:'',//热门新书悬停显示
    };
  },
  created() {
    getAllNotice(1).then(data => {
        if (data.data[0].noticeId == "0") {
          this.noticeList = [];
        } else {
          this.noticeList = data.data.slice(0,5);
        }
      });
    getAllReadMessage(1).then(data => {
        if (data.data[0].readId == "0") {
          this.readMessageList = [];
        } else {
          this.readMessageList = data.data.slice(0,5);
        }
      });
    getAllResource(1).then(data => {
      this.resourceList1 = data.data.slice(0, 15);
    });
    getAllResource(2).then(data => {
      this.resourceList2 = data.data.slice(0, 15);
    });
    getAllBook("", 1).then(data => {
      if (data.data[0].msg == "0") {
        this.bookList = [];
      } else {
        this.bookList = data.data.slice(0,6);
      }
    });
  },
  methods: {
    selectName(value) {
      this.name = value;
    },
    loginBtn() {
      //登录弹窗
      this.modal1 = true;
    },
    openTimeBtn() {
      //开放时间跳转
      this.$router.push("/header/opentime");
      window.sessionStorage.setItem('index',2);
    },
    hutuBtn() {
      //关于湖图跳转
      this.$router.push("/header/hutu");
      window.sessionStorage.setItem('index',1);
    },
    messageBtn() {
      //我要留言跳转
      this.$router.push("/header/readMessage");
      window.sessionStorage.setItem('index',4);
    },
    noticeBtn(){//通知公告跳转
      this.$router.push('/header/notice');
      window.sessionStorage.setItem('index',3);
    },
    toLend() {
      //检索跳转
      this.$router.push({
        path: "/lend",
        query: { select: this.select, searchItem: this.searchItem }
      });
    },
    toLend2(){
        this.$router.push('/lend');
    },
    personBtn() {//个人中心
      this.$router.push("/header/person");
      window.sessionStorage.setItem('index',6);
    },
    studentLogin() {
      //登录
      getStudentLogin(this.formItem).then(data => {
        if (data.data.msg != "0") {
          window.sessionStorage.setItem("token", data.data.msg);
          location.reload();
          this.$message.success("登录成功");
        } else {
          this.$message.warning("账号获密码错误");
        }
      });
      this.modal1 = false;
    },
    moreResource() {
      //更多
      this.$router.push("/header/notice");
      window.sessionStorage.setItem('index',3);
    },
    snoRule(rule,value,callback){//学号表单验证
      if(value==''){
        callback(new Error('学号不能为空'));
      }
      callback();
    },
    pwdRule(rule,value,callback){//密码表单验证
      if(value==''){
        callback(new Error('密码不能为空'));
      }
      callback();
    },
    newBookOver(value){
      this.newBookName=value.bookName;
    }
  },
  computed: {
    isToken() {
      if (window.sessionStorage.getItem("token")) {
        return "2";
      } else {
        return "1";
      }
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
.left {
  display: inline-block;
}
.resource {
  padding: 3%;
  ul {
    width: 42%;
    li {
      a {
        font-size: 15px;
        color: #4f4f4f;
      }
    }
  }
}
.friendly {
  margin-left: 15px;
}

.lendBack {
  position: relative;
  height: 430px;
  margin-top: 30px;
  margin-bottom: 30px;
  background: url("../../assets/lendback.jpg") no-repeat;
  background-size: 100%;
  .lendItem {
    position: absolute;
    top:0;
    bottom:0;
    left:0;
    right: 0;
    width: 75%;
    height:72%;
    margin: auto;
    background: #363636;
    opacity: 0.7;
    ul {
      list-style: none;
      height: 60px;
      background-color: #104e8b;
      li:hover{
        background: #DCDCDC;
        color:black;
        cursor: pointer;
      }
      li {
        float: left;
        color: white;
        font-size: 20px;
        line-height: 60px;
        width: 100px;
        text-align: center;
        transition: all 1s;
      }
    }
  }
}
.three {
  background-color: #e8e8e8;
  padding-left: 3px;
  padding-top: 20px;
  p {
    text-align: center;
    font-size: 15px;
    color: black;
  }
  img {
    margin-left: 13%;
    transition: 0.2s all;
  }
  img:hover {
    cursor: pointer;
    transform: scale(0.9);
  }
}
#more:hover {
  cursor: pointer;
}
#more {
  float: right;
}
#newBookItem{
  img{
    transition: all 1s;
  }
}
#newBookItem img:hover{
  box-shadow: 0px 0px 10px green;
}
</style>