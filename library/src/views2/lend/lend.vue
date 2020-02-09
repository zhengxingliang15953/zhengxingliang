<template>
  <div id="lend">
    <div class="el-menu-demo header">
      <img src="../../assets/logo.png" height="100%" alt />
      <el-input placeholder="请输入内容" style="width:40%;margin:40px auto">
        <el-select slot="prepend" placeholder="请选择" v-model="select" style="width:100px;">
          <el-option label="题名(精确)" value="1"></el-option>
          <el-option label="著者(模糊)" value="2"></el-option>
          <el-option label="著者" value="3"></el-option>
          <el-option label="ISSN" value="4"></el-option>
        </el-select>
        <el-button slot="append" icon="el-icon-search" style="background-color:orange;color:white"></el-button>
      </el-input>
    </div>
    <br />
    <Row type="flex" justify="center">
      <Col :lg="1"></Col>
      <Col :lg="17">
        <p class="headBar">检索记录(100条)</p>
        <Row
          type="flex"
          v-for="(item,index) in 10"
          :key="index"
          style="border-top:1px solid #B5B5B5;"
        >
          <Col :lg="5">
            <img src="https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1581273643447&di=71a454e860c079159cebdc7373408c80&imgtype=0&src=http%3A%2F%2Fc23.tianyuimg.com%2Fs%2Fp%2F78%2Fd9e99fe42e0248ab987d272755334b88.jpg%3Fp600" width="90px" height="100px" alt="错误,请检查链接" />
          </Col>
          <Col :lg="19">
            <p>
              <span>JAVA开发实践</span>
              <span style="color:#8B3A3A;">
                <Poptip trigger="hover" title="馆藏位置" content="东校区图书馆1楼">馆藏副本2,已预约1,已借阅0</Poptip>
              </span>
            </p>
            <p>
              <span>作者:John</span>
              <span>索书号</span>
              <Button type="primary" @click="appointmentBtn">预约图书</Button>
            </p>
            <p>
              <span>出版社:清华大学出版社</span>
              <span>年份:2003</span>
            </p>
            <p>
              <span>
                格式:BK
                <Icon type="md-cube" />
              </span>
              <span>电子书链接</span>
            </p>
          </Col>
        </Row>
      </Col>
      <Col :lg="4" style="margin-left:10px;">
        <div style="border:1px solid  #5d8fb6;margin-bottom:10px;">
          <p class="headBar">读者信息>></p>
          <p class="headBarItem">您好!匿名用户</p>
        </div>
        <div style="border:1px solid  #5d8fb6;margin-bottom:10px">
          <p class="headBar">当前检索>></p>
          <p class="headBarItem">主题名=(计算机)</p>
        </div>
        <div style="border:1px solid  #5d8fb6;margin-bottom:10px">
          <p class="headBar">主题词>></p>
          <p class="headBarItem">计算机、、、、、、、</p>
        </div>
      </Col>
      <Col :lg="1"></Col>
    </Row>
    <p class="footer">湖ICP备20182841 湖州师范学院图书馆</p>
  </div>
</template>

<script>
export default {
  name: "lend",
  data() {
    return {
      select: ""
    };
  },
  methods: {
    appointmentBtn() {
      this.$Modal.success({
        title: '预约成功',
        content: '请前往个人中心查看预约详细信息'
      });
    }
  }
};
</script>

<style lang="less" scoped>
.header {
  display: flex;
  height: 130px;
}
span {
  display: inline-block;
  width: 40%;
  color: #483d8b;
  font-size: 14px;
}
.headBar {
  background-color: #5d8fb6;
  height: 25px;
  font-size: 14px;
  line-height: 25px;
  color: black;
  padding-left: 3px;
}
.headBarItem {
  font-size: 15px;
  padding: 2px;
}
</style>