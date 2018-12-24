<template>
<div>
    <guestTopbar/>
    <div class="title">
        <span>Deliciousrilla</span>
    </div>
    <el-row>
        <div class="section">
            <div class="title">
                <span>Pictures</span>
            </div>
            <el-col :span="8">
                <div class="image_big">
                    <img src="../../assets/4.jpg" height="300">
                </div>
                <el-button>Upload the cover</el-button>
            </el-col>
            <el-col :span="8">
                <div class="image_small">
                    <img src="../../assets/5.jpg" height="150" width="150">
                    <img src="../../assets/6.jpg" height="150" width="150">
                    <img src="../../assets/7.jpg" height="150" width="150">
                    <img src="../../assets/1.jpg" height="150" width="150">
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
            <div class="introduction">
                <el-input type="textarea" v-model="introduction" placeholder="请输入简介"></el-input>
            </div> 
        </div>
    </el-row>
    <el-row>
        <el-col :span="8">
            <div class="section">
                <div class="title">
                    <span>Menu</span>
                </div>
                <div class="dish">
                    <el-input v-model="introduction"></el-input>
                </div>
                <div class="dish">
                    <el-input v-model="introduction"></el-input>
                </div>
            </div>
        </el-col>
        <el-col :span="8">
            <div class="section">
                <div class="title">
                    <span>Ingredients</span>
                </div>
                <div class="dish">
                    <el-input v-model="introduction"></el-input>
                </div>
                <div class="dish">
                    <el-input v-model="introduction"></el-input>
                </div>
            </div>
        </el-col>
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
            <div class="input">
                <el-input v-model="introduction"></el-input>
            </div>

            <div class="title">
                <span>E-mail</span>
            </div>
            <div class="input">
                <el-input v-model="introduction"></el-input>
            </div>

            <div class="title">
                <span>Number of guests suggested</span>
            </div>
            <div class="input">
                <el-input v-model="introduction"></el-input>
            </div>

            <div class="title">
                <span>Set the Price</span>
            </div>
            <div class="input">
                <el-input v-model="price"></el-input>
            </div>

            <div class="title">
                <el-button type="primary" @click="onSubmit">Save the change</el-button>
            </div>
        </div>
    </el-row>

    
</div>
</template>

<script>
import guestTopbar from '@/components/guestTopbar.vue'

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
    height: 500px;
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
    height: 320px;
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