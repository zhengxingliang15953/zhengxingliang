// pages/person/person.js
import {
  getEntry
} from '../../api/index.js';
import Notify from '../../miniprogram_npm/@vant/weapp/notify/notify';
Page({
  /**
   * 页面的初始数据
   */
  data: {
    checked: false, //在线状态
    show: false,
    loginValue: false, //昵称
    infoUser: {}, //用户信息
    studentName: '', //姓名
    sno: '', //学号
  },
  change() {
    let status;
    if (!wx.getStorageSync('token')) {
      Notify('你还没有登录');
    } else if (this.data.change == true) {
      status = 1;
      wx.showToast({
        title: '上线成功',
      })
    } else {
      status = 2;
      wx.showToast({
        title: '下线成功',
      })
    }
    if (wx.getStorageSync('token')) {
      this.setData({
        checked: !this.data.checked
      })
    }
  },
  start() { //开始接单
    wx.navigateTo({
      url: '/pages/main/main',
    })
  },
  loginBtn() { //获取openId
    let _this = this;
    wx.login({
      success(res) {
        wx.request({
          url: `http://localhost:8081/api/getWxLogin?code=${res.code}`,
          success(res) {
            wx.setStorageSync('token', res.data.openid);
          }
        })
      }
    })
  },
  login123123(res) { //用户登录
    let _this = this;
    this.loginBtn();
    console.log(res.detail.userInfo);
    this.setData({
      infoUser: res.detail.userInfo,
      loginValue: true
    })
  },
  resourirBtn() { //骑手申请成功提交
    let _this=this;
    if (this.data.studentName == '' || this.data.sno == '') {
      Notify({
        type: 'warning',
        message: '请信息填写完整'
      });
      this.setData({
        show: true
      });
    } else {
      wx.request({
        url: `http://localhost:8081/api/getApply?openId=${wx.getStorageSync('token')}&studentName=${_this.data.studentName}&sno=${_this.data.sno}`,
        success(res){
          if(res.data.msg==1){
            console.log(res);
            wx.showToast({
              title: '申请成功',
            })
          }else{
            Toast.fail('你已经是骑手');
          }
          _this.setData({
            show: false
          });
        }
      })
    }
  },
  startResourirBtn() { //申请骑手
    if (!wx.getStorageSync('token')) {
      Notify('你还没有登录');
    } else {
      this.setData({
        show: true
      })
    }
  },
  historyBtn() { //历史订单
    wx.navigateTo({
      url: "/pages/history/history"
    })
  },
  statisticBtn() { //我的统计
    wx.navigateTo({
      url: "/pages/statistics/statistic"
    })
  },
  studentNameInput(value){//姓名输入框监听
    this.setData({
      studentName:value.detail
    })
  },
  snoInput(value){//学号框监听
    this.setData({
      sno: value.detail
    })
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    wx.getSetting({
      success: res => {
        if (res.authSetting['scope.userInfo']) {
          // 已经授权，可以直接调用 getUserInfo 获取头像昵称，不会弹框
          wx.getUserInfo({
            success: res => {
              // 可以将 res 发送给后台解码出 unionId
              this.infoUser = res.userInfo
              this.data.loginValue = true;
              this.setData({
                loginValue: true,
                infoUser: res.userInfo
              })
              // 由于 getUserInfo 是网络请求，可能会在 Page.onLoad 之后才返回
              // 所以此处加入 callback 以防止这种情况
              if (this.userInfoReadyCallback) {
                this.userInfoReadyCallback(res)
              }
            }
          })
        } else {
          wx.removeStorageSync('token');
        }
      }
    })
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {

  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {

  },

  /**
   * 生命周期函数--监听页面隐藏
   */
  onHide: function() {

  },

  /**
   * 生命周期函数--监听页面卸载
   */
  onUnload: function() {

  },

  /**
   * 页面相关事件处理函数--监听用户下拉动作
   */
  onPullDownRefresh: function() {

  },

  /**
   * 页面上拉触底事件的处理函数
   */
  onReachBottom: function() {

  },

  /**
   * 用户点击右上角分享
   */
  onShareAppMessage: function() {

  }
})