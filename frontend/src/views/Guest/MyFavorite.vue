<template>
<div>
    <guestTopbar/>
    <el-row>
        <el-col :span="4">          
            <guestInforSidebar/>
        </el-col>
         <el-col :span="20" style="background-color:rgb(255, 255, 255)">         
                
                    <div class="basic_info_title">
                        <span>My Favorite</span>
                    </div>

                    <div class="box">
                        <el-col :span="8" v-for="item in Favorite" :key="item.id">
                            <el-card :body-style="{ padding: '0px' }">
                                <div class="recommend_pic_box" style="width:100%;height:250px;overflow:hidden;">
                             <img :src="item.img" class="image" style="width:100%;height:250px" >
                                </div>
                         <div style="padding: 60px;">
                            <span>{{item.favoriteID}}</span>
                            <div class="text item">
                                {{ item.text }}
                                </div>
                         <div class="bottom clearfix">
                         <el-button type="text" class="button" @click="view_detail(item.favoriteID)"> View Details </el-button>
                        </div>
                        </div>
                        </el-card>
                        </el-col>          
               
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
    coomputed: {
        pic:function(item){

        }
    },
    computed: {
        pic:function(item){

        }
    },
    data() {
        return{
                favoriteID:"1",
                text:"one",
                img: require("../../assets/1.jpg"),
                Favorite:[],
        }

    },
    created(){
           let that = this;
          axios({
            method:	'get',
            //url: '/api/image/findImages', 
          })
            .then(function (response) {
            console.log(response);
             that.picFile = response.data.images;
             for(let i=0;i<response.data.images.length;i++){
                let albums=response.data.images[i].resources;
                let link;
                //console.log(albums.length)
                if(albums.length==0){
                    link='../../../static/blank.jpg';
                    //console.log(link)
                }
                else{
                    link= albums[0].link;
                }
                console.log(that.picFile[i])
                that.picFile[i].cover=link;
                
             }
             
             console.log(that.picFile)
            })
            .catch(function (error) {
              alert(error);
            });
        },
        methods: {
            view_detail(id){
                this.$router.push('/Shop/'+id)
            }
        }
}
</script>

<style scoped>
template {
    height: 100%;
    width:100%
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
    padding-left: 50px;
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
  .img{
    height: 100px;
    margin-left: 20px;
}
 .text {
    font-size: 14px;
  }

  .item {
    margin-bottom: 18px;
  }
</style>


