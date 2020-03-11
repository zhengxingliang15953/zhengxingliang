const {resolve}=require('path');
const HtmlWebpackPlugins = require('html-webpack-plugin');//html-webpack插件
const webpack=require('webpack');//访问内置的插件


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
        filename:'js/index.js',//输出文件名
        //__dirname代表当前文件的目录绝对路径
        path:resolve(__dirname,'dist'),
    },
    /**
     * loader配置
     */
    module:{
        rules:[
            {test:/\.css$/,use:['style-loader','css-loader']},
            {test:/\.less$/,use:['style-loader','css-loader','less-loader']},
            //图片插件只使用一个loader,下载url-loader和file-loader
            {test:/\.(jpg|png|jpeg|gif)$/,loader:'url-loader',options:{
                limit:8*1024,//图片小于8kb,会被base64处理，减少请求数量，减轻服务器压力
                esModule:false,//关闭url-loader的es6模块化
                name:'[hash:10].[ext]',//去原来图片名称的前10位，扩展名不变
                outputPath:'image',//输出资源位置
            }},
            /**处理html中的图片 */
            {test:/\.html$/,loader:'html-loader'},
            /**处理打包其他资源 */
            {exclude:/\.(css|js|html|less|jpg|png|jpeg|gif)$/,loader:'file-loader',options:{
                name:'[hash:10].[ext]',
                outputPath:'media',
            }},
        ]
    },
    /**
     * 插件
     */
    plugins:[
        /**默认会创建一个index.html空文件，引入打包输出的所有资源 */
        new HtmlWebpackPlugins,
        new webpack.optimeze.UglifyJsPlugin(),
    ],
    /**启动指令webpack-dev-server */
    devServer:{
        contentBase:resolve(__dirname,'dist'),//项目路径
        /**启动gzip压缩 */
        compress:true,
        port:8080,//端口号
        open:true,//自动打开浏览器
    }
}