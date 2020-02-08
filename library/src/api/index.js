import Http from "../plugins/axios";
import qs from "qs";
import Config from "../config";

const baseURL = Config.SERVER_BASE_URL;

/*学生登录*/
export let getStudentLogin = data => {
    return Http.post(`/api/getStudentLogin`, qs.stringify(data));
};
/*获取当前登录信息*/
export let getIndexStudent = () => {
    return Http.get(`/api/getIndexStudent`);
};
/*获取所有公告通知*/
export let getAllNotice = () => {
    return Http.get(`/api/selectAllNotice`);
};
/**获取所有的读者留言 */
export let getAllReadMessage = () => {
    return Http.get(`/api/getAllReadMessage`);
};  
/**添加读者留言 */
export let addReadMessage = (sno,message,readId) => {
    return Http.get(`/api/addReadMessage?sno=${sno}&message=${message}&readId=${readId}`);
};    
/*修改密码*/
export let getUpdatePwd = data => {
    return Http.post(`/api/getUpdatePwd`, qs.stringify(data));
};
/*我的留言 */
export let getOneReadMessage = (sno) => {
    return Http.get(`/api/getOneReadMessage?sno=${sno}`);
};    