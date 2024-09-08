<template>
  <div class="app">
    <div class="sidebar">
      <SideBarMenu></SideBarMenu>
    </div>
    <div class="main">
      <BreadCrumb></BreadCrumb>
      <RouterView id="router-view"></RouterView>
    </div>
  </div>
</template>

<script>
import { RouterView } from 'vue-router'
import SideBarMenu from './components/SideBarMenu.vue'
import BreadCrumb from './components/BreadCrumb.vue'
export default {
  name: 'app',
  components: {
    SideBarMenu,
    RouterView,
    BreadCrumb
  }
}
</script>

<style lang="scss">
.sidebar {
  position: fixed;
  height: 100%;
  width: 15%;
  left: 0px;
  bottom: 0px;
  border: 1px solid black;
}

.main {
  position: fixed;
  height: 100%;
  width: 85%;
  right: 0px;
  top: 0px;
}
#router-view {
  height: 100%;
}
</style>
