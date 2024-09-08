// import Vue from 'vue'
// import Vuex from 'vuex'
import axios from 'axios'

export default {
  namespaced: true,
  state () {
    return {
      list: []
    }
  },
  getters: {
  },
  mutations: {
    updateItems (state, itemlist) {
      state.list = itemlist
    },
    alterItemCount (state, data) {
      console.log(data.num)
      console.log(data.id)
      for (const i in state.list) {
        if (state.list[i].id === data.id) {
          console.log(state.list[i].count, data.num)
          state.list[i].count += data.num
          this.dispatch('cart/alterItems', state.list[i])
        }
      }
      console.log(state.list)
      this.commit('cart/updateItems', state.list)
    }
  },
  actions: {
    async updateItemsFromServer (store) {
      const res = await axios({
        url: 'http://127.0.0.1:8000/getItems',
        method: 'get'
      })
      store.commit('updateItems', res.data.items)
      console.log(store.state.list)
    },
    // async buyItems (store, id) {
    // const res = await axios({
    //   url: 'http://127.0.0.1:8000/buyItems',
    //   method: 'put',
    //   params: {
    //     id: id
    //   }
    // })
    // if (res.data.msg === 'delete successfully') {
    //   store.dispatch('updateItemsFromServer')
    // } else {
    //   alert('delete failed')
    // }
    // },
    // async deleteItems (store, id) {
    //   const res = await axios({
    //     url: 'http://127.0.0.1:8000/deleteItems',
    //     method: 'put',
    //     params: {
    //       id: id
    //     }
    //   })
    //   if (res.data.msg === 'delete successfully') {
    //     store.dispatch('updateItemsFromServer')
    //   } else {
    //     alert('delete failed')
    //   }
    // }
    async alterItems (store, item) {
      console.log(item)
      const res = await axios({
        url: 'http://127.0.0.1:8000/alterItems',
        method: 'put',
        params: {
          item: JSON.stringify(item)
        }
      })
      if (res.data.msg === 'altered successfully') {
        store.dispatch('updateItemsFromServer')
      } else {
        alert(res.data.msg)
      }
    }
  },
  modules: {
  }
}
