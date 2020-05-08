<template>
  <div>
    <!--head-->
    <Row type="flex" class="headAppointment">
      <Col :lg="2"></Col>
      <Col :lg="7">
        <Input
          search
          enter-button
          placeholder="请输入骑手学号"
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

    <el-table :data="riderList" border style="width: 100%;margin-top:10px;">
      <el-table-column fixed prop="studentName" label="骑手姓名" style="width:10%"></el-table-column>
      <el-table-column prop="sno" label="学号" style="width:10%"></el-table-column>
      <el-table-column prop="orderNumber" label="累计订单" style="width:10%"></el-table-column>
      <el-table-column prop="status" label="状态" style="width:10%">
        <template slot-scope="scope">
          <Tag color="primary" v-if="scope.row.status==5">上线</Tag>
          <Tag color="error" v-if="scope.row.status==4">下线</Tag>
        </template>
      </el-table-column>
      <el-table-column fixed="right" label="操作" style="width:10%">
        <template slot-scope="scope">
          <Button type="success" @click="deleteRider(scope.row.openId)">删除骑手</Button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getAllRider, getDeleteRider } from "../../api";
export default {
  data() {
    return {
      searchSnoItem: "", //搜索v-model
      searchSno: "",
      page: 1, //当前页码
      sum: 0, //总数
      riderList: [] //骑手列表
    };
  },
  created() {
    getAllRider("", 1).then(data => {
      if (data.data[0].msg == "0") {
        this.riderList = [];
        this.sum = 0;
      } else {
        this.riderList = data.data;
        this.sum = Number(data.data[0].msg);
      }
    });
  },
  methods: {
    searchBtn() {
      //搜索
      this.searchSno = this.searchSnoItem;
      getAllRider(this.searchSno, 1).then(data => {
        if (data.data[0].msg == "0") {
          this.riderList = [];
          this.sum = 0;
        } else {
          this.riderList = data.data;
          this.sum = Number(data.data[0].msg);
        }
      });
    },
    changePage(value) {
      //页码改变回调
      this.page = value;
      getAllRider(this.searchSno, value).then(data => {
        if (data.data[0].msg == "0") {
          this.riderList = [];
          this.sum = 0;
        } else {
          this.riderList = data.data;
          this.sum = Number(data.data[0].msg);
        }
      });
    },
    deleteRider(value) {
      //删除骑手
      getDeleteRider(value).then(data => {
        if (data.data.msg == "0") {
          this.$message.warning("骑手有订单信息无法删除");
        } else {
          this.$message.success("删除成功");
          getAllRider(this.searchSno, this.page).then(data => {
            if (data.data[0].msg == "0") {
              this.riderList = [];
              this.sum = 0;
            } else {
              this.riderList = data.data;
              this.sum = Number(data.data[0].msg);
            }
          });
        }
      });
    }
  }
};
</script>

<style lang="less" scoped>
</style>