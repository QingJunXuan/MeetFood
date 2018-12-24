import Vue from 'vue'
import Router from 'vue-router'
import Main from '@/views/Main.vue'
import GuestBasicInfor from '@/views/Guest/GuestBasicInfor.vue'
import GuestDetailInfor from '@/views/Guest/GuestDetailInfor.vue'
import AllReviews from '@/views/Guest/AllReviews.vue'
import MyFavorite from '@/views/Guest/MyFavorite.vue'
import Message from '@/views/Guest/Message.vue'
import Shop from '@/views/Shop/Shop.vue'

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
      path: '/Guest_Detail_Infor',
      name: 'GuestDetailInfor',
      component: GuestDetailInfor
    },
    {
      path: '/ALL_Reviews',
      name: 'AllReviews',
      component: AllReviews
    },
    {
      path: '/My_Favorite',
      name: 'MyFavorite',
      component: MyFavorite
    },
    {
      path: '/Message',
      name: 'Message',
      component: Message
    },
    {
      path: '/Shop',
      name: 'Shop',
      component: Shop
    },
  ]
})

export default router
