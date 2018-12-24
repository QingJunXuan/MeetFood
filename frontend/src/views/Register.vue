<template>
<div style="background-color:#E4E5E6" >
    <el-row type="flex" justify="center">
        <el-col :span="7">          
            <!--login-->
            <div class="requester_box">
                <b style="font-size:38px;color:#303133;margin-bottom:20px;">注册</b>
                <br><span style="color:#909399;font-size:15px;">创建新账号</span>
                 <el-form label-position="top" label-width="60px" :model="user" :rules="rules" required ref="user" status-icon>
                    <el-form-item label="" prop="name">
                        <el-input v-model="user.name" placeholder="用户名">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                            </el-input>
                    </el-form-item>
                    <el-form-item label="" prop="email">
                        <el-input v-model="user.email" placeholder="邮箱">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                            </el-input>
                    </el-form-item>
                    <el-form-item label="" prop="pwd">
                        <el-input v-model="user.pwd" type="password" placeholder="密码">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                        </el-input>
                    </el-form-item>
                    <el-form-item label="" prop="pwd2">
                        <el-input v-model="user.pwd2" type="password" placeholder="确认密码">
                            <template slot="prepend">&nbsp;&nbsp;</template>
                        </el-input>
                    </el-form-item>
                    
                    <el-form-item style="padding-top:10px;">
                        <el-button  @click="register('user')" class="register_button">创建新账号</el-button>
                    </el-form-item>
                    

                </el-form>
                <div style="margin-bottom:0;font-size:15px;">
                    <span style="color:#606266">已经拥有账户？</span>
                    <div class="login_text"><b @click="login">登录</b></div>
                </div>
            </div>

        </el-col>

    </el-row>
</div>
</template>

<script>
    export default {
        methods: {
           login () {
                this.$router.push('/login')
            },
            register(formName) {
                this.$refs[formName].validate((valid) => {
                if (valid) {
                    axios.post('http://localhost:8080/',{
                    "username":this.username,
                    "email":this.email,
                    "tele":this.teleNumber,
                    "pwd":this.pwd
                }).then(function(response){
                    if(response.status == 200) {                 
                    }
                }).catch(function(error){
                   
                    });
                   this.$router.push('/register_requester_info');
                } else {
                    console.log('error submit!!');
                    return false;
                }
                });
            },
        },
        data () {
            var validatePass = (rule, value, callback) => {
                if (value === '') {
                callback(new Error('密码不能为空'));
                } else {
                if (this.user.pwd2 !== '') {
                    this.$refs.user.validateField('pwd2');
                }
                callback();
                }
            };
            var validateCheck = (rule, value, callback) => {
                    if (value === '') {
                    callback(new Error('请再次输入密码'));
                    } else if (value !== this.user.pwd) {
                    callback(new Error('两次输入密码不一致!'));
                    } else {
                    callback();
                    }
                };    
            return {    
                       
                user: {},
                rules: {
                    name: [
                        {required: true, message: '用户名不能为空', trigger: 'blur'}
                    ],
                    email:[
                        {required: true, message: '邮箱不能为空', trigger: 'blur'}
                    ],
                    pwd: [
                        {validator:validatePass, trigger: 'blur'}
                    ],
                    pwd2:[
                        {validator:validateCheck, trigger: 'blur'}
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
