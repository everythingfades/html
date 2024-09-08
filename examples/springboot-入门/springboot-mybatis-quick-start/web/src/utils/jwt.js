import axios from 'axios'
// import router from '@/router'

// axios.interceptors.request.use(
//   (config) => {
//     const token = localStorage.getItem('jwtToken') // 从本地存储中获取JWT令牌
//     if (token) {
//       config.headers.common['Authorization'] = token // 将JWT令牌添加到请求header中
//     }
//     return config
//   },
//   (error) => {
//     return Promise.reject(error)
//   }
// )

// export default async () => {
//   const jwtToken = localStorage.getItem('login_token')
//   if (jwtToken === null) {
//     router.push('/')
//     alert('没登录就想进?')
//   }
//   console.log(jwtToken)
//   axios({
//     url: 'http://localhost:8080/identifyJwt',
//     method: 'post',
//     params: {
//       jwt: jwtToken
//     }
//   }).then((res) => {
//     if (res.data.msg === 'error') {
//       router.push('/')
//       alert('没登录就想进?')
//     }
//   })
// }

export default () => {
  axios.interceptors.request.use((config) => {
    if (localStorage.getItem('login_token')) {
      config.headers.Authorization = localStorage.getItem('login_token')
    }
    config.headers['Access-Control-Allow-Origin'] = 'http://127.0.0.1:8080'
    config.headers['Access-Control-Allow-Headers'] =
      'Content-Type, Authorization, Accept'
    config.headers['Content-Type'] = 'application/json'
    console.log(config)
    return config
  })
  axios.interceptors.response.use((res) => {
    return res
  })
}
