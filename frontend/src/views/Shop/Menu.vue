<template>
<div>
    <guestTopbar/>

    <el-row>
        <el-col :span="16">
            <div class="title">
                <span>今日菜谱</span>
            </div>
            <div class="section">
                <div class="menu">
                   <div class="name">
                       <span>这是第一道菜的名字</span>
                   </div>
                   <div class="ingredients">
                       <span>这是第一道菜的配料</span>
                   </div>
                   <img src="../../assets/3.jpg" width="100" height="100">
                </div>
                <div class="menu">
                   <div class="name">
                       <span>这是第二道菜的名字</span>
                   </div>
                   <div class="ingredients">
                       <span>这是第二道菜的配料</span>
                   </div>
                   <img src="../../assets/4.jpg" width="100" height="100">
                </div>
            </div>
            <div class="menu">
                <el-button class="ingredients">返回餐厅</el-button>
            </div>
        </el-col> 
        <el-col :span="8">
            <div class="reserve">
                <div class="reserve_price">
                    <span>￥359</span>
                </div>
                <div class="reserve_peoplenum">
                    <span>建议用餐人数：3~5人</span>
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
                        <el-input type="textarea" v-model="form.desc" placeholder="留言" style="width: 80%;">></el-input>
                    </el-form-item>

                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">立即预订</el-button>
                        <span>您暂时不会被收费</span>
                    </el-form-item>
                            
                </el-form>
            </div>    
        </el-col> 
    </el-row> 
    <el-row>
        <el-col :span="16">
            <div class="title">
                <span>营养成分分析</span>
            </div>
            <div class="section">
            </div>
        </el-col>     
    </el-row>
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'

export default {
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
            },
            value5:3.7

        }
    },
    methods: {
      onSubmit() {
        console.log('submit!');
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
    
}
.img{
    height: 100px;
    margin-left: 20px;
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
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 20px;
    font-size: 16px;
    color: gray;
}
.nutrition{
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 30px;
    font-size: 16px;
    color: gray;
    height: 500px;
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
.section{
    margin-top: 20px;
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 20px;
    margin-left: 10px;
    font-size: 16px;
    background-color: #f3f1f1;
    
}
.name{
    font-size: 22px;
    color:black;
    padding-bottom: 20px;
}
.ingredients{
    font-size: 18px;
    padding-bottom: 20px;
}
</style>