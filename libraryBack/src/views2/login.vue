<template>
  <div id="login">
    <h1>湖州师范学院图书馆预约系统管理</h1>
    <Form ref="formCustom" :model="formCustom" style="width:300px;margin:10px auto;">
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
            window.sessionStorage.setItem("token", data.data.msg);
            this.$Message.success("登陆成功");
            this.$router.push("/index");
          } else {
            this.$Message.error("登陆失败");
          }
        });
      }
    }
  }
};
</script>

<style lang="less" scoped>
#login {
  height: 100%;
  background-color: #cfcfcf;
  padding-top: 8%;
  h1 {
    color: rgb(0, 0, 0);
    font-size: 30px;
    text-align: center;
  }
}
</style>