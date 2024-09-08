<template>
  <div id="app">
    <BaseSelect
     v-model="selectId"
    >
    </BaseSelect>
    <p>{{selectId}}</p>
  </div>
</template>

<script>
import BaseSelect from "./components/BaseSelect.vue"
export default {
  data(){
    return {
      selectId: "102"
    }
  },
  components:{
    BaseSelect
  }
}
</script>

<style>

</style>