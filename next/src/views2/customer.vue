<template>
  <div id="customer">
      <!--添加弹窗-->
      <Modal
        v-model="modal1"
        title="添加客户"
        ok-text="添加"
        @on-ok="addSubmit"
        >
        <div class="modal-item">
            客户名称:<Input v-model="value" placeholder="请输入客户名称" style="width: 70%;" />
        </div>
        <div class="modal-item">
            客户地址:<Input v-model="value" placeholder="请输入客户地址" style="width: 70%;" />
        </div>
        <div class="modal-item">
            联系人:<Input v-model="value" placeholder="请输入联系人" style="width: 70%;" />
        </div>
        <div class="modal-item">
            客户电话:<Input v-model="value" placeholder="请输入客户电话" style="width: 70%;" />
        </div>
        <div class="modal-item">
            客户微信:<Input v-model="value" placeholder="请输入客户微信" style="width: 70%;" />
        </div>
        <div class="modal-item">
            开票信息:<Input v-model="value17" show-word-limit type="textarea" placeholder="请输入开票信息" style="width:70%;" />
        </div>
    </Modal>
    <!--添加弹窗-->

    <div class="panel-head">客户列表</div>
    <div class="panel-body">
      <div class="panel-body-search">
        <Input v-model="customerSearch1" placeholder="请输入客户名称" style="width: 250px;" />
        <Button type="info" class="searchBtn" @click="searchBtn">查询</Button>
        <Button type="primary" class="searchBtn" @click="modal1=true">添加客户</Button>
      </div>
      <Table :columns="columns1" :data="data1">
        <template slot-scope="{ row, index }" slot="action">
          <Button type="primary" size="small" style="margin-right: 5px" @click="edit(row)">编辑</Button>
          <Button type="error" size="small" @click="remove(row)">删除</Button>
        </template>
      </Table>
      <Page :total="sum" :current="page" style="margin-top:20px;" @on-change="pageChange" />
      <span class="sum-footer">总共{{sum}}条记录</span>
    </div>
  </div>
</template>

<script>
export default {
  name: "apply",
  data() {
    return {
      columns1: [//表头
        {
          title: "客户名称",
          key: "customer"
        },
        {
          title: "业务内用",
          key: "bussiness"
        },
        {
          title: "成交金额",
          key: "money"
        },
        {
          title: "制作成本",
          key: "cost"
        },
        {
          title: "安装费用",
          key: "installMoney"
        },
        {
          title: "安装人员",
          key: "installName"
        },
        {
          title: "已收款项",
          key: "installName"
        },
        {
          title: "日期",
          key: "date"
        },
        {
          title: "订单状态",
          key: "status"
        },
        {
          title: "操作",
          slot: "action",
          width: 200,
          align: "center"
        }
      ],
      data1: [
        
      ] ,//开支列表
      modal1:false,//弹窗控制
      sum:0,//总数
      page:1,//当前页码
      customerSearch1:'',//客户名称检索v-model
      customerSearch2:'',//实际查询客户名称
    };
  },
  created() {

  },
  methods:{
      addSubmit(){//添加客户提交

      },
      pageChange(value){//页码改变回调
        this.page=value;
      },
      searchBtn(){//查询
        this.customerSearch2=this.customerSearch1;
      }
  }
};
</script>

<style lang="less" scoped>
#customer {
  padding: 20px;
}
</style>