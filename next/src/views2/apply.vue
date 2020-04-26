<template>
  <div id="apply">
    <!--添加弹窗-->
    <Modal v-model="modal1" title="添加日常开支" ok-text="添加" @on-ok="addSubmit">
      <div class="modal-item">
        支出时间:
        <DatePicker
          type="date"
          :value="submitForm.date"
          placeholder="请选择支出时间"
          style="width:70%;"
          @on-change="applyTimeChange"
        ></DatePicker>
      </div>
      <div class="modal-item">
        支出金额:
        <Input v-model="submitForm.money" placeholder="请输入支出金额" style="width: 70%;" />
      </div>
      <div class="modal-item">
        支出人员:
        <Input v-model="submitForm.name" placeholder="请输入支出人" style="width: 70%;" />
      </div>
      <div class="modal-item">
        支出信息:
        <Input
          v-model="submitForm.info"
          show-word-limit
          type="textarea"
          placeholder="请输入支出信息"
          style="width:70%;"
        />
      </div>
    </Modal>
    <!--添加弹窗-->

    <div class="panel-head">开支管理</div>
    <div class="panel-body">
      <div class="panel-body-search">
        <DatePicker
          type="date"
          :value="stime"
          placeholder="请选择查询开始时间"
          style="width: 200px"
          @on-change="timeChange1"
        ></DatePicker>至
        <DatePicker
          type="date"
          :value="etime"
          placeholder="请选择查询结束时间"
          style="width: 200px"
          @on-change="timeChange2"
        ></DatePicker>
        <Button type="info" class="searchBtn" @click="searchBtn">查询</Button>
        <Button type="primary" class="searchBtn" @click="modal1=true">添加开支</Button>
      </div>
      <Table :columns="columns1" :data="expensesList">
        <template slot-scope="{ row, index }" slot="action">
          <Button type="success" size="small" style="margin-right: 5px" @click="examine(row)">审核</Button>
          <Button type="primary" size="small" style="margin-right: 5px" @click="edit(row)">编辑</Button>
          <Button type="error" size="small" @click="remove(row)">删除</Button>
        </template>
      </Table>
      <Page :total="sum" :current="page" style="margin-top:20px;" @on-change="pageChange" />
    </div>
  </div>
</template>

<script>
import { getExpensesPagelist, getAddExpenses } from "../api";
import { changeTime } from "../plugins/time.js";
export default {
  name: "apply",
  data() {
    return {
      columns1: [
        {
          title: "支出时间",
          key: "date"
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
          key: "status"
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
      modal1: false, //弹窗控制
      stime: "0001-01-01", //开始时间
      etime: "", //结束时间
      expensesList: [], //展示列表
      sum: 0, //总数
      page: 1, //当前页码
      submitForm: {
        //添加开支
        date: "",
        money: 0,
        name: "",
        info: ""
      }
    };
  },
  created() {
    this.etime = changeTime(new Date());
    this.submitForm.date = changeTime(new Date());
    getExpensesPagelist({
      pagesize: 10,
      pageid: 1,
      stime: this.stime,
      etime: this.etime,
      allnumber: 0,
      pagenumber: 0
    }).then(data => {
      this.sum = data.data.data.allnumber;
      this.expensesList = data.data.data.all_xyz_expenses || [];
    });
  },
  methods: {
    timeChange1(value) {
      //开始时间
      this.stime = value;
    },
    timeChange2(value) {
      //结束时间
      this.etime = value;
    },
    applyTimeChange(value) {
      //添加开支时间回调
      this.submitForm.date = value;
    },
    pageChange(value) {
      //页码改变回调
      this.page = value;
      getExpensesPagelist({
        pagesize: 10,
        pageid: this.page,
        stime: this.stime,
        etime: this.etime,
        allnumber: 0,
        pagenumber: 0
      }).then(data => {
        this.sum = data.data.data.allnumber;
        this.expensesList = data.data.data.all_xyz_expenses || [];
      });
    },
    searchBtn() {
      //查询按钮
      this.page = 1;
      getExpensesPagelist({
        pagesize: 10,
        pageid: 1,
        stime: this.stime,
        etime: this.etime,
        allnumber: 0,
        pagenumber: 0
      }).then(data => {
        this.sum = data.data.data.allnumber;
        this.expensesList = data.data.data.all_xyz_expenses || [];
      });
    },
    addSubmit() {
      //开支添加提交
      getAddExpenses(this.submitForm).then(data => {
        if (data.data.message == "添加成功") {
          this.$Message.success("添加成功");
          getExpensesPagelist({
            pagesize: 10,
            pageid: this.page,
            stime: this.stime,
            etime: this.etime,
            allnumber: 0,
            pagenumber: 0
          }).then(data => {
            this.sum = data.data.data.allnumber;
            this.expensesList = data.data.data.all_xyz_expenses || [];
          });
        }
      });
    }
  }
};
</script>

<style lang="less" scoped>
#apply {
  padding: 20px;
}
</style>