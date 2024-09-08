<script setup>
const props = defineProps({
  car: String,
  data: Number
})
const emit = defineEmits(['changeMoney'])
const buy = () => {
  emit('changeMoney', 5)  
}
</script>

<template>
    <div class="son">
      子组件 - {{car}} {{data}}
    </div>
    <button @click="buy">花钱</button>
</template>

<style scoped>
.son {
  border: 1px solid #000;
  padding: 30px;
}
</style>