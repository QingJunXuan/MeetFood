import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex);

//初始化时用sessionStore.getItem('token'),这样子刷新页面就无需重新登录

const store = new Vuex.Store({
  state: {
    // 存储token
    token: window.localStorage.getItem('token'),
    
  },

  mutations: {
    UserLogin(state,token){
      window.localStorage.setItem('token', token);
      state.token = token;
    },
    UserInfo(state,user_information){
      window.localStorage.setItem('username', user_information.username);
      state.username = user_information.username;
    },
    UserLogout(state) {
        window.localStorage.removeItem("token");
      window.localStorage.removeItem("username");
      while(window.localStorage.getItem('token') != undefined || window.localStorage.getItem('username') !=undefined){
        console.log(window.localStorage.getItem('token'));
      };
    },
  }
});

export default store;

