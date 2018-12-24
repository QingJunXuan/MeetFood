import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// 初始化时用sessionStore.getItem('token') 刷新页面就无需重新登录

const store = new Vuex.Store({
  state: {
    // 存储token
    token: window.localStorage.getItem('token'),
    name: window.localStorage.getItem('name'),
  },

  mutations: {
    UserLogin (state, token) {
      window.localStorage.setItem('token', token)
      state.token = token
    },
    UserInfo (state, user_information) {
      window.localStorage.setItem('name', user_information.name)
      state.name = user_information.name
    },
    UserLogout(state){
      window.localStorage.removeItem ("token")
      window.localStorage.removeItem("name")
      while(window.localStorage.getItem('token') != undefined || window.localStorage.getItem('name') !=undefined){
        console.log(window.localStorage.getItem('token'))
       }  ``
      }
  })

export default store
