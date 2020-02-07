import axios from 'axios'
// http://ce.jing-quan.com
axios.defaults.baseURL = 'http://www.jing-quan.com/api'
axios.defaults.headers.post['Content-type'] = 'application/json'

/* BANNER */
export let getbanner = (lang) => {
  return axios.get(`/banner?lang=${lang}`)
}
/* about */
export let getabout = (lang) => {
  return axios.get(`/aboutus?lang=${lang}`)
}
export let getaboutdel = (id, lang) => {
  return axios.get(`/aboutus/details?id=${id}&lang=${lang}`)
}
export let getnews = (category, lang) => {
  return axios.get(`/news?category=${category}&lang=${lang}&limit=10`)
}
export let getindexnews = (category, lang) => {
  return axios.get(`/news/getindex?category=${category}&lang=${lang}&limit=10`)
}
export let getcontact = (lang) => {
  return axios.get(`/ContactUs?lang=${lang}`)
}
/* 获取新闻详情 */
export let getnewsdetail = (id, lang) => {
  return axios.get(`/news/details?id=${id}&lang=${lang}`)
}
/* 获取产品详情 */
export let getproducts = (id, lang) => {
  return axios.get(`/product?id=${id}&lang=${lang}`)
}
/* 获取首页产品 */
export let getindexproducts = (lang) => {
  return axios.get(`/product/getindex?lang=${lang}`)
}
/* 获取case */
export let getcase = (id, category, lang) => {
  return axios.get(`/cases?id=${id}&category=${category}&lang=${lang}`)
}
/* 获取水处理知识 */
export let getknowledge = (id, lang) => {
  return axios.get(`/knowledge?id=${id}&lang=${lang}`)
}
export let getindexknowledge = (lang) => {
  return axios.get(`/knowledge/getindex?lang=${lang}`)
}
