<template>
  <div class="base-progress">
    <div
     class="inner"
     :style="{width:w + '%'}">
     <span>{{w}}%</span>
    ></div>
  </div>
</template>

<script>
export default {
  // props: ['w']
  // props: {
  //   w: Number
  // }
  props: {
    w : {
      type: Number,
      required: true,
      default: 50,
      validator (value) {
        return value >= 0 && value <= 100
      }
    }
  }
}
</script>

<style scoped>
.base-progress{
  height: 26px;
  width: 400px;
  border-radius: 15px;
  background-color: #272425;
  border: 3px solid #272425;
  box-sizing: border-box;
  margin-bottom: 30px;
}
.inner{
  background-color: #4f81bd;
  border-radius: 15px;
}
</style>