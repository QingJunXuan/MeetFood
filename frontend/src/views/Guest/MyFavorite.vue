<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <guestInforSidebar/>
        </el-col>
         <el-col :span="20" style="background-color:rgb(255, 255, 255)">         
                
                    <div class="basic_info_title">
                        <span>My Favorite</span>
                    </div>

                    <div class="box">
                        <el-col :span="8" v-for="item in Favorite" :key="item.id">
                            <el-card :body-style="{ padding: '0px' }">
                                <div class="recommend_pic_box" style="width:100%;height:250px;overflow:hidden;">
                             <img :src="item.img" class="image" style="width:100%;height:250px" >
                                </div>
                         <div style="padding: 60px;">
                            <el-rate v-model="item.rate" disabled show-score text-color="#ff9900" score-template="{value}" class="rate"></el-rate>
                           <span>{{item.text}} </span><br>
                            <span>{{item.Tel}} </span><br>
                            <span> {{item.address}} </span><br>
                            <span> {{item.Email}} </span><br>
                         <div class="bottom clearfix">
                         <el-button type="text" class="button" @click="view_detail(item.id)"> View Details </el-button>
                        </div>
                        </div>
                        </el-card>
                        </el-col>          
               
                    </div>
               
            
        </el-col>
    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
import guestInforSidebar from '@/components/guestInforSidebar.vue'

export default {
    components:{
        guestTopbar,
        guestInforSidebar
    },
    computed: {
        pic:function(item){

        }
    },
    data() {
        return{
                Favorite:[{
                   
                        text:"Name:Deliciousrilla",
                        img:require("../../assets/2.jpg"),
                        id:"1",
                        rate:"5",
                        address:"Address:767 South State Street, Chicago, IL 60605",
                        Email:"Email:devil@gmail.com",
                        Tel:"Tel:(312) 583-9100"
                       
                },
                {
                        text:"Name:Snack Shop",
                        img:require("../../assets/3-3.jpg"),
                        id:"2",
                        rate:"3.8",
                        address:"Address:160 North Halsted Street, Chicago, IL 60661",
                        Email:"Email:snack@gmail.com",
                        Tel:"Tel:(312) 226-7769"
                },
                {
                        text:"Name: Corner Bar ",
                        img:require("../../assets/Pi3.jpg"),
                        id:"2",
                        rate:"4.2",
                        address:"Address:956 West Addison Street, Chicago, IL 60613",
                        Email:"Email:grill@gmail.com",
                        Tel:"Tel:(773) 929-1441" 
                },
                {
                        text:"Name:New Furama Restaurant",
                        img:require("../../assets/Pi4.jpg"),
                        id:"2",
                        rate:"3.6",
                        address:"Address:2828 South Wentworth Avenue, Chicago, IL 60616",
                        Email:"Email:furama@gmail.com",
                        Tel:"Tel:(312) 225-6888"
                },
                {
                        text:"Name:Davern's Tavern",
                        img:require("../../assets/P5.jpg"),
                        id:"2",
                        rate:"4.5",
                        address:"Address:8527 79th St, Justice, IL 60458",
                        Email:"Email:davern@gmail.com",
                        Tel:"Tel:(708) 924-6003"
                },
                {
                        text:"Name:Lao Sze Chuan Evanston",
                        img:require("../../assets/P6.jpg"),
                        id:"2",
                        rate:"3.6",
                        address:"Address:1633 Orrington Avenue, Evanston, IL 60201",
                        Email:"Email:davern@gmail.com",
                        Tel:"Tel:(847) 868-8989"
                }
                ]
        }

    },
        methods: {
            view_detail(id){
                if(id==1)
                this.$router.push('/Shop')
                else
                this.$router.push('/Shop_Snack')
            }
           
        }
}
</script>

<style scoped>
template {
    height: 100%;
    width:100%
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
    width: 80%;
    padding-left: 50px;
    padding-top: 50px;
}
  .time {
    font-size: 13px;
    color: #999;
  }
  
  .bottom {
    margin-top: 13px;
    line-height: 12px;
  }

  .button {
    padding: 0;
    float: right;
  }

  .image {
    width: 100%;
    display: block;
  }

  .clearfix:before,
  .clearfix:after {
      display: table;
      content: "";
  }
  
  .clearfix:after {
      clear: both
  }
  .img{
    height: 100px;
    margin-left: 20px;
}
 .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }
</style>


