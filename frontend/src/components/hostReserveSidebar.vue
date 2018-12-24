<template>
              <div class="sidebar">
                    <div class="sidebar_title">
                        <h5 > 我的预定 </h5>
                    </div>
                    <el-menu 
                    :default-active="activeIndex" 
                    background-color="#fff" text-color="#4D4D4D"  
                    active-text-color="rgb(60, 121, 202)"
                    @select="handleSelect" router>
                    <el-menu-item index="Host_Order_Undone" >
                        <i class="el-icon-menu"></i>                       
                        <span slot="title">未完成</span>
                    </el-menu-item>
                     <el-menu-item index="Host_Order_Done" >
                        <i class="el-icon-menu"></i>                       
                        <span slot="title">已完成</span>
                    </el-menu-item>
                     <el-menu-item index="Host_Order_All" >
                        <i class="el-icon-menu"></i>                       
                        <span slot="title">全部</span>
                    </el-menu-item>
        
                    <el-menu-item index="Host_Order_Week" > 
                        <i class="el-icon-menu"></i>                     
                        <span slot="title">最近一周</span>
                    </el-menu-item>
                    <el-menu-item index="Host_Order_Month" >   
                        <i class="el-icon-menu"></i>                   
                        <span slot="title">最近一月</span>
                    </el-menu-item>
             
                    </el-menu>
              </div>
      
</template>

<script>
export default {
    data() {
      return {
      }
    },
   computed:{
      activeIndex(){       
            return this.$route.path.replace('/','');
      }
    },
    methods: {
      handleSelect(key, keyPath) {
        console.log(this);
        console.log(key,keyPath);
      }
    }
}
</script>


<style scoped>
.sidebar{
    background-color: #fff;
    color: #4D4D4D;
    height:700px;
    padding-left: 10px;
}
.sidebar_title{
    font:#4D4D4D;
    padding:30px 25px 0 25px;
}
.sidebar_title h5{
    border-bottom:solid 1px #4D4D4D;
    margin: 0;
    padding-bottom: 20px;
}
.el-menu {
    border: 0px;
}
</style>
