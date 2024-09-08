<template>
    <div class="wrapper">
      <p>我是C组件(接受方)</p>
      <p>{{msg}}</p>
    </div>
  </template>
  
  <script>
  import Bus from "../utils/EventBus.js"
  export default {
    created () {
      Bus.$on("sendMsg", (msg)=>{
        console.log(msg)
        this.msg = msg
      })
    },
    data(){
      return {
        msg: ""
      }
    }
  }
  </script>
  
  <style>
  .wrapper{
    width: 400px;
    height: 300px;
    border: 2px solid black;
  }
  </style>