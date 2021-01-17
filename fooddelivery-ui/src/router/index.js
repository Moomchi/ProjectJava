import Vue from 'vue'
import VueRouter from 'vue-router'
import Home from '../views/Home.vue'
import Burger from '../views/Burger'
import Pizza from '../views/Pizza'
import Salad from '../views/Salad'
import Dessert from '../views/Dessert'
import Drink from '../views/Drink'
import Sauce from '../views/Sauce'
import Cart from '../views/Cart'
import Orders from '../views/Orders'

Vue.use(VueRouter)

const routes = [
  {
    path: '/',
    name: 'Home',
    component: Home
  },
  {
    path: '/burger',
    name: 'Burger',
    component: Burger
  },
  {
    path: '/pizza',
    name: 'Pizza',
    component: Pizza
  },
  {
    path: '/salad',
    name: 'Salad',
    component: Salad
  },
  {
    path: '/dessert',
    name: 'Dessert',
    component: Dessert
  },
  {
    path: '/drink',
    name: 'Drink',
    component: Drink
  },
  {
    path: '/sauce',
    name: 'Sauce',
    component: Sauce
  },
  {
    path: '/cart',
    name: 'Cart',
    component: Cart
  },
  {
    path: '/orders',
    name: 'Orders',
    component: Orders
  },
  {
    path: '/about',
    name: 'About',
    // route level code-splitting
    // this generates a separate chunk (about.[hash].js) for this route
    // which is lazy-loaded when the route is visited.
    component: () => import(/* webpackChunkName: "about" */ '../views/About.vue')
  }

]

const router = new VueRouter({
  routes
})

export default router
