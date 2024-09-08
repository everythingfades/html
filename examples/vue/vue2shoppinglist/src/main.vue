<template>
  <div id="a">
    <cart-header></cart-header>
    <ul class="item-list">
      <cart-item :item="item" v-for="item in list" :key="item.id" @alterItems="alterItemCount">
      </cart-item>
    </ul>
    <cart-footer :totalNum="totalNum" :totalPrice="totalPrice"></cart-footer>
  </div>
</template>

<script>
import CartHeader from '@/components/CartHeader.vue'
import CartFooter from '@/components/CartFooter.vue'
import CartItem from '@/components/CartItem.vue'
import { mapState, mapActions, mapMutations } from 'vuex'

export default ({
  name: 'MainPage',
  components: {
    CartHeader,
    CartFooter,
    CartItem
  },
  data () {
    return {
      friends: []
    }
  },
  computed: {
    ...mapState('cart', ['list']),
    totalNum () {
      console.log(this.list)
      let rtrn = 0
      for (const i of this.list) {
        rtrn = rtrn + i.count
      }
      return rtrn
    },
    totalPrice  () {
      let rtrn = 0
      for (const i of this.list) {
        rtrn = rtrn + i.price
      }
      return rtrn
    }
  },
  methods: {
    ...mapActions('cart', ['updateFromServer', 'alterItems']),
    ...mapMutations('cart', ['alterItemCount'])
    // ...mapActions('cart', ['updateFromServer', 'buyItems', 'deleteItems'])
  },
  created () {
    this.$store.dispatch('cart/updateItemsFromServer')
    console.log('created')
    console.log(this.list)
  }
})
</script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  justify-content: center;
}

nav {
  padding: 30px;

  a {
    font-weight: bold;
    color: #2c3e50;

    &.router-link-exact-active {
      color: #42b983;
    }
  }
}

.item-list {
  position: absolute;
  top: 50px;
  width: 80%;
  left: 0px;
  transform: translateX(10%);
  height: calc(100% - 150px);
  padding: 0px;
  margin: 10px;
  overflow-y: scroll;
  overflow-x: hidden;
}

.item-list .item{
  margin-bottom: 25px;
}
</style>
