<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <guestInforSidebar/>
        </el-col>
         <el-col :span="20" style="background-color:#F7F6F6">         
                <div class="basic_info">
                    <div class="basic_info_title">
                        <span>我的收藏</span>
                    </div>

                    <div class="box">
                        <el-col :span="8" v-for="(o, index) in 2" :key="o" :offset="index > 0 ? 2 : 0">
                            <el-card :body-style="{ padding: '0px' }">
                             <img src="../../assets/1.jpg" class="image">
                         <div style="padding: 60px;">
                            <span>收藏的餐厅</span>
                         <div class="bottom clearfix">
                         <time class="time">{{ currentDate }}</time>
                         <el-button type="text" class="button">查看详情</el-button>
                        </div>
                        </div>
                        </el-card>
                        </el-col>          
               
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
    data() {
        return{
            currentDate: new Date()
        }
    }
}
</script>

<style scoped>
template {
    height: 100%;
    width:100%
    }
.basic_info{
    margin:30px;
    background-color: #fff;
    height: 640px;
    border: solid 1px rgb(255, 255, 255);
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


