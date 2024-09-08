import Vue from 'vue'
import VueRouter from 'vue-router'
import Layout from '@/views/layout/index.vue'
import LoginPage from '@/views/login/index.vue'
import MyOrder from '@/views/myorder/index.vue'
import Pay from '@/views/pay/index.vue'
import ProductDetail from '@/views/prodetail/index.vue'
import Search from '@/views/search/index.vue'
import SearchList from '@/views/search/list.vue'

import Home from '@/views/layout/home.vue'
import Cart from '@/views/layout/cart.vue'
import User from '@/views/layout/user.vue'
import Category from '@/views/layout/category.vue'

Vue.use(VueRouter)

const routes = [
  { path: '/login', component: LoginPage },
  {
    path: '/',
    component: Layout,
    redirect: '/home',
    children: [
      { path: '/home', component: Home },
      { path: '/category', component: Category },
      { path: '/cart', component: Cart },
      { path: '/user', component: User }
    ]
  },
  { path: '/search', component: Search },
  { path: '/searchlist', component: SearchList },
  { path: '/prodetail/"id', component: ProductDetail },
  { path: '/pay', component: Pay },
  { path: '/myorder', component: MyOrder }
]

const router = new VueRouter({
  routes,
  mode: 'history'
})

export default router
