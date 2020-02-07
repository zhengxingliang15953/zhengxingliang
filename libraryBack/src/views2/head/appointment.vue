<template>
    <div id="appointment">
        <RadioGroup v-model="value1" style="margin-top:5px;padding-left:5px;margin-bottom:5px;">
        <Radio label="1">
            <Icon type="logo-apple"></Icon>
            <span>所有</span>
        </Radio>
        <Radio label="2">
            <Icon type="logo-android"></Icon>
            <span>已预约未借阅</span>
        </Radio>
        <Radio label="3">
            <Icon type="logo-windows"></Icon>
            <span>已借阅</span>
        </Radio>
        <Radio label="4">
            <Icon type="logo-windows"></Icon>
            <span>预约过期</span>
        </Radio>
        <Radio label="5">
            <Icon type="logo-windows"></Icon>
            <span>借阅过期</span>
        </Radio>
    </RadioGroup>
        <List border>
            <ListItem v-for="(item,index) in listItem" :key="index">
              <span>{{item.title}}</span>
              <span>索书号:{{item.bno}}</span>
              <span>借阅人:{{item.sno}}{{item.name}}</span>
              <span>预约时间:{{item.appointTime}}</span>
              <span>借阅时间:{{item.lendTime}}</span>
              <span>归还时间:{{item.backTime}}</span>
              <span v-if="item.status==2">借阅</span>
              <span v-if="item.status==3">归还</span>
            </ListItem>
        </List>
    </div>
</template>

<script>
export default {
    name:'appointment',
    data(){
        return{
            value1:'1',
            listItem:[
                {title:'JAVA实践教程',bno:'123',sno:'2018284129',name:'郑兴樑',appointTime:'2018',lendTime:'2018',backTime:'2018',status:'2'},
                {title:'JAVA实践教程',bno:'123',sno:'2018284129',name:'郑兴樑',appointTime:'2018',lendTime:'2018',backTime:'2018',status:'3'},            
                ]
        }
    }
}
</script>

<style lang="less" scoped>
span{
    width:15%;
}
span:nth-child(7){
    color:#1E90FF;
}
span:nth-child(7):hover{
    cursor: pointer;
}
</style>