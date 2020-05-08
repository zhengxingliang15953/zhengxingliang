<template>
  <div id="lend">
    <!--借阅方式-->
    <Modal v-model="lendMethods" title="请选择借阅方式" width="400px" @on-ok="appointmentSubmit">
      <RadioGroup v-model="border" @on-change="ridioChange">
        <Radio label="图书自提" border></Radio>
        <Radio label="送书上门" border v-if="bookDoor"></Radio>
      </RadioGroup>
    </Modal>
    <!--借阅方式-->
    <div class="el-menu-demo header">
      <img src="../../assets/logo.png" height="100%" alt />
      <el-input placeholder="请输入检索内容" style="width:40%;margin:40px auto" v-model="searchItem">
        <el-select slot="prepend" placeholder="请选择" v-model="select" style="width:100px;">
          <el-option label="题名(精)" value="1"></el-option>
          <el-option label="题名(糊)" value="2"></el-option>
          <el-option label="著者" value="3"></el-option>
          <el-option label="ISBN" value="4"></el-option>
        </el-select>
        <el-button
          slot="append"
          icon="el-icon-search"
          style="background-color:orange;color:white"
          @click="searchBtn"
        ></el-button>
      </el-input>
    </div>
    <br />
    <Row type="flex" justify="center" style="min-height:600px;">
      <Col :lg="1"></Col>
      <Col :lg="17">
        <span style="width:80%;background:#5d8fb6;">检索记录({{count}}条)</span>
        <Page
          :current="page"
          :total="sum"
          simple
          @on-change="pageChange"
          style="display:inline-block;"
        />
        <div style="height:350px;line-height:350px;font-size:40px" v-if="count==0">
          <Row type="flex">
            <Col :lg="8">
              <img src="../../assets/baoqian.jpg" width="100%">
            </Col>
            <Col :lg="16">
             抱歉没有检索到相关图书...
            </Col>
          </Row>
        </div>
        <Row
          type="flex"
          v-for="(item,index) in searchBookList"
          :key="index"
          style="border-top:1px solid #B5B5B5;margin-top:2px;"
        >
          <Col :lg="5">
            <img :src="item.bookUrl" width="90px" height="100px" alt="错误,请检查链接" />
          </Col>
          <Col :lg="19">
            <p>
              <span style="font-size:15px;color:black;">{{item.bookName}}</span>
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
              <Button type="primary" @click="appointmentBtn(item)" v-if="item.type==1">预约图书</Button>
              <el-button type="info" plain disabled="true" v-if="item.type==0">已下架</el-button>
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
        </Row>
      </Col>
      <Col :lg="4" style="margin-left:10px;">
        <div style="border:1px solid  #5d8fb6;margin-bottom:10px;">
          <p class="headBar">读者信息>></p>
          <p class="headBarItem">您好!{{user}}用户</p>
        </div>
        <div style="border:1px solid  #5d8fb6;margin-bottom:10px">
          <p class="headBar">当前检索>></p>
          <p class="headBarItem">{{select | selectFil}}=({{searchItemShow}})</p>
        </div>
        <div style="border:1px solid  #5d8fb6;margin-bottom:10px">
          <p class="headBar">主题词>></p>
          <p class="headBarItem" style="font-size:20px;">计算机、临床医学、生物、物理、历史、数学、英语、中医药、机械、电气自动化、护理、光电、PLC、电子、船舶、制药、物联网、现代教育、日语、小语种...</p>
        </div>
      </Col>
      <Col :lg="1"></Col>
    </Row>
    <div class="footer">
      湖ICP备2018284129 湖州师范学院图书馆
    </div>
  </div>
</template>

