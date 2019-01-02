<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <guestInforSidebar/>
        </el-col>
        <el-col :span="20">
            <div class="information">
                <div class="title">
                    <span>All Reviews</span>
                </div>
                <div class="review" v-for="(item, i) in comment" :key="i">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>
                                {{item.reviewid}}
                            </span>
                             <time class="time">{{ currentDate }}</time>
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
export default {
    components:{
        guestTopbar,
        guestInforSidebar
    },
    data(){
        return {
            comment:[{
                reviewid:"1",
                text:"comment1",
                rate:"4",
                img:require("../../assets/1.jpg")
            },
            {
                reviewid:"2",
                text:"comment2",
                rate:"5",
                img:require("../../assets/2.jpg")
            }
            ],
            currentDate: new Date()

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
  .button {
      padding: 0;
      float: right;
  }
</style>

