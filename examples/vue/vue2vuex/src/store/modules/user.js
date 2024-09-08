const state = {
  userInfo: {
    name: 'zs',
    age: 18
  },
  score: 80
}
const mutations = {}
const actions = {}
const getters = {
  doubleAge (state) {
    return state.userInfo.age * 2
  }
}
export default {
  namespaced: true,
  state,
  mutations,
  actions,
  getters
}
