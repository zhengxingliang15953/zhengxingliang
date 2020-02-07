<template>
    <div id="readMessage">
        <!--留言对话框-->
        <Modal v-model="modal1" width="400" ok-text="提交" @on-ok="onOk">
          <Input maxlength="50" show-word-limit type="textarea" placeholder="留言内容不能超过50字" style="width: 350px" size="large"/>
        </Modal>
        <!--留言对话框-->

        <!--标签-->
        <el-breadcrumb separator-class="el-icon-arrow-right">
            <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
            <el-breadcrumb-item>读者留言</el-breadcrumb-item>
        </el-breadcrumb>
        <!--标签-->
        <a style="float:right;" @click="modal1=true">我要留言</a>
    <br><hr></hr>
    <!--读者留言-->
            <List>
              <ListItem>
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  title="2018284129留言:"
                  description="太好看了"
                />
              </ListItem>
              <ListItem>
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  title="2018284129留言:"
                  description="This is description, this is description."
                />
              </ListItem>
            </List>
            <!--读者留言-->
    </div>
</template>

<script>
export default {
    name:'readMessage',
    data(){
        return{
            modal1:false,
        }
    },
    methods:{
        onOk(){//留言提交
            this.$Message.success('提交成功!');
 
        }
    }
}
</script>

<style lang="less" scoped>

</style>