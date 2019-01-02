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
                        <el-col :span="8" v-for="(item, i) in Favorite" :key="i">
                            <el-card :body-style="{ padding: '0px' }">
                            <div class="recommend_pic_box" style="width:100%;height:250px;overflow:hidden;">
                             <img :src="item.img" class="image" style="width:100%;height:250px" >
                                </div>
                         <div style="padding: 60px;">
                            <span>{{item.favoriteID}}</span>
                            <div class="text item">
                                {{ item.text }}
                                </div>
                         <div class="bottom clearfix">
                         <time class="time">{{ currentDate }}</time>
                         <el-button type="text" class="button"> View Details </el-button>
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
export default {
    components:{
        guestTopbar,
        guestReserveSidebar
    },
    data(){
        return{
            currentDate: new Date(),
             Favorite:[
            {
                favoriteID:"1",
                text:"one",
                img: require("../../../assets/1.jpg")
            },
            {
                favoriteID:"2",
                text:"two",
                img: require("../../../assets/2.jpg")
            },
             {
                favoriteID:"3",
                text:"three",
                img: require("../../../assets/3.jpg")
            },
            {
                favoriteID:"4",
                text:"four",
                img: require("../../../assets/4.jpg")
            },
             {
                favoriteID:"5",
                text:"five",
                img: require("../../../assets/5.jpg")
            },
            {
                favoriteID:"6",
                text:"six",
                img: require("../../../assets/6.jpg")
            }
            ]
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

