import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

// 初始化时用sessionStore.getItem('token') 刷新页面就无需重新登录

const store = new Vuex.Store()

export default store
