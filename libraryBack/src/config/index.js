import development from "./development";
import production from "./production";

export const isDev = process.env.NODE_ENV === "development";

const config = isDev ? development : production;

export default config;
