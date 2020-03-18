import Http from "../plugins/axios";
import qs from "qs";
import Config from "../config";

const baseURL = Config.SERVER_BASE_URL;

/*管理员登录*/
export let getLogin = data => {
    return Http.post(`/api/getLogin`, qs.stringify(data));
};
/*获取当前登陆账号 */
export let getIndexAccount = () => {
    return Http.get(`/api/getIndexAccount`);
}
/*添加公告通知*/
export let getAddNotice = (title, message,noticeId) => {
    return Http.get(`/api/getAddNotice?title=${title}&message=${message}&noticeId=${noticeId}`);
}
/*删除公告通知*/
export let getDeleteNotice = (noticeId) => {
    return Http.get(`/api/getDeleteNotice?noticeId=${noticeId}`);
}
/*获取所有公告通知*/
export let getAllNotice = (start) => {
    return Http.get(`/api/selectAllNotice?start=${start}`);
}
/*修改公告*/
export let getUpdateNotice = (title,message,noticeId) => {
    return Http.get(`/api/getUpdateNotice?title=${title}&message=${message}&noticeId=${noticeId}`);
}
/**获取所有的读者留言 */
export let getAllReadMessage = (start) => {
    return Http.get(`/api/getAllReadMessage?start=${start}`);
};  
/**删除读者留言 */
export let getDeleteReadMessage = (readId) => {
    return Http.get(`/api/deleteReadMessage?readId=${readId}`);
};  
/**获取所有的学生 */
export let getAllStudent = (sno,start) => {
    return Http.get(`/api/getAllStudent?sno=${sno}&start=${start}`);
};  
/*添加管理员*/
export let getAddAccount = data => {
    return Http.post(`/api/getAddAccount`, qs.stringify(data));
};
/*修改密码*/
export let getUpdateAccountPwd = data => {
    return Http.post(`/api/getUpdateAccountPwd`, qs.stringify(data));
};
/*获取所有的导航资源*/
export let getAllResource = (start) => {
    return Http.get(`/api/getAllResource?start=${start}`);
};    
/*删除导航资源*/
export let getDetailResource = (resourceId) => {
    return Http.get(`/api/getDetailResource?resourceId=${resourceId}`);
};    
/*添加导航资源*/
export let getAddResource = (title,resourceUrl,resourceId) => {
    return Http.get(`/api/getAddResource?title=${title}&resourceUrl=${resourceUrl}&resourceId=${resourceId}`);
};   
/*获取所有的图书*/
export let getAllBook = (isbn,start) => {
    return Http.get(`/api/getAllBook?isbn=${isbn}&start=${start}`);
};    
/*添加图书*/
export let getAddBook = data => {
    return Http.post(`api/getAddBook`,qs.stringify(data));
    //return Http.get(`/api/getAddBook?isbn=${data.isbn}&bookName=${data.bookName}&author=${data.author}&press=${data.press}&bookDate=${data.bookDate}&bookNumber=${data.bookNumber}&bookUrl=${data.bookUrl}&address=${data.address}`);
};
/*删除图书*/
export let getDeleteBook = (isbn) => {
    return Http.get(`/api/getDeleteBook?isbn=${isbn}`);
};   
/*修改图书*/
export let getUpdateBook = (data) => {
    return Http.post(`/api/getUpdateBook`,qs.stringify(data));
};     
/**获取所有的管理员 */
export let getAllAccount = () => {
    return Http.get(`/api/getAllAccount`);
}
/*冻结or解冻管理员账号 */
export let getUpdateType = (account,type) => {
    return Http.get(`/api/getUpdateType?account=${account}&type=${type}`);
}
/*删除管理员账号 */
export let getDeleteAccount = (account) => {
    return Http.get(`/api/getDeleteAccount?account=${account}`);
}
/*预约列表 */
export let getAllAppointment = (sno,appTime,start) => {
    return Http.get(`/api/getAllAppointment?sno=${sno}&appTime=${appTime}&start=${start}`);
}
/*预约状态改变*/
export let getUpdateAppointment = (appId,status,isbn) => {
    return Http.get(`/api/getUpdateAppointment?appId=${appId}&status=${status}&isbn=${isbn}`);
}
/*获取归还列表*/
export let getAllBackBook = (sno,appTime,start) => {
    return Http.get(`/api/getAllBackBook?sno=${sno}&appTime=${appTime}&start=${start}`);
}
/*删除管理员账号 */
export let getBackBookBtn = (appId,isbn) => {
    return Http.get(`/api/getBackBookBtn?appId=${appId}&isbn=${isbn}`);
}
/*获取已归还列表 */
export let getAllBackingBook = (sno,backTime,start) => {
    return Http.get(`/api/getAllBackingBook?sno=${sno}&backTime=${backTime}&start=${start}`);
}
/*删除管理员账号 */
export let getUpdateBookType = (isbn,type) => {
    return Http.get(`/api/getUpdateBookType?isbn=${isbn}&type=${type}`);
}
/*获取预约预期列表*/
export let getAppointmentAfter = (sno,appTime,start) => {
    return Http.get(`/api/getAppointmentAfter?sno=${sno}&appTime=${appTime}&start=${start}`);
};   
/*获取骑手审批列表*/
export let getApprove = (sno,start) => {
    return Http.get(`/api/getApprove?sno=${sno}&start=${start}`);
};   
/*审批通过*/
export let getAgreement = (openId,status) => {
    return Http.get(`/api/getAgreement?openId=${openId}&status=${status}`);
};   
/*骑手配置修改*/
export let getRiderConfig = (riderSwitch) => {
    return Http.get(`/api/getRiderConfig?riderSwitch=${riderSwitch}`);
};   
/*获取配置信息*/
export let getAllConfig = () => {
    return Http.get(`/api/getAllConfig`);
};   
/*审批不通过*/
export let getRefuse = (openId) => {
    return Http.get(`/api/getRefuse?openId=${openId}`);
};
/*审批不通过*/
export let getWaitDesignation = (sno,start) => {
    return Http.get(`/api/getWaitDesignation?sno=${sno}&start=${start}`);
};
/*根据appId获取相应的骑手*/
export let getAppRider = (appId) => {
    return Http.get(`/api/getAppRider?appId=${appId}`);
};
/*添加配送单*/
export let getAddPoint = (openId,appId) => {
    return Http.get(`/api/getAddPoint?openId=${openId}&appId=${appId}`);
};
/*获取正在配送列表*/
export let getIngDesignation = (sno,start) => {
    return Http.get(`/api/getIngDesignation?sno=${sno}&start=${start}`);
};
/*获取所有骑手*/
export let getAllRider = (sno,start) => {
    return Http.get(`/api/getAllRider?sno=${sno}&start=${start}`);
};
/*删除骑手*/
export let getDeleteRider = (openId) => {
    return Http.get(`/api/getDeleteRider?openId=${openId}`);
};