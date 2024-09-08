<template>
  <div class="App">
    <!--头部组件-->
    <ExampleHeader></ExampleHeader>
    <!--主体组件-->
    <ExampleBody></ExampleBody>
    <!--底部组件-->
    <ExampleTail></ExampleTail>
  </div>
</template>

<script>
import ExampleHeader from "./components/ExampleHead.vue"
import ExampleBody from "./components/ExampleBody.vue"
import ExampleTail from "./components/ExampleTail.vue"
export default {
  components: {
    //"组件名":"组件对象"
    ExampleHeader: ExampleHeader,
    ExampleBody: ExampleBody,
    ExampleTail: ExampleTail
  }
}
</script>

<style>
.App{
  width: 600px;
  height: 700px;
  background-color: #87ceeb;
  margin: 0 auto;
  padding: 20px;
}
</style>