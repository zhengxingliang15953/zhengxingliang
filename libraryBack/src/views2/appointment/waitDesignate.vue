<template>
  <div>
    <!--弹出框-->
    <Modal v-model="modal1" title="可指派的骑手" scrollable>
      <Button
        type="success"
        long
        v-for="(item,index) in riderList"
        :key="index"
        style="margin-bottom:10px;height:70%;"
        @click="pointSubmit(item)"
      >{{item.sno}}{{item.studentName}}</Button>
    </Modal>
    <!--弹出框-->
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
      <Col :lg="8"></Col>
      <Col :lg="6">
        <Page :current="page" :total="sum" simple style="margin-top:3px;" @on-change="changePage" />
      </Col>
    </Row>
    <!--head-->
    <Row type="flex" style="width:97%;margin:5px auto;">
      <Col :lg="24">
        <List border v-for="(item,index) in waitDesignateList" :key="index">
          <ListItem>
            <span>书名:{{item.bookName}}</span>
            <span>ISBN:{{item.isbn}}</span>
            <span>姓名:{{item.sno}}{{item.studentName}}</span>
            <span>预约时间:{{item.appTime}}</span>
            <span>
              <Tag color="cyan">待指派</Tag>
            </span>
            <span>
              <Button type="success" @click="pointBtn(item)">指派</Button>
            </span>
          </ListItem>
        </List>
      </Col>
    </Row>
  </div>
</template>

<script>
import { getWaitDesignation, getAppRider, getAddPoint } from "../../api";
export default {
  data() {
    return {
      searchSnoItem: "", //搜索v-model
      searchSno: "",
      page: 1, //当前页码
      sum: 0, //总数
      waitDesignateList: [], //待指派列表
      modal1: false,
      appointmentItem: {}, //指派预约对象
      riderList: [] //骑手列表
    };
  },
  created() {
    getWaitDesignation("", 1).then(data => {
      if (data.data[0].msg == "0") {
        this.waitDesignateList = [];
        this.sum = 0;
      } else {
        this.waitDesignateList = data.data;
        this.sum = Number(this.waitDesignateList[0].msg);
      }
    });
  },
  methods: {
    searchBtn() {
      //搜索
      this.searchSno = this.searchSnoItem;
      getWaitDesignation(this.searchSno, 1).then(data => {
        if (data.data[0].msg == "0") {
          this.waitDesignateList = [];
          this.sum = 0;
        } else {
          this.waitDesignateList = data.data;
          this.sum = Number(this.waitDesignateList[0].msg);
        }
      });
    },
    changePage(value) {
      //页码改变回调
      this.page = value;
      getWaitDesignation(this.searchSno, value).then(data => {
        if (data.data[0].msg == "0") {
          this.waitDesignateList = [];
          this.sum = 0;
        } else {
          this.waitDesignateList = data.data;
          this.sum = Number(this.waitDesignateList[0].msg);
        }
      });
    },
    pointBtn(value) {
      //指派按钮
      this.modal1 = true;
      this.appointmentItem = value;
      getAppRider(value.appId).then(data => {
        this.riderList = data.data;
      });
    },
    pointSubmit(value) {
      //指派提交
      this.riderList = this.riderList.filter(function(item) {
        return item.openId != value.openId;
      });
      getAddPoint(value.openId, this.appointmentItem.appId).then(data => {
        if (data.data.msg == "0") {
          this.$message.warning("该骑手已被指派");
        } else {
          this.$message.success("指派成功");
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