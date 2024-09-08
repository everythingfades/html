<script setup>
import useCounterStore from '@/store/counter.js'

const counterStore = useCounterStore()
</script>

<template>
  <div>
    <span>我是Son2 - {{ counterStore.count }}</span>
    <button @click="counterStore.subCount">-</button>
  </div>
</template>

<style scoped>
</style>