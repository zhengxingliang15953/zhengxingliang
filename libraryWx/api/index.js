/**
 * 进入小程序监听
 */
export let getEntry=(openId,nickName)=>{
  wx.request({
    url: `http://localhost:8081/api/entrySwapp？openId=${openId}&nickName=${nickName}`,
    
  })
}