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
export let getAllNotice = (start) => {
    return Http.get(`/api/selectAllNotice?start=${start}`);
};
/**获取所有的读者留言 */
export let getAllReadMessage = (start) => {
    return Http.get(`/api/getAllReadMessage?start=${start}`);
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
/*获取所有的导航资源*/
export let getAllResource = (start) => {
    return Http.get(`/api/getAllResource?start=${start}`);
};    
/*获取所有的图书*/
export let getAllBook = (isbn,start) => {
    return Http.get(`/api/getAllBook?isbn=${isbn}&start=${start}`);
};    
/*根据ISBN获取图书*/
export let getIsbnBook = (isbn) => {
    return Http.get(`/api/getIsbnBook?isbn=${isbn}`);
};    
/*根据书名获取图书(精确)*/
export let getBookName1 = (bookName,start) => {
    return Http.get(`/api/getBookName1?bookName=${bookName}&start=${start}`);
};    
/*根据书名获取图书(模糊)*/
export let getBookName2 = (bookName,start) => {
    return Http.get(`/api/getBookName2?bookName=${bookName}&start=${start}`);
}; 
/*根据著者获取图书*/
export let getAuthorBook = (author,start) => {
    return Http.get(`/api/getAuthorBook?author=${author}&start=${start}`);
};       