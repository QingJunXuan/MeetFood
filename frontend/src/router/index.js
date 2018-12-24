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
import test from '@/views/Guest/test.vue'

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
      path: '/test',
      name: 'test',
      component: test
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
      path: '/Shop',
      name: 'Shop',
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
      component: Comment
    }
  ]
})

export default router
