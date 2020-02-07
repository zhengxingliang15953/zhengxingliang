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
  err => {}
);

const getToken = function() {
  return window.localStorage.getItem("token");
};

export default instance;
