<template>
  <div id="readMessage">
    <Row type="flex">
      <Col :lg="16"></Col>
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
    <!--读者留言-->
    <List>
      <ListItem v-for="(item,index) in readMessageList" :key="index">
        <ListItemMeta
          avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
          :title="item.sno"
          :description="item.message"
          style="padding-left:15px;"
        />
        <el-button
          type="danger"
          icon="el-icon-delete"
          circle
          style="margin-right:70px;"
          @click="detailBtn(item.readId)"
        ></el-button>
      </ListItem>
    </List>
    <!--读者留言-->
  </div>
</template>

<script>
import { getAllReadMessage, getDeleteReadMessage } from "../../api";
export default {
  name: "readMessage",
  data() {
    return {
      readMessageList: [], //读者留言
      sum: 0,
      page: 1 //当前页码
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
    detailBtn(readId) {
      this.$confirm("确认删除该留言, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        if (this.readMessageList.length == 1 && this.page > 1) {
          this.page--;
        }
        getDeleteReadMessage(readId).then(() => {
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          getAllReadMessage(this.page).then(data => {
            if (data.data[0].readId == "0") {
              this.readMessageList = [];
              this.sum = 0;
            } else {
              this.readMessageList = data.data;
              this.sum = this.readMessageList[0].status;
            }
          });
        });
      });
    },
    pageChange(value) {
      this.page = value;
      getAllReadMessage(this.page).then(data => {
        if (data.data[0].readId == "0") {
          this.readMessageList = [];
          this.sum = 0;
        } else {
          this.readMessageList = data.data;
          this.sum = this.readMessageList[0].status;
        }
      });
    }
  }
};
</script>

<style lang="less" scoped>
#readMessage {
  height: 100%;
}
</style>