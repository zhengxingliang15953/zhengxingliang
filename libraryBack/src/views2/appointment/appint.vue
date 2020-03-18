<template>
  <div id="appint">
    <!--head-->
    <Row type="flex" class="headAppointment">
      <Col :lg="2"></Col>
      <Col :lg="7">
        <Input
          search
          enter-button
          placeholder="请输入学号"
          v-model="searchSnoItem"
          @on-search="searchBtn"
        />
      </Col>
      <Col :lg="1"></Col>
      <Col :lg="8">
        <DatePicker
          v-model="time"
          type="date"
          confirm
          placeholder="预约时间选择"
          style="width: 300px"
          @on-ok="trueTime"
          @on-clear="clearTime"
        ></DatePicker>
      </Col>
      <Col :lg="6">
        <Page :current="page" :total="sum" simple style="margin-top:3px;" @on-change="changePage" />
      </Col>
    </Row>
    <!--head-->
    <Row type="flex" style="width:97%;margin:5px auto;">
      <Col :lg="24">
        <List border v-for="(item,index) in AllAppointmentList" :key="index">
          <ListItem>
            <span>书名:{{item.bookName}}</span>
            <span>ISBN:{{item.isbn}}</span>
            <span>姓名:{{item.sno}}{{item.studentName}}</span>
            <span>预约时间:{{item.appTime}}</span>
            <span>
              <Tag color="primary" v-if="item.status==1">已预约</Tag>
              <Tag color="warning" v-if="item.status==2">预约预期</Tag>  
              <Tag color="success" v-if="item.status==3">已借阅</Tag>
              <Tag color="error" v-if="item.status==4">借阅预期</Tag>
              <Tag color="blue" v-if="item.status==5">已归还</Tag>
              <Tag color="cyan" v-if="item.status==6">待指派</Tag>
              <Tag color="blue" v-if="item.status==7">骑手未接单</Tag>
              <Tag color="gold" v-if="item.status==8">骑手取货中</Tag>
              <Tag color="purple" v-if="item.status==9">骑手配送中</Tag>
            </span>
            <el-button
              type="success"
              icon="el-icon-check"
              circle
              size="small"
              v-if="item.status==1||item.status==6||item.status==7"
              @click="brrowBook(item)"
            ></el-button>
          </ListItem>
        </List>
      </Col>
    </Row>
  </div>
</template>

<script>
import { getAllAppointment, getUpdateAppointment } from "../../api";
import { timeChange } from "../../components/press";
export default {
  name: "appoint",
  data() {
    return {
      time: null, //选择时间
      page: 1, //当前页码
      sum: 0, //总数
      AllAppointmentList: [], //当前显示列表
      searchSnoItem: "" ,//搜索内容(sno)v-model
      searchSno:'',
    };
  },
  created() {
    getAllAppointment("", "", this.page).then(data => {
      if (data.data[0].msg == 0) {
        this.AllAppointmentList = [];
        this.sum = 0;
      } else {
        this.AllAppointmentList = data.data;
        this.sum = Number(this.AllAppointmentList[0].msg);
      }
    });
  },
  methods: {
    trueTime(value) {
      //时间回调
      this.searchSno = "";
      this.page = 1;
      getAllAppointment(
        this.searchSno,
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.AllAppointmentList = [];
          this.sum = 0;
        } else {
          this.AllAppointmentList = data.data;
          this.sum = Number(this.AllAppointmentList[0].msg);
        }
      });
    },
    clearTime() {
      //清空时间
      this.time = undefined;
      this.searchSno='';
      this.page=1;
      getAllAppointment(
        this.searchSno,
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.AllAppointmentList = [];
          this.sum = 0;
        } else {
          this.AllAppointmentList = data.data;
          this.sum = Number(this.AllAppointmentList[0].msg);
        }
      });
    },
    changePage(value) {
      //页码改变回调
      this.page = value;
      getAllAppointment(
        this.searchSno,
        typeof this.time == "object"
          ? timeChange(this.time.toDateString())
          : "",
        this.page
      ).then(data => {
        if (data.data[0].msg == 0) {
          this.AllAppointmentList = [];
          this.sum = 0;
        } else {
          this.AllAppointmentList = data.data;
          this.sum = Number(this.AllAppointmentList[0].msg);
        }
      });
    },
    brrowBook(value) {
      //借阅
      getUpdateAppointment(value.appId, 3, value.isbn).then(() => {
        this.$message.success('借阅成功');
        getAllAppointment(
          this.searchSno,
          typeof this.time == "object"
            ? timeChange(this.time.toDateString())
            : "",
          this.page
        ).then(data => {
          if (data.data[0].msg == 0) {
            this.AllAppointmentList = [];
            this.sum = 0;
          } else {
            this.AllAppointmentList = data.data;
            this.sum = Number(this.AllAppointmentList[0].msg);
          }
        });
      });
    },
    searchBtn() {
      //搜索
      this.page = 1;
      this.time = null;
      this.searchSno=this.searchSnoItem;
      getAllAppointment(this.searchSno, "", this.page).then(data => {
        if (data.data[0].msg == 0) {
          this.AllAppointmentList = [];
          this.sum = 0;
        } else {
          this.AllAppointmentList = data.data;
          this.sum = Number(this.AllAppointmentList[0].msg);
        }
      });
    }
  },
  computed: {}
};
</script>

<style lang="less" scoped>
span {
  display: inline-block;
  width: 18%;
}
</style>