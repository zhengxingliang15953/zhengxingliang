<template>
  <div id="person">
    <!--标签-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
      <el-breadcrumb-item>个人中心</el-breadcrumb-item>
    </el-breadcrumb>
    <!--标签-->
    <br />
    <hr />
    <Button type="primary" @click="value1='1'">个人中心</Button>
    <Button type="primary" @click="myAppointment">我的预约</Button>
    <Button type="primary" @click="myReadMessageBtn">我的留言</Button>
    <Button type="primary" @click="value1='4'">预约制度</Button>
    <Button type="warning" style="float:right;" @click="back">退出登陆</Button>
    <div v-if="value1==1" class="personItem">
      <h2>个人中心</h2>
      <table
        align="center"
        border="1"
        cellpadding="0"
        cellspacing="0"
        style="width:65%;margin:4px auto;"
      >
        <tbody>
          <tr>
            <td>姓名</td>
            <td>{{indexStudent.name}}</td>
            <td>学院</td>
            <td>{{indexStudent.school}}</td>
          </tr>
          <tr>
            <td>学号</td>
            <td>{{indexStudent.sno}}</td>
            <td>专业</td>
            <td>{{indexStudent.marjor}}</td>
          </tr>
          <tr>
            <td>身份证号</td>
            <td>{{indexStudent.idCard}}</td>
            <td>学制</td>
            <td></td>
          </tr>
          <tr>
            <td>联系方式</td>
            <td>{{indexStudent.tel}}</td>
            <td>家庭住址</td>
            <td>{{indexStudent.address}}</td>
          </tr>
          <tr>
            <td>修改密码</td>
            <td>
              <Input placeholder="请输入您的新密码" style="width:100%" v-model="pwd1" type="password" />
            </td>
            <td>
              <Input placeholder="请再次输入您的新密码" style="width:100%" v-model="pwd2" type="password" />
            </td>
            <td>
              <Button type="success" style="width:100%;" @click="changePwd">修改密码</Button>
            </td>
          </tr>
        </tbody>
      </table>
    </div>

    <div v-if="value1==2" class="personItem">
      <van-notice-bar
        mode="closeable"
        text="同学你好!欢迎使用湖州师范学院图书馆借阅系统,这里是您预约的图书,请在3日之内前往指定位置向图书馆管理员借阅.如果在规定时间内没有前往借阅,系统将视为预期预约,该书会自动判定为后者预约人。本馆的图书预约周期为30天,如果还有图书需求,请在后3天续借。"
      />
      <List border id="listItem">
        <ListItem v-for="(item,index) in myAppointmentList" :key="index">
          <Poptip trigger="hover" title="预约号" :content="item.appId" style="width:10%;">
            <Button>序号:{{index+1}}</Button>
          </Poptip>
          <span>书名:{{item.tbBook.bookName}}</span>
          <span>ISBN:{{item.tbBook.isbn}}</span>
          <span>预约时间{{item.appTime}}</span>
          <Poptip trigger="hover" title="地点" :content="item.tbBook.address" style="width:10%;">
            <Button type="info">地点</Button>
          </Poptip>
          <span style="width:10%;color:green;">{{item.status|appType}}</span>
          <el-button
            size="small"
            type="success"
            icon="el-icon-delete"
            @click="deleteAppointment(item)"
            v-if="item.status==1||item.status==0"
          >取消</el-button>
          <Poptip
            confirm
            :title="item.lendingTimeNumber"
            @on-ok="lendingTime(item)"
            v-if="item.status==3"
          >
            <Button type="primary">续借</Button>
          </Poptip>
        </ListItem>

        <ListItem v-for="(item,index) in myWaitList" :key="index">
          <Poptip trigger="hover" title="预约号" :content="item.waitId" style="width:10%;">
            <Button>序号:{{index+1}}</Button>
          </Poptip>
          <span>书名:{{item.tbBook.bookName}}</span>
          <span>ISBN:{{item.tbBook.isbn}}</span>
          <span>预约时间{{item.appTime}}</span>
          <Poptip trigger="hover" title="地点" content="还在排队中" style="width:10%;">
            <Button type="info">地点</Button>
          </Poptip>
          <span style="width:10%;color:green;">{{item.status|appType}}</span>
          <el-button
            size="small"
            type="warning"
            icon="el-icon-delete"
            @click="deleteAppointment(item)"
            v-if="item.status==0||item.status==1"
          >取消</el-button>
        </ListItem>
      </List>
    </div>

    <div v-if="value1==3" class="personItem">
      <h2>我的留言</h2>
      <!--读者留言-->
      <List>
        <ListItem v-for="(item,index) in this.myReadMessage" :key="index">
          <ListItemMeta
            avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
            :title="item.sno"
            :description="item.message"
          />
        </ListItem>
      </List>
      <!--读者留言-->
    </div>

    <div v-if="value1==4" class="personItem">
      <h2>预约制度</h2>
      <p>
        <b>第一条:</b>
        <span>本馆的主要服务对象为本校师生员工。根据馆藏和借阅条件许可，对社会各界适度开放。</span>
      </p>
      <p>
        <b>第二条:</b>
        <span>读者凭学号登录图书馆预约系统来借书、阅览。账号为学号,首次登陆密码为身份证后6位,登录成功可在个人中心修改密码。</span>
      </p>
      <p>
        <b>第三条:</b>
        <span>读者有合法、公平利用图书馆用于服务的文献信息资源、设备和空间的权利；有使用图书馆提供的服务的权力；有向图书馆提出各类意见、建议的权利；对图书馆的处理有异议时，有向图书馆或学校有关部门提出申诉的权利。</span>
      </p>
    </div>
  </div>
