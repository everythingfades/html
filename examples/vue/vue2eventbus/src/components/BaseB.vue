<template>
    <div class="wrapper">
        <p>我是B组件(发布方)</p>
        <button @click="clickSend">发布</button>
    </div>
</template>

<script>
import Bus from "../utils/EventBus.js"
export default {
  methods:{
    clickSend(){
        Bus.$emit("sendMsg","你好")
    }
  }
}
</script>

<style>
.wrapper{
    width: 400px;
    height: 300px;
    border: 2px solid black;
}
</style>