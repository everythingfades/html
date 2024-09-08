<template>
  <div id="app">
    <BaseOne></BaseOne>
    <BaseTwo></BaseTwo>
  </div>
</template>

<script>
import Vue from "vue";
import BaseOne from "./components/BaseOne.vue"
import BaseTwo from "./components/BaseTwo.vue"
import CommonButton from "./components/CommonButton.vue"

Vue.component("CommonButton", CommonButton)

export default {
  name: 'App',
  components: {
    BaseOne: BaseOne,
    BaseTwo: BaseTwo
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
