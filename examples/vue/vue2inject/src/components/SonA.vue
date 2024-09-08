<template>
  <div class="wrapper">
    <p>我是SonA组件</p>
    <GrandSon></GrandSon>
  </div>
</template>

<script>
// import GrandSon from './GrandSon.vue';

export default {

}
</script>

<style scoped>
.wrapper{
    width: 600px;
    height: 200px;
    border:3px solid black;
    position: absolute;
    left: 50%;
    transform: translateX(-50%);
}
</style>