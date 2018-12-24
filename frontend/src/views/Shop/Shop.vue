<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="16">
            <div class="picture">
                <div class="title">
                    <span>Deliciousrilla</span>
                </div>
                <img :src="imgUrl" width="1000">
            </div>
        </el-col>
        <el-col :span="8">
            <div class="title">
                <span>Menu Today</span>
            </div>
            <div class="menu">
                <h4>The first dish</h4>
                <h4>The second dish</h4>
                <h4>The third dish</h4>
                <h4>The fourth dish</h4>
            </div>
            <div class="ingredients">
                <el-button class="ingredients">View nutrients</el-button>
            </div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="24">
            <div class="picture_small">
                <img src="../../assets/3.jpg" width="300" height="300">
                <img src="../../assets/4.jpg" width="300" height="300">
                <img src="../../assets/5.jpg" width="300" height="300">
                <img src="../../assets/6.jpg" width="300" height="300">
                <img src="../../assets/7.jpg" width="300" height="300">
            </div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="16">
            <div class="information">
                <el-row>
                    <el-col :span="4">
                        <img src="../../assets/1.jpg" class="avatar">
                    </el-col> 
                    <el-col :span="8">
                        <div class="hostname">
                            <span>HOST:Lela</span>
                        </div>
                        <div class="reviewamount">
                            <span>79 Comments Now</span>
                        </div>
                    </el-col>
                </el-row>
                <div class="introduction">
                    <span>Introduction:</span>
                    <div class="introduction_content">Here are some introductions of the restaurant</div>
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
                    <span>￥359</span>
                </div>
                <div class="reserve_peoplenum">
                    <span>Number of guests suggested：3~5 person</span>
                </div>
                <el-rate
                        v-model="value5"
                        disabled
                        show-score
                        text-color="#ff9900"
                        score-template="{value}"
                        class="rate">
                </el-rate>
               
                <el-form ref="form" :model="form" label-width="80px">    
                    <el-form-item>
                        <span>DATE</span>
                        <el-row>
                            <el-col>
                                <el-date-picker type="date" placeholder="Choose Date" v-model="form.date1" style="width: 80%;"></el-date-picker>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col>
                                <el-time-picker type="fixed-time" placeholder="Choose Time" v-model="form.date2" style="width: 80%;"></el-time-picker>
                            </el-col>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <span>Number of guests</span>
                        <el-row>
                            <el-select v-model="form.region" placeholder="Please choose the number of guests" style="width: 80%;">
                                <el-option label="1位" value="1"></el-option>
                                <el-option label="2位" value="2"></el-option>
                            </el-select>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <el-input type="textarea" v-model="form.desc" placeholder="Leave some message" style="width: 80%;">></el-input>
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
                <div class="review">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>The title of Comments</span>
                        </div>
                        <div class="text item">
                            Here is one comment.
                        </div>
                        <img src="../../assets/1.jpg" class="image">
                        
                    </el-card>
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>The title of Comments</span>
                        </div>
                        <div class="text item">
                            Here is one comment.
                        </div>
                        <img src="../../assets/1.jpg" class="image">
                    </el-card>
                </div>    
            </div>
        </el-col>     
    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
export default {
    mounted(){
        this.baiduMap();
    },
    components:{
        guestTopbar,
    },

    data(){
        return {
            imgUrl:require("../../assets/2.jpg"),
            form: {
                date1: '',
                date2: '',
                region:'',
                desc:'',
            },
            value5:3.7
        }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
      },
      baiduMap(){
          var map = new BMap.Map("allmap");
          map.centerAndZoom(new BMap.Point(116.404,39.915),11);
          map.addControl(new BMap.MapTypeControl({
              mapTypes:[
                  BMAP_NORMAL_MAP,
                  BMAP_HYBRID_MAP
              ]
          }));
          map.setCurrentCity("上海");
          map.enableScrollWheelZoom(true);
      }
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
.picture_small{
    padding-top: 20px;
    padding-bottom: 20px;
    font-size: 22px;
    color: gray;
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
    font-size: 22px;
    color: gray;
}
.menu{
    padding-top: 20px;
    padding-bottom: 20px;
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
    height: 500px;
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
    font-size: 16px;
    background-color: #f3f1f1;
    
}
.introduction_content{
    margin-top: 10px;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 20px;
    margin-left: 10px;
    font-size: 16px;
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
    height: 500px;
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
    font-size: 18px;
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