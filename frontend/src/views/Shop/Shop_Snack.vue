<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="16">
            <div class="picture">
                <div class="title">
                    <span>{{Dining.name}}</span>
                </div>
                <div class="recommend_pic_box" style="width:100%;height:600px;overflow: hidden;">
                    <img :src="Dining.cover" style="height:600px;width:1000px">
                </div>
                
            </div>
        </el-col>
        <el-col :span="8">
            <div class="title">
                <span>Menu Today</span>
            </div>
            <div class="menu" v-for="(item, i) in Dish" :key="i">
                <h4>{{item.name}}</h4>
            </div>
            <div class="ingredients">
                <el-button class="ingredients" @click="toNutrients">View nutrients</el-button>
            </div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="24">
            <div class="picture_row" style="width:100%;height:300px;overflow: hidden;">
                <img  v-for="(item, i) in Dining.picture" :key="i" :src="item" width="300" height="100%" class="picture_small">
            </div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="16">
            <div class="information">
                <el-row>
                    <el-col :span="4">
                        <img :src="Dining.hostavatar" class="avatar">
                    </el-col> 
                    <el-col :span="8">
                        <div class="hostname">
                            <span>HOST:{{Dining.hostname}}</span>
                        </div>
                        <div class="reviewamount">
                            <span>79 Comments Now</span>
                        </div>
                    </el-col>
                </el-row>
                <div class="introduction">
                    <span>Introduction:</span>
                    <div class="introduction_content">{{Dining.intro}}</div>
                </div>    
            </div>
            <div class="map">
                <div class="title">
                    <span>Location</span>
                    <div class="baidumap" id="allmap" style="height:500px">
                    </div>
                </div>
            </div>
        </el-col> 
        <el-col :span="8">
            <div class="reserve">
                <div class="reserve_price">
                    <span>￥{{Dining.price}}</span>
                </div>
                <div class="reserve_peoplenum">
                    <span>Number of guests suggested：{{Dining.person}} person</span>
                </div>
                <el-rate
                        v-model="Dining.rate"
                        disabled
                        show-score
                        text-color="#ff9900"
                        score-template="{value}"
                        class="rate">
                </el-rate>
               
                <el-form ref="form" :model="reserve" label-width="80px">    
                    <el-form-item>
                        <span>DATE</span>
                        <el-row>
                            <el-col>
                                <el-date-picker type="date" placeholder="Choose Date" v-model="reserve.date1" style="width: 80%;"></el-date-picker>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col>
                                <el-time-picker type="fixed-time" placeholder="Choose Time" v-model="reserve.date2" style="width: 80%;"></el-time-picker>
                            </el-col>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <span>Number of guests</span>
                        <el-row>
                            <el-select v-model="reserve.number" placeholder="Please choose the number of guests" style="width: 80%;">
                                <el-option label="3" value="3"></el-option>
                                <el-option label="4" value="4"></el-option>
                                <el-option label="5" value="5"></el-option>
                            </el-select>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <el-input type="textarea" v-model="reserve.message" placeholder="Leave some message" style="width: 80%;">></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">Reserve Now!</el-button>
                        <span>You needn't to pay now</span>
                    </el-form-item>
                            
                </el-form>
            </div>    
        </el-col> 
    </el-row> 
    <el-row>
        <el-col :span="20">
            <div class="information">
                <div class="title">
                    <span>Comments</span>
                </div>
                <div class="review" v-for="(item, i) in comment" :key="i">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>{{item.guestid}}</span>
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
import axios from 'axios'
export default {
    mounted(){
        this.baiduMap();

        let that = this;
        let param = new URLSearchParams();
        param.append('id',1);
        
        let dining_id = new URLSearchParams();
        dining_id.append('dining_id',1);
        axios({
            method:'get',
            url:'http://172.20.10.4:8080/dining/view',
            data:param
        })
        .then(function(response){
            that.Dining.name = response.data.name;
            that.Dining.intro = response.data.intro;
            that.Dining.rate = response.data.grade;
            that.Dining.hostavatar = response.data.icon;
        })
        .catch(function(error){
            console.log(error)
            this.errored = true
        })

        axios({
            method:'get',
            url:'http://172.20.10.4:8080/comment/receivedComments',
            data:dining_id
        })
        .then(function(response){
            that.comment.text = response.data.text;
            that.comment.rate = response.data.score;
        })
        .catch(function(error){
            console.log(error)
            this.errored = true
        })

    },
    props:['id'],
    components:{
        guestTopbar,
    },

    data(){
        return {
            Dining:{
                name:'Snack Shop',
                intro:'Johnnies Snack Shop prides itself on being an old-school diner. The atmosphere is no-frills, but the service is good and the food comes fast. The breakfast staples—omelettes, skillets, pancakes, and more—are served all day, or there are a range of plate lunch specials and sandwiches, including five Greek-inspired pita delights. Another sign of a great diner? No matter when you stop in, there will likely be a Chicago police officer enjoying a meal.',
                rate:4.1,
                hostname:'Johnies',
                hostavatar:require("../../assets/1.jpg"),
                cover:require("../../assets/2-1.jpg"),
                picture:[
                    require("../../assets/2-2.jpg"),
                    require("../../assets/2-3.jpg"),
                    require("../../assets/2-4.jpg"),
                    require("../../assets/2-5.jpg"),
                    require("../../assets/2-6.jpg"),
                    ],
                price:159,
                person:"1~3"
            },
            Dish:[
            {
                name:'Roasted Cauliflower With Parmesan & Garlic'
            },
            {
                name:'Brown Rice & Cherry Tomato Cooked Salad'
            },
            {
                name:'Cheese Spread'
            },
            {
                name:'Chopped Greek Salad'
            },
            ],
            reserve: {
                date1: '',
                date2: '',
                number:0,
                message:'',
            },
            comment:[{
                guestid:"Tim K.",
                text:"Gyro omelet was incredible! They also have a 3 eggs, 3 pancakes and 3 sausages deal for $9. Amazing! Especially for the area of overpriced “foodie” places.",
                rate:4.8,
                img:require("../../assets/1.jpg")
            },
            {
                guestid:"Kevin P.",
                text:"Great food and service thank you",
                rate:5,
                img:require("../../assets/2.jpg")
            }
            ]
        }
    },
    
    methods: {
      onSubmit() {
        console.log('submit!');
        let that=this;
        let order = new URLSearchParams();
        order.append('repast_time',this.reserve.date1);
        order.append('dining_id',1);
        order.append('guest_id',1);
        
        axios({
            method:'post',
            url:'http://172.20.10.4:8080/myReservation/book',
            data: order
        })
        .then(function(response){
            that.$message('成功');
            that.$alert('您已成功预订', '预订成功', {
            confirmButtonText: '确定',
            callback: action => {
                that.$message({
                type: 'info',
                message: `action: ${ action }`
                });
            }
            });
        })
        .catch(function(error){
            console.log(error)
            this.errored = true
        })
      },
      baiduMap(){
          var map = new BMap.Map("allmap");
          map.centerAndZoom(new BMap.Point(116.404,39.915),16);
          map.addControl(new BMap.MapTypeControl({
              mapTypes:[
                  BMAP_NORMAL_MAP,
                  BMAP_HYBRID_MAP
              ]
          }));
          map.setCurrentCity("上海");
          map.enableScrollWheelZoom(true);
      },
      toNutrients(){
          this.$router.push({path:'/Menu'})
      },
    }
}
</script>

