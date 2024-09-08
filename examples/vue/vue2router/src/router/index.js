import VueRouter from 'vue-router';
import Vue from 'vue'
import BootstrapVue from 'bootstrap-vue'

// import Find from '../views/Find.vue'
import Home from '@/views/Home.vue';
// import SearchPagePDF from '@/views/SearchPagePDF.vue'
import SearchPageDialog from '@/views/SearchPageDialog.vue'
import Comments from '../views/Comments.vue'
import NotFound from '@/views/NotFound.vue';
import Navigate from '@/views/Navigate.vue'
Vue.use(VueRouter)
Vue.use(BootstrapVue)

const router = new VueRouter({
  routes:[
    { path: '/', redirect: "/home"},
    { path: '/home', component: Home },
    { path: '/search/:path*', component: SearchPageDialog, sensitive: false, strict: false},
    // { path: '/search/pdf/:path*', component: SearchPagePDF, sensitive: false, strict: false},
    { path: '/comments', component: Comments},
    { path: '/navigate/:path*', component: Navigate, sensitive: false, strict:false},
    { path: '/notfound', component: NotFound},
    { path: '*', component: NotFound,}
  ],
  linkActiveClass: "link-active",
  linkExactActiveClass: "link-exact-active",
  mode: "hash"
})

export default router