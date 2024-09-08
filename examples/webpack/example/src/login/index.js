const { checkPhone, checkCode } = require("../utils/check")

document.querySelector(".btn").addEventListener("click", () =>{
    const phone = document.querySelector(".item [name=mobile]").value
    const code = document.querySelector(".item [name=code]").value

    if (!checkPhone(phone)){
        console.log("手机号应为11位数字")
        return
    }

    if (!checkCode(code)){
        console.log("验证码为六位数字")
        return
    }
    console.log("登录")
})



import './index.css'
import './index.less'

// js中引入本地图片要用import
// 但是url可以直接写
import imgObj from './assets/ak.png'
const img = document.createElement('img')
img.src = imgObj
document.querySelector(".login-box").appendChild(img)
console.log(process.env.NODE_ENV)
console.warn(123)
if (process.env.NODE_ENV === "production"){
    console.log = function(){} 
}
console.log("if you see this, it is development mode")