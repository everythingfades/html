<template>
  <div id="app">
    <BaseA></BaseA>
    <BaseB></BaseB>
    <BaseC></BaseC>
  </div>
</template>

<script>
import BaseA from "./components/BaseA.vue"
import BaseB from "./components/BaseB.vue"
import BaseC from "./components/BaseC.vue"
export default {
  name: 'App',
  components: {
    BaseA,
    BaseB,
    BaseC,
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
./components/BaseA.vue