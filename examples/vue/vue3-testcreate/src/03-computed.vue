<script setup>
import { computed, ref } from 'vue'
const list = ref([1,2,3,4,5,6,7,8])
console.log(list)
console.log(list.value)
const computedList = computed(() => {
  return list.value.filter(it=>it > 2)
})
const addFn = () => {
  list.value.push(12345)
}
</script>

<template>
  <div>
    <div>{{list}}</div>
    <div>{{computedList}}</div>
    <button @click="addFn">add</button>
  </div>
</template>