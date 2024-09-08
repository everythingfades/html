<template>
  <div id="app">
    <BaseComponent>
      <template #head>
        <span>个性化title</span>
      </template>
      <template #content>
        <span>个性化内容</span>
      </template>
    </BaseComponent>
    <BaseComponent>
      <template #head>
        <span>个性化title</span>
      </template>
    </BaseComponent>
    <BaseComponent>
    </BaseComponent>
    <BaseTable :data="list1">
      <template #default="obj">
        <button
          @click="del(obj.row.id)"
        >删除</button>
      </template>
    </BaseTable>
    <BaseTable :data="list2">
      <button>查看</button>
    </BaseTable>
  </div>
</template>

<script>
import BaseComponent from './components/BaseComponent.vue';
import BaseTable from './components/BaseTable.vue';
export default {
  name: 'App',
  data () {
    return {
      msg: "你好",
      list1: [
        {id: 1, name: "a", age:"18"},
        {id: 2, name: "b", age:"19"},
        {id: 3, name: "c", age:"20"}
      ],
      list2: [
        {id: 1, name: "X", age:"18"},
        {id: 2, name: "Y", age:"29"},
        {id: 3, name: "Z", age:"30"}
      ]
    }
  },
  methods:{
    del(id){
      console.log(id)
    }
  },
  components: {
    BaseComponent,
    BaseTable
  }
}
</script>

<style>
#app {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
  justify-content: center;
  vertical-align: middle;
}
</style>
