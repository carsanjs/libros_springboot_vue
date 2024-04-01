import { createRouter, createWebHistory } from 'vue-router'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: () => import('../views/HomeView.vue')
    },
    {
      path: '/sesion',
      name: 'Sesion',
      component: () => import('../views/VSesion.vue')
    },
    {
      path:'/registro',
      name:'Registro',
      component: () => import('../views/VRegistro.vue')
    },
    {
      path:'/crud',
      name:'crud',
      component: () => import('../views/Vistascrud.vue')
    }
   
  ]
})

export default router
