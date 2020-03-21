//logs.js
const util = require('../../utils/util.js')

Page({
  data: {
    logs: []
  },
  delBack(e){
    console.log(e);
  },
  onLoad: function () {
    this.setData({
      logs: (wx.getStorageSync('logs') || []).map(log => {
        return util.formatTime(new Date(log))
      })
    })
  }
})
