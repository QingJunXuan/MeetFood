<template>
<div  >
    <guestTopbar/>
    <el-row type="flex" justify="center">
        <el-col :span="8">          
            <!--login-->
            <div class="requester_box">
                <b style="font-size:38px;color:#303133;margin-bottom:20px;">Register</b>
                <br><span style="color:#909399;font-size:15px;">Create a new account</span>
                 <el-form label-position="top" label-width="60px" :model="user" :rules="rules" required ref="user" status-icon>                   
                    
                    <div v-if="this.user.identity=='Guest'">
                    <el-form-item label="" prop="username">
                        <el-input v-model="user.username" placeholder="Username">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                            </el-input>
                    </el-form-item>
                    <el-form-item label="" prop="age">
                        <el-input v-model="user.age" placeholder="Age">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                            </el-input>
                    </el-form-item>
                    </div>
                    <div v-if="this.user.identity=='Host'">
                        <el-form-item label="" prop="dinningname">
                        <el-input v-model="user.dinningname" placeholder="Restraurant Name">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                            </el-input>
                        </el-form-item>
                                                                          
                    </div>
                    <el-form-item label="" prop="email">
                        <el-input v-model="user.email" placeholder="E-mail">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                            </el-input>
                    </el-form-item>
                    <el-form-item label="" prop="tele">
                        <el-input v-model="user.tele" placeholder="Telephone">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                            </el-input>
                    </el-form-item>
                    <el-form-item label="" prop="pwd">
                        <el-input v-model="user.pwd" type="password" placeholder="Password">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                        </el-input>
                    </el-form-item>
                    <el-form-item label="" prop="pwd2">
                        <el-input v-model="user.pwd2" type="password" placeholder="Confirm password">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                        </el-input>
                    </el-form-item>
                    
                    <div v-if="this.user.identity=='Host'">
                        <el-form-item label="" prop="address">
                        <el-input 
                            v-model="user.address" placeholder="Address of the restraunt">                           
                            </el-input>
                        </el-form-item>
                        <el-form-item label="" prop="dinningtype"> 
                            <el-select v-model="user.dinningtype" placeholder="Restraurant Type">
                                <template slot="prepend">&nbsp;&nbsp;</template>
                                <el-option label="Asian cuisines" value="Asian cuisines"></el-option>
                                <el-option label="European cuisines" value="European  cuisines"></el-option>
                                <el-option label="Others" value="Others"></el-option>
                            </el-select>
                        </el-form-item>
                        <el-form-item label="" prop="dinningintro">
                        <el-input :autosize="{ minRows: 3, maxRows: 4}"  type="textarea"
                            v-model="user.dinningintro" placeholder="Introduction of the restaurant">                           
                            </el-input>
                        </el-form-item>
                    </div>
                    <el-form-item label="" prop="identity">
                        <el-radio-group v-model="user.identity">
                            <el-radio-button label="Guest"></el-radio-button>
                            <el-radio-button label="Host"></el-radio-button>                                             
                        </el-radio-group>
                    </el-form-item> 
                    <el-form-item style="padding-top:10px;">
                        <el-button  @click="register('user')" class="register_button">Register</el-button>
                    </el-form-item>                                       
                </el-form>
                <div style="margin-bottom:0;font-size:15px;">
                    <span style="color:#606266">Already have an account?</span>
                    <div class="login_text"><b @click="login">Login</b></div>
                </div>
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
        } ,
        methods: {
           login () {
                this.$router.push('/login')
            },
            register(formName) {
                this.$refs[formName].validate((valid) => {
                if (valid){
                    if(this.user.identity=="Guest"){
                        
                    let that = this;
                    let param = new URLSearchParams();
                    param.append('username',that.user.username);
                    param.append('email',that.user.email);
                    param.append('password',that.user.pwd);
                    param.append('age',that.user.age);
                    param.append('teleNumber',that.user.tele);                   
                    console.log(param);
                    axios({
                    method:'post',
                    url: 'http://172.20.10.4:8080/guest/register',
                    data:param
                    })
                    .then(function(response){
                      console.log(response);
                        if(response.data.code[0] == "2"){
                            that.$message('Registration successful');
                            that.$router.replace('/login');
                        }
                        else if(response.data.code == "400") {
                        that.wrong_pwd("Error400")
                        }
                        else if(response.data.code == "500") {
                        that.wrong_pwd("Error500")
                        }
                    })
                    .catch(function (error) {
                        alert(error);
                    });                  
                } 
                else if(this.user.identity=="Host"){
                    let that = this;
                    let param = new URLSearchParams();
                    param.append('name',that.user.dinningname);
                    param.append('email',that.user.email);
                    param.append('password',that.user.pwd);
                    param.append('type',that.user.dinningtype);
                    param.append('intro',that.user.dinningintro);   
                    param.append('tel',that.user.tele); 
                    param.append('address',that.user.address);                 
                    
                    axios({
                    method:'post',
                    url: '/api/dining/register',
                    data:param
                    })
                    .then(function(response){
                      console.log(response);
                        if(response.data.code == "200"){
                            
                            that.$message('Registration successful');
                            that.$router.replace('/login');
                        }
                        else if(response.data.code == "400") {
                        that.wrong_pwd("Error400")
                        }
                        else if(response.data.code == "500") {
                        that.wrong_pwd("Error500")
                        }
                    })
                    .catch(function (error) {
                        alert(error);
                    });  
                }
                }else {
                    console.log('error submit!!');
                    return false;
                }
                
                });
            },
        },
        data () {
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                callback(new Error('Please enter the password'));
                } else {
                if (this.user.pwd2 !== '') {
                    this.$refs.user.validateField('pwd2');
                }
                callback();
                }
            };
            var validateCheck = (rule, value, callback) => {
                    if (value === '') {
                    callback(new Error('Please enter the password again'));
                    } else if (value !== this.user.pwd) {
                    callback(new Error('The two passwords you entered did not match'));
                    } else {
                    callback();
                    }
                };    
            return {    
                       
                user: {
                    username:'',
                    email:'',
                    tele:'',
                    pwd:'',
                    pwd2:'',
                    identity:'Guest',
                    dinningname:'',
                    age:'',
                    dinningname:'',
                    dinningtype:'',
                    dinningintro:'',
                    address:''
                },
                rules: {
                    username: [
                        {required: true, message: 'Please enter the username', trigger: 'blur'}
                    ],
                    email:[
                        {required: true, message: 'Please enter the E-mail', trigger: 'blur'}
                    ],
                    pwd: [
                        {validator:validatePass, trigger: 'blur'}
                    ],
                    pwd2:[
                        {validator:validateCheck, trigger: 'blur'}
                    ],
                    identity:[
                        {required: true, message: 'Please choose an identity', trigger: 'blur'}
                    ],

                }
            }
        }
    }
</script>

<style scoped>

.requester_box{
    background-color: #fff;
    border-style:solid;
    border-width: 1px;
    border-color:rgb(209, 209, 209);
    border-radius: 4px;
    padding:30px 40px;
    margin-top: 100px;
    margin-bottom: 110px;
    color:#606266
}
.el-form{
    margin-top: 30px;
}
.el-input__inner{
    border-radius: 12px;
}
.el-input__inner:hover{
    border-color: rgb(147, 206, 229);
}
.el-input__inner:focus {
    border-color: #42a5f5;
    box-shadow: 8px;
    transition-duration: .5s;
}
.register_button{
    width:100%;
    background-color: #00ACED;
    font-size: 18px;
    color: #fff;
}
.register_button:hover{
    background-color: #0090C7
}
.login_text{
    float:right;
}
.login_text:hover{
    color: rgb(22, 139, 185)
}

</style>
