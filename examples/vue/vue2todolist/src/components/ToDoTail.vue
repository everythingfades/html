<template>
    <footer class="footer">
        <!-- 统计 -->
        <span class="todo-count">合 计:<strong> {{items.length}} </strong></span>
        <!-- 清空 -->
        <button class="clear-completed" @click="empty">
            清空任务
        </button>
    </footer>
</template>

<script>
export default {
    props: {
        items: {
            type: Array,
            required: true
        }
    },
    methods:{
        empty(){
            this.$emit("emptyItems")
        }
    }
}
</script>

<style>

</style>