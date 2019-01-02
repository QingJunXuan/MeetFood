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
      component: GuestBasicInfor
    },
    {
      path: '/All_Reviews',
      name: 'AllReviews',
      component: AllReviews
    },
    {
      path: '/My_Favorite',
      name: 'MyFavorite',
      component: MyFavorite
    },
    {
      path: '/Guest_Order_All',
      name: 'GuestOrderAll',
      component: GuestOrderAll
    },
    {
      path: '/Guest_Order_Done',
      name: 'GuestOrderDone',
      component: GuestOrderDone
    },
    {
      path: '/Guest_Order_Undone',
      name: 'GuestOrderUndone',
      component: GuestOrderUndone
    },
    {
      path: '/Guest_Order_Month',
      name: 'GuestOrderMonth',
      component: GuestOrderMonth
    },
    {
      path: '/Guest_Order_Week',
      name: 'GuestOrderWeek',
      component: GuestOrderWeek
    },
    {
      path: '/Host_Order_All',
      name: 'HostOrderAll',
      component: HostOrderAll
    },
    {
      path: '/Host_Order_Done',
      name: 'HostOrderDone',
      component: HostOrderDone
    },
    {
      path: '/Host_Order_Undone',
      name: 'HostOrderUndone',
      component: HostOrderUndone
    },
    {
      path: '/Host_Order_Month',
      name: 'HostOrderMonth',
      component: HostOrderMonth
    },
    {
      path: '/Host_Order_Week',
      name: 'HostOrderWeek',
      component: HostOrderWeek
    },
    {
      path: '/Shop/:id',
      name: 'Shop',
      props: true,
      component: Shop
    },
    {
      path: '/Edit',
      name: 'Edit',
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
      alert('未登录，请先登录')
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
