<template>
<div>
    <guestTopbar/>
    <el-row>
       <el-col :span="4">          
            <guestInforSidebar/>
        </el-col>
        <el-col :span="20" style="background-color:#F7F6F6">         
                <div class="basic_info">
                    <div class="basic_info_title">
                        <span>Basic Information</span>
                    </div>
                    <div class="box">
                        <el-form label-position="left" label-width="110px" :model="user" >                                            
                        <el-form-item label="Name">
                        <el-input v-model="name"></el-input>
                        </el-form-item>
                        <el-form-item label="Email">
                        <el-input v-model="eMail"></el-input>
                        </el-form-item>
                        <el-form-item label="Age">
                        <el-input v-model="age"></el-input>
                        </el-form-item>
                        <el-form-item label="TeleNumber">
                        <el-input v-model="teleNumber"></el-input>
                        </el-form-item>
                        <el-form-item>
                            <el-button type="primary" @click="confirmupdate">Save</el-button>
                            <el-button @click="cancel">Cancel</el-button>
                        </el-form-item>               
                </el-form>
                    </div>
                </div>
            
        </el-col>
    
    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
import guestInforSidebar from '@/components/guestInforSidebar.vue'
import * as Vue from 'autoprefixer'
import axios from 'axios'

let self = this
export default {
    components:{
        guestTopbar,
        guestInforSidebar
    },
    methods: {
        cancel() {
            this.$message('The system will not retain any of your changes')
        },
        confirmupdate() {
            let that = this
            this.button_disabled = true;
            let param = new URLSearchParams();
            let self = this;
            //param.append('id',this.guest.id);
            param.append('name',this.guest.name);
            param.append('age',this.guest.age);
            param.append('email',this.guest.email);
            param.append('teleNumber',this.guest.teleNumber);
            axios({
                method: 'post',
                url: 'api/guest/reviser?',
                data:param
            })
            .then(function(reponse) {
                 console.log(reponse);
            if(reponse.data.code[0] == "2") {
                   self.$message("修改成功")
                }
                else if(response.data.code[0] == "4") {
                  that.wrong_pwd = "用户名或密码错误";
                  that.button_disabled = false;
                }
                else if(response.data.code[0] == "5") {
                  that.wrong_pwd("服务器错误")
                  that.button_disabled = false;
                }
            })
            .catch(function (error) {
                alert(error);
                token_pointer.button_disabled = false;
              })
        }
    },
    data() {
        return{
            user: {
            name: this.$store.state.name,
        },
        input_search: '',
        input_advice: '',
        information: [],
        activeNames: [],
        form:
          {
            name: '',
            age: '',
            teleNumber: '',
            email:'',
          },
        guest: {
          name: '',
            age: '',
            teleNumber: '',
            email:'',
        },
      }
    },
    created() {
        let that=this
      if(this.$route.params.page!=null)
      {
        this.page = this.$route.params.page;
      }
      axios.get('/api/guest/')
        .then(function (response) {
          console.log(response);
          that.guest = response.data.guest;
          that.$forceUpdate();
        })
        .catch(function (error) {
          console.log(error);
        })
    }
}
</script>

<style scoped>
template {
    height: 100%;
    width:100%
    }
.basic_info{
    margin:30px;
    background-color: #fff;
    height: 640px;
    border: solid 1px rgb(255, 255, 255);
}
.basic_info_title{
    width: 600px;
    padding-top: 40px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 50px;
    font-size: 25px;
    border-bottom:solid 1px #E4E7ED;
}
.box{
    width: 30%;
    padding-left: 60px;
    padding-top: 50px;
}
</style>