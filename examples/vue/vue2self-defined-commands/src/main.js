import Vue from 'vue'
import App from './App.vue'

Vue.config.productionTip = false

// 全局注册:
// Vue.directive('focus', {
//   //inserted 会在指令所在的元素被插入到页面的时候被触发
//   // 形参el为指令所在元素
//   inserted (el) {
//     console.log(el);
//     el.focus()
//   }
// })

Vue.directive('color', {
    inserted (el, binding){
      el.style.color = binding.value
    }
  }
)




new Vue({
  render: h => h(App),
}).$mount('#app')
