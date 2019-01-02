<template>
    <div>
        <guestTopbar/>
        <el-row>
            <div class="search_box" style="width:70%">
                    <div class="location">
                        <el-col :span="8">
                            <!--<i class="el-icon-location" style="font-size:120%;color:#606266"></i>-->
                            <el-cascader
                                :options="options"
                                @active-item-change="handleItemChange"
                                :props="props" 
                                filterable
                                placeholder="Please select a city"
                            ></el-cascader>
                        </el-col>
                        <el-col :span="16">
                            <el-input placeholder="Search" v-model="search" class="input-with-select">
                            
                                <el-button slot="append" icon="el-icon-search" ></el-button>
                            </el-input>
                            <div class="dinning_type">
                                <el-radio-group v-model="dinning_type" size="medium">
                                    <el-radio-button label="All" ></el-radio-button>
                                    <el-radio-button label="Asian cuisines"></el-radio-button>
                                    <el-radio-button label="European cuisines"></el-radio-button>
                                    <el-radio-button label="Others"></el-radio-button>
                                </el-radio-group>
                            </div>
                        </el-col>
                    </div>
                </div>
          <el-col :span="18">
                
                <div class="popular">
                    <h2 style="font-weight:500;font-size:28px;color:#303133">Popular Restaurants</h2>
                    <div class="popular_box">
                        <el-carousel  height='500px'>
                            <el-carousel-item v-for="item in popular_rest" :key="item.id">
                                <div style="width:100%;height:100%" :style="{backgroundImage: 'url(' + item.cover + ')',backgroundSize:'cover' }">
                                    <div class="popular_intro">
                                        <h3 style="color:#fff">{{item.name}}</h3>
                                        <p  style="color:#ddd">{{item.intro}}</p>
                                    </div>
                                </div>
                            </el-carousel-item>
                        </el-carousel>
                    </div>
                </div>
                <div class="comments">
                    <h2 style="font-weight:500;font-size:26px;color:#303133">Remarkable Comments</h2>
                    <!--<el-col :span="5" class="comments_box"  v-for="item2 in comments" :key="item2.id">
                        <el-card :body-style="{ padding: '0px' }" >
                        <img :src="item2.pic" style="width:100%">
                        <div style="padding: 14px;">
                            <span style="color:#909399">{{item2.user}}</span>
                            <div class="bottom clearfix">
                            <p style="color:#606266;font-size:15px">{{item2.content}}</p>
                            
                            </div>
                        </div>
                        </el-card>
                    </el-col>-->
                    <div class="review" v-for="(item, i) in comment" :key="i" style="min-height:200px;max-height:600px;margin-bottom:20px;">
                    <el-card class="box-card">
                        <div slot="header" class="clearfix">                          
                            <time class="time">{{ item.data }}</time>
                            <el-rate v-model="item.rate" disabled show-score text-color="#ff9900" score-template="{value}" class="rate"></el-rate>
                            <span style="color:#909399;margin-top:10px">{{item.user}}</span>
                        </div>
                        <h4 style="color:#606266;margin-bottom:5px;font-size:18px;">{{item.dinning_name}}</h4>
                        <div class="text item" style="color:#606266;margin-bottom:10px;font-size:15px;">
                            {{item.text}}
                        </div>
                        <img v-for="src in item.img_list" :key="src.url" :src="src.url" style="width:10%;margin:0 10px;"/>
                    </el-card>
                </div> 
                </div>
          </el-col>
          <el-col :span="6">
              <div class="newest">
                  <ul v-for="item_new in newest_list" :key="item_new.id">
                      <div class="new_box" style="border-bottom:#E4E7ED 1px dashed;padding:10px 0;">
                        <h3 style="font-weight:300;font-size:20px;color:#303133">{{item_new.time}}</h3>
                        <h4 style="font-weight:300;font-size:17px;color:#606266">{{item_new.name}} </h4>
                        <p class="newest_intro">{{item_new.intro}}</p>
                      </div>
                  </ul>
              </div>
          </el-col>
        </el-row>
    </div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
