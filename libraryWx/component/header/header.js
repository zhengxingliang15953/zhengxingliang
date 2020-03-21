// component/header/header.js
Component({
  /**
   * 组件的属性列表
   */
  properties: {
    value:{
      type:String
    }
  },

  /**
   * 组件的初始数据
   */
  data: {
    number:0
  },
  options:{
    multipleSlots:true,//支持多个插槽
  },

  /**
   * 组件的方法列表
   */
  methods: {
    show(){
      let _this = this;
      wx.showToast({
        title: _this.properties.value,
      })
      _this.triggerEvent("del",{id:5});
      -this.setData({
        number:++_this.data.number
      })
    }
  },
  created(){
    console.log("组件创建成功");
  },
  attached(){
    console.log('把实例挂载到页面上');
  },
  ready(){
    console.log("页面已经渲染完成");
  },
  observers:{//数据监听
    "number":function(value){
      console.log(value);
    }
  }
})
