<script setup>
const msg = "vue3"
const logMessage = () => {
  console.log(msg)
}
</script>

<template>
  <div>
    {{msg}}
    <button @click="logMessage"></button>
  </div>
</template>