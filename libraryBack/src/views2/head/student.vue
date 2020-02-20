<template>
  <div id="student">
    <Row type="flex" style="margin-bottom:10px;">
      <Col :lg="8" style="padding-left:10px;">
        <Input
          v-model="value1"
          search
          enter-button
          placeholder="请输入学号搜索"
          style="width:300px;"
          @on-search="search"
        />
      </Col>
      <Col :lg="8"></Col>
      <Col :lg="8">
        <el-pagination
          background
          layout="prev, pager, next"
          :total="sum"
          @current-change="pageChange"
        ></el-pagination>
      </Col>
    </Row>
    <Table stripe :columns="columns1" :data="data1" style="height:520px;"></Table>
  </div>
</template>

<script>
import { getAllStudent } from "../../api";
export default {
  name: "student",
  data() {
    return {
      columns1: [
        { title: "学号", key: "sno" },
        { title: "姓名", key: "name" },
        { title: "联系方式", key: "tel" },
        { title: "专业", key: "marjor" },
        { title: "学院", key: "school" },
        { title: "身份证号码", key: "idCard" },
        { title: "地址", key: "address" }
      ],
      data1: [], //学生列表
      value1: "", //搜索值
      sum: 1
    };
  },
  created() {
    getAllStudent(this.value1, 1).then(data => {
      this.data1 = data.data;
      this.sum = this.data1[0].status;
    });
  },
  methods: {
    search() {
      //搜索
      getAllStudent(this.value1, 1).then(data => {
        this.data1 = data.data;
        this.sum = this.data1[0].status;
      });
    },
    pageChange(value) {
      getAllStudent(this.value1, value).then(data => {
        this.data1 = data.data;
      });
    }
  }
};
</script>

<style lang="less" scoped>
#student{
  padding-top:10px;
}
</style>