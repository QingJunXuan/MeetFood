<template>
<div>
    <guestTopbar/>

    <el-row>
        <el-col :span="16">
            <div class="title">
                <span>Menu Today</span>
            </div>
            <div class="section">
                <div class="menu" v-for="(item, i) in Dish" :key="i">
                   <div class="name">
                       <span>{{item.name}}</span>
                   </div>
                   <div class="ingredients">
                       <span>Ingredients: {{item.ingredients}}</span>
                   </div>
                   <img :src="item.img" width="100" height="100">
                </div>

            </div>
            <div class="menu">
                <el-button class="ingredients" @click="toShop">Return to the restaurant</el-button>
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
                                <el-time-picker type="fixed-time" placeholder="Choose Date" v-model="reserve.date2" style="width: 80%;"></el-time-picker>
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
        <el-col :span="16">
            <div class="title">
                <span>Nutritions analysis</span>
            </div>
            <div class="section">
                <div class="ingredients">
                    <span>Theren are 112 calories in 1 serving of Roasted Cauliflower with Pamsesan & Garlic</span>
                </div>
                <div class="ingredients">
                    <span>There are 257 calories in 1 serving of Brown Rice & Cherry Tomato Cooked Salad. Calories break-down: 50% fat, 44%carbs, 6% protein</span>
                </div>
                <div class="ingredients">
                    <span>There are 149 calories in 2 serving of Cheese Spread.Calorie break-down: 60% fat, 12% carbs, 28% protein.</span>
                </div>
                <div class="ingredients">
                    <span>There are 384 calories in 1 serving of Chopped Greek Salad.Calories break-down: 60% fat, 28% carbs, 12% protein.</span>
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
    components:{
        guestTopbar,
    },
    mounted(){
        let that=this;
        let param = new URLSearchParams();
        param.append('dining_id',1);

        axios({
            method:'get',
            url:'http://172.20.10.4:8080/dish/viewDish?dining_id=1',
            data: param
        })
        .then(function(response){
            that.$message('成功')
            that.Dish.name = response.data.name;
            that.Dish.ingredients = response.data.ingredients;
            console.log(response)
        })
        .catch(function(error){
            console.log(error)
            this.errored = true
        })
    },
    data(){
        return {
            imgUrl:require("../../assets/1.jpg"),
            reserve: {
                date1: '',
                date2: '',
                number:0,
                message:''
            },
            value5:3.7,
            Dish:[
                {
                    name:"Roasted Cauliflower With Parmesan & Garlic",
                    ingredients:"lettuce, bacon, cheese",
                    img:require("../../assets/3-1.jpg"),
                },
                {
                    name:"Brown Rice & Cherry Tomato Cooked Salad",
                    ingredients:"rice, tomato",
                    img:require("../../assets/3-2.jpg"),
                },
                {
                    name:"Cheese Spread",
                    ingredients:"cheese, bread",
                    img:require("../../assets/3-3.jpg"),
                },
                {
                    name:"Chopped Greek Salad",
                    ingredients:"lettuce, tomato, cucumber, bell pepper",
                    img:require("../../assets/3-4.jpg"),
                },
            ],
            Dining:{
                rate:4.1,
                price:159,
                person:"1~3"
            }

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
      toShop(){
          this.$router.push({path:'/Shop_Snack'})
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
.img{
    height: 100px;
    margin-left: 20px;
}
.title{
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 10px;
    font-size: 24px;
    color: rgb(100, 100, 100);
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
    font-size: 22px;
    padding-bottom: 20px;
}
</style>