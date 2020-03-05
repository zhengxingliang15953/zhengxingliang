<template>
  <div id="notice">
    <!--详细公告-->
    <Drawer placement="left" :closable="false" v-model="value1" width="40%">
      <h2 style="text-align:center">{{itemDetail.title}}</h2>
      <p style="font-size:13px;">{{itemDetail.message}}</p>
    </Drawer>
    <!--详细公告-->

    <!--标签-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
      <el-breadcrumb-item>通知公告</el-breadcrumb-item>
    </el-breadcrumb>
    <!--标签-->
    <br />
    <hr />
    <!--通知公告-->
    <el-pagination
      background
      layout="prev, pager, next"
      :total="sum"
      @current-change="pageChange"
      :current-page="page"
    ></el-pagination>
    <List>
      <ListItem v-for="(item,index) in noticeList" :key="index">
        <ListItemMeta
          avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
          :title="item.title"
          :description="item.message.slice(0,100)"
        />
        <li>
          <a @click="look(item)">去看看</a>
        </li>
      </ListItem>
    </List>
    <!--通知公告-->
  </div>
</template>

<script>
import { getAllNotice } from "../../api";
export default {
  name: "notice",
  data() {
    return {
      value1: false,
      noticeList: [], //通知公告
      itemDetail: {}, //去看看的详细
      sum: 0,
      page: 1
    };
  },
  created() {
    getAllNotice(this.page).then(data => {
      if (data.data[0].noticeId == "0") {
        this.noticeList = [];
        this.sum = 0;
      } else {
        this.noticeList = data.data;
        this.sum = this.noticeList[0].status;
      }
    });
  },
  methods: {
    look(item) {
      //去看看
      this.value1 = true;
      this.itemDetail = item;
    },
    pageChange(value) {
      //页码改变回调
      this.page = value;
      getAllNotice(this.page).then(data => {
        if (data.data[0].noticeId == "0") {
          this.noticeList = [];
          this.sum = 0;
        } else {
          this.noticeList = data.data;
          this.sum = this.noticeList[0].status;
        }
      });
    }
  }
};
</script>

<style lang="less" scoped>
</style>