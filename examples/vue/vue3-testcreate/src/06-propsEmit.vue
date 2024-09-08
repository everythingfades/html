<script setup>
import SonCom from '@/components/son-com.vue'
import { ref } from 'vue'
const data = ref(100)
const car = ref("benz")
const addData = () => {
  data.value++
}
const changeData = (newMoney) => {
  data.value = newMoney
}
</script>

<template>
  <div>
    <h3>父组件 - {{data}}</h3>
    <SonCom :data="data" :car="car" @changeMoney="changeData"></SonCom>
    <button @click="addData">+1</button>
  </div>
</template>