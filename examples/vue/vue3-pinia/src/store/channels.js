import { defineStore } from 'pinia' 
import { ref } from 'vue'
import axios from 'axios'

export const useChannelStore = defineStore('channel', () => {
  //数据
  const channelList = ref([])
  //
  const getList = async () => {
    const { data: { data }} = await axios.get('https://geek.itheima.net/v1_0/channels')
    channelList.value = data.channels
    console.log(channelList.value)
  }
  return {
    channelList,
    getList
  }
})

export default useChannelStore