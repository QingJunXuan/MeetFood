<template>
              <div class="sidebar">
                    <div class="sidebar_title">
                        <h5 > Personal information </h5>
                    </div>
                    <el-menu 
                    :default-active="activeIndex" 
                    background-color="#fff" text-color="#4D4D4D"  
                    active-text-color="rgb(60, 121, 202)"
                    @select="handleSelect" router>
                    <el-menu-item index="Guest_Basic_Infor" >
                        <i class="el-icon-menu"></i>                       
                        <span slot="title">Basic Information</span>
                    </el-menu-item>
                    <el-menu-item index="All_Reviews" > 
                        <i class="el-icon-menu"></i>                     
                        <span slot="title">All Reviews</span>
                    </el-menu-item>
                    <el-menu-item index="My_Favorite" >   
                        <i class="el-icon-menu"></i>                   
                        <span slot="title">My Favorite</span>
                    </el-menu-item>
                    <el-menu-item index="/" >  
                <el-button type="text" style="color:#4D4D4D;width:100%;height:60px" @click="logout">
                <span>Log out</span>
                </el-button>
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
