<template>
  <!-- 输入框 -->
  <header class="header">
    <h1>记事本</h1>
    <input placeholder="请输入任务" v-model="input" class="new-todo" />
    <button class="add" @click="add">添加任务</button>
  </header>
</template>

<script>
export default {
  props: {
    items: {
      type: Array,
      required: true
    }
  },
  data(){
    return {
      input: ""
    }
  },
  methods:{
    add(){
      this.$emit("addItem",this.input)
    }
  }
}
</script>

<style scoped>
</style>