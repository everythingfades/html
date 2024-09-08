<template>
  <div class="base-dialog">
    <div class="title">
      <slot name="head">
        默认title
      </slot>
      <button class="close">X</button>
    </div>

    <div class="content">
      <slot name="content">
        看不见我,看不见我....
      </slot>
    </div>

    <div class="buttons">
      <button>确认</button>
      <button>取消</button>
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>
.base-dialog-mask{
  position: fixed;
  left:0;
  top:0;
  width: 100%;
  height: 100%;
  background-color: rgba(0,0,0,0.3);
}
.base-dialog{
  position:relative;
  border: 2px solid black;
  border-radius: 3px;
  left: 50%;
  /* top: 50%; */
  transform: translateX(-150px);
  margin: 10px;
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