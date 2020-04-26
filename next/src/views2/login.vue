<template>
  <div id="login">
    <h1>下一站管理系统</h1>
    <Form ref="formCustom" :model="formCustom" :rules="ruleCustom" style="width:300px;margin:15px auto;">
      <FormItem label="账号" prop="Username">
        <Input v-model="formCustom.Username" placeholder="请输入管理员账号" ></Input>
      </FormItem>
      <FormItem label="密码" prop="Password">
        <Input type="password" v-model="formCustom.Password" placeholder="请输入管理员密码"></Input>
      </FormItem>
      <FormItem>
        <Button type="primary" long @click="loginBtn">登录</Button>
      </FormItem>
    </Form>
    <p>Copyright © 2019.盘古技术支持</p>
  </div>
</template>

<script>
import {getLogin} from '../api';
export default {
  name: "login",
  data() {
    return {
      formCustom: {
        Username: "cjadmin",
        Password: "admin123456"
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
      callBack();
    },
    loginBtn(){//登录
      if(this.formCustom.username==''||this.formCustom.password==''){
        this.$Message.error('账号密码不能为空');
      }else{
        getLogin(this.formCustom).then(data=>{
          let TOKEN=data.data.data;
          if(TOKEN!=null){
            window.sessionStorage.setItem('token',TOKEN);
            this.$Message.success('登录成功');
            this.$router.push('/index');
          }else{
            this.$Message.error('账号或密码错误');
          }
        })
      }
    }
  },
  created(){
    window.sessionStorage.removeItem('select');
    window.sessionStorage.removeItem('token');
  }
};
</script>

<style lang="less" scoped>
#login {
  height: 100%;
  background:url('../assets/img/loginBack.jpg') no-repeat;
  background-size: 100%;
  padding-top: 8%;
  h1 {
    color: rgb(0, 0, 0);
    font-size: 35px;
    text-align: center;
    font-family: 'loginText';
  }
}
p{
  position: absolute;
  width: 100%;
  bottom: 40px;
  text-align: center;
  font-size: 15px;
  color:#9C9C9C;
}
</style>