<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="16">
            <div class="picture">
                <div class="title">
                    <span>西餐厅</span>
                </div>
                <img :src="imgUrl">
            </div>
        </el-col>
        <el-col :span="8">
            <div class="title">
                <span>今日菜谱</span>
            </div>
            <div class="menu">
                <h4>第一道菜是什么呢</h4>
                <h4>第二道菜是什么呢</h4>
                <h4>第三道菜是什么呢</h4>
                <h4>第四道菜是什么呢</h4>
            </div>
            <div class="ingredients">
                <el-button class="ingredients">查看营养成分</el-button>
            </div>
        </el-col>
    </el-row>
    <el-row>
        <el-col :span="24">
            <div class="picture_small">
                <img src="../../assets/1.jpg" width="300" height="300">
                <img src="../../assets/1.jpg" width="300" height="300">
                <img src="../../assets/1.jpg" width="300" height="300">
                <img src="../../assets/1.jpg" width="300" height="300">
                <img src="../../assets/1.jpg" width="300" height="300">
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
                    <el-col :span="4">
                        <div class="hostname">
                            <span>HOST:Lela</span>
                        </div>
                        <div class="reviewamount">
                            <span>共收到79条评价</span>
                        </div>
                    </el-col>
                </el-row>
                <div class="introduction">
                    <span>简介：</span>
                    <div class="introduction_content">这里是餐厅的简介啊什么的blabla</div>
                </div>    
            </div>
            <div class="map">
                <div class="title">
                    <span>地图</span>
                    <div class="baidumap" id="allmap" style="height:500px">
                    </div>
                </div>
            </div>
        </el-col> 
        <el-col :span="8">
            <div class="reserve">
                <div class="title">
                    <span>预定栏</span>
                </div>
                

                <el-form ref="form" :model="form" label-width="80px">
                    <el-rate
                        v-model="value5"
                        disabled
                        show-score
                        text-color="#ff9900"
                        score-template="{value}">
                    </el-rate>
                    <el-form-item>
                        <span>日期</span>
                        <el-row>
                            <el-col>
                                <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 80%;"></el-date-picker>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col>
                                <el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2" style="width: 80%;"></el-time-picker>
                            </el-col>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <span>人数</span>
                        <el-row>
                            <el-select v-model="form.region" placeholder="请选择人数" style="width: 80%;">
                                <el-option label="1位" value="1"></el-option>
                                <el-option label="2位" value="2"></el-option>
                            </el-select>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">立即预订</el-button>
                        <span>您暂时不会被收费</span>
                    </el-form-item>
                    
                    <el-form-item>
                        <el-input type="textarea" v-model="form.desc" placeholder="留言" style="width: 80%;">></el-input>
                    </el-form-item>
                </el-form>
            </div>    
        </el-col> 
    </el-row> 
    <el-row>
        <el-col :span="20">
            <div class="information">
                <div class="title">
                    <span>评价</span>
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
            imgUrl:require("../../assets/1.jpg"),
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
    height: 320px;
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
    width: 500px;
    border-style:solid;
    border-color:#a0a0a0;
    border-width:1px;
}
</style>