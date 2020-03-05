<template>
  <div id="notice">
    <!--编辑通知-->
    <Drawer width="720" :mask-closable="false" v-model="value1">
      标题:
      <Input v-model="noticeHead" placeholder="请输入公告通知的标题" style="width:100%" />正文:
      <Input
        v-model="noticeMain"
        show-word-limit
        type="textarea"
        placeholder="请输入公告通知正文"
        style="width: 100%;"
      />
      <div class="demo-drawer-footer">
        <Button style="margin-right: 8px" @click="value1 = false">取消</Button>
        <Button type="primary" @click="addNoticeItem">{{message}}</Button>
      </div>
    </Drawer>
    <!--编辑通知-->
    <Row type="flex" style="padding-top:10px;">
      <Col :lg="1"></Col>
      <Col :lg="15">
        <Button @click="addNotice" type="primary">添加公告</Button>
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
    <!--通知公告-->
    <List>
      <ListItem v-for="(item,index) in noticeList" :key="index">
        <ListItemMeta
          avatar="https://dev-file.iviewui.com/userinfoPDvn9gKWYihR24SpgC319vXY8qniCqj4/avatar"
          :title="item.title"
          :description="item.message.slice(0,100)"
          style="padding-left:15px;"
        />
        <el-button type="primary" icon="el-icon-edit" circle @click="changeBtn(item)"></el-button>
        <el-button
          type="danger"
          icon="el-icon-delete"
          circle
          style="margin-right:100px;"
          @click="detailBtn(item.noticeId)"
        ></el-button>
      </ListItem>
    </List>
    <!--通知公告-->
  </div>
</template>

<script>
import {
  getAddNotice,
  getDeleteNotice,
  getAllNotice,
  getUpdateNotice
} from "../../api";
export default {
  name: "notice",
  data() {
    return {
      value1: false, //编辑修改弹窗
      noticeHead: "", //编辑修改标题
      noticeMain: "", //编辑修改正文
      message: "修改", //修改、添加
      noticeList: [], //通知公告列表
      updateId: "", //修改ID
      sum: 0,
      page: 1
    };
  },
  created() {
    getAllNotice(this.page).then(data => {
      if (data.data[0].noticeId == "0") {
        this.noticeList = [];
        this.sum = 0;
      } else {
        this.noticeList = data.data;
        this.sum = this.noticeList[0].status;
      }
    });
  },
  methods: {
    detailBtn(value) {
      //删除公告
      this.$confirm("确认删除该通知, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        if (this.noticeList.length == 1 && this.page > 1) {
          this.page--;
        }
        getDeleteNotice(value.toString()).then(() => {
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          getAllNotice(this.page).then(data => {
            if (data.data[0].noticeId == "0") {
              this.noticeList = [];
              this.sum = 0;
            } else {
              this.noticeList = data.data;
              this.sum = this.noticeList[0].status;
            }
          });
        });
      });
    },
    changeBtn(value) {
      //编辑公告
      this.message = "修改";
      this.value1 = true;
      this.updateId = value.noticeId;
      this.noticeHead = value.title;
      this.noticeMain = value.message;
    },
    addNotice() {
      //添加公告弹出
      this.message = "添加";
      this.noticeHead = "";
      this.noticeMain = "";
      this.value1 = true;
    },
    addNoticeItem() {
      //添加公告
      if (this.message == "添加") {
        if (this.noticeHead == "" || this.noticeMain == "") {
          this.$message.warning("请输入完整");
        } else {
          this.value1 = false;
          let noticeId = new Date().getTime().toString();
          getAddNotice(this.noticeHead, this.noticeMain, noticeId)
            .then(() => {
              getAllNotice(this.page).then(data => {
                if (data.data[0].noticeId == "0") {
                  this.noticeList = [];
                  this.sum = 0;
                } else {
                  this.noticeList = data.data;
                  this.sum = this.noticeList[0].status;
                }
              });
              this.$message.success("添加成功");
            })
            .catch(() => {
              this.$message.error("添加失败");
            });
        }
      } else if (this.message == "修改") {
        //修改公告
        if (this.noticeHead == "" || this.noticeMain == "") {
          this.$message.warning("请输入完整");
        } else {
          this.value1 = false;
          getUpdateNotice(this.noticeHead, this.noticeMain, this.updateId)
            .then(() => {
              getAllNotice(this.page).then(data => {
                if (data.data[0].noticeId == "0") {
                  this.noticeList = [];
                  this.sum = 0;
                } else {
                  this.noticeList = data.data;
                  this.sum = this.noticeList[0].status;
                }
              });
              this.$message.success("修改成功");
            })
            .catch(() => {
              this.$message.error("修改失败");
            });
        }
      }
    },
    pageChange(value) {
      //页码改变回调
      this.page = value;
      getAllNotice(this.page).then(data => {
        if (data.data[0].noticeId == "0") {
          this.noticeList = [];
          this.sum = 0;
        } else {
          this.noticeList = data.data;
          this.sum = this.noticeList[0].status;
        }
      });
    }
  },
  computed: {}
};
</script>

<style lang="less" scoped>
.demo-drawer-footer {
  width: 100%;
  position: absolute;
  bottom: 0;
  left: 0;
  border-top: 1px solid #e8e8e8;
  padding: 10px 16px;
  text-align: right;
  background: #fff;
}
.addNotice {
  text-align: right;
  padding: 5px;
  span {
    color: #436eee;
    font-size: 13px;
  }
  span:hover {
    cursor: pointer;
  }
}
</style>