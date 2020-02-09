<template>
  <div id="person">
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
      </Form>
    </Modal>

    <Row type="flex" justify="center" style="width:60%;margin:30px auto;">
      <Col :lg="8">
        <span>管理员账号:{{indexAccount.account}}</span>
      </Col>
      <Col :lg="8">
        <span>身份:{{indexAccount.status|identity}}</span>
      </Col>
      <Col :lg="8">
        <span style="color:#4876FF;" @click="addAccount" id="addAccount">添加管理员</span>
      </Col>
    </Row>

    <Form :model="formPwd" :label-width="50" style="width:30%;margin:50px auto;">
      <FormItem label="新密码">
        <Input v-model="formPwd.pwd1" placeholder="请输入密码" type="password"></Input>
      </FormItem>
      <FormItem label="新密码">
        <Input v-model="formPwd.pwd2" placeholder="请再次输入密码" type="password"></Input>
      </FormItem>
      <Button type="primary" long @click="changePwd">修改密码</Button>
    </Form>
  </div>
</template>

<script>
import { getIndexAccount, getAddAccount ,getUpdateAccountPwd} from "../../api";
export default {
  name: "index",
  data() {
    return {
      indexAccount: {}, //当前登陆信息
      modal1: false,
      formItem: {//添加的账号
        account: "",
        pwd: ""
      },
      pwd2: "",
      formPwd:{//修改密码
        pwd1:'',
        pwd2:'',
      }
    };
  },
  created() {
    getIndexAccount().then(data => {
      this.indexAccount = data.data;
    });
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
    changePwd(){//修改密码
      if(this.formPwd.pwd1==''||this.formPwd.pwd2==''){
        this.$message.warning('不能为空');
      }else if(this.formPwd.pwd1!=this.formPwd.pwd2){
        this.$message.warning('密码不一致');
      }else{
          getUpdateAccountPwd({account:this.indexAccount.account,pwd:this.formPwd.pwd1}).then(()=>{
            this.$message.success('修改成功');
            this.formPwd.pwd1='';
            this.formPwd.pwd2='';
          })
      }
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
</style>