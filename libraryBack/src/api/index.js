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
export let getAllNotice = () => {
    return Http.get(`/api/selectAllNotice`);
}
/*修改公告*/
export let getUpdateNotice = (title,message,noticeId) => {
    return Http.get(`/api/getUpdateNotice?title=${title}&message=${message}&noticeId=${noticeId}`);
}
/**获取所有的读者留言 */
export let getAllReadMessage = () => {
    return Http.get(`/api/getAllReadMessage`);
};  
/**删除读者留言 */
export let getDeleteReadMessage = (readId) => {
    return Http.get(`/api/deleteReadMessage?readId=${readId}`);
};  
/**获取所有的学生 */
export let getAllStudent = () => {
    return Http.get(`/api/getAllStudent`);
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
export let getAllResource = () => {
    return Http.get(`/api/getAllResource`);
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
export let getAllBook = (title,resourceUrl,resourceId) => {
    return Http.get(`/api/getAllBook?`);
};    