</template>

<script>
import {
  getIndexStudent,
  getUpdatePwd,
  getOneReadMessage,
  getMyAppointment,
  getDeleteAppointment,
  getUpdateLendingTime
} from "../../api";
export default {
  name: "person",
  data() {
    return {
      value1: "1",
      indexStudent: {}, //当前登录信息
      pwd1: "", //密码1
      pwd2: "", //密码2
      myReadMessage: [], //我的留言
      myAppointmentList: [], //我的已有预约
      myWaitList: [] //等待预约
    };
  },
  created() {
    getIndexStudent().then(data => {
      this.indexStudent = data.data;
    });
  },
  methods: {
    back() {
      //退出登陆
      window.sessionStorage.removeItem("token");
      this.$router.push("/");
    },
    changePwd() {
      //修改密码
      if (this.pwd1 == "" || this.pwd2 == "") {
        this.$message.warning("密码不能为空");
      } else if (this.pwd1 != this.pwd2) {
        this.$message.warning("两次密码输入不一致");
      } else {
        getUpdatePwd({ sno: this.indexStudent.sno, pwd: this.pwd1 }).then(
          () => {
            this.$message.success("修改成功");
            this.pwd1 = "";
            this.pwd2 = "";
          }
        );
      }
    },
    myReadMessageBtn() {
      //我的留言
      this.value1 = "3";
      getOneReadMessage(this.indexStudent.sno).then(data => {
        this.myReadMessage = data.data;
      });
    },
    myAppointment() {
      //我的预约
      this.value1 = "2";
      getMyAppointment(this.indexStudent.sno).then(data => {
        console.log(data);
        if (data.data[0].msg == 0) {
          this.myAppointmentList = [];
        } else {
          this.myAppointmentList = data.data;
        }
        //if (data.data[0].tbWaitList != null) {
        this.myWaitList =data.data[0].tbWaitList || [];
        //}
      });
    },
    deleteAppointment(value) {
      //取消预约(已预约)
      this.$confirm("您确定取消该预约,该书将会自动派送给后面的预约人", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        var app;
        if (value.status == 1) {
          app = value.appId;
        } else {
          app = value.waitId;
        }
        getDeleteAppointment(app, value.status).then(data => {
          if (data.data.msg == "1") {
            this.$message.success("取消成功");
          } else {
            this.$message.error("改预约状态已改变,无法取消");
          }
          getMyAppointment(this.indexStudent.sno).then(data => {
            if (data.data[0].msg == 0) {
              this.myAppointmentList = [];
            } else {
              this.myAppointmentList = data.data;
            }
            //if (data.data[0].tbWaitList != null) {
            this.myWaitList = this.data.data[0].tbWaitList || [];
            //}
          });
        });
      });
    },
    lendingTime(value) {
      //续借
      getUpdateLendingTime(value.appId, value.isbn).then(data => {
        if (data.data.msg == "0") {
          this.$message.error("借阅状态发生改变");
        } else if (data.data.msg == "1") {
          this.$message.error("已逾期无法预约");
        } else if (data.data.msg == "2") {
          this.$messager.warning("该书后续已有人预约,无法续借");
        } else if (data.data.msg == "3") {
          this.$message.warning("后3天才能续借");
        } else {
          this.$message.success("续借成功");
        }
        getMyAppointment(this.indexStudent.sno).then(data => {
          if (data.data[0].msg == 0) {
            this.myAppointmentList = [];
          } else {
            this.myAppointmentList = data.data;
          }
          //if (data.data[0].tbWaitList != null) {
          this.myWaitList = this.data.data[0].tbWaitList || [];
          //}
        });
      });
    }
  }
};
</script>

<style lang="less" scoped>
.personItem {
  h2 {
    text-align: center;
  }
  p {
    font-size: 14px;
  }
}
tr {
  td {
    width: 25%;
    height: 30px;
    text-align: center;
  }
}
#listItem {
  span {
    font-size: 14px;
    width: 20%;
  }
}
.demo-badge {
  width: 42px;
  height: 42px;
  background: #eee;
  border-radius: 6px;
  display: inline-block;
}
</style>