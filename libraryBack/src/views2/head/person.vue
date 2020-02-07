<template>
    <div id="person">
        <Row type="flex" justify="center" style="width:60%;margin:100px auto;">
          <Col :lg="8">
            <span>姓名:张三</span>
          </Col>
          <Col :lg="8">
            <span>年龄:22</span>
          </Col>  
          <Col :lg="8">
            <span>管理员账号:15953871</span>
          </Col>  
          <Col :lg="8">
            <span>开户时间:2018</span>
          </Col>
          <Col :lg="8">
            <span>联系方式:15314652021</span>
          </Col>    
          <Col :lg="8">
            <span>家庭住址:浙江省</span>
          </Col>  
        </Row>
    </div>
</template>

<script>
export default {
    name:'index',
    data(){
        return{

        }
    }
}
</script>

<style lang="less" scoped>
span{
    font-size: 15px;
}
</style>