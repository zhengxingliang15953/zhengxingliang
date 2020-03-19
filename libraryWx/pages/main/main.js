// pages/main/main.js
import Toast from '../../miniprogram_npm/@vant/weapp/toast/toast';
Page({

  /**
   * 页面的初始数据
   */
  data: {
    orderItem1: [], //配送单1
    orderItem2:[],//取货单
    orderItem3:[],//待送达单
    noneValue:false,//监听当前有无订单
    tap:'1',//标识
  },
  pointBtn1(e) { //骑手同意接单
    let _this = this;
    wx.request({
      url: `http://localhost:8081/api/getAgreePoint?appId=${e.target.dataset.id.appId}&openId=${wx.getStorageSync('token')}&pointId=${e.target.dataset.id.pointId}`,
      success(res) {
        if (res.data.msg == '0') {
          Toast.fail('订单已失效');
        } else {
          wx.showToast({
            title: '接单成功',
          })
        }
        _this.setData({
          orderItem1: _this.data.orderItem1.filter(function(item) {
            return item.pointId != e.target.dataset.id.pointId;
          })
        })
      }
    })
    if (_this.data.orderItem1.length <= 0) {
      _this.setData({
        noneValue: true
      })
    } else {
      _this.setData({
        noneValue: false
      })
    }
  },
  tabsChange(value){//监听标签页状态改变
    let _this=this;
    _this.setData({
      tap: value.detail.name
    })
    switch(value.detail.name){//123
      case '1':{
        wx.request({ //根据openId获取待接单列表
          url: `http://localhost:8081/api/getOpenIdPoint?openId=${wx.getStorageSync('token')}`,
          success(res) {
            _this.setData({
              orderItem1: res.data
            })
          }
        })
        if(_this.data.orderItem1.length<=0){
          _this.setData({
            noneValue:true
          })
        }else{
          _this.setData({
            noneValue: false
          })
        }
        break;
      }
      case '2':{
        wx.request({//获取待取货列表
          url: `http://localhost:8081/api/selectHavePointId?openId=${wx.getStorageSync('token')}`,
          success(res){
            _this.setData({
              orderItem2: res.data
            })
          }
        })
        if (_this.data.orderItem2.length <= 0) {
          _this.setData({
            noneValue: true
          })
        } else {
          _this.setData({
            noneValue: false
          })
        }
        break;
      }
      case '3':{
        wx.request({//获取待送达列表
          url: `http://localhost:8081/api/getWaitFinish?openId=${wx.getStorageSync('token')}`,
          success(res) {
            _this.setData({
              orderItem3: res.data
            })
          }
        })
        if (_this.data.orderItem3.length <= 0) {
          _this.setData({
            noneValue: true
          })
        } else {
          _this.setData({
            noneValue: false
          })
        }
        break;
      }
    }
  },
  finsh(value){//完成取货
    let _this=this;
    wx.request({
      url: `http://localhost:8081/api/getFinishTake?pointId=${value.target.dataset.id.pointId}&appId=${value.target.dataset.id.appId}`,
    })
    _this.setData({
      orderItem2: _this.data.orderItem2.filter(function (item) {
        return item.pointId != value.target.dataset.id.pointId;
      })
    })
    wx.showToast({
      title: '成功取货',
    })
    if (_this.data.orderItem2.length <= 0) {
      _this.setData({
        noneValue: true
      })
    } else {
      _this.setData({
        noneValue: false
      })
    }
  },
  finshOrder(value){//完成订单
    let _this=this;
    wx.request({
      url: `http://localhost:8081/api/getFinishOrder?pointId=${value.target.dataset.id.pointId}&appId=${value.target.dataset.id.appId}&openId=${wx.getStorageSync('token')}`,
    })
    _this.setData({
      orderItem3: _this.data.orderItem3.filter(function (item) {
        return item.pointId != value.target.dataset.id.pointId;
      })
    })
    wx.showToast({
      title: '订单完成',
    })
    if (_this.data.orderItem3.length <= 0) {
      _this.setData({
        noneValue: true
      })
    } else {
      _this.setData({
        noneValue: false
      })
    }
  },
  /**
   * 生命周期函数--监听页面加载
   */
  onLoad: function(options) {
    let _this = this;
    wx.request({ //根据openId获取待接单列表
      url: `http://localhost:8081/api/getOpenIdPoint?openId=${wx.getStorageSync('token')}`,
      success(res) {
        _this.setData({
          orderItem1: res.data
        })
      }
    })
    if (_this.data.orderItem1.length <= 0) {
      _this.setData({
        noneValue: true
      })
    } else {
      _this.setData({
        noneValue: false
      })
    }
  },

  /**
   * 生命周期函数--监听页面初次渲染完成
   */
  onReady: function() {
    let _this = this;
    if (_this.data.orderItem1.length <= 0) {
      _this.setData({
        noneValue: true
      })
    } else {
      _this.setData({
        noneValue: false
      })
    }
  },

  /**
   * 生命周期函数--监听页面显示
   */
  onShow: function() {
    let _this=this;
    if (_this.data.orderItem1.length <= 0) {
      _this.setData({
        noneValue: true
      })
    } else {
      _this.setData({
        noneValue: false
      })
    }
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