<style scoped>
template {
    height: 100%;
    width: 100%;
}
.picture{
    height: 6s00px;
}
.picture_row{
    padding-top: 20px;
    padding-bottom: 20px;
    font-size: 22px;
    color: gray;
}
.picture_small{
    margin-right: 10px;
}
.img{
    height: 100px;
    margin-left: 20px;
}
.avatar {
    width: 100px;
    height: 100px;
    padding-left: 10px;
    display: block;
}
.hostname{
    font-size:40px;
}
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
.menu{
    padding-left: 10px;
    margin-left: 30px;
    font-size: 16px;
    color: gray;
}
.information{
    margin-top: 20px;
    padding-top: 40px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 20px;
    font-size: 16px;
    border-style:solid;
    border-color:#a0a0a0;
    border-width:0px;
}
.introduction{
    margin-top: 20px;
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 20px;
    margin-left: 10px;
    font-size: 20px;
    background-color: #f3f1f1;
    
}
.introduction_content{
    margin-top: 10px;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    padding-right: 40px;
    margin-left: 10px;
    font-size: 20px;
}
.map{
    margin-top: 20px;
    margin-bottom: 20px;
    padding-left: 10px;
    margin-left: 20px;
    font-size: 16px;
    color: gray;
    height: 500px;
    border-style:solid;
    border-color:#a0a0a0;
    border-width:0px;
}
.reserve{
    margin-top: 20px;
    margin-left: 30px;
    padding-bottom: 20px;
    font-size: 16px;
    color: gray;
    width: 450px;
    border-style:solid;
    border-color:#a0a0a0;
    border-width:1px;
}
.reserve_price{
    padding-top: 20px;
    padding-bottom: 10px;
    padding-left: 10px;
    margin-left: 60px;
    font-size: 22px;
    color: gray;
}
.reserve_peoplenum{
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 60px;
    font-size: 16px;
    color: gray;
}
.rate{
    padding-left: 10px;
    margin-left: 60px;
}
.review{
    padding-left: 10px;
}
  .text {
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
  .clearfix:after {
    clear: both
  }

  .box-card {
    width: 80%;
    margin-bottom: 20px;
  }
    .image {
    width: 20%;
    display: block;
  }
</style>