// 这里放vuex的东西
import Vue from 'vue'
import Vuex from 'vuex'
import user from './modules/user'

// 插件安装
Vue.use(Vuex)

// 初始化仓库
const store = new Vuex.Store({
  strict: true,
  state: {
    count: 101
  },
  mutations: {
    add (state, n) {
      state.count += n
    }
  },
  actions: {
    addAsync (context, num) {
      setTimeout(() => {
        context.commit('add', 5)
      }, 1000)
    }
  },
  getters: {
    double (state) {
      return 2 * state.count
    }
  },
  modules: {
    user
  }
})

// 导出
export default store
