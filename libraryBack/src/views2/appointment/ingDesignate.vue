<template>
  <div>
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
      <Col :lg="8"></Col>
      <Col :lg="6">
        <Page :current="page" :total="sum" simple style="margin-top:3px;" @on-change="changePage" />
      </Col>
    </Row>
    <!--head-->
    <Row type="flex" style="width:97%;margin:5px auto;">
      <Col :lg="24">
        <List border v-for="(item,index) in ingDesignateList" :key="index">
          <ListItem>
            <span>书名:{{item.bookName}}</span>
            <span>ISBN:{{item.isbn}}</span>
            <span>姓名:{{item.sno}}{{item.studentName}}</span>
            <span>预约时间:{{item.appTime}}</span>
            <span>
              <!--<Tag color="purple">正在配送</Tag>-->
              <Tooltip :content="item.tbRider.studentName">
                <Tag color="gold" v-if="item.status==8">骑手取货中</Tag>
                <Tag color="purple" v-if="item.status==9">骑手配送中</Tag>
              </Tooltip>
            </span>
          </ListItem>
        </List>
      </Col>
    </Row>
  </div>
</template>

<script>
import { getIngDesignation } from "../../api";
export default {
  data() {
    return {
      searchSnoItem: "", //搜索v-model
      searchSno: "", //
      page: 1, //当前页码
      sum: 0, //总数
      ingDesignateList: [] //正在配送列表
    };
  },
  created() {
    getIngDesignation("", 1).then(data => {
      if (data.data[0].msg == "0") {
        this.ingDesignateList = [];
        this.sum = 0;
      } else {
        this.ingDesignateList = data.data;
        this.sum = Number(data.data[0].msg);
      }
    });
  },
  methods: {
    searchBtn() {
      //搜索
      this.searchSno = this.searchSnoItem;
      getIngDesignation(this.searchSno, 1).then(data => {
        if (data.data[0].msg == "0") {
          this.ingDesignateList = [];
          this.sum = 0;
        } else {
          this.ingDesignateList = data.data;
          this.sum = Number(data.data[0].msg);
        }
      });
    },
    changePage(value) {
      //页码改变回调
      this.page = value;
      getIngDesignation(this.searchSno, value).then(data => {
        if (data.data[0].msg == "0") {
          this.ingDesignateList = [];
          this.sum = 0;
        } else {
          this.ingDesignateList = data.data;
          this.sum = Number(data.data[0].msg);
        }
      });
    }
  }
};
</script>

<style lang="less" scoped>
span {
  display: inline-block;
  width: 18%;
}
</style>