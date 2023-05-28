// api js
import http from "@/lib/axios";
export const shortLink = (query) => {
    return http.request({
        method: "get",
        url: "/short-link",
        params: query
    })
}


