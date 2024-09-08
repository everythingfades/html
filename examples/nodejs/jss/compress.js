const fs = require("fs")
const path = require("path")
fs.readFile(path.join(__dirname, "../txts/something.html"), (err, data) => {
    if (err) console.log(err)
    else{
        const htmlStr = data.toString()
        const resultStr = htmlStr.replace(/[\r\n]/g,'')
        fs.writeFile(path.join(__dirname, "../txts/compress_new.html"), resultStr, err => {
            if (err) console.log(err)
            else console.log("succeed")
        })
    }
})