<template>
    <div id="studnt">
        <Input v-model="value1" search enter-button placeholder="请输入学号搜索" style="width:300px" @on-search="search"/>
        <Table stripe :columns="columns1" :data="data1"></Table>
    </div>
</template>

<script>
export default {
    name:'student',
    data(){
        return{
            columns1:[
                {title:'姓名',key:'name'},
                {title:'学号',key:'sno'},
                {title:'联系方式',key:'tel'},
                {title:'学院',key:'school'},
            ],
            data1:[
                {name:'郑兴樑',sno:'2018284129',tel:'15314652021',school:'求真学院'},
                {name:'郑兴樑',sno:'2018284129',tel:'15314652021',school:'求真学院'},
                {name:'郑兴樑',sno:'2018284129',tel:'15314652021',school:'求真学院'},
            ],
            value1:'',
        }
    },
    methods:{
        search(){//搜索
            alert(this.value1);
        }
    }
}
</script>

<style lang="less" scoped>

</style>