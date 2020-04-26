<template>
  <div id="customer">
      <!--添加弹窗-->
      <Modal
        v-model="modal1"
        title="添加客户"
        ok-text="添加"
        @on-ok="ok"
        @on-cancel="cancel">
        <div class="modal-item">
            客户名称:<Input v-model="value" placeholder="请输入支出金额" style="width: 70%;" />
        </div>
        <div class="modal-item">
            客户地址:<Input v-model="value" placeholder="请输入支出人" style="width: 70%;" />
        </div>
        <div class="modal-item">
            联系人:<Input v-model="value" placeholder="请输入支出人" style="width: 70%;" />
        </div>
        <div class="modal-item">
            客户电话:<Input v-model="value" placeholder="请输入支出人" style="width: 70%;" />
        </div>
        <div class="modal-item">
            客户微信:<Input v-model="value" placeholder="请输入支出人" style="width: 70%;" />
        </div>
        <div class="modal-item">
            开票信息:<Input v-model="value17" maxlength="100" show-word-limit type="textarea" placeholder="请输入支出信息" style="width:70%;" />
        </div>
    </Modal>
    <!--添加弹窗-->

    <div class="panel-head">客户列表</div>
    <div class="panel-body">
      <div class="panel-body-search">
        <Input v-model="value" placeholder="请输入客户名称" style="width: 250px;" />
        <Button type="info" class="searchBtn">查询</Button>
        <Button type="primary" class="searchBtn" @click="modal1=true">添加客户</Button>
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
          title: "名称",
          key: "customer"
        },
        {
          title: "联系人",
          key: "name"
        },
        {
          title: "地址",
          key: "address"
        },
        {
          title: "电话",
          key: "tel"
        },
        {
          title: "微信",
          key: "weixin"
        },
        {
          title: "开票信息",
          key: "info"
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
          
        }
      ] ,//开支列表
      modal1:false,//弹窗控制
    };
  },
  created() {},
  methods:{
      
  }
};
</script>

<style lang="less" scoped>
#customer {
  padding: 20px;
}
</style>