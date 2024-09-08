import { defineStore } from 'pinia'
import { ref, computed } from 'vue'

const useCounterStore = defineStore('counter', ()=>{
  //state
  const count = ref(0)
  const msg = ref("something")
  //actions
  const addCount = () => count.value++
  const subCount = () => count.value--
  //getters
  const double = computed(() => count.value * 2)
  return {
    count,
    msg,
    addCount,
    subCount,
    double
  }
},
{
  persist: {
    key: 'counter'
  }
})

export default useCounterStore