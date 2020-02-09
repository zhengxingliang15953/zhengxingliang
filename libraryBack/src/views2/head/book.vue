<template>
    <div id="book">
        <Input
      v-model="value1"
      search
      enter-button
      placeholder="请输入ISBN搜索"
      style="width:300px"
      @on-search="search"
    />
    <Row type="flex" justify="center" v-for="(item,index) in bookList" :key="index" style="width:95%;margin:10px auto;">
      <Col :lg="5">
            <img :src="item.bookUrl" width="90px" height="100px" alt="错误,请检查链接" />
          </Col>
          <Col :lg="19">
            <p>
              <span>{{item.name}}</span>
              <span style="color:#8B3A3A;">
                <Poptip trigger="hover" title="馆藏位置" :content="item.address">馆藏副本{{item.number}},已预约{{item.appNumber}},已借阅{{item.readNumber}}</Poptip>
              </span>
            </p>
            <p>
              <span>作者:{{item.author}}</span>
              <span>ISBN:{{item.isbn}}</span>
              <Button type="primary" >编辑</Button>
            </p>
            <p>
              <span>出版社:{{item.press}}</span>
              <span>年份:{{item.data}}</span>
            </p>
            <p>
              <span>
                格式:BK
                <Icon type="md-cube" />
              </span>
              <span>电子书链接</span>
              <Button type="error" >删除</Button>
            </p>
          </Col>
          <Col :lg="24" style="margin-top:2px;"><hr></Col>
    </Row>
    </div>
</template>

<script>
import {getAllBook} from '../../api';
export default {
    name:'book',
    data(){
        return{
            value1:'',
            bookList:[],//图书列表
        }
    },
    created(){
        getAllBook().then(data=>{
            this.bookList=data.data;
        })
    },
    methods:{
        search(){//搜索

        }
    }
}
</script>

<style lang="less" scoped>
span {
  display: inline-block;
  width: 40%;
  color: #483d8b;
  font-size: 14px;
}
</style>