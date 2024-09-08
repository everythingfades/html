<template>
  <div class="App">
    <UserInfo
      :username="username"
      :age="age"
      :isSingle="isSingle"
      :car="car"
      :hobby="hobby"
    >
    </UserInfo>
  </div>
</template>

<script>
import UserInfo from './components/UserInfo.vue';
// import Vue from 'vue';
export default {
  data () {
    return {
      username: "aaa",
      age: 18,
      isSingle: true,
      car: {
        brand: "benz",
      },
      hobby: ["唱","跳","rap","篮球"]
    }
  },
  components:{
    UserInfo
  }
}
</script>

<style>
.App{
  width: 600px;
  height: 700px;
  background-color: #87ceeb;
  margin: 0 auto;
  padding: 20px;
  align-items: center;
  text-align: center;
}
</style>