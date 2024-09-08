<template>
  <div id="app">
    <BaseProgress
     :w="width">
    </BaseProgress>
  </div>
</template>

<script>
import BaseProgress from './components/BaseProgress.vue';
export default {
  data () {
    return {
      width: 20
      // 这里只能出现数字,但是console没有任何提示
    }
  },
  components: { 
    BaseProgress 
  },
}
</script>

<style>

</style>