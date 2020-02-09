<template>
  <div id="studnt">
    <Input
      v-model="value1"
      search
      enter-button
      placeholder="请输入学号搜索"
      style="width:300px"
      @on-search="search"
    />
    <Table stripe :columns="columns1" :data="studentList"></Table>
  </div>
</template>

<script>
import { getAllStudent } from "../../api";
export default {
  name: "student",
  data() {
    return {
      columns1: [
        { title: "学号", key: "sno" },
        { title: "姓名", key: "name" },
        { title: "联系方式", key: "tel" },
        { title: "专业", key: "marjor" },
        { title: "学院", key: "school" },
        { title: "身份证号码", key: "idCard" },
        { title: "地址", key: "address" }
      ],
      data1: [], //学生列表
      value1: "", //搜索值
      modal1: false
    };
  },
  created() {
    getAllStudent().then(data => {
      this.data1 = data.data;
    });
  },
  methods: {
    search() {
      //搜索
      this.modal1 = true;
    }
  },
  computed: {
    studentList() {
      if (this.value1 == "") {
        this.modal1 = false;
        return this.data1;
      } else if(this.modal1==true){
        for (let i = 0; i < this.data1.length; i++) {
          if (this.value1 == this.data1[i].sno) {
            return [this.data1[i]];
          }
        }
        return [];
      }else{
          return this.data1;
      }
    }
  }
};
</script>

<style lang="less" scoped>
</style>