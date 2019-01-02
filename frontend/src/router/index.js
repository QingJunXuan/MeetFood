import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/views/Main.vue'
import GuestBasicInfor from '@/views/Guest/GuestBasicInfor.vue'
import AllReviews from '@/views/Guest/AllReviews.vue'
import MyFavorite from '@/views/Guest/MyFavorite.vue'
import Shop from '@/views/Shop/Shop.vue'
import Edit from '@/views/Shop/Edit.vue'
import Menu from '@/views/Shop/Menu.vue'
import Comment from '@/views/Shop/Comment.vue'
import Shop_host from '@/views/Shop/Shop_host.vue'
import GuestOrderAll from '@/views/Guest/Order/GuestOrderAll.vue'
import GuestOrderDone from '@/views/Guest/Order/GuestOrderDone.vue'
import GuestOrderUndone from '@/views/Guest/Order/GuestOrderUndone.vue'
import GuestOrderMonth from '@/views/Guest/Order/GuestOrderMonth.vue'
import GuestOrderWeek from '@/views/Guest/Order/GuestOrderWeek.vue'
import HostOrderAll from '@/views/Host/Order/HostOrderAll.vue'
import HostOrderDone from '@/views/Host/Order/HostOrderDone.vue'
import HostOrderUndone from '@/views/Host/Order/HostOrderUndone.vue'
import HostOrderMonth from '@/views/Host/Order/HostOrderMonth.vue'
import HostOrderWeek from '@/views/Host/Order/HostOrderWeek.vue'
import Login from '@/views/Login.vue'
import Register from '@/views/Register.vue'
import Discovery from '@/views/Discovery.vue'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  routes: [
    {
      path: '/',
      name: 'Main',
      component: Main
    },
    {
      path: '/Guest_Basic_Infor',
      name: 'GuestBasicInfor',
      meta: { login: true },
      component: GuestBasicInfor
    },
    {
      path: '/All_Reviews',
      name: 'AllReviews',
      meta: { login: true },
      component: AllReviews
    },
    {
      path: '/My_Favorite',
      name: 'MyFavorite',
      meta: { login: true },
      component: MyFavorite
    },
    {
      path: '/Guest_Order_All',
      name: 'GuestOrderAll',
      meta: { login: true },
      component: GuestOrderAll
    },
    {
      path: '/Guest_Order_Done',
      name: 'GuestOrderDone',
      meta: { login: true },
      component: GuestOrderDone
    },
    {
      path: '/Guest_Order_Undone',
      name: 'GuestOrderUndone',
      meta: { login: true },
      component: GuestOrderUndone
    },
    {
      path: '/Guest_Order_Month',
      name: 'GuestOrderMonth',
      meta: { login: true },
      component: GuestOrderMonth
    },
    {
      path: '/Guest_Order_Week',
      name: 'GuestOrderWeek',
      meta: { login: true },
      component: GuestOrderWeek
    },
    {
      path: '/Host_Order_All',
      name: 'HostOrderAll',
      meta: { login: true },
      component: HostOrderAll
    },
    {
      path: '/Host_Order_Done',
      name: 'HostOrderDone',
      meta: { login: true },
      component: HostOrderDone
    },
    {
      path: '/Host_Order_Undone',
      name: 'HostOrderUndone',
      meta: { login: true },
      component: HostOrderUndone
    },
    {
      path: '/Host_Order_Month',
      name: 'HostOrderMonth',
      meta: { login: true },
      component: HostOrderMonth
    },
    {
      path: '/Host_Order_Week',
      name: 'HostOrderWeek',
      meta: { login: true },
      component: HostOrderWeek
    },
    {
      path: '/Shop',
      name: 'Shop',
      props: true,
      component: Shop
    },
    {
      path: '/Edit',
      name: 'Edit',
      meta: { login: true },
      component: Edit
    },
    {
      path: '/Menu',
      name: 'Menu',
      component: Menu
    },
    {
      path: '/Comment',
      name: 'Comment',
      meta: { login: true },
      component: Comment
    },
    {
      path: '/Shop_host',
      name: 'Shop_host',
      
      component: Shop_host
    },
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path: '/register',
      name: 'Register',
      component: Register
    },
    {
      path: '/discovery',
      name: 'Discovery',
      component: Discovery
    }
  ]
})

router.beforeEach((to, from, next) => {
  // console.info(22, window.location.href)
  // console.info(to,from,next)
  // 对路由变化作出响应...
  // console.log(router,to)
  // console.log(router,to.query, from)
  // console.log(to,$.param( to.query ),window.location.href)
  // 全局拦截器的
  if (to.meta.login) { // 判断该路由是否需要登录权限
    if (window.localStorage.getItem('token') === null) {
      alert('Please login first')
      next({
        path: '/login',
        query: { redirect: to.fullPath } // 将跳转的路由path作为参数，登录成功后跳转到该路由
      })
    } else {
      console.log(window.localStorage.getItem('token'))
      next()
    }
  } else {
    next()
  }
})

export default router
