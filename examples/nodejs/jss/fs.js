const fs = require("fs")
fs.writeFile("./fs.txt", "hello, Node", (err)=>{
    if (err) console.log(err)
    else console.log(`执行成功 ${err}`)
})

fs.readFile("./fs.txt", (err, data) => {
    if (err) console.log(err)
    else {
        console.log(data)
        // data会输出一个16进制Buffer对象
        console.log(data.toString())
    }
})