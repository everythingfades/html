// import './assets/main.css'
import { createPinia } from 'pinia'
import piniaPluginPersistedState from 'pinia-plugin-persistedstate'

import { createApp } from 'vue'
import App from './App.vue'
const pinia = createPinia()

pinia.use(piniaPluginPersistedState)

const app = createApp(App)
app.use(pinia)
app.mount('#app')
// createApp(App).use(pinia).mount('#app')
