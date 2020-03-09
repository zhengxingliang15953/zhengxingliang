const {resolve}=require('path');
module.exports={
    /**
     * 模式
     */
    mode:'development',//开发模式
    /**
     * 入口文件
     */
    entry:'./src/main.js',
    /**
     * 出口文件
     */
    output:{
        filename:'index.js',//输出文件名
        //__dirname代表当前文件的目录绝对路径
        path:resolve(__dirname,'build'),
    },
    /**
     * loader配置
     */
    module:{
        rules:[
            {test:/\.css$/,use:['style-loader','css-loader']},
            {test:/\.less$/,use:['style-loader','css-loader','less-loader']},
        ]
    },
    /**
     * 插件
     */
    plugins:[]
}