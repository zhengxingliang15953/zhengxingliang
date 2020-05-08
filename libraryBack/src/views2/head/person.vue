<template>
  <div id="person">
    <!--添加管理员账号弹出-->
    <Modal v-model="modal1" title="添加管理员账号" @on-ok="ok">
      <Form :model="formItem" :label-width="40">
        <FormItem label="账号">
          <Input v-model="formItem.account" placeholder="请输入管理员账号"></Input>
        </FormItem>
        <FormItem label="密码">
          <Input v-model="formItem.pwd" placeholder="请输入密码" type="password"></Input>
        </FormItem>
        <FormItem label="密码">
          <Input v-model="pwd2" placeholder="请再次输入密码" type="password"></Input>
        </FormItem>
        <FormItem label="角色">
          <Select v-model="formItem.role">
            <Option value="普通管理员">普通管理员</Option>
            <Option value="超级管理员">超级管理员</Option>
          </Select>
        </FormItem>
      </Form>
    </Modal>
    <!--添加管理员账号弹出-->
    <Row type="flex" style="width:95%;margin:0 auto;">
      <Col :lg="12">
        <h2>管理员列表</h2>
      </Col>

      <Col :lg="12">
        <h2>设置</h2>
      </Col>
      <Col :lg="12">
        <Scroll :height="cliHeight" style="color:black;">
          <Card
            dis-hover
            v-for="(item, index) in userList"
            :key="index"
            :class="{account1:item.type==1,account2:item.type==2}"
          >
            <Row type="flex">
              <Col :lg="6">{{item.account}}</Col>
              <Col :lg="6">{{item.status | identity}}</Col>
              <Col :lg="4"></Col>
              <Col :lg="4">
                <el-button type="warning" v-if="item.type==1" @click="accountFreeze(item)">冻结</el-button>
                <el-button v-if="item.type==2" @click="saveAccount(item)">解冻</el-button>
              </Col>
              <Col :lg="4">
                <el-button type="danger" icon="el-icon-close" @click="deleteAccount(item.account)"></el-button>
                <i
                  class="el-icon-user"
                  v-if="item.account==indexAccount.account"
                  style="margin-left:10px;"
                ></i>
              </Col>
            </Row>
          </Card>
        </Scroll>
      </Col>
      <Col :lg="12">
        <span class="accountInfo">管理员账号:{{indexAccount.account}}</span>
        <span style=";color:#4876FF;" class="accountInfo" @click="addAccount" id="addAccount">添加管理员</span>
        <br></br>
        <Form :model="formPwd" :label-width="50" style="width:70%;margin:50px auto;">
          <FormItem label="新密码">
            <Input v-model="formPwd.pwd1" placeholder="请输入密码" type="password"></Input>
          </FormItem>
          <FormItem label="新密码">
            <Input v-model="formPwd.pwd2" placeholder="请再次输入密码" type="password"></Input>
          </FormItem>
          <Button type="primary" long @click="changePwd">修改密码</Button>
          </FormItem>
          <FormItem label="骑手">
              <el-switch
                v-model="rider"
                active-color="#13ce66"
                inactive-color="#ff4949"
                @change="riderChange">
              </el-switch>
              <Tooltip content="如无需骑手,可在此关闭,读者将无法选择’送书上门‘服务" max-width="200">
        <Icon type="md-alert" size="24"/>
    </Tooltip>
          </FormItem>
        </Form>
      </Col>
    </Row>
  </div>
</template>

