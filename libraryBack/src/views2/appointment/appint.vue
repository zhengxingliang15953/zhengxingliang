<template>
  <div id="appint">
    <!--head-->
    <Row type="flex" class="head">
      <Col :lg="2">
        <RadioGroup v-model="snoIsbn" @on-change="radioChange">
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
        <Input
          search
          enter-button
          placeholder="请输入学号"
          v-model="searchSnoItem"
          v-show="snoIsbn==1"
          @click="searchBtn"
        />
        <Input
          search
          enter-button
          placeholder="请输入ISBN"
          v-model="searchIsbnItem"
          v-show="snoIsbn==2"
          @click="searchBtn"
        />
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="8">
        <DatePicker
          type="date"
          multiple
          placeholder="预约时间选择"
          style="width: 300px"
          @on-change="trueTime"
          @on-clear="clearTime"
        ></DatePicker>
      </Col>
      <Col :lg="6">
        <Page :current="page" :total="sum" simple style="margin-top:3px;" @on-change="changePage" />
      </Col>
    </Row>
    <!--head-->
    <Row type="flex" style="width:97%;margin:5px auto;">
      <Col :lg="24">
        <List border v-for="(item,index) in AllAppointmentList" :key="index">
          <ListItem>
            <span>书名:{{item.bookName}}</span>
            <span>ISBN:{{item.isbn}}</span>
            <span>姓名:{{item.sno}}{{item.studentName}}</span>
            <span>预约时间:{{item.appTime}}</span>
            <span>
              <Tag color="primary" v-if="item.status==1">已预约</Tag>
              <Tag color="success" v-if="item.status==3">已借阅</Tag>
            </span>
            <el-button
              type="success"
              icon="el-icon-check"
              circle
              size="small"
              v-if="item.status==1"
              @click="brrowBook(item)"
            ></el-button>
          </ListItem>
        </List>
      </Col>
    </Row>
  </div>
</template>

<script>
import { getAllAppointment, getUpdateAppointment } from "../../api";
export default {
  name: "appoint",
  data() {
    return {
      snoIsbn: "1", //学号orISBN
      time: "", //选择时间
      page: 1, //当前页码
      sum: 0, //总数
      AllAppointmentList: [], //当前显示列表
      searchSnoItem: "", //搜索内容(sno)
      searchIsbnItem: "" //搜索内容(isbn)
    };
  },
  created() {
    getAllAppointment(
      this.searchSnoItem,
      this.searchIsbnItem,
      this.time,
      this.page
    ).then(data => {
      this.AllAppointmentList = data.data;
      this.sum = Number(this.AllAppointmentList[0].msg);
    });
  },
  methods: {
    trueTime(value) {
      //时间回调
      this.time = value;
      console.log(this.time);
    },
    clearTime() {
      //清空时间
      this.time = "";
    },
    changePage(value) {
      //页码改变回调
      this.page = value;
    },
    radioChange() {
      //单选按钮改变回调
      this.searchSnoItem = "";
      this.searchIsbnItem = "";
    },
    brrowBook(value) {
      //借阅
      getUpdateAppointment(value.appId, 3,value.isbn).then(() => {
        getAllAppointment(
          this.searchSnoItem,
          this.searchIsbnItem,
          this.time,
          this.page
        ).then(data => {
          this.AllAppointmentList = data.data;
          this.sum = Number(this.AllAppointmentList[0].msg);
          this.$Message.success("借阅成功");
        });
      });
    },
    searchBtn() {
      //搜索
      this.page=1;
      getAllAppointment(
        this.searchSnoItem,
        this.searchIsbnItem,
        this.time,
        this.page
      ).then(data => {
        this.AllAppointmentList = data.data;
        this.sum = Number(this.AllAppointmentList[0].msg);
      });
    }
  },
  computed: {}
};
</script>

<style lang="less" scoped>
.head {
  width: 97%;
  margin-left: 3%;
  margin-top: 10px;
}
span {
  display: inline-block;
  width: 18%;
}
</style>