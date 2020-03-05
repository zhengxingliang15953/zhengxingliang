<template>
  <div id="readMessage">
    <!--留言对话框-->
    <Modal v-model="modal1" width="400" ok-text="提交" @on-ok="onOk">
      <Input
        maxlength="50"
        show-word-limit
        type="textarea"
        placeholder="留言内容不能超过50字"
        style="width: 350px"
        size="large"
        v-model="addReadMessageText"
      />
    </Modal>
    <!--留言对话框-->

    <!--标签-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
      <el-breadcrumb-item>读者留言</el-breadcrumb-item>
    </el-breadcrumb>
    <!--标签-->
    <a style="float:right;" @click="myselfMessage">我要留言</a>
    <br />
    <hr />
    <!--读者留言-->
    <el-pagination
      background
      layout="prev, pager, next"
      :total="sum"
      @current-change="pageChange"
      :current-page="page"
    ></el-pagination>
    <List>
      <ListItem v-for="(item,index) in readMessageList" :key="index">
        <ListItemMeta
          avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
          :title="item.sno"
          :description="item.message"
        />
      </ListItem>
    </List>
    <!--读者留言-->
  </div>
</template>

<script>
import { getAllReadMessage, addReadMessage, getIndexStudent } from "../../api";
export default {
  name: "readMessage",
  data() {
    return {
      modal1: false,
      readMessageList: [], //读者留言
      addReadMessageText: "", //添加留言值
      studentId: "", //当前登陆ID
      sum: 0,
      page: 1
    };
  },
  created() {
    getAllReadMessage(this.page).then(data => {
        if (data.data[0].readId == "0") {
          this.readMessageList = [];
          this.sum = 0;
        } else {
          this.readMessageList = data.data;
          this.sum = this.readMessageList[0].status;
        }
      });
  },
  methods: {
    onOk() {
      //留言提交
      let str = new Date().getTime().toString();
      addReadMessage(this.studentId, this.addReadMessageText, str).then(() => {
        this.$Message.success("提交成功!");
        getAllReadMessage(this.page).then(data => {
          this.readMessageList = data.data;
          this.sum = this.readMessageList[0].status;
        });
      });
    },
    myselfMessage() {
      //我要留言
      this.addReadMessageText='';
      getIndexStudent().then(data => {
        if (
          window.sessionStorage.getItem("token") == data.data.msg &&
          window.sessionStorage.getItem("token")
        ) {
          this.studentId = data.data.sno;
          this.modal1 = true;
        } else {
          this.$message.warning("请先前往首页登陆");
        }
      });
    },
    pageChange(value) {
      //页码改变回调
      this.page = value;
      getAllReadMessage(this.page).then(data => {
        this.readMessageList = data.data;
        this.sum = this.readMessageList[0].status;
      });
    }
  }
};
</script>

<style lang="less" scoped>
</style>