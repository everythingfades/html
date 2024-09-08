<template>
  <div id="app">
    <p>我是App组件</p>
    <button @click="change">更改数据</button>
    <div>
    <SonA>
    </SonA>
    <SonB class="b">
    </SonB>
    </div>
  </div>
</template>

<script>
import SonA from './components/SonA.vue'
import SonB from './components/SonB.vue'
import GrandSon from './components/GrandSon.vue'
import Vue from 'vue';
Vue.component("GrandSon",GrandSon)

export default {
  name: 'App',
  components: {
    SonA,
    SonB,
    // GrandSon,
  },
  provide(){
    return {
      "color": this.color,
      "userInfo": this.userInfo,
    }
  },
  data(){
    return {
      color: "red",
      userInfo: {
        name: "aaa",
        age: 28
      }
    }
  },
  methods:{
    change(){
      console.log("changed color")
      this.color = "yellow"
      console.log("changed userInfo name")
      this.userInfo.name = "bbb"
    }
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
  height: 700px;
  width: 800px;
  border:3px solid black;
  position: relative;
}
#app .b{
  top: 300px;
}
</style>