<script>
import {
  getAllBook,
  getIsbnBook,
  getBookName1,
  getAuthorBook,
  getBookName2,
  getIndexStudent,
  getAppointment,
  getAllConfig
} from "../../api";
export default {
  name: "lend",
  data() {
    return {
      select: "",
      searchItem: "",
      searchBookList: [], //检索列表
      page: 1, //当前页码
      sum: 0, //检索总数
      user: "匿名", //当前登录学号
      searchItemShow: "", //当前检索
      studentName: "", //登录姓名
      lendMethods: false, //借阅方式绑定
      border: "图书自提",
      bookDoor: true ,//送书上门有没有
      appItem:{},//具体提交书本信息
    };
  },
  created() {
    this.select = this.$route.query.select || "1";
    this.searchItem = this.$route.query.searchItem || "";
    this.searchItemShow = this.searchItem;
    getIndexStudent().then(data => {
      if (data.data.msg == 0||!window.sessionStorage.getItem('token')) {
        this.user = "匿名";
      } else {
        this.user = data.data.sno;
        this.studentName = data.data.name;
      }
    });
    if (this.searchItem == "") {
      getAllBook(this.searchItem, this.page).then(data => {
        this.searchBookList = data.data;
        this.sum = this.searchBookList[0].status;
      });
    } else {
      this.startChanceBook();
    }
    getAllConfig().then(data => {
      this.bookDoor = data.data.riderSwitch == 1 ? true : false;
    });
  },
  methods: {
    appointmentBtn(value) {
      //预约按钮
      if (!window.sessionStorage.getItem("token")) {
        this.$message.warning("请先登录");
      } else {
        this.lendMethods = true;
        this.appItem=value;
      }
    },
    pageChange(value) {
      //页码改变回调
      this.page = value;
      if (this.searchItemShow == "") {
        getAllBook(this.searchItemShow, this.page).then(data => {
          this.searchBookList = data.data;
          this.sum = this.searchBookList[0].status;
        });
      } else {
        this.startChanceBook();
      }
    },
    startChanceBook() {
      //检索4者选择
      switch (this.select) {
        case "1": {
          //题目(精)
          getBookName1(this.searchItemShow, this.page).then(data => {
            this.searchBookList = data.data;
            this.sum = this.searchBookList[0].status || 0;
          });
          break;
        }
        case "2": {
          //题目(模糊)
          getBookName2(this.searchItem, this.page).then(data => {
            this.searchBookList = data.data;
            this.sum = this.searchBookList[0].status || 0;
          });
          break;
        }
        case "3": {
          //著者
          getAuthorBook(this.searchItem, this.page).then(data => {
            this.searchBookList = data.data;
            this.sum = this.searchBookList[0].status || 0;
          });
          break;
        }
        case "4": {
          //ISBN
          this.searchBookList = [];
          getAllBook(this.searchItem, this.page).then(data => {
            this.searchBookList = data.data;
            this.sum = this.searchBookList[0].status || 0;
          });
          break;
        }
      }
    },
    searchBtn() {
      //当前页面检索
      this.searchItemShow = this.searchItem;
      this.page = 1;
      if (this.searchItem == "") {
        getAllBook(this.searchItem, this.page).then(data => {
          this.searchBookList = data.data;
          this.sum = this.searchBookList[0].status;
        });
      } else {
        this.startChanceBook();
      }
    },
    ridioChange(value) {
      //单选按钮选择回调
      this.border = value;
    },
    appointmentSubmit() {
      //预约提交
      var appid = `${this.appItem.isbn}${this.user}${new Date().getTime().toString()}`;
      var apptime = this.timeFilter(new Date().toString());
      getAppointment(appid,this.appItem.bookName,this.appItem.isbn,this.studentName,this.user,apptime,this.border).then(data=>{
        switch(data.data.msg){
          case '0':this.$message.warning('你已经预约该书');break;
          case '1':this.$message.warning('排队人数过多不可预约');break;
          case '2':this.$message.success('预约排队成功');break;
          case '3':this.$message.success('预约成功');break;
          case '4':this.$message.warning('该书已下架');break;
          case '5':this.$message.warning('送书上门功能已关闭');break;
        }
      });
    },
    timeFilter(value) {
      let list = [];
      let str = "";
      list = value.split(" ");
      switch (list[1]) {
        case "Jan":
          str = "01";
          break;
        case "Feb":
          str = "02";
          break;
        case "Mar":
          str = "03";
          break;
        case "Apr":
          str = "04";
          break;
        case "May":
          str = "05";
          break;
        case "Jun":
          str = "06";
          break;
        case "Jul":
          str = "07";
          break;
        case "Aug":
          str = "08";
          break;
        case "Sept":
          str = "09";
          break;
        case "Oct":
          str = "10";
          break;
        case "Nov":
          str = "11";
          break;
        case "Dec":
          str = "12";
          break;
      }
      return `${list[3]}-${str}-${str}`;
    }
  },
  filters: {
    selectFil(value) {
      //4者显示过滤器
      switch (value) {
        case "1":
          return "题名(精)";
          break;
        case "2":
          return "题名(糊)";
          break;
        case "3":
          return "著者";
          break;
        case "4":
          return "ISBN";
          break;
      }
    }
  },
  computed: {
    count() {
      if (this.searchBookList.length == 0) {
        return 0;
      } else {
        return this.sum;
      }
    }
  },
};
</script>

<style lang="less" scoped>
.header {
  display: flex;
  height: 130px;
}
span {
  display: inline-block;
  width: 40%;
  color: #483d8b;
  font-size: 14px;
}
.headBar {
  background-color: #5d8fb6;
  height: 25px;
  font-size: 14px;
  line-height: 25px;
  color: black;
  padding-left: 3px;
  span {
    width: 70%;
    height: 100%;
    color: black;
  }
}
.headBarItem {
  font-size: 15px;
  padding: 2px;
}
</style>