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

    <el-table :data="ApplyList" border style="width: 100%;margin-top:10px;">
      <el-table-column fixed prop="studentName" label="骑手姓名" style="width:10%"></el-table-column>
      <el-table-column prop="sno" label="学号" style="width:10%"></el-table-column>

      <el-table-column fixed="right" label="操作" style="width:10%">
        <template slot-scope="scope">
          <Button type="success" @click="applySuccess(scope.row.openId)">通过</Button>
          <Button type="error" @click="applyError(scope.row.openId)" style="margin-left:20px;">回拒</Button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getApprove, getAgreement, getRefuse } from "../../api";
export default {
  data() {
    return {
      searchSnoItem: "", //搜索v-model
      searchSno: "",
      sum: 0, //总数
      page: 1, //当前页码
      ApplyList: [] //审批列表
    };
  },
  created() {
    getApprove("", 1).then(data => {
      if (data.data[0].msg == "0") {
        this.sum = 0;
        this.ApplyList = [];
      } else {
        this.ApplyList = data.data;
        this.sum = Number(this.ApplyList[0].msg);
      }
    });
  },
  methods: {
    searchBtn() {
      //搜索
      this.searchSno = this.searchSnoItem;
      getApprove(this.searchSno, 1).then(data => {
        if (data.data[0].msg == "0") {
          this.sum = 0;
          this.ApplyList = [];
        } else {
          this.ApplyList = data.data;
          this.sum = Number(this.ApplyList[0].msg);
        }
      });
    },
    changePage(value) {
      //页码改变回调
      this.page = value;
      getApprove(this.searchSno, value).then(data => {
        if (data.data[0].msg == "0") {
          this.sum = 0;
          this.ApplyList = [];
        } else {
          this.ApplyList = data.data;
          this.sum = Number(this.ApplyList[0].msg);
        }
      });
    },
    applySuccess(value) {
      //审核通过
      getAgreement(value, 4).then(data => {
        if (data.data.msg == "1") {
          this.$message.success("审批通过");
          getApprove(this.searchSno, this.page).then(data => {
            if (data.data[0].msg == "0") {
              this.sum = 0;
              this.ApplyList = [];
            } else {
              this.ApplyList = data.data;
              this.sum = Number(this.ApplyList[0].msg);
            }
          });
        } else {
          this.$message.warning("已经是骑手,刷新页面");
        }
      });
    },
    applyError(value) {
      //拒绝审核
      getRefuse(value).then(data => {
        if (data.data.msg == "0") {
          this.$message.warning("已被其他管理员拒绝");
        } else if (data.data.msg == "2") {
          this.$message.warning("已被其他管理员通过");
        } else {
          this.$message.success("回拒成功");
          getApprove(this.searchSno, this.page).then(data => {
            if (data.data[0].msg == "0") {
              this.sum = 0;
              this.ApplyList = [];
            } else {
              this.ApplyList = data.data;
              this.sum = Number(this.ApplyList[0].msg);
            }
          });
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