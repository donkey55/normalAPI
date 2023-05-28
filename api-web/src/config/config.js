const baseUrl = {
    "dev": "http://127.0.0.1:8888",
    // "dev": "/",
    "pro": "/api"
}


const apiUrl = import.meta.env.DEV ? baseUrl["dev"] : baseUrl["pro"]

const isDev = import.meta.env.DEV
let config = {
    api: apiUrl,
    isDev,
}

export default config
