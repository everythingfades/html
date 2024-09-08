<script setup>
import CenterCom from '@/components/center-com.vue'
import { provide, ref } from 'vue'

provide('theme-color','darkred')
const count = ref(100)
provide('count', count)

setTimeout(() => {
  count.value = 500
})

provide('changeCount', (newCount) => {
  count.value = newCount
})
</script>
<template>
  <h1>顶层组件</h1>
  <CenterCom></CenterCom>
</template>