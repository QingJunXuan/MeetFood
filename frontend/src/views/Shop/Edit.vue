<template>
<div>
    <guestTopbar/>
    <el-form class="dish">
    <div class="title">
        <span>Deliciousrilla</span>
    </div>
    <el-row>
        <div class="picture">
            <div class="title">
                <span>Pictures</span>
            </div>
            <el-col :span="8">
                <div class="image_big">
                    <img src="../../assets/4.jpg" height="300">
                </div>
                <el-upload
                    action="https://jsonplaceholder.typicode.com/posts/"
                    :on-preview="handlePictureCardPreview"
                    :on-remove="handleRemove">
                     <el-button>Upload the cover</el-button>
                </el-upload>
               
            </el-col>
            <el-col :span="16">
                <el-upload
                    action="https://jsonplaceholder.typicode.com/posts/"
                    list-type="picture-card"
                    :on-preview="handlePictureCardPreview"
                    :on-remove="handleRemove">
                    <i class="el-icon-plus"></i>
                </el-upload>
                <el-dialog :visible.sync="dialogVisible">
                    <img width="100%" :src="dialogImageUrl" alt="">
                </el-dialog>
                <div class="image_small">
                    <img  v-for="(item, i) in Dining.picture" :key="i" :src="item" width="150" height="150">
                </div>
                <el-button>Upload the picture</el-button>
            </el-col>
        </div>
    </el-row>
    <el-row>
        <div class="section">
            <div class="title">
                <span>Introduction</span>
            </div>
            <el-form-item class="introduction">
                <el-input type="textarea" v-model="Dining.intro" placeholder=""></el-input>
            </el-form-item> 
        </div>
    </el-row>
    <el-row>
        <div class="section">
            <el-row>
                <el-col :span="8">
                    <div class="title">
                        <span>Dish</span>
                    </div>
                </el-col>    
                <el-col :span="8">
                    <div class="title">
                        <span>Ingredients</span>
                    </div>
                </el-col>
            </el-row>
            <div class="dish">
                <el-row>
                    <el-form-item
                        v-for="(domain, index) in DishForm"
                        :key="domain.key"
                        :prop="'domains.' + index + '.value'"
                    >
                        <el-col :span="8">
                            <div class="dish">
                                <el-input v-model="DishForm[index].name"></el-input>
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div class="dish">
                                <el-input v-model="DishForm[index].ingredients"></el-input>
                            </div>
                        </el-col>
                        <el-col :span="8">
                            <div class="dish">
                                <el-button @click.prevent="removeDomain(domain)">DELETE</el-button>
                            </div>
                        </el-col>   
                    </el-form-item>
                </el-row>
                <el-row>
                    <div class="dish">
                        <el-button @click="addDomain">ADD</el-button>
                    </div>
                </el-row>
            </div>
        </div>
    </el-row>
    <el-row>
        <div class="section">
            <div class="title">
                <span>Location</span>
            </div>
            <div class="block">
                <span class="demonstration">Choose the location</span>
                <el-cascader
                    expand-trigger="hover"
                    :options="options"
                    v-model="selectedOptions2"
                    @change="handleChange"
                    class="location_cas">
                </el-cascader>
            </div>
            <div class="block">
                <el-col :span="24">
                    <span class="demonstration">Enter the detailed address</span>
                    <div class="location_detail">
                        <el-input v-model="location_detail"></el-input>
                    </div>
                    <div class="location_detail">
                        <el-button>Search</el-button>
                    </div>
                </el-col>
            </div>
            <div class="baidumap" id="allmap" style="height:300px">
            </div>
        </div>
    </el-row>
    <el-row>
        <div class="section">
            <div class="title">
                <span>Telephone Number</span>
            </div>
            <el-form-item class="input">

                <el-input v-model="Dining.phone"></el-input>
            </el-form-item>

            <div class="title">
                <span>E-mail</span>
            </div>
            <el-form-item class="input">
                <el-input v-model="Dining.email"></el-input>
            </el-form-item>

            <div class="title">
                <span>Number of guests suggested</span>
            </div>
            <el-form-item class="input">
                <el-input v-model="Dining.person"></el-input>
            </el-form-item>

            <div class="title">
                <span>Set the Price</span>
            </div>
            <el-form-item class="input">
                <el-input v-model="Dining.price"></el-input>
            </el-form-item>

            <div class="title">
                <el-button type="primary" @click="onSubmit">Save the change</el-button>
            </div>
        </div>
    </el-row>
    </el-form>
    
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'
import axios from 'axios'

