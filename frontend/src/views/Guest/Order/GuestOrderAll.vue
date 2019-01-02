<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <guestReserveSidebar/>
        </el-col>
          <el-col :span="20" style="background-color:rgb(255, 255, 255)">         
                
                    <div class="basic_info_title">
                        <span>All</span>
                    </div>

                     <div class="box">
                        <el-col :span="8" v-for="item in Order" :key="item.id">
                            <el-card :body-style="{ padding: '0px' }">
                            <div class="recommend_pic_box" style="width:100%;height:250px;overflow:hidden;">
                             <img :src="item.img" class="image" style="width:100%;height:250px" >
                                </div>
                         <div style="padding: 60px;">
                            <span>{{item.id}}</span>
                            <span>{{item.date}}</span>
                            <span>{{item.text}} </span><br>
                            <span>{{item.Tel}} </span><br>
                            <span> {{item.address}} </span><br>
                            <span> {{item.Email}} </span><br>
                         <div class="bottom clearfix">
                         <el-button type="text" class="button" @click="order_detail(item.id)"> View Details </el-button>
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
import guestReserveSidebar from '@/components/guestReserveSidebar.vue'
import axios from 'axios'
export default {
    components:{
        guestTopbar,
        guestReserveSidebar
    },
    computed: {
        pic:function(item){

        }

    },
    data(){
        return{
            Order:[{
                 text:"Name:Deliciousrilla",
                        img:require("../../../assets/2.jpg"),
                        id:"1",
                        rate:"5",
                        address:"Address:767 South State Street, Chicago, IL 60605",
                        Email:"Email:devil@gmail.com",
                        Tel:"Tel:(312) 583-9100",
                        date:"2018-04-13",
            },{
                       text:"Name:Snack Shop",
                        img:require("../../../assets/P2.jpg"),
                        id:"1",
                        rate:"3.8",
                        address:"Address:160 North Halsted Street, Chicago, IL 60661",
                        Email:"Email:snack@gmail.com",
                        Tel:"Tel:(312) 226-7769",
                        date:"2018-05-13"
            },
           {
                        text:"Name:Davern's Tavern",
                        img:require("../../../assets/P5.jpg"),
                        id:"1",
                        rate:"4.5",
                        address:"Address:8527 79th St, Justice, IL 60458",
                        Email:"Email:davern@gmail.com",
                        Tel:"Tel:(708) 924-6003",
                        date:"2018-06-30"
                },
                {
                        text:"Name:Lao Sze Chuan Evanston",
                        img:require("../../../assets/P6.jpg"),
                        id:"1",
                        rate:"3.6",
                        address:"Address:1633 Orrington Avenue, Evanston, IL 60201",
                        Email:"Email:davern@gmail.com",
                        Tel:"Tel:(847) 868-8989",
                        date:"2018-12-10"
                },
                {
                        text:"Name: Corner Bar ",
                        img:require("../../../assets/Pi3.jpg"),
                        id:"1",
                        rate:"4.2",
                        address:"Address:956 West Addison Street, Chicago, IL 60613",
                        Email:"Email:grill@gmail.com",
                        Tel:"Tel:(773) 929-1441" ,
                        date:"2018-12-15"
                },
                {
                        text:"Name:New Furama Restaurant",
                        img:require("../../../assets/Pi4.jpg"),
                        id:"1",
                        rate:"3.6",
                        address:"Address:2828 South Wentworth Avenue, Chicago, IL 60616",
                        Email:"Email:furama@gmail.com",
                        Tel:"Tel:(312) 225-6888",
                        date:"2018-12-31"
                },

            ]
        }
    },
    created(){
         let that = this;
          axios({
            method:	'get',
            url: 'http://172.20.10.4:8080/myReservation/all?guest_id=1', 
          })
            .then(function (response) {
            console.log(response);
             /*that.Order = response.data.images;
             for(let i=0;i<response.data.images.length;i++){
                let albums=response.data.images[i].resources;
                let link;
                //console.log(albums.length)
                if(albums.length==0){
                    link='../../../assets/1.jpg';
                    //console.log(link)
                }
                else{
                    link= albums[0].link;
                }
                console.log(that.Order[i])
                that.Order[i].cover=link;
                
             }
             
             console.log(that.Order)*/
            })
            .catch(function (error) {
              alert(error);
            });
    },
    methods: {
        order_detail(id){
            this.$router.push('/Shop')
        }
    }
}
</script>

<style scoped>
template {
    height: 100%;
    width:100%
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
    padding-left: 60px;
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
</style>

