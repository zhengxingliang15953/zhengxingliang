<template>
  <div id="appointmentAfter">
    <!--head-->
    <Row type="flex" class="headAppointment">
      <Col :lg="2"></Col>
      <Col :lg="7">
        <Input
          search
          enter-button
          placeholder="请输入学号"
          v-model="searchSnoItem"
          @on-search="searchBtn"
        />
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="8">
        <DatePicker
          v-model="time"
          type="date"
          confirm
          placeholder="预约时间选择"
          style="width: 300px"
          @on-ok="trueTime"
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
        <List border v-for="(item,index) in AfterList" :key="index">
          <ListItem>
            <span>书名:{{item.bookName}}</span>
            <span>ISBN:{{item.isbn}}</span>
            <span>姓名:{{item.sno}}{{item.studentName}}</span>
            <span>预约时间:{{item.appTime}}</span>
            <span>
              <Tag color="warning">预约预期</Tag>
            </span>
          </ListItem>
        </List>
      </Col>
    </Row>
  </div>
</template>

<script>
import { getAppointmentAfter } from "../../api";
import { timeChange } from "../../components/press";
export default {
  name: "appointmentAfter",
  data() {
    return {
      searchSnoItem: "", //搜索v-model
      searchSno: "",
      time: null, //时间选择器
      page: 1, //当前页码
      sum: 0, //总数
      AfterList: [] //当前显示列表
    };
  },
  created() {
    getAppointmentAfter("", "", this.page).then(data => {
      if (data.data[0].msg == 0) {
        this.AfterList = [];
        this.sum = 0;
      } else {
        this.AfterList = data.data;
        this.sum = Number(this.AfterList[0].msg);
      }
    });
  },
  methods: {
    searchBtn() {
      //搜索
      this.page = 1;
      this.time = null;
      this.searchSno = this.searchSnoItem;
      getAppointmentAfter(this.searchSno, "", this.page).then(data => {
        if (data.data[0].msg == 0) {
          this.AfterList = [];
          this.sum = 0;
        } else {
          this.AfterList = data.data;
          this.sum = Number(this.AfterList[0].msg);
        }
      });
    },
    trueTime() {
      //时间选择回调
      this.searchSnoItem = "";
      this.page = 1;
      getAppointmentAfter(
        "",
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.AfterList = [];
          this.sum = 0;
        } else {
          this.AfterList = data.data;
          this.sum = Number(this.AfterList[0].msg);
        }
      });
    },
    clearTime() {
      //清除时间
      this.time = undefined;
      this.searchSnoItem='';
      this.page=1;
      getAppointmentAfter(
        '',
        "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.AfterList = [];
          this.sum = 0;
        } else {
          this.AfterList = data.data;
          this.sum = Number(this.AfterList[0].msg);
        }
      });
    },
    changePage(value) {
      //页码改变回调
      this.page = value;
      getAppointmentAfter(
        this.searchSno,
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.AfterList = [];
          this.sum = 0;
        } else {
          this.AfterList = data.data;
          this.sum = Number(this.AfterList[0].msg);
        }
      });
    }
  }
};
</script>

<style lang="less" scoped>
span {
  display: inline-block;
  width: 18%;
}
</style>