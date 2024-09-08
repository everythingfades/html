<script setup>
import { ref, watch } from 'vue'
const count = ref(0)
const nickname = ref("name")
const someDict = ref({"id": 0, "name": "someName"})

const changeCount = () => {
  count.value++
}

const changeNickname = () => {
  nickname.value = "some random name"
}

const changeNameinDict = () => {
  someDict.value.name = "this random name"
}

watch(count, (newValue, oldValue) => {
  console.log("changed count")
  console.log(newValue, oldValue)
}, {
  immediate: true
})

watch(someDict, (newValue, oldValue) => {
  console.log("changed dict")
  console.log(newValue, oldValue)
}, {
  deep: true
})

watch([count, nickname], (newArr, oldArr) => {
  console.log(newArr, oldArr)
})
</script>

<template>
  <div>{{ count }}</div>
  <button @click="changeCount">改数字</button>
  <div>{{ nickname }}</div>
  <button @click="changeNickname">改昵称</button>
  <div>{{ someDict }}</div>
  <button @click="changeNameinDict">改昵称</button>
</template>