<template>
  <div id="notice">
    <!--编辑通知-->
    <Drawer  width="720" :mask-closable="false" v-model="value1">
      标题:<Input v-model="noticeHead" placeholder="请输入公告通知的标题" style="width:100%" />
      正文:<Input v-model="noticeMain" show-word-limit type="textarea" placeholder="请输入公告通知正文" style="width: 100%;" /> 
      <div class="demo-drawer-footer">
        <Button style="margin-right: 8px" @click="value1 = false">取消</Button>
        <Button type="primary" @click="value1 = false">{{message}}</Button>
      </div>
    </Drawer>
    <!--编辑通知-->
    <p class="addNotice"><span @click="addNotice">添加公告</span></p>
    <!--通知公告-->
    <List>
      <ListItem v-for="(item,index) in noticeList" :key="index">
        <ListItemMeta
          avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
          :title="item.title"
          :description="item.message"
          style="padding-left:15px;"
        />
        <el-button type="primary" icon="el-icon-edit" circle @click="changeBtn(item.noticeId)"></el-button>
        <el-button
          type="danger"
          icon="el-icon-delete"
          circle
          style="margin-right:100px;"
          @click="detailBtn"
        ></el-button>
      </ListItem>
    </List>
    <!--通知公告-->
  </div>
</template>

<script>
export default {
  name: "notice",
  data() {
    return {
      value1:false,//编辑修改弹窗
      noticeHead:'',//编辑修改标题
      noticeMain:'',//编辑修改正文
      message:'修改',//修改、添加
      noticeList: [
        {
          noticeId: 1,
          title: "春节闭馆通知1",
          message: "范德萨发生方式范德萨发生"
        },
        {
          noticeId: 2,
          title: "春节闭馆通知2",
          message: "范德萨发生方式范德萨发生"
        },
        {
          noticeId: 3,
          title: "春节闭馆通知3",
          message: "范德萨发生方式范德萨发生"
        },
        {
          noticeId: 4,
          title: "春节闭馆通知4",
          message: "范德萨发生方式范德萨发生"
        }
      ]
    };
  },
  methods: {
    detailBtn() {//删除公告
      this.$confirm("确认删除该通知, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        this.$message({
          type: "success",
          message: "删除成功!"
        });
      });
    },
    changeBtn(value){//编辑公告
        this.message='修改';
        this.value1=true;
        this.delId=value;
        for(var i=0;i<this.noticeList.length;i++){
            if(this.noticeList[i].noticeId==value){
                this.noticeHead=this.noticeList[i].title;
                this.noticeMain=this.noticeList[i].message;
                break;
            }
        }
    },
    addNotice(){//添加公告
      this.message='添加';
      this.noticeHead='';
      this.noticeMain='';
      this.value1=true;
    }
  },
  computed:{
      
  }
};
</script>

<style lang="less" scoped>
.demo-drawer-footer{
        width: 100%;
        position: absolute;
        bottom: 0;
        left: 0;
        border-top: 1px solid #e8e8e8;
        padding: 10px 16px;
        text-align: right;
        background: #fff;
    }
.addNotice{
  text-align: right;
  padding:5px;
  span{
    color:#436EEE;
    font-size: 13px;
  }
  span:hover{
    cursor: pointer;
  }
}    
</style>