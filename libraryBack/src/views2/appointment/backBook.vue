<template>
  <div id="backBook">
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
        <List border v-for="(item,index) in backBookList" :key="index">
          <ListItem>
            <span>书名:{{item.bookName}}</span>
            <span>ISBN:{{item.isbn}}</span>
            <span>姓名:{{item.sno}}{{item.studentName}}</span>
            <span>预约时间:{{item.appTime}}</span>
            <span>借阅时间:{{item.lendTime}}</span>
            <span>
              <Tag color="success" v-if="item.status==3">已借阅</Tag>
              <Tag color="error" v-if="item.status==4">借阅预期</Tag>
            </span>
            <el-button
              type="primary"
              icon="el-icon-circle-check"
              size="mini"
              @click="backBookBtn(item)"
            >还书</el-button>
          </ListItem>
        </List>
      </Col>
    </Row>
  </div>
</template>

<script>
import { getAllBackBook, getBackBookBtn } from "../../api";
import { timeChange } from "../../components/press";
export default {
  name: "backBook",
  data() {
    return {
      searchSnoItem: "", //搜索学号V-model
      searchSno: "",
      time: null, //时间选择器
      page: 1, //当前页码
      sum: 0, //总数
      backBookList: [] //还书列表
    };
  },
  created() {
    getAllBackBook("", "", this.page).then(data => {
      if (data.data[0].msg == 0) {
        this.backBookList = [];
        this.sum = 0;
      } else {
        this.backBookList = data.data;
        this.sum = Number(this.backBookList[0].msg);
      }
    });
  },
  methods: {
    searchBtn() {
      //搜索
      this.searchSno = this.searchSnoItem;
      this.page = 1;
      this.time = null;
      getAllBackBook(this.searchSno, "", this.page).then(data => {
        if (data.data[0].msg == 0) {
          this.backBookList = [];
          this.sum = 0;
        } else {
          this.backBookList = data.data;
          this.sum = Number(this.backBookList[0].msg);
        }
      });
    },
    trueTime() {
      //时间确认回调
      this.searchSnoItem = "";
      this.page = 1;
      getAllBackBook(
        "",
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.backBookList = [];
          this.sum = 0;
        } else {
          this.backBookList = data.data;
          this.sum = Number(this.backBookList[0].msg);
        }
      });
    },
    clearTime() {
      //清空时间回调
      this.time = undefined;
      this.searchSnoItem = "";
      this.page = 1;
      getAllBackBook("", "", this.page).then(data => {
        if (data.data[0].msg == 0) {
          this.backBookList = [];
          this.sum = 0;
        } else {
          this.backBookList = data.data;
          this.sum = Number(this.backBookList[0].msg);
        }
      });
    },
    changePage(value) {
      //页码改变回调
      this.page = value;
      getAllBackBook(
        this.searchSno,
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.backBookList = [];
          this.sum = 0;
        } else {
          this.backBookList = data.data;
          this.sum = Number(this.backBookList[0].msg);
        }
      });
    },
    backBookBtn(value) {
      //还书
      getBackBookBtn(value.appId, value.isbn).then(() => {
        this.$message.success("还书成功");
        getAllBackBook(
          this.searchSno,
          typeof this.time == "object"
            ? timeChange(this.time.toDateString())
            : "",
          this.page
        ).then(data => {
          if (data.data[0].msg == 0) {
            this.backBookList = [];
            this.sum = 0;
          } else {
            this.backBookList = data.data;
            this.sum = Number(this.backBookList[0].msg);
          }
        });
      });
    }
  }
};
</script>

<style lang="less" scoped>
span {
  display: inline-block;
  width: 15.5%;
}
</style>