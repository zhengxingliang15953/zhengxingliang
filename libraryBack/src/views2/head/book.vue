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
          <Col :lg="12" v-if="modal2=='添加图书'">
            <FormItem label="ISBN" prop="isbn">
              <Input v-model="formData.isbn" placeholder="请输入ISBN"></Input>
            </FormItem>
          </Col>
          <Col :lg="12" v-if="modal2=='修改图书'">
            <FormItem label="ISBN" prop="isbn">
              <span style="width:100%;">{{formData.isbn}}</span>
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
            <FormItem label="数量" v-if="modal2=='添加图书'">
              <el-input-number
                v-model="formData.bookNumber"
                :min="1"
                :max="10"
                label="描述文字"
                size="small"
              ></el-input-number>
            </FormItem>
            <FormItem label="数量" prop="bookNumber" v-if="modal2=='修改图书'">
              <span>{{formData.bookNumber}}</span>
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

    <Row type="flex" style="padding-top:10px;padding-left:10px;">
      <Col :lg="8">
        <Input
          v-model="value1"
          search
          enter-button
          placeholder="请输入ISBN搜索"
          style="width:300px;"
          @on-search="search"
        />
      </Col>
      <Col :lg="8">
        <Button type="primary" @click="add">添加图书</Button>
      </Col>
      <Col :lg="8">
        <el-pagination
          background
          layout="prev, pager, next"
          :total="sum"
          @current-change="pageChange"
          :current-page="page"
        ></el-pagination>
      </Col>
    </Row>
    <Row
      type="flex"
      justify="center"
      v-for="(item,index) in bookList"
      :key="index"
      style="width:95%;margin:10px auto;"
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
            <el-button
              type="success"
              icon="el-icon-bottom"
              size="mini"
              v-if="item.type==1"
              @click="topBottom(item)"
            >下架</el-button>
            <el-button
              type="info"
              icon="el-icon-top"
              size="mini"
              v-if="item.type==0"
              @click="topBottom(item)"
            >上架</el-button>
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
import {
  getAllBook,
  getAddBook,
  getDeleteBook,
  getUpdateBook,
  getUpdateBookType
} from "../../api";
import { pressData } from "../../components/press.js"; //出版社列表
export default {
  name: "book",
  data() {
    return {
      value1: "", //搜索内容
      bookList: [], //图书列表
      modal1: false,
      modal2: "添加图书", //添加图书or修改图书
      formData: {
        //添加图书表单
        isbn: "",
        bookName: "",
        author: "",
        press: "",
        bookDate: 2005,
        bookNumber: 1,
        bookUrl: "",
        address: ""
      },
      data1: [], //自动填写列表
      sum: 0,
      value2: "", //当前搜索值
      page: 1 //当前页码
    };
  },
  created() {
    getAllBook(this.value2, this.page).then(data => {
      if (data.data[0].msg == "0") {
        this.bookList = [];
        this.sum = 0;
      } else {
        this.bookList = data.data;
        this.sum = this.bookList[0].status;
      }
    });
  },
  methods: {
    handleSearch1(value) {
      //自动填写完整列表
      this.data1 = pressData;
    },
    addSubmit() {
      //添加图书提交
      this.modal2 = "添加图书";
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
              getAllBook(this.value2, this.page).then(data => {
                if (data.data[0].msg == "0") {
                  this.bookList = [];
                  this.sum = 0;
                } else {
                  this.bookList = data.data;
                  this.sum = this.bookList[0].status;
                }
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
      getDeleteBook(value).then(data => {
        if (data.data.status == 0) {
          this.$message.warning(
            "该书已有人预约,您可以先下架，以防止后续有人预约"
          );
        } else {
          this.$confirm("确认删除该通知, 是否继续?", "提示", {
            confirmButtonText: "确定",
            cancelButtonText: "取消",
            type: "warning"
          }).then(() => {
            if (this.bookList.length == 1 && this.page > 1) {
              this.page--;
            }
            getDeleteBook(value).then(() => {
              this.$message({
                type: "success",
                message: "删除成功!"
              });
              getAllBook(this.value2, this.page).then(data => {
                if (data.data[0].msg == "0") {
                  this.bookList = [];
                  this.sum = 0;
                } else {
                  this.bookList = data.data;
                  this.sum = this.bookList[0].status;
                }
              });
            });
          });
        }
      });
    },
    updateBook(data) {
      //修改图书
      this.modal2 = "修改图书";
      this.modal1 = true;
      this.formData = data;
    },
    updateBookSubmit() {
      //修改图书提交
      this.modal1 = false;
      getUpdateBook(this.formData).then(data => {
        if (data.data.msg == "修改成功") {
          this.$message.success("修改成功");
          getAllBook(this.value2, this.page).then(data => {
            if (data.data[0].msg == "0") {
              this.bookList = [];
              this.sum = 0;
            } else {
              this.bookList = data.data;
              this.sum = this.bookList[0].status;
            }
          });
        } else {
          this.$message.error("修改失败");
        }
      });
    },
    add() {
      //添加图书
      this.modal1 = true;
      this.modal2 = "添加图书";
      this.formData.isbn = "";
      this.formData.bookName = "";
      this.formData.author = "";
      this.formData.press = "";
      this.formData.bookNumber = 1;
      this.formData.bookUrl = "";
      this.formData.address = "";
    },
    pageChange(value) {
      //页码回调
      this.page = value;
      getAllBook(this.value2, this.page).then(data => {
        if (data.data[0].msg == "0") {
          this.bookList = [];
          this.sum = 0;
        } else {
          this.bookList = data.data;
          this.sum = this.bookList[0].status;
        }
      });
    },
    search() {
      //搜索
      this.value2 = this.value1;
      this.page = 1;
      getAllBook(this.value2, this.page).then(data => {
        this.bookList = data.data;
        this.sum = this.bookList[0].status;
      });
    },
    topBottom(value) {
      //上架下架
      let a = value.type;
      getUpdateBookType(value.isbn, value.type).then(() => {
        if (a == 1) {
          this.$message.success("下架成功");
        } else {
          this.$message.success("上架成功");
        }
        getAllBook(this.value2, this.page).then(data => {
          this.bookList = data.data;
          this.sum = this.bookList[0].status;
        });
      });
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