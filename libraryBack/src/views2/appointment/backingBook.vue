<template>
  <div id="backingBook">
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
          placeholder="归还时间选择"
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
        <List border v-for="(item,index) in backingBookList" :key="index">
          <ListItem>
            <span>书名:{{item.bookName}}</span>
            <span>ISBN:{{item.isbn}}</span>
            <span>姓名:{{item.sno}}{{item.studentName}}</span>
            <span>预约时间:{{item.appTime}}</span>
            <span>归还时间:{{item.backTime}}</span>
            <span>
              <Tag color="blue" v-if="item.status==5">已归还</Tag>
            </span>
          </ListItem>
        </List>
      </Col>
    </Row>
  </div>
</template>

<script>
import { getAllBackingBook } from "../../api";
import { timeChange } from "../../components/press";
export default {
  name: "backingBook",
  data() {
    return {
      searchSnoItem: "", //搜索内容v-model
      searchSno: "",
      time: null, //时间选择器
      page: 1, //当前页码
      sum: 0, //总数
      backingBookList: [] //当前展示列表
    };
  },
  created() {
    getAllBackingBook("", "", this.page).then(data => {
      if (data.data[0].msg == 0) {
        this.backingBookList = [];
        this.sum = 0;
      } else {
        this.backingBookList = data.data;
        this.sum = Number(this.backingBookList[0].msg);
      }
    });
  },
  methods: {
    searchBtn() {
      //搜索
      this.page = 1;
      this.time = null;
      this.searchSno = this.searchSnoItem;
      getAllBackingBook(this.searchSno, "", this.page).then(data => {
        if (data.data[0].msg == 0) {
          this.backingBookList = [];
          this.sum = 0;
        } else {
          this.backingBookList = data.data;
          this.sum = Number(this.backingBookList[0].msg);
        }
      });
    },
    trueTime() {
      //时间确认
      this.searchSnoItem = "";
      this.page = 1;
      getAllBackingBook(
        "",
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.backingBookList = [];
          this.sum = 0;
        } else {
          this.backingBookList = data.data;
          this.sum = Number(this.backingBookList[0].msg);
        }
      });
    },
    clearTime() {
      //时间清除
      this.time = undefined;
      this.searchSnoItem='';
      this.page=1;
      getAllBackingBook(
        '',
        "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.backingBookList = [];
          this.sum = 0;
        } else {
          this.backingBookList = data.data;
          this.sum = Number(this.backingBookList[0].msg);
        }
      });
    },
    changePage(value) {
      //页码改变回调
      this.page=value;
      getAllBackingBook(
        this.searchSno,
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.backingBookList = [];
          this.sum = 0;
        } else {
          this.backingBookList = data.data;
          this.sum = Number(this.backingBookList[0].msg);
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