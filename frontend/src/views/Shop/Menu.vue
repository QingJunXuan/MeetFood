<template>
<div>
    <guestTopbar/>

    <el-row>
        <el-col :span="14">
            <div class="title">
                <span>今日菜谱</span>
            </div>
            <div class="menu">
                <h4>第一道菜是什么呢</h4>
                <h4>第一道菜是什么呢</h4>
                <h4>第一道菜是什么呢</h4>
                <h4>第一道菜是什么呢</h4>
            </div>
            <div class="ingredients">
                <el-button class="ingredients">查看营养成分</el-button>
            </div>
        </el-col> 
        <el-col :span="10">
            <div class="reserve">
                <div class="title">
                    <span>预定栏</span>
                </div>
                <el-form ref="form" :model="form" label-width="80px">
                    <el-form-item>
                        <span>日期</span>
                        <el-row>
                            <el-col :span="10">
                                <el-date-picker type="date" placeholder="选择日期" v-model="form.date1" style="width: 100%;"></el-date-picker>
                            </el-col>
                        </el-row>
                        <el-row>
                            <el-col :span="10">
                                <el-time-picker type="fixed-time" placeholder="选择时间" v-model="form.date2" style="width: 100%;"></el-time-picker>
                            </el-col>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <span>人数</span>
                        <el-row>
                            <el-select v-model="form.region" placeholder="请选择人数">
                                <el-option label="1位" value="1"></el-option>
                                <el-option label="2位" value="2"></el-option>
                            </el-select>
                        </el-row>
                    </el-form-item>
                    <el-form-item>
                        <el-button type="primary" @click="onSubmit">立即预订</el-button>
                    </el-form-item>
                </el-form>
            </div>    
        </el-col> 
    </el-row> 
    <el-row>
        <el-col :span="20">
            <div class="nutrition">
                <div class="title">
                    <span>营养成分分析</span>
                </div>
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
            }

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
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 30px;
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
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 30px;
    font-size: 16px;
    color: gray;
    height: 500px;
}
</style>