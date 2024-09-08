<template>
  <div class="app">
    <h1 v-color="color1">自定义指令</h1>
    <h1 v-color="color2">自定义指令</h1>
    <input v-color="color1" ref="input" type="text">
    <p>v-loading示例</p>
    <ul v-loading="isLoading" class="news-list">
      <li v-for="item in news" :key="item.id">
        <div class="left">
          <div class="title">
            <p>{{item.title}}</p>
          </div>
          <div class="other-info">
            <span>{{item.source}}</span>
            <span>{{item.time}}</span>
          </div>
        </div>
        <div class="right">
          <img class="news-image" :src="'https://ajax-api.itheima.net/public'+item.img" alt="">
        </div>
      </li>
    </ul>
  </div>
</template>
<!-- <script src="https://cdn.jsdelivr.net/npm/axios/dist/axios.min.js"></script> -->
<script>
// import HelloWorld from './components/HelloWorld.vue'
import axios from 'axios';
export default {
  // mounted (){
  //   this.$ref.input.focus()
  // }
  data () {
    return {
      color1: "red",
      color2: "green",
      news: [
      ],
      isLoading: true
    }
  },
  directives: {
    // 指令名: 指令配置项
    focus: {
      inserted (el) {
        el.focus()
      }
    },
    loading: {
      inserted(el, binding){
        binding.value ? el.classList.add("loading") : el.classList.remove("loading");
        binding.value ? el.style.overflow = "hidden" : el.style.overflow = "scroll"
      },
      update(el, binding){
        binding.value ? el.classList.add("loading") : el.classList.remove("loading");
        binding.value ? el.style.overflow = "hidden" : el.style.overflow = "scroll"
      }
    }
  },
  async created (){
    const res = await axios.get(
      "https://hmajax.itheima.net/api/news/"
    )
    setTimeout(()=>{
      this.news = res.data.data
      this.isLoading = false
    }, 2000)
    console.log(this.news)
  }
}
</script>

<style>
.box {
  font-family: Avenir, Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  color: #2c3e50;
  margin-top: 60px;
}

.news-list{
  width: 800px;
  height: 60%;
  position: absolute;
  left: 50%;
  transform: translateX(-400px);
  overflow: scroll;
  justify-content: center;
  align-content: center;
}
.news-image{
  height: 200px;
  width: 200px;
  position: absolute;
  top: 50%;
  transform: translateY(-100px);
  border: solid 1px black;
}
.news-list li{
  position: relative;
  display: flex;
  margin: 20px;
  height: 250px;
  border: solid 1px black;
  overflow: hidden;
}

.left {
  position: absolute;
  height: 100%;
  width: 60%;
  left: 0px;
  top: 0px;
}

.right{
  position: absolute;
  height: 100%;
  width: 30%;
  right: 0px;
  top: 0px;
}

.title{
  position: absolute;
  height: 30%;
  width: 100%;
  top: 0px;
}

.other-info{
  position: absolute;
  height: 30%;
  width: 100%;
  bottom: 0px;
}

.loading:before{
  content: '';
  /* overflow:hidden; */
  position: absolute;
  left: 0;
  top: 0;
  width: 100%;
  height: 100%;
  z-index: 10;
  background: #fff url("https://gifdb.com/images/high/buffering-animated-text-icon-loading-u1h739who8u5mtw3.gif") no-repeat center;
}
</style>
