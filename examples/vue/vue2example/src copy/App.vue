<template>
  <div class="App">
    <div class="box" @click="fn">

    </div>
  </div>
</template>

<script>
export default {
  created(){
    console.log("created")
  },
  methods: {
    fn(){
      alert("你好")
    }
  }
}
</script>

<style>
.App {
  height: 400px;
  width: 400px;
  background-color: violet;
}
.App .box {
  width: 100px;
  height: 100px;
  background-color: aquamarine;
}

</style>
