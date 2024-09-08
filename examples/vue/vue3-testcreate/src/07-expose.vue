<script setup>
import { ref, onMounted } from 'vue'
import RefCom from '@/components/ref-com.vue'

const inp = ref(null)
onMounted(() => {

})

const clickFn = () => {
  console.log(inp.value.count)
  inp.value.focus()
  inp.value.value = "你点击了按钮"
}
</script>

<template>
  <div>
    <input ref="inp" type="text">
    <button @click="clickFn">点击</button>
  </div>
  <RefCom></RefCom>
</template>