<template>
  <div class="breadcrumb">
    <el-breadcrumb separator="/">
      <!-- <el-breadcrumb-item v-for="item in path.split('/')" :key="item">{{
        item
      }}</el-breadcrumb-item> -->
    </el-breadcrumb>
  </div>
</template>

<style scoped></style>

<script>
import router from '../router'
export default {
  name: 'BreadCrumb',
  data() {
    return {
      path: router.currentRoute.value
    }
  },
  mounted() {
    console.log(this.path)
  }
}
</script>

<style scoped>
.breadcrumb {
  border: 1px solid black;
  height: 10%;
  width: 100%;
}
</style>
