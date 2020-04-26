import Axios from "axios";
import Config from "../config";

const instance = Axios.create({
  baseURL: Config.SERVER_BASE_URL,
  timeout: 15000
});

instance.interceptors.request.use(
  config => {
    const token = getToken();

    if (token !== null) {
      config.headers.Authorization = "Bearer " + token;
    }

    return config;
  },
  err => {
    return err;
  }
);

instance.interceptors.response.use(
  (res, config) => {
    return res;
  },
  err => {
    console.log(err);
    /* const { status } = err.response;

    if (status === 403) {
      window.sessionStorage.removeItem('token');
      vue.$router.replace("/login");
    } else {
      return Promise.reject(err);
    } */
  }
);

const getToken = function() {
  return window.sessionStorage.getItem("token");
};

export default instance;
