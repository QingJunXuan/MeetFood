<template>
    <div>
        <guestTopbar/>
        <el-row>
        <el-col :span="24">
            <div class="cover_box">
                <img :src="cover" style="width:100%;height56%">
            </div>
            <div style="height:50px;">
            </div>
        </el-col>
        </el-row>
        <!--<el-row>
          <el-col :span='6'>
              <div class="navi_box">
                  <div class="navi_box_title">
                  </div>
              </div>
          </el-col>
         
          <el-col :span="6">
              <div class="navi_box">
                  <div class="navi_box_title">
                  </div>
              </div>
          </el-col>
          <el-col :span="6">
              <div class="navi_box">
                  <div class="navi_box_title">
                  </div>
              </div>
          </el-col>
          <el-col :span="6">
              <div class="navi_box" >
                  <div class="navi_box_title">
                  </div>
              </div>
          </el-col>
          
        </el-row>-->
        <div style="height:50px; border-bottom:1px solid #DCDFE6;margin-bottom:50px;"></div>
        <el-row>
            <h2 style="font-weight:500;font-size:28px;color:#303133">Daily Recommendation </h2>
          <el-col :span="16">
              
              <!--<div class="recommend_pic" :style="recommend_sty"></div>-->
                <div class="recommend_box">                    
                    <div class="recommend_pic_box" >
                        <img :src="recommend.pic" style="width:100%">
                    </div>
                    <h3 style="font-weight:400;font-size:25x;color:#303133">{{recommend.name}}</h3>
                    <p style="color:#606266">
                        Vestibulum sem magna, elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a dolor. 
                        Nulla facilisi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur 
                        ridiculus mus. Sed blandit. Phasellus pellentesque, ante nec iaculis dapibus, eros justo
                        auctor lectus, a lobortis lorem mauris quis nunc. Praesent pellentesque facilisis elit.
                            Class aptent taciti sociosqu ad litora torquent per conubia nostra, per inceptos 
                            hymenaeos. In hac habitasse platea dictumst. Nullam id ante eget dui vulputate aliquam. 
                            Pellentesque erat erat, tincidunt in.
                    </p>
                    <ul style="color:#909399">
                        <li v-for="item in menu" :key="item.id">
                            {{item.content}}
                        </li>
                    </ul>
                    <p >
                        pricing：${{recommend.price}}
                    </p>
                    <el-button type="">Browse</el-button>
                </div>
          </el-col>
          <el-col :span="1"><p></p></el-col>
          <el-col :span="7">
              <div class="recommend_side" >
                    <div class="recommend_side_box" v-for="side_item in side_restraunt" :key="side_item.id">
                        
                        <div class="side_pic_box">
                            <img :src="side_item.pic" style="width:100%">
                        </div>
                        <router-link tag="" to="">
                            <h4 style="font-weight:400;font-size:20x;color:#303133;margin:10px 0;">
                                {{side_item.name}}
                            </h4>
                        </router-link>
                        <p class='side_text' style="font-size:15px;margin-top:5px;">{{side_item.text}}</p>
                    </div>
              </div>
          </el-col>
        </el-row>
        <div style="height:100px;"></div>
    </div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
 import * as axios from 'axios'
export default {
    components:{
        guestTopbar
    },
    data(){
        return{
            cover:require("../../static/cover.jpg"),
            recommend:{
                pic:('../../static/homepage/recommend_pic.jpg'),
                price:'300',
                name:"Deliciousrilla"
            },
            menu:[
                {
                    id:1,
                    content:"Vestibulum sem magna, elementum ut"
                },
                {
                    id:2,
                    content:"Vestibulum sem magna, elementum ut"
                },
                {
                    id:3,
                    content:"Vestibulum sem magna, elementum ut"
                }
            ],
            side_restraunt:[
                {
                    id:1,
                    name:"Deliciousrilla1",
                    pic:'../../static/homepage/1.jpg',
                    text:"Vestibulum sem magna, elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a dolor. Nulla facilisi. Cum sociis natoque penatibus et magnis dis parturient montes, "
                },{
                    id:2,
                    name:"Deliciousrilla2",
                    pic:'../../static/homepage/2.jpg',
                    text:"Vestibulum sem magna, elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a dolor. Nulla facilisi. Cum sociis natoque penatibus et magnis dis parturient montes, "
                },{
                    id:3,
                    name:"Deliciousrilla3",
                    pic:'../../static/homepage/3.jpg',
                    text:"Vestibulum sem magna, elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a dolor. Nulla facilisi. Cum sociis natoque penatibus et magnis dis parturient montes, "
                }
            ]
        }
    },
    computed:{
        
    },
    mounted(){
        
        
    },
    created() {
                /*axios({
                    method:'get',
                    url: 'http://172.20.10.4:8080/dining/all',
                    
                    })
                    .then(function(response){
                      console.log(response);
                        if(response.data.code == "200"){
                            
                            
                        }
                        else {}
                    })
                    .catch(function (error) {
                        alert(error);
                    });*/
    },
}
</script>

<style scoped>
p{
    color:#606266
}
.navi_box{
    background-color: #333333;
    height:280px;
    border-radius: 4px;
    margin-right: 50px;
    margin-left: 50px
}
.navi_box_title{
    background-color: #181818;
    height: 60px;
    border-radius: 4px 4px;
}
.cover_box{
    overflow: hidden; 
    border:solid 0px;
    border-radius: 0px 0px 4px 4px; 
}
.recommend_pic_box{
    width:100%;
    overflow: hidden; 
   /* border:solid 0px;
    border-radius: 2px; */ 
}
.el-button{
    background-color: #F5C300;
    color: #fff;
}
/*side*/
.recommend_side{
    background-color: #F2F6FC;
    padding: 30px 8%;
}
.recommend_side_box{
    padding-bottom: 20px;
}
.side_pic_box{
    width: 100%;
    max-height:200px;
    overflow: hidden;
    
}
.side_text{
    overflow: hidden;
    -webkit-line-clamp: 3;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;

}
</style>
