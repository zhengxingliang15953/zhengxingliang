const CompressionPlugin = require("compression-webpack-plugin");
const isProduction = process.env.NODE_ENV === "production"; // 是否是生产环境

module.exports = {
  // html获取静态文件路径,true 打包,false 开发
  publicPath: isProduction ? "./" : "/",

  // 生产源映射
  productionSourceMap: false,


  // 打包的静态资源目录
  assetsDir: "./assets",

  devServer: {
    // gzip
    compress: true,

    // h5 history
    historyApiFallback: true,
    proxy: {
        '/': {
            target: 'http://192.168.0.113:7776',
            changeOrigin: true
        }
    }
  },

  configureWebpack(config) {
    // 生产环境
    if (isProduction) {
      return {
        plugins: [
          // 添加 gzip
          new CompressionPlugin({
            test: /\.js$|\.html$|\.css/, // 正则匹配文件
            threshold: 10240, // 超过10kb的文件进行压缩
            deleteOriginalAssets: false, // 是否删除源文件
            minRatio: 0.8
          })
        ]
      };
    }
  }
};
