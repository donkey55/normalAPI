import axios from "axios";
import config from "@/config/config";

export const baseUrl = config.api

const http = axios.create({
    baseURL: baseUrl,
    timeout: 60000,
    headers: {
        'Content-Type': 'application/json'
    },
})


http.interceptors.response.use(response => {
    return response;
}, error => {
    if (error && error.response) {
        switch (error.response.status) {
            // case 404:
            //     router.push({name:'error_404'});
            //     break;
            //
            // case 500:
            //     router.push({ name:'error_500'});
            //     break;

            default: error.message = `连接出错(${error.response.status})!`;
        }
    }
    return Promise.reject(error);
});


export default http;
