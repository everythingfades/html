import Vue from 'vue'
import App from './App.vue'
import CommonButton from './components/CommonButton.vue' 

Vue.component("CommonButton", CommonButton)

Vue.config.productionTip = true // true为开发模式,false为生产模式

new Vue({
  el: "#app",
  render: h => h(App),
})//.$mount('#app')