//import contries from '../../static/countries.js'
import * as axios from 'axios'

export default {
    components:{
        guestTopbar
    } ,
    data(){
        return{
            search:'',
            dinning_type:"All",
            options:[
                
            ],
            countries:[
                {"name":"Afghanistan","code":"af"},{"name":"Albania","code":"al"},{"name":"Algeria","code":"dz"}
            ],
            props: {
            value: 'label',
            children: 'cities'
            },
            popular_rest:[{
                id:'1',
                name:'Deliciousrilla1',
                cover:'../../static/homepage/1.jpg',
                intro:'Vestibulum sem magna, elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a dolor. Nulla facilisi.',
                city:'Shanghai'
            },{
                id:'2',
                name:'Deliciousrilla2',
                cover:'../../static/homepage/2.jpg',
                intro:'Vestibulum sem magna, elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a dolor. Nulla facilisi.',
                city:'Shanghai'
            },{
                id:'3',
                name:'Deliciousrilla3',
                cover:'../../static/homepage/3.jpg',
                intro:'Vestibulum sem magna, elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a dolor. Nulla facilisi.',
                city:'Shanghai'
            }
            ],
            comment:[{
                reviewid:"1",
                text:"comment1",
                rate:"4",
                img_list:[
                    {url:'../../static/homepage/6.jpg'},
                    {url:'../../static/homepage/7.jpg'},
                    {url:'../../static/homepage/8.jpg'},
                    {url:'../../static/homepage/9.jpg'}
                    ],
                data:'2019-1-1',
                user:'elementum',
                dinning_name:'Deliciousrilla1'
            },
            {
                reviewid:"2",
                text:"comment2",
                rate:"5",
                img_list:{
                    url:'../../static/homepage/6.jpg',
                    url:'../../static/homepage/7.jpg',
                    url:'../../static/homepage/8.jpg',
                    url:'../../static/homepage/9.jpg'},
                data:'2019-1-1',
                user:'elementum',
                dinning_name:'Deliciousrilla2'
            }
            ],
            newest_list:[
                {
                    id:'1',
                    name:'Vestibulum',
                    intro:'Vestibulum sem magna, elementum ut, vestibulum eu, facilisis quis, arcu. Mauris a dolor. Nulla facilisi.',
                    time:'Oct.19th,2018'
                }
            ]
        }
    },
    created(){
        /*axios({
            method:	'get',
            url: '/getCity/country/all/?key=ce2dd2e2300ed9f2cde80ae411f9d29f',
          })
            .then(function (response) {
            console.log(response);
             
            })
            .catch(function (error) {
              alert(error);
            });*/
            axios({
            method:	'get',
            url: '/api/myReservation/all?guest_id=1',
          })
            .then(function (response) {
            console.log(response);
             
            })
            .catch(function (error) {
              alert(error);
            });
            for(let i=0;i<this.countries.length;i++){
                this.options.push({label:this.countries[i].name,cities:[]});
                //console.log(this.options)
            }
    },
    methods:{
        getLocation(){

        }
    }
}
</script>

<style scoped>
p{
    color:#606266;
}
.search_box{
    padding-top: 30px;
}
.dinning_type{
    margin-top: 10px;
}
.dinning_type .el-radio-button{
    background-color: #C0C4CC;
}
.popular{
    margin-top:10px;
}
.popular_intro {
    background-color: rgba(32, 32, 32,0.3);
    color: #fff;
    width: 300px;
    float: right;
    padding: 10px;
}
.popular_intro p{
    overflow: hidden;
    -webkit-line-clamp: 3;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
}
.comments{
 margin-top: 50px;
}
.comments_box{
    max-height: 500px;
    overflow: hidden;
    min-height: 200px;
    margin: 10px
}
.newest_intro{
    overflow: hidden;
    -webkit-line-clamp: 3;
    text-overflow: ellipsis;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    font-size: 15px;
    font-style: italic
}
.newest h3,h4,p{
    margin: 5px 0;
    
}

</style>


