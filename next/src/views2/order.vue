<template>
  <div id="apply">
      <!--添加弹窗-->
      <Modal
        v-model="modal1"
        title="添加订单"
        ok-text="添加"
        @on-ok="ok"
        @on-cancel="cancel">
        <div class="modal-item">
            支出时间:<DatePicker type="date" placeholder="请选择支出时间" style="width:70%;"></DatePicker>
        </div>
        <div class="modal-item">
            支出金额:<Input v-model="value" placeholder="请输入支出金额" style="width: 70%;" />
        </div>
        <div class="modal-item">
            支出人员:<Input v-model="value" placeholder="请输入支出人" style="width: 70%;" />
        </div>
        <div class="modal-item">
            支出信息:<Input v-model="value17" maxlength="100" show-word-limit type="textarea" placeholder="请输入支出信息" style="width:70%;" />
        </div>
    </Modal>
    <!--添加弹窗-->

    <div class="panel-head">订单管理</div>
    <div class="panel-body">
      <div class="panel-body-search">
        <DatePicker type="date" placeholder="请选择查询开始时间" style="width: 200px"></DatePicker>至
        <DatePicker type="date" placeholder="请选择查询结束时间" style="width: 200px"></DatePicker>
        <Button type="info" class="searchBtn">查询</Button>
        <Button type="primary" class="searchBtn" @click="modal1=true">添加订单</Button>
      </div>
      <Table :columns="columns1" :data="data1">
        <template slot-scope="{ row, index }" slot="action">
          <Button type="primary" size="small" style="margin-right: 5px" @click="edit(row)">编辑</Button>
          <Button type="error" size="small" @click="remove(row)">删除</Button>
        </template>
      </Table>

    </div>
  </div>
</template>

<script>
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
        {
          time: "2020",
          info: "niha",
          money: "123",
          name: "郑兴樑",
          type: "通过",
          result: "通过",
          people: "1"
        }
      ] ,//开支列表
      modal1:false,//弹窗控制
    };
  },
  created() {},
  methods:{
      examine(value){
          console.log(value);
      }
  }
};
</script>

<style lang="less" scoped>
#apply {
  padding: 20px;
}
</style>