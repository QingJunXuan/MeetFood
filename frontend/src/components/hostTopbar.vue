<template>
<el-row>
    <div class="topbar">  
        <el-col :span="3"><p></p></el-col>    
        <el-col :span="18">
            <el-menu :default-active="activeIndex"
                    class="el-menu-demo"
                    mode="horizontal"
                    @select="handleSelect"
                    
                    background-color="#181818"
                    text-color="#fff"
                    active-text-color="#fff">
                <el-menu-item index="1" @click="HOME" >HOME</el-menu-item>
                <el-menu-item index="2" @click="Edit_Page" >Edit Page</el-menu-item> 
                <el-menu-item index="3" @click="YOUR_ORDER">YOUR ORDER</el-menu-item>       
            </el-menu>
        </el-col>  
        <el-col :span="3"></el-col>         
    </div>
</el-row>
</template>

<script>
    export default {
        methods: {
            HOME(){
                this.$router.push('/Shop_host')
            },
            Edit_Page(){
                this.$router.push('/Edit')
            },
            YOUR_Order(){
                this.$router.push('/Host_Order_All')
            },
            handleSelect(key, keyPath) {
                console.log(this);
                console.log(key,keyPath);
            }
        },
        computed:{
            activeIndex(){       
                    return this.$route.path.replace('/','');
            }
        },
    }

    
</script>


<style scoped>
.topbar{
    background-color: #181818;
    height: 60px;
    border-radius: 4px 4px 0 0;
}
.el-menu{
    text-align: center
}
.el-menu-item{
    width:230px;

}
.el-menu-item:hover{
    background-color: rgb(0, 0, 0) !important;
}
.el-menu-item.is-active{
    background-color: #F3C402 !important;
    border: 0px;
}

</style>

