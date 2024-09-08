const dayjs = require("dayjs")

const string = dayjs().format("YYYY-MM-DD HH:mm:ss")
console.log(string)

const _ = require("lodash")
console.log(_.max([1,2,7,3,4,15]))
// 在wsl2里nodemon server.js需要在前面加上CHOKIDAR_USEPOLLING=true