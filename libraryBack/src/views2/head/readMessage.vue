<template>
  <div id="readMessage">
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
      readMessageList: [] //读者留言
    };
  },
  created() {
    getAllReadMessage().then(data => {
      this.readMessageList = data.data;
    });
  },
  methods: {
    detailBtn(readId) {
      this.$confirm("确认删除该通知, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        getDeleteReadMessage(readId).then(() => {
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          getAllReadMessage().then(data => {
            this.readMessageList = data.data;
          });
        });
      });
    }
  }
};
</script>

<style lang="less" scoped>
</style>