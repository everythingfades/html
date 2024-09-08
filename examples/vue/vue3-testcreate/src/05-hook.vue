<script setup>
import { onMounted } from 'vue';

const getList = () => {
  setTimeout(() => {
    console.log('data')
  }, 2000)
}

getList()

onMounted(() => {
  console.log("data1")
})


onMounted(() => {
  console.log("data2")
})
</script>

<template>
  <div>something</div>
</template>