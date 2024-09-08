import Vue from 'vue'
import App from './App.vue'

console.log(123)
console.log(456)

Vue.config.productionTip = true // true为开发模式,false为生产模式

new Vue({
  el: "#app",
  render: h => h(App),
})//.$mount('#app')