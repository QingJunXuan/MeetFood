<template>
<div  >
   <guestTopbar/>
    <el-row type="flex" justify="center">
        <el-col :span="8">
            <!--logo-->
            <div style="height:70px"></div>
            <!--login-->
            <div class="login_box left">
                <b style="font-size:38px;color:#303133;margin-bottom:20px;">Login</b>
                <br><span style="color:#909399;font-size:15px;">Sign In to your account</span>
                 <el-form label-position="top" label-width="60px" style=" margin-top: 30px;" >
                    <el-form-item label="">
                        <el-input v-model="email" placeholder="E-mail"><template slot="prepend">&nbsp;&nbsp;</template></el-input>
                    </el-form-item>
                    <el-form-item label="">
                        <el-input v-model="pwd" type="password" placeholder="Password"><template slot="prepend">&nbsp;&nbsp;</template></el-input>
                        <span style="color:#e4260c">{{wrong_pwd}}</span>
                    </el-form-item>      
                    <el-form-item >
                        <b class="forget" @click="forget">forget your password?</b>
                    </el-form-item>           
                    <el-form-item>
                        <el-button  @click="loginGuest" 
                        style="background-color:#F5C300;color:#fff;font-weight:500;font-size:17px;width:110px;">
                          Login
                          </el-button>
                          <el-button  @click="loginHost" type="text">
                            Login as a host
                          </el-button>
                    </el-form-item>                   
                   
                        <!--<div class="sign_up">
                            <el-button  @click="register" style="width:100%;">注册新账户</el-button>
                        </div>-->
                </el-form>
            </div>            
        </el-col>

        <el-col :span="7">
          <div style="height:70px;"></div>
          <div class="login_box right">
            <b style="font-size:34px;color:#fff;margin-bottom:20px;">Sign up</b>
            <p style="width:280px;color:#fff;font-weight:100;font-size:19px;">
              Register a new account to join in the incredible food journey!
              You can sign up as a guest to be a order and enjoy fascinating food
              or as a host to offer your wonderful dishes to all your guests.
            </p>
            <el-button  @click="Signup" 
              style="background-color:#F5C300;color:#fff;font-weight:500;font-size:17px;width:110px;">
              Sign up
              </el-button>
            </div>
        </el-col>

    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
    import * as axios from 'axios'

    export default {
      components:{
        guestTopbar
      },
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
        loginGuest:function () {
          console.log(localStorage.token);
          delete localStorage.token;
          delete localStorage.username;
          this.$store.state.username = '';
          this.$store.state.token = '';
          console.log(localStorage.token);
          let token_pointer = this
          this.button_disabled = true;
          //this.role = "ROLE_REQUESTER";
          if (this.email == "") {
            this.$message({
              message: 'Please enter the email',
              type: 'warning'
            });
          }
          else if (this.pwd == "") {
            this.$message('Please enter the password');
          }
          else
          {
            if(this.email == "666@qq.com"&&this.pwd == "tongji"){
              this.$store.state.username = 'z';
              this.$store.state.token = '1234';
            }
            /*let param = new URLSearchParams();
            let self = this;
            let login = false;
            param.append('email',this.email);
            param.append('password',this.pwd);
            
            axios({
              method:	'post',
              url: 'http://172.20.10.4:8080/guest/login',
              data:param
            })
              .then(function (response) {
                console.log(response);
                if(response.data.code[0] == "2") {
                  window.sessionStorage.removeItem('token');
                  let token = response.data.X_Auth_Token;//token
                  let email = self.email;
                  let user_information = {
                    token: token,
                    email: email
                  }
                  token_pointer.$store.commit('UserLogin', user_information);
                  /*axios({
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
              });*/
          }
        },
        loginHost:function () {
          delete localStorage.token;
          delete localStorage.username;
          let self = this
          this.button_disabled = true;
          //this.role = "ROLE_WORKER";
          if (this.email == "") {
            this.$message({
              message: 'Please enter the email',
              type: 'warning'
            });
          }
          else if (this.pwd == "") {
            this.$message('Please enter the password');
          }
          else
          {
            let param = new URLSearchParams();
            param.append('email',this.email);
            param.append('password',this.pwd);
            
            axios({
              method:	'post',
              url: 'http://172.20.10.4:8080/dining/login',
              data:param
            })
              .then(function (response) {
                window.localStorage.getItem('token');
                if(response.data.code[0] == "2") {
                  console.log("login")
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
        }
      }
    }
</script>

<style scoped>

.login_box{
    border-style:solid;
    border-width: 1px;
    border-color:rgb(209, 209, 209);
    height: 300px;
    padding:30px 40px;
    margin-top: 20px;
    margin-bottom: 50px;
    background-color:#fff;
}
.left{
  border-radius: 4px 0px 0px 4px;
  border-right: 0px;
  padding: 60px 60px
}
.right{
  border-radius: 0px 4px 4px 0px;
   border-left: 0px;
   background-color: #20A8D8;
   text-align:center ;
   padding-top:90px;
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



