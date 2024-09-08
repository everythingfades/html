<template>
  <div id="app">
    <button
      @click="isShow = true"
    >显示</button>
    <BaseDialog
      :visible.sync="isShow"
    ></BaseDialog>
  </div>
</template>

<script>
import BaseDialog from './components/BaseDialog.vue'

export default {
  data () {
    return {
      isShow: false
    }
  },
  components:{
    BaseDialog
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
</style>
