import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/LoginPage.vue')
    },
    {
      path: '/employers',
      name: 'employers',
      component: () => import('../views/EmployersPage.vue')
    },
    {
      path: '/depts',
      name: 'departments',
      component: () => import('../views/DeptPage.vue')
    }
  ]
})

export default router
