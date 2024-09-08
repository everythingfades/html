<script setup>
import Son1 from '@/components/Son1Com.vue'
import Son2 from '@/components/Son2Com.vue'
import useCounterStore from '@/store/counter.js'
import useChannelStore from '@/store/channels.js' 
import { storeToRefs } from 'pinia'

const counterStore = useCounterStore()
const channelStore = useChannelStore()

const {count, msg} = storeToRefs(counterStore)
</script>

<template>
  <div>
    <h3>App.vue
      - {{ count }}
      - {{ counterStore.msg }}
      - {{ counterStore.double }}
    </h3>
    <Son1></Son1>
    <Son2></Son2>
    <button @click="channelStore.getList">获取列表</button>
    <ul>
      <li v-for="item in channelStore.channelList">{{item.name}}</li>
    </ul>
  </div>
</template>

<style scoped>
</style>