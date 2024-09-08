<template>
  <div v-show="visible" class="base-dialog-mask">
    <div class="base-dialog">
      <div class="title">
        <h3>提示</h3>
        <button class="close"
          @click="close"
        >X</button>
      </div>

      <div class="content">
        <p>确定要退出吗?</p>
      </div>

      <div class="buttons">
        <button
          @click="close"
        >确认</button>
        <button>取消</button>
      </div>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    visible: Boolean
  },
  methods: {
    close(){
      this.$emit('update:visible', false)
    }
  }
}
</script>

<style>
.base-dialog-mask{
  position: fixed;
  left:0;
  top:0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,0.3);
}
.base-dialog{
  position:fixed;
  border: 2px solid black;
  border-radius: 3px;
  left: 50%;
  top: 50%;
  transform: translateX(-150px) translateY(-100px);
  height: 200px;
  width: 300px;
  background-color: #fff;
  padding: 10px;
}
.title{
  position: relative;
  width: 100%;
  height: 40px;
  display: flex;
  justify-content: space-between;
  border-bottom: solid 2px black;
}
.content{
  position: relative;
  height: 100px;
  width: 100%;
  text-align: left;
}
.buttons{
  position: relative;
  height:50px;
  width:100%;
  display: flex;
  justify-content: space-between;
}
</style>