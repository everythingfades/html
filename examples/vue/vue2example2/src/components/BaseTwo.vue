<template>
    <div>
        <CommonButton @click="count--">-</CommonButton>
        <span>{{ count }}</span>
        <CommonButton @click="count++">+</CommonButton>
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
    border: 3px solid aquamarine;
    margin: 30px;
}
</style>