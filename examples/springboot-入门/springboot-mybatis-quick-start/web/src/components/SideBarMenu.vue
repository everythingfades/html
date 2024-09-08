<template>
  <div class="sidebar">
    <div class="icon"></div>
    <div class="menu">
      <el-col :span="24">
        <h5 class="mb-2">菜单栏</h5>
        <el-menu default-active="2" class="el-menu-vertical-demo">
          <el-sub-smenu index="1">
            <template #title>
              <span>Navigator One</span>
            </template>
            <el-menu-item-group title="">
              <el-menu-item index="1-1"></el-menu-item>
              <el-menu-item index="1-2">item two</el-menu-item>
            </el-menu-item-group>
            <el-menu-item-group title="Group Two">
              <el-menu-item index="1-3">item three</el-menu-item>
            </el-menu-item-group>
            <el-sub-menu index="1-4">
              <template #title>item four</template>
              <el-menu-item index="1-4-1">item one</el-menu-item>
            </el-sub-menu>
          </el-sub-smenu>
        </el-menu>
      </el-col>
    </div>
  </div>
</template>
<script>
export default {
  name: 'SideBarMenu'
}
</script>

<style scoped>
.icon {
  height: 10%;
  background-color: aquamarine;
}
.menu {
  height: 90%;
}
</style>
