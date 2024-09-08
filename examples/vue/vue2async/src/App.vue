<template>
  <div id="app">
    <div v-if="isShow">
      <input ref="input" type="text" v-model="editvalue">
      <button>确认</button>
    </div>
    <div v-else>
      <p>{{ title }}</p>
      <button @click="edit">编辑</button>
    </div>
  </div>
</template>

<script>
// import HelloWorld from './components/HelloWorld.vue'

export default {
  name: 'App',
  components: {

  },
  data () {
    return {
      isShow: false,
      title: "something",
      editvalue: ""
    }
  },
  methods:{
    edit(){
      this.isShow = true
      console.log("由于异步更新,所以这个元素是undefined,需要用nextTick")
      this.$nextTick(()=>{
          console.log(this.$refs.input)
          this.$refs.input.focus()
        }
      )
    },
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
}
</style>
