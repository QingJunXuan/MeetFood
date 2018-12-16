<template>
<div style="background-color:#E4E5E6;height:740px;" >
    <el-row type="flex" justify="center">
        <el-col :span="7">
            <!--logo-->
            <div style="height:120px"></div>
            <!--login-->
            <div class="login_box">
                <b style="font-size:38px;color:#303133;margin-bottom:20px;">登录</b>
                <br><span style="color:#909399;font-size:15px;">登录以进入你的账号</span>
                 <el-form label-position="top" label-width="60px" style=" margin-top: 30px;">
                    <el-form-item label="">
                        <el-input v-model="email" placeholder="邮箱"><template slot="prepend">&nbsp;&nbsp;</template></el-input>
                    </el-form-item>
                    <el-form-item label="">
                        <el-input v-model="pwd" type="password" placeholder="密码"><template slot="prepend">&nbsp;&nbsp;</template></el-input>
                        <span style="color:#e4260c">{{wrong_pwd}}</span>
                    </el-form-item>      
                    <el-form-item >
                        <b class="forget" @click="forget">忘记密码？</b>
                    </el-form-item>           
                    <el-form-item>
                        <el-button  @click="loginRequester" class="login_button login_requester">以Requester身份登录</el-button>
                    </el-form-item>
                    <el-form-item>
                        <el-button  @click="loginWorker" class="login_button login_worker">以Worker身份登录</el-button>
                    </el-form-item>
                    
                    <el-form-item>
                        <div class="sign_up">
                            <el-button  @click="register" style="width:100%;">注册新账户</el-button>
                        </div>
                    </el-form-item>
                </el-form>
            </div>

        </el-col>

    </el-row>
</div>
</template>

