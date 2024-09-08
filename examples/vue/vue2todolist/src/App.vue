<template>
  <!-- 主体区域 -->
  <section id="app">
    <!-- 输入框 -->
    <!-- <header class="header">
      <h1>小黑记事本</h1>
      <input placeholder="请输入任务" class="new-todo" />
      <button class="add">添加任务</button>
    </header> -->
    <ToDoHeader
     :items="list"
     @addItem="add"
    >
    </ToDoHeader>
    <!-- 列表区域 -->
    <!-- <section class="main">
      <ul class="todo-list">
        <li class="todo">
          <div class="view">
            <span class="index">1.</span> <label>吃饭饭</label>
            <button class="destroy"></button>
          </div>
        </li>
      </ul>
    </section> -->
    <ToDoList
     :items="list"
     @removeItem="remove"
    >
    </ToDoList>
    <!-- 统计和清空 -->
    <ToDoTail
     :items="list"
     @emptyItems="empty"
    >
    </ToDoTail>
  </section>
</template>

<script>
import ToDoHeader from './components/ToDoHeader.vue';
import ToDoList from './components/ToDoList.vue';
import ToDoTail from './components/ToDoTail.vue'
export default {
  components:{
    ToDoHeader,
    ToDoList,
    ToDoTail
  },
  data (){
    return {
      list: [
        { id: 1, name: "吃饭"},
        { id: 2, name: "打篮球"}
      ],
      id: 2,
   }
  },
  methods:{
    remove(id){
      this.list = this.list.filter(it => it.id != id)
    },
    empty(){
      this.list = []
    },
    add(item){
      this.id += 1
      this.list.push({id:this.id, name:item})
    }
  }
}
</script>

<style>
</style>