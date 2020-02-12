<template>
  <div id="book">
    <!--添加图书弹出框-->
    <Modal title="添加图书" v-model="modal1" :mask-closable="false" footer-hide>
      <Form ref="formValidate" :model="formData" :label-width="60">
        <Row type="flex">
          <Col :lg="12">
            <FormItem label="题名" prop="bookName">
              <Input v-model="formData.bookName" placeholder="请输入题名"></Input>
            </FormItem>
          </Col>
          <Col :lg="12">
            <FormItem label="ISBN" prop="isbn" v-show="modal2=='添加图书'">
              <Input v-model="formData.isbn" placeholder="请输入ISBN"></Input>
            </FormItem>
            <FormItem label="ISBN" prop="isbn" v-show="modal2=='修改图书'">
              <span>{{formData.isbn}}</span>
            </FormItem>
          </Col>
          <Col :lg="12">
            <FormItem label="作者" prop="author">
              <Input v-model="formData.author" placeholder="请输入作者名"></Input>
            </FormItem>
          </Col>
          <Col :lg="12">
            <FormItem label="出版社">
              <AutoComplete
                v-model="formData.press"
                :data="data1"
                placeholder="请输入出版社名称"
                @on-search="handleSearch1"
              ></AutoComplete>
            </FormItem>
          </Col>
          <Col :lg="12">
            <FormItem label="日期">
              <Select v-model="formData.bookDate" placeholder="请选择日期">
                <Option
                  :value="item"
                  v-for="(item,index) in 2020"
                  :key="index"
                  v-show="item>1989"
                >{{item}}</Option>
              </Select>
            </FormItem>
          </Col>
          <Col :lg="12">
            <FormItem label="数量">
              <el-input-number
                v-model="formData.bookNumber"
                :min="1"
                :max="10"
                label="描述文字"
                size="small"
              ></el-input-number>
            </FormItem>
          </Col>
        </Row>

        <FormItem label="位置">
          <Input v-model="formData.address" placeholder="请输入馆藏位置"></Input>
        </FormItem>
        <FormItem label="图片地址" prop="bookUrl">
          <Input
            v-model="formData.bookUrl"
            type="textarea"
            :autosize="{minRows: 2,maxRows: 405}"
            placeholder="请输入封面图片地址"
          ></Input>
        </FormItem>
        <FormItem v-if="modal2=='添加图书'">
          <Button type="primary" long @click="addSubmit">添加图书</Button>
        </FormItem>
        <FormItem v-if="modal2=='修改图书'">
          <Button type="primary" long @click="updateBookSubmit">修改图书</Button>
        </FormItem>
      </Form>
    </Modal>
    <!--添加图书弹出框-->

    <Input
      v-model="value1"
      search
      enter-button
      placeholder="请输入ISBN搜索"
      style="width:300px;"
      @on-search="search"
    />
    <p style="text-align:right;padding-right:10px;">
      <a href="#" @click="modal1=true">添加图书</a>
    </p>
    <Row
      type="flex"
      justify="center"
      v-for="(item,index) in bookList"
      :key="index"
      style="width:95%;margin:10px auto;"
      v-show="value1==''||value1==item.isbn"
    >
      <Col :lg="5">
        <img :src="item.bookUrl" width="90px" height="100px" alt="错误,请检查链接" />
      </Col>
      <Col :lg="19">
        <p>
          <span>{{item.bookName}}</span>
          <span style="color:#8B3A3A;">
            <Poptip
              trigger="hover"
              title="馆藏位置"
              :content="item.address"
            >馆藏副本{{item.bookNumber}},已预约{{item.appNumber}},已借阅{{item.readNumber}}</Poptip>
          </span>
        </p>
        <p>
          <span>作者:{{item.author}}</span>
          <span>ISBN:{{item.isbn}}</span>
          <Button type="primary" @click="updateBook(item)">编辑</Button>
          <Button type="error" style="margin-left:4px" @click="deleteBook(item.isbn)">删除</Button>
        </p>
        <p>
          <span>出版社:{{item.press}}</span>
          <span>年份:{{item.bookDate}}</span>
        </p>
        <p>
          <span>
            格式:BK
            <Icon type="md-cube" />
          </span>
          <span>电子书链接</span>
        </p>
      </Col>
      <Col :lg="24" style="margin-top:2px;">
        <hr />
      </Col>
    </Row>
  </div>
</template>

<script>
import { getAllBook, getAddBook, getDeleteBook ,getUpdateBook} from "../../api";
import { pressData } from "../../components/press.js"; //出版社列表
export default {
  name: "book",
  data() {
    return {
      value1: "", //搜索内容
      bookList: [], //图书列表
      modal1: false,
      modal2:'添加图书',//添加图书or修改图书
      formData: {
        //添加图书表单
        isbn: "",
        bookName: "",
        author: "",
        press: "",
        bookDate: 2020,
        bookNumber: 1,
        bookUrl: "",
        address: ""
      },
      data1: [] //搜索源
    };
  },
  created() {
    getAllBook().then(data => {
      this.bookList = data.data;
    });
  },
  methods: {
    handleSearch1(value) {
      this.data1 = pressData;
    },
    addSubmit() {
      //添加图书提交
      this.modal2='添加图书';
      if (
        this.formData.isbn == "" ||
        this.formData.name == "" ||
        this.formData.author == "" ||
        this.formData.address == ""
      ) {
        this.$message.warning("信息请填写完整");
      } else {
        getAddBook(this.formData)
          .then(data => {
            if (data.data.msg == "添加成功") {
              this.$message.success("添加成功");
              this.modal1 = false;
              getAllBook().then(data => {
                this.bookList = data.data;
              });
            } else {
              this.$message.error("改ISBN已存在,请检查");
            }
          })
          .catch(() => {
            this.$message.warning("添加失败");
          });
      }
    },
    deleteBook(value) {
      //删除图书
      this.$confirm("确认删除该通知, 是否继续?", "提示", {
        confirmButtonText: "确定",
        cancelButtonText: "取消",
        type: "warning"
      }).then(() => {
        getDeleteBook(value).then(() => {
          this.$message({
            type: "success",
            message: "删除成功!"
          });
          getAllBook().then(data => {
            this.bookList = data.data;
          });
        });
      });
    },
    updateBook(data){//修改图书
      this.modal2='修改图书';
      this.modal1=true;
      this.formData=data;
    },
    updateBookSubmit(){//修改图书提交

    }
  },
  computed: {}
};
</script>

<style lang="less" scoped>
span {
  display: inline-block;
  width: 40%;
  color: #483d8b;
  font-size: 14px;
}
a {
  font-size: 17px;
}
</style>