<script>
    import * as axios from 'axios'

    export default {
      computed: {
        getToken () {
          return this.$store.state.token;
        }
      },
      methods: {
        setToken: function() {
          this.$store.commit('newToken', this.textValue)
        },
        register(){
          this.$router.push('/register')
        },
        loginRequester:function () {
          console.log(localStorage.token);
          delete localStorage.token;
          delete localStorage.username;
          this.$store.state.username = '';
          this.$store.state.token = '';
          console.log(localStorage.token);
          let token_pointer = this
          this.button_disabled = true;
          this.role = "ROLE_REQUESTER";
          if (this.email == "") {
            this.$message({
              message: '请输入用户名',
              type: 'warning'
            });
          }
          else if (this.pwd == "") {
            this.$message('请输入密码');
          }
          else
          {
            let param = new URLSearchParams();
            let self = this;
            let login = false;
            param.append('username',this.email);
            param.append('password',this.pwd);
            param.append('role',this.role);
            axios({
              method:	'post',
              url: '/api/login',
              data:param
            })
              .then(function (response) {
                console.log(response);
                if(response.data.code[0] == "2") {
                  window.sessionStorage.removeItem('token');
                  let token = response.data.X_Auth_Token;
                  let email = self.email;
                  let user_information = {
                    token: token,
                    email: email
                  }
                  token_pointer.$store.commit('UserLogin', user_information);
                  axios({
                    method:	'get',
                    url: '/api/requester/find-myself',
                  })
                    .then(function (response) {
                      console.log(response);
                      if(response.data.code[0] == "2") {
                        let requester_information = {
                          username: response.data.requester.username
                        }
                        token_pointer.$store.commit('RequesterLogin', requester_information);
                      }
                    })
                    .catch(function (error) {
                      alert(error);
                    });
                  token_pointer.button_disabled = false;
                }
                else if(response.data.code[0] == "4") {
                  token_pointer.wrong_pwd = "用户名或密码错误";
                  token_pointer.button_disabled = false;
                }
                else if(response.data.code[0] == "5") {
                  token_pointer.wrong_pwd("服务器错误")
                  token_pointer.button_disabled = false;
                }
              })
              .catch(function (error) {
                alert(error);
                token_pointer.button_disabled = false;
              });
          }
        },
        loginWorker:function () {
          delete localStorage.token;
          delete localStorage.username;
          let self = this
          this.button_disabled = true;
          this.role = "ROLE_WORKER";
          if (this.email == "") {
            this.$message({
              message: '请输入用户名',
              type: 'warning'
            });
          }
          else if (this.pwd == "") {
            this.$message('请输入密码');
          }
          else
          {
            let param = new URLSearchParams();
            param.append('username',this.email);
            param.append('password',this.pwd);
            param.append('role',this.role);
            axios({
              method:	'post',
              url: '/api/login',
              data:param
            })
              .then(function (response) {
                window.localStorage.getItem('token');
                if(response.data.code[0] == "2") {
                  let token = response.data.X_Auth_Token;
                  console.log(token);
                  let user_information = {
                    token: token,
                    email: self.email
                  }
                  self.$store.commit('UserLogin', user_information);
                  axios({
                    method:	'get',
                    url: '/api/worker/find-myself',
                  })
                    .then(function (response) {
                      console.log(response);
                      if(response.data.code[0] == "2") {
                        console.log(response);
                        let worker_information = {
                          username: response.data.worker.username,
                          level:response.data.worker.level,
                        }
                        self.$store.commit('WorkerLogin', worker_information);
                        self.$router.replace("/worker_task_square");
                      }
                    })
                    .catch(function (error) {
                      alert(error);
                    });
                  self.$router.replace("/worker_task_square");
                  self.wrong_pwd = "";
                  self.button_disabled = false;
                }
                else if(response.data.code[0] == "4") {
                  self.wrong_pwd = "用户名或密码错误";
                  self.button_disabled = false;
                }
                else if(response.data.code[0] == "5") {
                  self.wrong_pwd("服务器错误")
                  self.button_disabled = false;
                }
              })
              .catch(function (error) {
                alert(error);
              });
            if(login == 'true'){
              console.log(a);
            }
          }
        },
        forget(){
            this.$prompt('请输入邮箱', '找回密码', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            inputPattern: /[\w!#$%&'*+/=?^_`{|}~-]+(?:\.[\w!#$%&'*+/=?^_`{|}~-]+)*@(?:[\w](?:[\w-]*[\w])?\.)+[\w](?:[\w-]*[\w])?/,
            inputErrorMessage: '邮箱格式不正确'
          }).then(({ value }) => {
            this.$message({
              type: 'success',
              message: '你的邮箱是: ' + value
            });
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '取消输入'
            });       
          });
        }
      },
      data () {
        return {
          email:'',
          pwd:'',
          role:'',
          wrong_pwd:'',
          button_disabled:false,
          radio:false,
          logo:require("../../static/logo_black.png"),
        }
      }
    }
</script>

<style scoped>

.login_box{
    border-style:solid;
    border-width: 1px;
    border-color:rgb(209, 209, 209);
    border-radius: 4px;
    padding:30px 40px;
    margin-top: 20px;
    background-color:#fff;
}
.el-form--label-top .el-form-item__label{
    padding-bottom:0;
    font-size: 18px;
}
.el-form-item{
    margin-bottom: 10px;
}

.el-input__inner:hover{
    border-color: rgb(147, 206, 229);
}
.el-input__inner:focus {
    border-color: #42a5f5;
    box-shadow: 8px;
    transition-duration: .5s;
}
.login_button{
    width:100%;
    background-color: #00ACED;
    color: #fff;
}
.login_button:hover{
    background-color: #0090C7
}
.login_worker{
  background-color: #4DBD74
}
.login_worker:hover{
  background-color: rgb(61, 168, 99)
}
.sign_up{
    border-top: solid 1px rgb(224, 224, 224);
    padding-top: 20px;
}
.forget{
  font-size:13px;
}
.forget:hover{
  color: rgb(22, 139, 185)
}
</style>



