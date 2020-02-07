<template>
  <div id="readMessage">
    <!--读者留言-->
    <List>
      <ListItem>
        <ListItemMeta
          avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
          title="2018284129留言:"
          description="太好看了"
          style="padding-left:15px;"
        />
        <el-button
          type="danger"
          icon="el-icon-delete"
          circle
          style="margin-right:70px;"
          @click="detailBtn"
        ></el-button>
      </ListItem>
    </List>
    <!--读者留言-->fds
  </div>
</template>

<script>
export default {
  name: "readMessage",
  data() {
    return {};
  },
  methods:{
      detailBtn(){

      }
  }
};
</script>

<style lang="less" scoped>
</style>