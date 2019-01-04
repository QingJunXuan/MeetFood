<template>
<div>
    <hostTopbar/>
    <el-row>
        <el-col :span="4">          
            <hostReserveSidebar/>
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
                            <div class="text item">
                                {{ item.text }}
                                </div>
                         <div class="bottom clearfix">
                         <el-button type="text" class="button" @click="order_detail(item.order.id)"> View Details </el-button>
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
import hostTopbar from '@/components/hostTopbar.vue'
import hostReserveSidebar from '@/components/hostReserveSidebar.vue'

export default {
    components:{
        hostTopbar,
        hostReserveSidebar
    },
    computed: {
        pic:function(item){

        }

    },
    data(){
        return{
             Order:[
                 {
                 text:"Name:guest1",
                        img:require("../../../assets/4.jpg"),
                        id:"1",
                      address:"Num:3 people",
                        Tel:"(720) 865-9090",
                        date:"2019-01-04",
            },
                 {
                 text:"Name:Deliciousrilla",
                        img:require("../../../assets/2.jpg"),
                        id:"1",
                      address:"Num:4 people",
                        Tel:"Tel:(312) 583-9100",
                        date:"2018-04-13",
            },{
                       text:"Name:Snack Shop",
                        img:require("../../../assets/3-3.jpg"),
                        id:"1",
                      address:"Num:4 people",
                        
                        Tel:"Tel:(312) 226-7769",
                        date:"2018-05-13"
            },
           {
                        text:"Name:Davern's Tavern",
                        img:require("../../../assets/D1-1.jpg"),
                        id:"1",
                       address:"Num:5 people",
                        Tel:"Tel:(708) 924-6003",
                        date:"2018-06-30"
                },
                {
                        text:"Name:Lao Sze Chuan Evanston",
                        img:require("../../../assets/D1-3.jpg"),
                        id:"1",
                        address:"Num:6 people",
                        Tel:"Tel:(847) 868-8989",
                        date:"2018-12-10"
                },
                {
                        text:"Name: Corner Bar ",
                        img:require("../../../assets/D2-1.jpg"),
                        id:"1",
                        address:"Num:6 people",
                        Tel:"Tel:(773) 929-1441" ,
                        date:"2018-12-15"
                },
                {
                        text:"Name:New Furama Restaurant",
                        img:require("../../../assets/D2-3.jpg"),
                        id:"1",
                        address:"Num:7 people",
                        Tel:"Tel:(312) 225-6888",
                        date:"2018-12-31"
                },

            ]
        }
    },
  
    methods: {
        order_detail(id){
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