export default {
    mounted(){
        this.baiduMap();
    },
    components:{
        guestTopbar,
    },
    data() {
      return {
        dialogImageUrl: '',
        dialogVisible: false,
        location_detail:'',
        introduction:'',
        DishForm: [
        {
            name: 'onedish',
            ingredients:'apple',
        },
        {
            name: 'anotherdish',
            ingredients:'beef',
        },
        ],
        Dining:{
            name:'Deliciousrilla',
            intro:'Johnnies Snack Shop prides itself on being an old-school diner. The atmosphere is no-frills, but the service is good and the food comes fast. The breakfast staples—omelettes, skillets, pancakes, and more—are served all day, or there are a range of plate lunch specials and sandwiches, including five Greek-inspired pita delights. Another sign of a great diner? No matter when you stop in, there will likely be a Chicago police officer enjoying a meal.',
            rate:'4.3',
            hostname:'Lela',
            hostavatar:require("../../assets/1.jpg"),
            cover:require("../../assets/2.jpg"),
            picture:[
                    require("../../assets/3.jpg"),
                    require("../../assets/4.jpg"),
                    require("../../assets/5.jpg"),
                    require("../../assets/6.jpg"),
                    require("../../assets/7.jpg"),
                    ],
            price:357,
            person:"3~5",
            email:"abc@gmail.com",
            phone:"61006200"
        },
        price:'',
        options: [{
          value: 'China',
          label: 'China',
          children: [
          {
            value: 'Shanghai',
            label: 'Shanghai',
            children: [
            {
              value: 'Yangpu',
              label: 'Yangpu'
            }, 
            {
              value: 'Jiading',
              label: 'Jiading'
            }, 
            ]
          }, 
          {
            value: 'Jiangsu',
            label: 'Jiangsu',
            children: [
            {
              value: 'Nanjing',
              label: 'Nanjing'
            }, 
            {
              value: 'Suzhou',
              label: 'Suzhou'
            }]
          }]
        }
        ],

        selectedOptions: [],
        selectedOptions2: []
      };
    },
    methods: {
      handleRemove(file, fileList) {
        console.log(file, fileList);
      },
      handlePictureCardPreview(file) {
        this.dialogImageUrl = file.url;
        this.dialogVisible = true;
      },
      handleChange(value) {
        console.log(value);
      },
      baiduMap(){
          var map = new BMap.Map("allmap");
          map.centerAndZoom(new BMap.Point(116.404,39.915),11);
          map.addControl(new BMap.MapTypeControl({
              mapTypes:[
                  BMAP_NORMAL_MAP,
                  BMAP_HYBRID_MAP
              ]
          }));
          map.setCurrentCity("上海");
          map.enableScrollWheelZoom(true);
      },
      addDomain() {
        this.DishForm.push({
          value: '',
          key: Date.now()
        });
      },
      removeDomain(item) {
        var index = this.DishForm.indexOf(item)
        if (index !== -1) {
          this.DishForm.splice(index, 1)
        }
      },
      onSubmit(){
        let that = this
        this.button_disabled = true;
        let param = new URLSearchParams();
        let self = this;
        
        param.append('id',1);
        param.append('name',this.Dining.name);
        
        axios({
            method:'put',
            url:'http://172.20.10.4:8080/dining/update',
            data: param
        })
        .then(function(reponse) {
            console.log(reponse);
            
        })
        .catch(function (error) {
            alert(error);
        })
      }
    }
}
</script>

<style scoped>
template {
    height: 100%;
    width: 100%;
}
.title{
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 10px;
    font-size: 22px;
    color: gray;
}
.dish{
    margin-top: 20px;
    margin-left: 20px;
    margin-right: 30px;
}
.section{
    margin-top: 20px;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 20px;
    font-size: 16px;
    
    width: 80%;
    border-style:solid;
    border-color:#a0a0a0;
    border-width:1px;
}
.picture{
    margin-top: 20px;
    padding-top: 10px;
    padding-bottom: 20px;
    padding-left: 10px;
    margin-left: 20px;
    font-size: 16px;
    height:500px;
    width: 80%;
    border-style:solid;
    border-color:#a0a0a0;
    border-width:1px;
}
.introduction{
    margin-top: 20px;
    padding-top: 20px;
    padding-bottom: 20px;
    padding-left: 20px;
    margin-left: 10px;
    font-size: 16px;
    background-color: #f3f1f1;
}
.location_cas{
    width:80%
}
.location_detail{
    width:80%;
    padding-left: 20px;
    margin-left: 10px;
    padding-top: 20px;
    
}
.input{
    width:20%
}
.image_big{
    padding-left: 20px;
    margin-left: 10px;
    padding-bottom: 20px;
}
.image_small{
    padding-bottom: 20px;
}
.demonstration{
    font-size: 20px;
    padding-left: 20px;
    padding-right: 20px;
    margin-bottom: 20px;
}
.block{
    padding-bottom: 20px;
}
</style>