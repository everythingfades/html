<template>
  <div>
    <button @click="count--">-</button>
    <span>{{ count }}</span>
    <button @click="count++">+</button>
  </div>
</template>

<script>
export default {
    data() {
        return {
            count: 100
        }
    }
}
</script>

<style scoped>
div {
    border: 3px solid blueviolet;
    margin: 30px;
}
</style>