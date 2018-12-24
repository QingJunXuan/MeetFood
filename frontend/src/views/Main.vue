<template>
    <div>
        <guestTopbar/>
        <el-row>
        <el-col :span="24">
            <img :src="cover" style="width:100%;">
            <div style="height:50px;">
            </div>
        </el-col>
        </el-row>
        <el-row>
          <el-col :span=4>
              <div class="navi_box">
                  <div class="navi_box_title">
                  </div>
              </div>
          </el-col>
          <el-col :span="2"><p></p></el-col>
          <el-col :span="5">
              <div class="navi_box">
                  <div class="navi_box_title">
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
        guestTopbar
    },
    data(){
        return{
            cover:require("../../static/cover.jpg")
        }
    }
}
</script>

<style>
.navi_box{
    background-color: #333333;
    height:280px;
}
.navi_box_title{
    background-color: #181818;
    height: 60px
}
</style>
