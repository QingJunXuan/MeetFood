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
                <div class="review" v-for="item in Comment" :key="item.id">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">
                            <span>
                                {{item.Comment.id}}
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
export default {
    components:{
        guestTopbar,
        guestInforSidebar
    },
    data(){
        return {
           text:"",
           img: require("../../assets/1.jpg")
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
             that.Comment = response.data.images;
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
                
             }
             
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

