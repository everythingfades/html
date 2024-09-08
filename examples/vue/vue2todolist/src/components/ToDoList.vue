<template>
  <section class="main">
      <ul class="todo-list">
        <li v-for="(item, index) in items" :key="item.id" class="todo">
          <div class="view">
            <span class="index">{{index + 1}}.</span> <label>{{item.name}}</label>
            <button class="destroy" @click="remove(item.id)"></button>
          </div>
        </li>
      </ul>
    </section>
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
      remove(id){
        this.$emit("removeItem", id)
      }
    }
}
</script>

<style>

</style>