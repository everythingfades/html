<template>
  <div class="box">
    <h1>Son2</h1>
    从vuex中获取的值:<label>{{this.$store.state.count}}</label>
    <br>
    <button>+1</button>
  </div>
</template>

<script>
export default {
  name: 'Son2Component'
}
</script>

<style scpoed>
.box{
  border: 3px solid #ccc;
  width: 400px;
  padding: 10px;
  margin: 20px;
}
h2{
  margin-top: 10px;
}
</style>
