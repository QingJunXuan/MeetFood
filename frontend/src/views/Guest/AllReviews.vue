<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <guestInforSidebar/>
        </el-col>
        <el-col :span="20" style="background-color:rgb(255, 255, 255)">
            
            <div class="basic_info_title">
               
                    <span>All Reviews</span>
                </div>
                <div class="box">
                <div class="review" v-for="item in Comment" :key="item.id">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span> {{item.id}}
                            </span>
                            <span> {{item.date}}
                            </span>
                            <el-rate v-model="item.rate" disabled show-score text-color="#ff9900" score-template="{value}" class="rate"></el-rate>
                        </div>
                        <div class="text item">
                            {{item.text}}
                        </div>
                        <img :src="item.img" class="image">
                    </el-card>  
            </div>
                </div>
        </el-col>  

    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
import guestInforSidebar from '@/components/guestInforSidebar.vue'
import axios from 'axios'
export default {
    components:{
        guestTopbar,
        guestInforSidebar
    },
    data(){
        return {
           Comment:[{
               text:"Gyro omelet was incredible! They also have a 3 eggs, 3 pancakes and 3 sausages deal for $9. Amazing! Especially for the area of overpriced “foodie” places.",
               img: require("../../assets/1.jpg"),
               id:"1",
               rate:"5",
               date:"2018-05-16"
          },
          {
               text:"Yum! Great place to eat!",
               img:require("../../assets/2.jpg"),
               id:"2",
               rate:"3.9",
               date:"2018-06-12"
              },
              {
                  text:"Yum! Great place to eat!",
                  img:require("../../assets/3.jpg"),
                  id:"3",
                  rate:"3.9",
                  date:"2018-08-11"
              },
              {
                   text:"Food was excellent, expensive,. $66.00 for 3, excluding tip, but we did get appetizers and tea. Try at least once if you can",
                  img:require("../../assets/P6.jpg"),
                  id:"4",
                  rate:"4.9",
                  date:"2018-09-11"
              },
              {
                   text:"Good food got out taste.",
                  img:require("../../assets/P5.jpg"),
                  id:"5",
                  rate:"4.2",
                  date:"2018-10-13"
              },
              {
                   text:"Food was late.",
                  img:require("../../assets/P2.jpg"),
                  id:"6",
                  rate:"4.4",
                  date:"2018-10-13"
              }
          ]

        }
    },
    created(){
         let that = this;
          axios({
            method:	'get',
            url: 'http://172.20.10.4:8080/myOrderForm/all', 
          })
            .then(function (response) {
            console.log(response);
            /* that.Comment = response.data.images;
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
                console.log(that.Comment[i])
                that.Comment[i].cover=link;
                
             }*/
             
             console.log(that.Comment)
            })
            .catch(function (error) {
              alert(error);
            });
    }
}
</script>

<style scoped>
.reviewamount{
    font-size:22px;
}
.title{
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 10px;
    font-size: 24px;
    color: rgb(102, 101, 101);
}
.time{
     font-size: 13px;
    color: #999;
}
.box{
    width: 90%;
    padding-left: 50px;
    padding-top: 50px;
}
.information{
    margin-top: 20px;
    padding-top: 40px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 20px;
    font-size: 16px;
    height: 500px;
    border-style:solid;
    border-color:#a0a0a0;
    border-width:0px;
}
.review{
    padding-left: 10px;
}

  .text {
    font-size: 14px;
  }
 .dinner {
    font-size: 14px;
  }
  .item {
    margin-bottom: 18px;
  }

  .clearfix:before,
  .clearfix:after {
    display: table;
    content: "";
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
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 90%;
    margin-bottom: 20px;
  }
    .image {
    width: 20%;
    display: block;
  }
  .button {
      padding: 0;
      float: right;
  }
</style>

