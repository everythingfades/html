<template>
  <div class="wrapper">
    <p>我是Grandson</p>
    <p>{{color}}</p>
    <p>{{userInfo.name}}</p>
  </div>
</template>

<script>
export default {
    inject: ["color","userInfo"]
}
</script>

<style scoped>
.wrapper{
    width: 80%;
    height: 60%;
    border: 3px solid black;
}
</style>