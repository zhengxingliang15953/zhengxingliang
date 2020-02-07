<template>
    <div id="notice">
        <!--详细公告-->
        <Drawer title="Basic Drawer" placement="left" :closable="false" v-model="value1" width="40%">
            <p>Some contents...</p>
            <p>Some contents...</p>
            <p>Some contents...</p>
        </Drawer>
        <!--详细公告-->

          <!--标签-->
    <el-breadcrumb separator-class="el-icon-arrow-right">
      <el-breadcrumb-item to="/">首页</el-breadcrumb-item>
      <el-breadcrumb-item>通知公告</el-breadcrumb-item>
    </el-breadcrumb>
    <!--标签-->
    <br><hr></hr>
    <!--通知公告-->
            <List>
              <ListItem>
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  title="春节闭关通知"
                  description="This is description, this is description."
                />
                <li>
                  <a @click="value1=true">去看看</a>
                </li>
              </ListItem>
              <ListItem>
                <ListItemMeta
                  avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
                  title="新型冠状"
                  description="This is description, this is description."
                />
              </ListItem>
            </List>
            <!--通知公告-->
    </div>
</template>

<script>
export default {
    name:'notice',
    data(){
        return{
            value1:false,
        }
    },
    methods:{
        
    }
}
</script>

<style lang="less" scoped>
  
</style>