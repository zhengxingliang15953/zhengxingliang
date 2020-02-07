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
    <Button type="primary" @click="value1='2'">我的预约</Button>
    <Button type="primary" @click="value1='3'">我的留言</Button>
    <Button type="primary" @click="value1='4'">预约制度</Button>

    <div v-if="value1==1" class="personItem">
        <h2>个人中心</h2>
      <table align="center" border="1" cellpadding="0" cellspacing="0" style="width:65%;margin:4px auto;">
          <tbody>
              <tr>
                  <td>姓名</td>
                  <td>郑兴樑</td>
                  <td>学院</td>
                  <td>求真学院</td>
              </tr>
              <tr>
                  <td>学号</td>
                  <td>2018284129</td>
                  <td>专业</td>
                  <td>计算机科学与技术</td>
              </tr>
              <tr>
                  <td>身份证号</td>
                  <td></td>
                  <td>学制</td>
                  <td></td>
              </tr>
              <tr>
                  <td>联系方式</td>
                  <td>15314652021</td>
                  <td>家庭住址</td>
                  <td></td>
              </tr>
              <tr>
                  <td>修改密码</td>
                  <td><Input  placeholder="请输入您的新密码" style="width:100%" /></td>
                  <td><Input  placeholder="请再次输入您的新密码" style="width:100%" /></td>
                  <td><Button type="success" style="width:100%;">修改密码</Button></td>
              </tr>
          </tbody>
      </table>
    </div>

    <div v-if="value1==2" class="personItem">
      <h2>我的预约</h2>
    </div>

    <div v-if="value1==3" class="personItem">
      <h2>我的留言</h2>
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
export default {
  name: "person",
  data() {
    return {
      value1: "1"
    };
  },
  methods: {}
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
tr{
    td{
        width:25%;
        height: 30px;
        text-align: center;
    }
}
</style>