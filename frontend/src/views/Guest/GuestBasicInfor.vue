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
                        <el-form ref="form" label-position="left" label-width="110px" :model="form">                                            
                        <el-form-item label="Name">
                        <el-input  value="guest1"></el-input>
                        </el-form-item>
                        <el-form-item label="Email">
                        <el-input value="1888888@tongji.edu.cn"></el-input>
                        </el-form-item>
                        <el-form-item label="Age">
                        <el-input value="12"></el-input>
                        </el-form-item>
                        <el-form-item label="TeleNumber">
                        <el-input value="(720) 865-9090"></el-input>
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
    },
    data() {
        return{
            user: {
            username: this.$store.state.username,
        },
        input_search: '',
        input_advice: '',
        information: [],
        activeNames: [],
        form:
          {
            username: '',
            age: '',
            teleNumber: '',
            email:'',
          },
        guest: {
            username: '',
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
      /*axios.get('http://172.20.10.4:8080/guest/message?id=1')
        .then(function (response) {
          console.log(response);
          that.guest = response.data.guest;
          that.$forceUpdate();
        })
        .catch(function (error) {
          console.log(error);
        })*/
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