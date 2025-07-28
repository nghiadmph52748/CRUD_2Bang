import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: '123',
      redirect: '/category',
    },
    {
      path: '/category',
      name: 'home',
      component: () => import('../views/HoaDonView.vue'),
      children: [{
        path: 'detail/:id',
        name: 'detail',
        component: () => import('../views/HoaDonView.vue'),
      },
      {
        path: 'update/:id',
        name: 'update',
        component: () => import('../views/HoaDonView.vue'),
      },
      {
        path: 'delete/:id',
        name: 'delete',
        component: () => import('../views/HoaDonView.vue'),
      },
      {
        path: 'add',
        name: 'add',
        component: () => import('../views/HoaDonView.vue'),
      }
      ]
    },
    {
      path: '/about',
      name: 'about',
    },
  ],
})

export default router
