<template>
  <div id="customer">
      <!--添加弹窗-->
      <Modal
        v-model="modal1"
        title="添加安装人员"
        ok-text="添加"
        @on-ok="addSubmit">
        <div class="modal-item">
            联系人:<Input v-model="value" placeholder="请输入安装人员" style="width: 70%;" />
        </div>
        <div class="modal-item">
            电话:<Input v-model="value" placeholder="请输入安装人员电话" style="width: 70%;" />
        </div>
        <div class="modal-item">
            微信:<Input v-model="value" placeholder="请输入安装人员微信" style="width: 70%;" />
        </div>
        <div class="modal-item">
            付款账号:<Input v-model="value" placeholder="请输入付款账号" style="width: 70%;" />
        </div>
    </Modal>
    <!--添加弹窗-->

    <div class="panel-head">安装人员管理</div>
    <div class="panel-body">
      <div class="panel-body-search">
        <!-- <Input v-model="value" placeholder="请输入客户名称" style="width: 250px;" /> -->
        <!-- <Button type="info" class="searchBtn">查询</Button> -->
        <Button type="primary" class="searchBtn" @click="modal1=true">添加安装人员</Button>
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
          title: "序号",
          key: "id"
        },
        {
          title: "联系人",
          key: "name"
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
          title: "付款账号",
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
        
      ] ,//开支列表
      modal1:false,//弹窗控制
      sum:0,//总数
      page:1,//当前页码
    };
  },
  created() {},
  methods:{
      addSubmit(){//添加安装人员

      },
      pageChange(value){//页码改编回调
        this.page=value;
      }
  }
};
</script>

<style lang="less" scoped>
#customer {
  padding: 20px;
}
</style>