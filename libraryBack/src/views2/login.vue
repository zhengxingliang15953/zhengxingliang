<template>
  <div id="login">
    <h1>湖州师范学院图书馆预约系统管理</h1>
    <Form ref="formCustom" :model="formCustom" :rules="ruleCustom" style="width:300px;margin:10px auto;">
      <FormItem label="账号" prop="account">
        <Input v-model="formCustom.account"></Input>
      </FormItem>
      <FormItem label="密码" prop="pwd">
        <Input type="password" v-model="formCustom.pwd"></Input>
      </FormItem>
      <FormItem>
        <Button type="primary" long @click="loginBtn">登录</Button>
      </FormItem>
    </Form>
  </div>
</template>

<script>
import { getLogin } from "../api";
export default {
  name: "login",
  data() {
    return {
      formCustom: {
        account: "",
        pwd: ""
      },
      ruleCustom:{//表单验证
        account:[
          {validator:this.ruleAccount,trigger:'blur'}
        ],
        pwd:[
          {validator:this.rulePwd,trigger:'blur'}
        ]
      }
    };
  },
  methods: {
    loginBtn() {
      if (this.formCustom.account == "" || this.formCustom.pwd == "") {
        this.$Message.error("账号密码不能为空");
      } else {
        getLogin(this.formCustom).then(data => {
          if (data.data.msg != null) {
            if (data.data.type == 2) {
              this.$Message.error("该账号被冻结");
            } else {
              window.sessionStorage.setItem("token", data.data.msg);
              this.$Message.success("登陆成功");
              this.$router.push("/index");
            }
          } else {
            this.$Message.error("登陆失败");
          }
        });
      }
    },
    ruleAccount(rule,value,callback){//账号表单验证
      if(value==''){
        callback(new Error('账号不能为空'));
      }
      callback();
    },
    rulePwd(rule,value,callBack){//密码表单验证
      if(value==''){
        callBack(new Error('密码不能为空'));
      }
    }
  },
  created(){
    window.sessionStorage.removeItem('select');
  }
};
</script>

<style lang="less" scoped>
#login {
  height: 100%;
  background:url('../assets/loginBack.jpg') no-repeat;
  background-size: 100%;
  padding-top: 8%;
  h1 {
    color: rgb(0, 0, 0);
    font-size: 30px;
    text-align: center;
  }
}
</style>