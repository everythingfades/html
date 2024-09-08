<template>
  <div id="app">
    <span>根组件</span>
    <br>
    <span>{{count}}</span>
    <br>
    <input type="text">
    <Son1></Son1>
    <Son2></Son2>
  </div>
</template>

<script>
import Son1 from './components/Son1.vue'
import Son2 from './components/Son2.vue'
import { mapState } from 'vuex'

export default {
  name: 'App',
  computed: {
    ...mapState(['count'])
  },
  components: {
    Son1,
    Son2
  }
}
</script>

<style lang="less">
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
