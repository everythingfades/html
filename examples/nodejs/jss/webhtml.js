const http = require("http")
const fs = require("fs")
const path = require("path")
const server= http.createServer()
server.on("request", (req,res) => {
    if (req.url === "./index.html"){
        fs.readFile(path.join(__dirname, "../txts/something.html"), (err, data) => {
            if (err) console.log(err)
            else{
                // 设置响应头
                res.setHeader("Content-Type","text/html:charset=utf-8")
                // 设置响应体
                res.end(data.toString())
            }
        })
    } else {
        res.setHeader("Content-Type","text/html:charset=utf-8")
        res.end("404")
    }
})
// 设置端口并运行服务
server.listen(3000, () => {
    console.log("web")
})