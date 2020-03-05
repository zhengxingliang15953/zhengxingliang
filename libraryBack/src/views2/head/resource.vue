<template>
  <div id="resource">
    <Row type="flex" style="padding-top:10px;padding-left:10px;">
      <Col :lg="16">
        标题:
        <Input v-model="resourceTitle" placeholder="请输入资源标题" clearable style="width: 200px;" />链接地址:
        <Input v-model="resourceUrl" placeholder="请输入资源链接地址" clearable style="width: 200px;" />
        <Button style="margin-right:20px;margin-left:20px;" type="primary" @click="addResource">添加资源</Button>
      </Col>
      <Col :lg="8">
        <el-pagination
          background
          layout="prev, pager, next"
          :total="sum"
          @current-change="pageChange"
          :current-page="page"
        ></el-pagination>
      </Col>
    </Row>

    <el-table :data="resourceList" border style="width: 100%;margin-top:10px;">
      <el-table-column fixed prop="resourceId" label="资源标号" style="width:10%"></el-table-column>
      <el-table-column prop="title" label="标题" style="width:10%"></el-table-column>
      <el-table-column prop="resourceUrl" label="链接地址" style="width:10%"></el-table-column>

      <el-table-column fixed="right" label="操作" style="width:10%">
        <template slot-scope="scope">
          <el-button @click="deleteResource(scope.row.resourceId)" type="text" size="small">删除</el-button>
        </template>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { getAllResource, getDetailResource, getAddResource } from "../../api";
export default {
  name: "resource",
  data() {
    return {
      resourceList: [], //资源列表
      resourceTitle: "",
      resourceUrl: "",
      page: 1, //当前页码
      sum: 0 //总数
    };
  },
  created() {
    getAllResource(this.page).then(data => {
      if (data.data[0].resourceId == "0") {
        this.resourceList = [];
        this.sum = 0;
      } else {
        this.resourceList = data.data;
        this.sum = this.resourceList[0].status;
      }
    });
  },
  methods: {
    deleteResource(value) {
      //删除资源
      this.$confirm("确认删除该通知, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        if (this.resourceList.length == 1 && this.page > 1) {
          this.page--;
        }
        getDetailResource(value).then(() => {
          getAllResource(this.page).then(data => {
            if (data.data[0].resourceId == "0") {
              this.resourceList = [];
              this.sum = 0;
            } else {
              this.resourceList = data.data;
              this.sum = this.resourceList[0].status;
            }
          });
          this.$message.success("删除成功");
        });
      });
    },
    addResource() {
      //添加资源
      if (
        this.resourceTitle == "" ||
        this.resourceUrl == "" ||
        this.resourceUrl == ""
      ) {
        this.$message.warning("不能为空");
      } else {
        getAddResource(
          this.resourceTitle,
          this.resourceUrl,
          new Date().getTime().toString()
        ).then(() => {
          this.$message.success("添加成功");
          getAllResource(this.page).then(data => {
            this.resourceList = data.data;
            this.sum = this.resourceList[0].status;
          });
        });
        this.resourceTitle = "";
        this.resourceUrl = "";
      }
    },
    pageChange(value) {
      //页码改变回调
      this.page = value;
      getAllResource(this.page).then(data => {
        this.resourceList = data.data;
        this.sum = this.resourceList[0].status;
      });
    }
  }
};
</script>

<style lang="less" scoped>
span {
  font-size: 14px;
}
</style>