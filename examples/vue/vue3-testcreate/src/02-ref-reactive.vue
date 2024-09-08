<script setup>
import { ref } from 'vue'
let count = ref(100)
const setCount = () => {
  count.value++
}
</script>

<template>
  <div>
    <div>{{count}}</div>
    <button @click=setCount>11111</button>
  </div>
</template>