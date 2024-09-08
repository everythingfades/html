const http = require("http")
const server= http.createServer()
server.on("request", (req,res) => {
    // 设置响应头
    res.setHeader("request","text/plain:charset=utf-8")
    // 设置响应体
    res.end("welcome")
})
// 设置端口并运行服务
server.listen(3000, () => {
    console.log("web")
})