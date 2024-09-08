<script setup>
import useCounterStore from '@/store/counter.js'

const counterStore = useCounterStore()
</script>

<template>
  <div>
    <span>我是Son1 - {{ counterStore.count }}</span>
    <button @click="counterStore.addCount">+</button>
  </div>
</template>

<style scoped>
</style>