<script>
import {
  getIndexAccount,
  getAddAccount,
  getUpdateAccountPwd,
  getAllAccount,
  getUpdateType,
  getDeleteAccount,
  getRiderConfig,
  getAllConfig
} from "../../api";
export default {
  name: "index",
  data() {
    return {
      indexAccount: {}, //当前登陆信息
      modal1: false,
      formItem: {
        //添加的账号
        account: "",
        pwd: "",
        role: ""
      },
      pwd2: "",
      formPwd: {
        //修改密码
        pwd1: "",
        pwd2: ""
      },
      userList: [] ,//管理员列表
      rider:true,//骑手开关
    };
  },
  created() {
    getIndexAccount().then(data => {
      this.indexAccount = data.data;
    });
    getAllAccount().then(data => {
      this.userList = data.data;
    });
    getAllConfig().then(data=>{
      this.rider=data.data.riderSwitch=='1'?true:false;
    })
  },
  methods: {
    ok() {
      //添加账号
      if (this.formItem.account == "" || this.formItem.pwd == "") {
        this.$message.warning("不能为空");
      } else if (this.formItem.pwd != this.pwd2) {
        this.$message.warning("密码不一致");
      } else {
        getAddAccount(this.formItem).then(data => {
          if (data.data.msg == "添加成功") {
            this.$message.success("添加成功");
            getAllAccount().then(data => {
              this.userList = data.data;
            });
          } else {
            this.$message.error("该账号已存在");
          }
        });
      }
    },
    addAccount() {
      //添加账号弹窗
      if (this.indexAccount.status != "1") {
        this.$message.warning("您没有该权限");
      } else {
        this.modal1 = true;
      }
    },
    changePwd() {
      //修改密码
      if (this.formPwd.pwd1 == "" || this.formPwd.pwd2 == "") {
        this.$message.warning("不能为空");
      } else if (this.formPwd.pwd1 != this.formPwd.pwd2) {
        this.$message.warning("密码不一致");
      } else {
        getUpdateAccountPwd({
          account: this.indexAccount.account,
          pwd: this.formPwd.pwd1
        }).then(() => {
          this.$message.success("修改成功");
          this.formPwd.pwd1 = "";
          this.formPwd.pwd2 = "";
          this.$router.push('/');
        });
      }
    },
    accountFreeze(value) {
      //冻结账号
      if (this.indexAccount.status != "1") {
        this.$message.warning("你没有该权限");
      } else {
        getUpdateType(value.account, value.type).then(data => {
          this.$message.info("冻结成功");
          getAllAccount().then(data => {
            this.userList = data.data;
          });
        });
      }
    },
    saveAccount(value) {
      //解冻
      if (this.indexAccount.status != "1") {
        this.$message.warning("你没有该权限");
      } else {
        getUpdateType(value.account, value.type).then(data => {
          this.$message.info("解冻成功");
          getAllAccount().then(data => {
            this.userList = data.data;
          });
        });
      }
    },
    deleteAccount(value) {
      //删除管理员账号
      if (this.indexAccount.status != "1") {
        this.$message.warning("你没该权限");
      } else {
        this.$confirm("确认删除该通知, 是否继续?", "提示", {
          confirmButtonText: "确定",
          cancelButtonText: "取消",
          type: "warning"
        }).then(() => {
          getDeleteAccount(value).then(data => {
            this.$message.success("删除成功");
            getAllAccount().then(data => {
              this.userList = data.data;
            });
          });
        });
      }
    },
    riderChange(value){//骑手开关变化回调
      if(this.indexAccount.status!='1'){
        this.$message.warning("您没有该权限");
        this.rider=!value;
      }else{
        let a;
        this.rider=value;
        if(this.rider==true){
          a=1;
        }else{
          a=0;
        }
        getRiderConfig(a).then(()=>{
          this.$message.success('更改成功');
        })
      }
      
    }
  },
  computed: {
    cliHeight() {
      //获取屏幕高度
      return document.body.clientHeight * 0.65;
    }
  }
};
</script>

<style lang="less" scoped>
span {
  font-size: 15px;
}
#addAccount:hover {
  cursor: pointer;
}
h2 {
  text-align: center;
  height: 50px;
  line-height: 50px;
}
.account1 {
  background-color: #90ee90;
}
.account2 {
  background-color: #b5b5b5;
}
.accountInfo {
  display: inline-block;
  width: 50%;
  text-align: center;
}
</style>