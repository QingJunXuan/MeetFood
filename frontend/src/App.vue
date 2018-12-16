<template>
  <el-main>
    <el-row>
      <el-col :span="24">
        <div class="app_head" :style="{backgroundImage: 'url(' + headimage + ')' }">
          <h1>MEETFOOD</h1>
          <p>Find your favorite restaurant here</p>
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="2">
        <div class="navi_blank" :style="{backgroundImage: 'url(' + headimage + ')' }">
        </div>
      </el-col>
      <el-col :span="20">
        <router-view/>
      </el-col>
      <el-col :span="2">
        <div class="navi_blank" :style="{backgroundImage: 'url(' + headimage + ')' }">
        </div>
      </el-col>
    </el-row>
    <el-row>
      <el-col :span="24">
        <!--footer-->
        <footer/>
        <!--<div>
          <div class="container" id="copyright">
            Design: <a href="http://www.tongji.com">TONGJI UNIVERSITY</a> Images: <a href="https://pixabay.com/">Pixabay</a> <a href="http://https://www.instagram.com/">INSTGRAM</a>)
          </div>
        </div>!-->
      </el-col>
    </el-row>
  </el-main>
</template>

<script>
export default {
  name: 'App' ,
  data(){
    return{
        headimage:require('../static/img01.png'),
    }
  }
}
 
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  margin-top: 60px;
}
.el-main{
   padding: 0;
   font-family: "Helvetica Neue",Helvetica,"PingFang SC","Hiragino Sans GB","Microsoft YaHei","微软雅黑",Arial,sans-serif;
   -webkit-font-smoothing: antialiased;
   -moz-osx-font-smoothing: grayscale;
 }
 .el-row{
    margin: 0;
    padding: 0;
}
.app_head{
  height: 130px;
  text-align: center
}
.app_head h1{
  padding: 40px 0 0 0;
  margin: 0;
  text-shadow: 1px 1px 0px #FFFFFF;
  color: #474747;
  font-family: Arial, Helvetica, sans-serif;
  font-size: 40px;
}
.app_head p{
  margin: 0;
  padding: 0;
  color: #909399;
  font-size: 15px;
  text-shadow: 1px 1px 0px #FFFFFF;
}
.navi_blank{
  height: 60px;
}
/* Copyright */
/*
#copyright {
  position: absolute;
  bottom: 0; 
	overflow: hidden;
	padding: 1.875em 0em 6em 0;
	border-top: 1px solid #CCCCCC;
	text-shadow: 1px 1px 0px #FFFFFF;
	text-align: center;
}

#copyright p {
	font-size: 1em;
	color: #333333;
}

#copyright a {
	color: #232323;
}

#copyright a:hover {
	text-decoration: none;
}*/
</style>
