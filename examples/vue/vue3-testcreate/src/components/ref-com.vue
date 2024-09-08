<script setup>
import { defineExpose } from 'vue'
const count = 999
const sayHi = () => {
  console.log("Hi")
}

defineExpose({
  count,
  sayHi
})

</script>

<template>
  <div class="ref-com">
    <p>测试用组件</p>
  </div>
</template> 

<style>
.ref-com {
  border: 1px solid black;
  font-weight: 700;
}
</style>