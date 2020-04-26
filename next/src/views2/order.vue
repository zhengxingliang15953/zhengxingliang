<template>
  <div id="apply">
    <!--添加弹窗-->
    <Modal v-model="modal1" title="添加订单" ok-text="添加" @on-ok="addSubmit">
      <div class="modal-item">
        支出时间:
        <DatePicker type="date" placeholder="请选择支出时间" style="width:70%;"></DatePicker>
      </div>
      <div class="modal-item">
        支出金额:
        <Input v-model="value" placeholder="请输入支出金额" style="width: 70%;" />
      </div>
      <div class="modal-item">
        支出人员:
        <Input v-model="value" placeholder="请输入支出人" style="width: 70%;" />
      </div>
      <div class="modal-item">
        支出信息:
        <Input
          v-model="value17"
          show-word-limit
          type="textarea"
          placeholder="请输入支出信息"
          style="width:70%;"
        />
      </div>
    </Modal>
    <!--添加弹窗-->

    <div class="panel-head">订单管理</div>
    <div class="panel-body">
      <div class="panel-body-search">
        <DatePicker type="date" :value="stime" placeholder="请选择查询开始时间" @on-change="timeChange1" style="width: 200px"></DatePicker>至
        <DatePicker type="date" :value="etime" placeholder="请选择查询结束时间" @on-change="timeChange2" style="width: 200px"></DatePicker>
        <Input
          v-model="customerSearch1"
          placeholder="请输入客户名称"
          style="width: 250px;margin-left:10px;"
        />
        <Button type="info" class="searchBtn" @click="searchBtn">查询</Button>
        <Button type="primary" class="searchBtn" @click="modal1=true">添加订单</Button>
      </div>
      <Table :columns="columns1" :data="data1">
        <template slot-scope="{ row, index }" slot="action">
          <Button type="primary" size="small" style="margin-right: 5px" @click="edit(row)">编辑</Button>
          <Button type="error" size="small" @click="remove(row)">删除</Button>
        </template>
      </Table>
      <Page :total="sum" :current="page" style="margin-top:20px;" @on-change="pageChange" />
    </div>
  </div>
</template>

<script>
import { changeTime } from "../plugins/time.js";
export default {
  name: "apply",
  data() {
    return {
      columns1: [
        {
          title: "支出时间",
          key: "time"
        },
        {
          title: "支出信息",
          key: "info"
        },
        {
          title: "支出金额",
          key: "money"
        },
        {
          title: "支出人",
          key: "name"
        },
        {
          title: "审核状态",
          key: "type"
        },
        {
          title: "审核结果",
          key: "result"
        },
        {
          title: "审核人",
          key: "people"
        },
        {
          title: "操作",
          slot: "action",
          width: 200,
          align: "center"
        }
      ],
      data1: [
        
      ], //开支列表
      modal1: false, //弹窗控制
      sum: 0, //总数目
      page: 1, //当前页码
      stime: "0001-01-01", //开始时间
      etime: "" ,//结束时间
      customerSearch1:'',//客户名称查询v-model
      customerSearch2:'',//客户名称查询实际
    };
  },
  created() {
    this.etime = changeTime(new Date());
  },
  methods: {
    addSubmit(){//添加订单

    },
    pageChange(value) {
      //页码改变回调
      this.page = value;
    },
    timeChange1(value) {
      //开始时间
      this.stime = value;
    },
    timeChange2(value) {
      //结束时间
      this.etime = value;
    },
    searchBtn(){//查询
      this.customerSearch2=this.customerSearch1;
    }
  }
};
</script>

<style lang="less" scoped>
#apply {
  padding: 20px;
}
</style>