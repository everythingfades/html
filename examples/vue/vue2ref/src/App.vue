<template>
  <div id="app">
    <p>这个不应该像是图标，但是类名为base-chart-box</p>
    <div class="base-chart-box"></div>
    <p>这个才是正经的图表组件，类名为base-chart-box</p>
    <BaseChart></BaseChart>
    <p>如果用queryselector，会选整个文档里第一个base-chart-box</p>
  </div>
</template>

<script>
import BaseChart from './components/BaseChart.vue';

export default {
  name: 'App',
  components: {
    BaseChart
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
