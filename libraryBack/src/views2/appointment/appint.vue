<template>
  <div id="appint">
      <!--head-->
    <Row type="flex" class="head">
      <Col :lg="2">
        <RadioGroup v-model="snoIsbn">
          <Radio label="1">
            <Icon type="logo-apple"></Icon>
            <span>学号</span>
          </Radio>
          <Radio label="2">
            <Icon type="logo-android"></Icon>
            <span>ISBN</span>
          </Radio>
        </RadioGroup>
      </Col>
      <Col :lg="7">
        <Input search enter-button :placeholder="placher" />
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="8">
        预约时间
        <el-date-picker
          v-model="time"
          type="datetime"
          placeholder="选择日期时间"
          align="right"
          @blur="trueTime"
        ></el-date-picker>
      </Col>
      <Col :lg="6">
        <Page :current="page" :total="sum" simple style="margin-top:3px;"/>
      </Col>
    </Row>
    <!--head-->
    <Row type="flex" style="width:97%;margin:5px auto;">
      <Col :lg="24">
        <List border>
            <ListItem>
              <span>书名:JAVA</span>
              <span>姓名:2018284129郑兴樑</span>
              <span>预约时间:2018.02.22</span>
              <span>ISBN:1234</span>
              <Tag color="primary">已预约</Tag>
            </ListItem>
        </List>
      </Col>
    </Row>
  </div>
</template>

<script>
export default {
  name: "appoint",
  data() {
    return {
      snoIsbn: "1", //学号orISBN
      time:'',//选择时间
      page:1,//当前页码
      sum:0,//总数
    };
  },
  methods:{
      trueTime(){
          console.log(this.time.getDate());
          alert(this.time.getDate());
      }
  },
  computed: {
    placher() {
      if (this.snoIsbn == 1) {
        return "请输入学号";
      } else {
        return "请输入ISBN";
      }
    }
  }
};
</script>

<style lang="less" scoped>
.head {
  width: 97%;
  margin-left: 3%;
  margin-top: 10px;
}
span{
    display: inline-block;
    width:20%;
}
</style>